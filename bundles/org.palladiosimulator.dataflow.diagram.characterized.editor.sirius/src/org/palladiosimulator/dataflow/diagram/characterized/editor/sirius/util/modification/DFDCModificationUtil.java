package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlow;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagramRefinement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Edge;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.EdgeRefinement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling.ComparisonUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling.DFDCRefinementUtil;

/**
 * 
 * Utility class handling modification of existing dfds as well as creation of
 * new (i.e., refining) ones.
 *
 */
public class DFDCModificationUtil {

	private static void removeFromRefs(CharacterizedDataFlow df) {
		List<EObject> refs = QueryUtil.getInverseReferences(df, "refiningEdges");
		refs.addAll(QueryUtil.getInverseReferences(df, "refinedEdge"));
		List<EdgeRefinement> toDelete = new ArrayList<EdgeRefinement>();
		for (EObject r : refs) {
			EdgeRefinement er = (EdgeRefinement) r;
			er.getRefiningEdges().remove(df);
			if (er.getRefinedEdge() == null || ComparisonUtil.isEqual(er.getRefinedEdge(), df)) {
				toDelete.add((EdgeRefinement) er);
			}
		}

		for (EdgeRefinement er : toDelete) {
			DataFlowDiagramRefinement ref = (DataFlowDiagramRefinement) er.eContainer();
			ref.getRefinedEdges().remove(er);

		}

	}

	public static void deleteEdge(EObject self) {
		DataFlowDiagram dfd = (DataFlowDiagram) self.eContainer();
		removeFromRefs((CharacterizedDataFlow) self);
		dfd.getEdges().remove(self);
	}


	public static void deleteNode(EObject self) {

		List<EObject> refiningRefs = QueryUtil.getInverseReferences(self, "refinedProcess");

		List<EObject> targetRefs = QueryUtil.getInverseReferences(self, "target").stream()
				.filter(r -> r instanceof DataFlow).collect(Collectors.toList());
		List<EObject> sourceRefs = QueryUtil.getInverseReferences(self, "source").stream()
				.filter(r -> r instanceof DataFlow).collect(Collectors.toList());

		for (EObject r : refiningRefs) {
			DataFlowDiagram ndfd = (DataFlowDiagram) r.eContainer();
			ndfd.getRefinedBy().remove(r);
		}

		for (EObject t : targetRefs) {
			DataFlowDiagram ndfd = (DataFlowDiagram) t.eContainer();
			ndfd.getEdges().remove(t);
		}

		for (EObject s : sourceRefs) {
			DataFlowDiagram ndfd = (DataFlowDiagram) s.eContainer();
			ndfd.getEdges().remove(s);
		}
		DataFlowDiagram dfd = (DataFlowDiagram) self.eContainer();
		dfd.getNodes().remove(self);
		for (DataFlowDiagramRefinement r : dfd.getRefinedBy()) {
			List<EdgeRefinement> toDelete = new ArrayList<EdgeRefinement>();
			for (EdgeRefinement er : r.getRefinedEdges()) {
				if (er.getRefinedEdge() == null || ComparisonUtil.isEqual(er.getRefinedEdge().getSource(), self)
						|| ComparisonUtil.isEqual(er.getRefinedEdge().getTarget(), self)) {
					toDelete.add(er);

				}
			}
			r.getRefinedEdges().removeAll(toDelete);
		}

	}
	/**
	 * 
	 * @param newDFD newly created dfd
	 * @param p to be refined process
	 * @param oldDFD
	 * @param ref current dfd refinement
	 */
	public static void refineProcess(EObject newDFD, EObject p, DataFlowDiagram oldDFD, DataFlowDiagramRefinement ref) {
		List<Edge> edges = oldDFD.getEdges();
		List<CharacterizedDataFlow> incoming = new ArrayList<CharacterizedDataFlow>();
		List<CharacterizedDataFlow> outgoing = new ArrayList<CharacterizedDataFlow>();
		for (Edge e : edges) {
			if (e instanceof CharacterizedDataFlow) {
				CharacterizedDataFlow df = (CharacterizedDataFlow) e;

				if (ComparisonUtil.isEquivalent((Node) p, (Node) df.getTarget())) {
					incoming.add(df);
				}
				if (ComparisonUtil.isEquivalent((Node) p, (Node) df.getSource())) {
					outgoing.add(df);
				}
			}
		}
		
		
		createLeveledDFD(incoming, outgoing, (CharacterizedProcess) p, oldDFD, (DataFlowDiagram) newDFD, ref);
	}

	/**
	 * 
	 * @param in incoming characterized dataflows to p
	 * @param out outgoing characterized dataflows from p
	 * @param p to be refined process
	 * @param oldDFD
	 * @param newDFD
	 * @param ref current dfd refinement
	 */
	public static void createLeveledDFD(List<CharacterizedDataFlow> in, List<CharacterizedDataFlow> out,
			CharacterizedProcess p, DataFlowDiagram oldDFD, DataFlowDiagram newDFD, DataFlowDiagramRefinement ref) {

		// copy process (including, pins, behavior, characteristics)
		Node newCharacterizedProcess = ComponentFactory.copyNode(p);
		newDFD.getNodes().add(newCharacterizedProcess);

		for (CharacterizedDataFlow cdf : in) {
			CharacterizedDataFlow ncdf = ComponentFactory.copyIncomingCharacterizedDataflow(cdf, newCharacterizedProcess);
			// copy incoming dataflows and add to edges of new dfd and to refinement
			newDFD.getEdges().add(ncdf);
			DFDCRefinementUtil.addToRef(cdf, ncdf, ref);
		}

		for (CharacterizedDataFlow cdf : out) {
			CharacterizedDataFlow ncdf = ComponentFactory.copyOutgoingCharacterizedDataflow(cdf, newCharacterizedProcess);
			// copy outgoing dataflows and add to edges of new dfd and to refinement
			newDFD.getEdges().add(ncdf);			
			DFDCRefinementUtil.addToRef(cdf, ncdf, ref);
		}
	}

}
