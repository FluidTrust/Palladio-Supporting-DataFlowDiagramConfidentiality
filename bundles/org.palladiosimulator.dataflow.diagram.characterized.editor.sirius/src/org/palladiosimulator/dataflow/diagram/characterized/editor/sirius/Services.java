package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Data;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlow;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagramRefinement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.EdgeRefinement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Process;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedNode;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling.DFDCRefinementUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling.DFDCTypeUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification.ComponentFactory;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification.DFDCModificationUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification.QueryUtil;

/**
 * The services class used by VSM.
 */
public class Services {

	/**
	 * See
	 * http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24
	 * for documentation on how to write service methods.
	 */

	public EObject navigateUp(EObject self, EObject dfd) {
		return dfd.eContainer().eContainer();
	}

	public EObject navigateDown(EObject self, EObject element) {
		return DFDCRefinementUtil.getRefinement(element).getRefiningDiagram();

	}

	public boolean canReconnectSource(EObject self) {
		return !QueryUtil.isBorderNode(((DataFlow) self).getSource());

	}

	public boolean canReconnectTarget(EObject self) {
		return !QueryUtil.isBorderNode(((DataFlow) self).getTarget());

	}

	public List<EObject> listDataTypes(EObject self) {
		Session session = SessionManager.INSTANCE.getSession(self);
		return DFDCTypeUtil.getDataTypes(session);
	}

	public boolean isRefined(EObject self) {
		return DFDCRefinementUtil.isRefined(self);
	}

	public boolean isNotRefined(EObject self, EObject element) {
		return !DFDCRefinementUtil.isRefined(element);
	}


	public boolean needsRefDialog(EObject self, EObject source, EObject target) {
		return DFDCRefinementUtil.needsRef(source, target) && !getAllRefinements(self, source, target).isEmpty(); // <->
																													// if
																													// cross-dfd;
	}

	public boolean needsRef(EObject self, EObject source, EObject target) {
		return DFDCRefinementUtil.needsRef(source, target) && getAllRefinements(self, source, target).isEmpty();
	}

	public void addNewRefinedDF(EObject self, EObject source, EObject target) {

		DFDCRefinementUtil.addNewRefinedDF(self, source, target);

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
//
//	public void createLeveledDFD(List<DataFlow> inc, List<DataFlow> out, Process p, DataFlowDiagram oldDFD,
//			DataFlowDiagram newDFD, DataFlowDiagramRefinement ref) {
//
//		DFDModificationUtil.createLeveledDFD(inc, out, p, oldDFD, newDFD, ref);
//
//	}

	public void loadResources(EObject self) {
		ResourceDialog r = new ResourceDialog(Display.getCurrent().getActiveShell(),
				"Load Characterized Data Dictionary", SWT.SINGLE);
		r.open();
		r.setBlockOnOpen(true);
		Session session = SessionManager.INSTANCE.getSession(self);
		for (URI uri : r.getURIs()) {
			if (!DFDCTypeUtil.uriAlreadyLoaded(uri, session))
				session.addSemanticResource(uri, new NullProgressMonitor());
		}

	}

//	
//	public boolean isValidData(EObject self) {
//		Data data = (Data) self;
//		return data.getName() != null && !data.getName().isBlank() && data.getType() != null;
//
//	}
//
//	public boolean isValidData(EObject self, EObject entry) {
//		Data data = (Data) entry;
//		return data.getName() != null && !data.getName().isBlank() && data.getType() != null;
//
//	}
//
	public List<EdgeRefinement> getAllRefinements(EObject self, EObject source, EObject target) {
		return DFDCRefinementUtil.getAllRefinements(self, source, target);

	}

//
//	public boolean canCreateDF(EObject self) {
//		return DFDRefinementUtil.getCurrentRefinement() != null;
//	}
//
//	public void stopDFCreation(EObject self) {
//		DFDRefinementUtil.setCurrentRefinement(null);
//	}
//
//	public void setRef(EObject self, EdgeRefinement er) {
//		DFDRefinementUtil.setCurrentRefinement(er);
//	}
//
//	public void addRefiningDF(EObject self, EObject source, EObject target) {
//		ComponentFactory.createDF(self, source, target, true);
//
//	}
//
	public void addDF(EObject self, EObject source, EObject target) {
		ComponentFactory.createCDF(self, source, target, false);
	}
//
	public boolean canConnect(EObject self, EObject source, EObject target) {
		if (!DFDCRefinementUtil.isRefinedDFD(self.eContainer())) {
			return true;
		}

		// TODO handle pins
		if (!QueryUtil.isBorderNode((Node) source) && !QueryUtil.isBorderNode((Node) target)) {
			return true;
		}

		return !(QueryUtil.isBorderNode((Node) source) && QueryUtil.isBorderNode((Node) target))
				&& !getAllRefinements(self, source, target).isEmpty();

	}
//
//	public boolean inputOutputIsConsistent(EObject self) {
//		return DFDValidationUtil.inputOutputIsConsistent(self);
//	}
//
	public void deleteNode(EObject self) {
		DFDCModificationUtil.deleteNode(self);
	}
//
//	public void deleteEdge(EObject self) {
//		DFDModificationUtil.deleteEdge(self);
//
//	}
//
//	public String getErrorMessage(EObject self) {
//		return DFDErrorMessageUtil.getErrorMessage(self);
//	}
	
	public CharacterizedNode getTarget(EObject self, EObject targetPin) {
		return null;
	}

}
