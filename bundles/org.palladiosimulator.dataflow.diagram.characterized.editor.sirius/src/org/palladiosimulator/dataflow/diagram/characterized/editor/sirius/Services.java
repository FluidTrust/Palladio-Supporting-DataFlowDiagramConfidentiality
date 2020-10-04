package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.palladiosimulator.dataflow.confidentiality.defaultmodels.DefaultModelConstants;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Data;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagramRefinement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.EdgeRefinement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedNode;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.emf.DefaultResourcesLoadedAdapter;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling.DFDCErrorMessageUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling.DFDCRefinementUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling.DFDCTypeUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling.DFDCValidationUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification.ComponentFactory;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification.DFDCModificationUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification.QueryUtil;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

/**
 * See
 * http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24
 * for documentation on how to write service methods.
 */
public class Services {

    private static final Adapter DEFAULT_RESOURCES_LOADED_ADAPTER = new DefaultResourcesLoadedAdapter();

    /**
     * Constructor for the services called by the Sirius framework.
     * 
     * The framework might instantiate this class several times for the same diagram or for other
     * diagrams. Therefore, holding state is not possible.
     */
    public Services() {
        // intentionally left blank
    }

    /**
     * Loads the default resources into the diagram's resource set.
     * 
     * 
     * @param self
     *            not used
     * @param diagramElement
     *            Any diagram element.
     * @return Always false.
     * @see {@link DefaultModelConstants#getDefaultDataDictionaries()}
     */
    public boolean loadDefaultResources(EObject self, DDiagramElement diagramElement) {
        if (!diagramElement.getParentDiagram()
            .eAdapters()
            .contains(DEFAULT_RESOURCES_LOADED_ADAPTER)) {
            diagramElement.getParentDiagram()
                .eAdapters()
                .add(DEFAULT_RESOURCES_LOADED_ADAPTER);
            var session = SessionManager.INSTANCE.getSession(self);
            var commandStack = session.getTransactionalEditingDomain()
                .getCommandStack();
            for (var dictionaryURI : DefaultModelConstants.getDefaultDataDictionaries()) {
                var command = new AddSemanticResourceCommand(session, dictionaryURI, new NullProgressMonitor());
                commandStack.execute(command);
            }
        }
        return false;
    }

    /**
     * Indicates if the source of the given data flow can be reconnected.
     * 
     * Reconnecting the edge is possible if the source can be changed in the current diagram, i.e.
     * does not belong to an upper level diagram.
     * 
     * @param self
     *            The data flow to be changed.
     * @return True if the source can be changed, false otherwise.
     */
    public boolean canReconnectSource(CharacterizedDataFlow self) {
        return !QueryUtil.isBorderNode(self.getSource());
    }

    /**
     * Indicates if the target of the given data flow can be reconnected.
     * 
     * Reconnecting the edge is possible if the target can be changed in the current diagram, i.e.
     * does not belong to an upper level diagram.
     * 
     * @param self
     *            The data flow to be changed.
     * @return True if the target can be changed, false otherwise.
     */
    public boolean canReconnectTarget(CharacterizedDataFlow self) {
        return !QueryUtil.isBorderNode(self.getTarget());
    }

    /**
     * Indicates if the source and target of an edge match their semantic content.
     * 
     * It is crucial to check the views of the pins to derive the real source and target nodes from
     * reused behaviors as well as from owned behaviors. The parent views of the pin views are the
     * views of the corresponding nodes that have to be checked as well.
     * 
     * @param self
     *            The data flow.
     * @param sourceView
     *            The source pin view.
     * @param targetView
     *            The target pin view.
     * @return True if the pins and nodes match the source and target of the data flow, false
     *         otherwise.
     */
    public boolean isValidEdge(CharacterizedDataFlow self, DNode sourceView, DNode targetView) {
        try {
            var sourcePin = sourceView.getSemanticElements()
                .get(0);
            var sourceNode = (Node) ((DDiagramElement) sourceView.eContainer()).getSemanticElements()
                .get(0);
            var targetPin = targetView.getSemanticElements()
                .get(0);
            var targetNode = (Node) ((DDiagramElement) targetView.eContainer()).getSemanticElements()
                .get(0);
            return self.getSource() == sourceNode && self.getSourcePin() == sourcePin && self.getTarget() == targetNode
                    && self.getTargetPin() == targetPin;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
    /**
     * Determines {@link Pin} elements for inputs that are available for the given node in the given diagram.
     * This method is meant to be used by read only nodes in refined diagrams.
     * 
     * @param node
     *            The node to determine the pins for.
     * @param diagram
     *            The current diagram view.
     * @return The set of available pins.
     * @see Services#getPinCandidates(DDiagram, CharacterizedNode, Function)
     */
    public Collection<Pin> getInputPinCandidates(CharacterizedNode node, DDiagram diagram) {
        return getPinCandidates(diagram, node, BehaviorDefinition::getInputs);
    }
    
    /**
     * Determines {@link Pin} elements for outputs that are available for the given node in the given diagram.
     * This method is meant to be used by read only nodes in refined diagrams.
     * 
     * @param node
     *            The node to determine the pins for.
     * @param diagram
     *            The current diagram view.
     * @return The set of available pins.
     * @see Services#getPinCandidates(DDiagram, CharacterizedNode, Function)
     */
    public Collection<Pin> getOutputPinCandidates(CharacterizedNode node, DDiagram diagram) {
        return getPinCandidates(diagram, node, BehaviorDefinition::getOutputs);
    }
    
    /**
     * Determines {@link Pin} elements that are available for the given node in the given diagram.
     * This method is meant to be used by read only nodes in refined diagrams.
     * 
     * The method assumes that every passed node is a read only node. The pins shown for a read only
     * node must only be pins that are used by the refined process in the upper level diagram.
     * 
     * @param diagram
     *            The current diagram view.
     * @param node
     *            The node to determine the pins for.
     * @param pinGet
     *            A function mapping a given behavior to pins (used to select input or output pins).
     * @return The set of available pins.
     */
    protected Collection<Pin> getPinCandidates(DDiagram diagram, CharacterizedNode node,
            Function<BehaviorDefinition, Collection<Pin>> pinGet) {
        // find the semantic element of the current diagram
        var refiningDfd = diagram.getOwnedDiagramElements()
            .stream()
            .filter(DNode.class::isInstance)
            .map(DNode.class::cast)
            .filter(n -> "CharacterizedProcessNode".equals(n.getActualMapping()
                .getName()))
            .findFirst()
            .map(DNode::getSemanticElements)
            .map(c -> c.get(0))
            .map(EObject::eContainer)
            .filter(DataFlowDiagram.class::isInstance)
            .map(DataFlowDiagram.class::cast)
            .orElse((DataFlowDiagram) node.eContainer());

        // get all pin candidates
        var pins = pinGet.apply(node.getBehavior());

        // if the node child of the same semantic diagram as the current diagram, all pins are
        // relevant
        var refinedDfd = (DataFlowDiagram) node.eContainer();
        if (refinedDfd == refiningDfd) {
            return pins;
        }

        // only the pins used by the refined process are relevant in the current diagram
        var refinedProcessCandidate = refinedDfd.getRefinedBy()
            .stream()
            .filter(r -> r.getRefiningDiagram() == refiningDfd)
            .findFirst()
            .map(DataFlowDiagramRefinement::getRefinedProcess);
        if (!refinedProcessCandidate.isPresent()) {
            return pins;
        }
        var refinedProcess = (CharacterizedProcess) refinedProcessCandidate.get();
        var usedPins = refinedDfd.getEdges()
            .stream()
            .filter(CharacterizedDataFlow.class::isInstance)
            .map(CharacterizedDataFlow.class::cast)
            .filter(df -> Arrays.asList(df.getSource(), df.getTarget())
                .contains(refinedProcess))
            .flatMap(df -> Arrays.asList(df.getSourcePin(), df.getTargetPin())
                .stream())
            .collect(Collectors.toSet());
        return pins.stream()
            .filter(usedPins::contains)
            .collect(Collectors.toList());
    }
    
    
    /**
     * navigate to refining diagram
     * 
     * @param self
     * @param element
     *            refined Process
     * @return refining diagram
     */
    public EObject navigateDown(EObject self, EObject element) {
        return DFDCRefinementUtil.getRefinement(element)
            .getRefiningDiagram();

    }

    /**
     * 
     * @param self
     * @return list of data types for data flows
     */
    public List<EObject> listDataTypes(EObject self) {
        Session session = SessionManager.INSTANCE.getSession(self);
        return DFDCTypeUtil.getDataTypes(session);
    }

    /**
     * 
     * @param self
     *            characterized process
     * @return
     */
    public boolean isRefined(EObject self) {
        return DFDCRefinementUtil.isRefined(self);
    }

    public boolean isNotRefined(EObject self, EObject element) {
        return !DFDCRefinementUtil.isRefined(element);
    }

    public boolean needsRefDialog(EObject self, EObject sourceNode, EObject targetNode) {
        return DFDCRefinementUtil.needsRef(sourceNode, targetNode)
                && !getAllRefinements(sourceNode, targetNode).isEmpty(); // <->
        // if
        // cross-dfd;
    }

    public boolean needsRef(EObject self, EObject source, EObject target) {
        return DFDCRefinementUtil.needsRef(source, target) && getAllRefinements(source, target).isEmpty();
    }

    public void addNewRefinedDF(EObject self, EObject sourcePin, EObject targetPin, EObject sourceNode,
            EObject targetNode) {

        DFDCRefinementUtil.addNewRefinedDF(self, sourcePin, targetPin, sourceNode, targetNode);

    }

    public void refineCDF(EObject self, CharacterizedDataFlow df, DataFlowDiagram dfd) {
        if (DFDCRefinementUtil.isRefined(df.getSource()) || DFDCRefinementUtil.isRefined(df.getTarget())) {
            return;
        }
        DFDCRefinementUtil.refineCDF(self, df, dfd);
    }

//
    public void refineProcess(EObject newDFD, EObject p, DataFlowDiagram oldDFD, DataFlowDiagramRefinement ref) {
        DFDCModificationUtil.refineProcess(newDFD, p, oldDFD, ref);
    }

    public void loadResources(EObject self) {
        ResourceDialog r = new ResourceDialog(Display.getCurrent()
            .getActiveShell(), "Load Characterized Data Dictionary", SWT.SINGLE);
        r.open();
        r.setBlockOnOpen(true);
        Session session = SessionManager.INSTANCE.getSession(self);
        for (URI uri : r.getURIs()) {
            if (!DFDCTypeUtil.uriAlreadyLoaded(uri, session))
                session.addSemanticResource(uri, new NullProgressMonitor());
        }

    }

    public boolean isValidData(EObject self) {
        Data data = (Data) self;
        return data.getName() != null && !data.getName()
            .isBlank() && data.getType() != null;

    }

    public boolean isValidData(EObject self, EObject entry) {
        Data data = (Data) entry;
        return data.getName() != null && !data.getName()
            .isBlank() && data.getType() != null;

    }

    public List<EdgeRefinement> getAllRefinements(EObject source, EObject target) {
        return DFDCRefinementUtil.getAllRefinements(source, target);

    }

    public boolean canCreateDF(EObject self) {
        return DFDCRefinementUtil.getCurrentRefinement() != null;
    }

    public void stopDFCreation(EObject self) {
        DFDCRefinementUtil.setCurrentRefinement(null);
    }

    public void setRef(EObject self, EdgeRefinement er) {
        DFDCRefinementUtil.setCurrentRefinement(er);
    }

    public void addRefiningDF(EObject self, EObject sourcePin, EObject targetPin, EObject source, EObject target) {
        ComponentFactory.createCDF(self, sourcePin, targetPin, source, target, true);

    }

    public void addCDF(EObject self, EObject sourcePin, EObject targetPin, EObject sourceNode, EObject targetNode) {
        ComponentFactory.createCDF(self, sourcePin, targetPin, sourceNode, targetNode, false);
    }

    /**
     * 
     * @param self
     *            source pin
     * @param source
     *            source pin
     * @param target
     *            target pin
     * @return
     */
    public boolean canConnect(EObject self, Node sourceNode, Pin sourcePin, Node targetNode, Pin targetPin) {
        DataFlowDiagram dfd = (DataFlowDiagram) sourceNode.eContainer();

        // none of the involved nodes is a read only node
        if (!QueryUtil.isBorderNode(sourceNode) && !QueryUtil.isBorderNode(targetNode)) {
            return true;
        }

        if (!DFDCRefinementUtil.isRefinedDFD(dfd)) {
            return true;
        }


        return !(QueryUtil.isBorderNode(sourceNode) && QueryUtil.isBorderNode(targetNode))
                && !getAllRefinements(sourceNode, targetNode).isEmpty();
    }



    public boolean inputOutputIsConsistent(EObject self) {
        return DFDCValidationUtil.inputOutputIsConsistent(self);
    }

    public void deleteNode(EObject self) {
        DFDCModificationUtil.deleteNode(self);
    }

    public void deleteEdge(EObject self) {
        DFDCModificationUtil.deleteEdge(self);

    }

    public String getErrorMessage(EObject self) {
        return DFDCErrorMessageUtil.getErrorMessage(self);
    }

    public CharacterizedNode getTarget(EObject self, EObject targetPin) {
        return null;
    }

}
