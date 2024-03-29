package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.query.EObjectQuery;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagramRefinement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.EdgeRefinement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
//import org.palladiosimulator.dataflow.diagram.editor.sirius.util.datastructures.Tuple;
//import org.palladiosimulator.dataflow.diagram.editor.sirius.util.leveling.ComparisonUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.datastructures.Tuple;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling.ComparisonUtil;


public class QueryUtil {

//	// TODO how to handle pins?
//	public static boolean canReconnect(EObject self, EObject source, EObject target) {
//		CharacterizedDataFlow cdf = (CharacterizedDataFlow) self;
//		Node newTarget = (Node) target;
//		Node oldTarget = cdf.getTarget();
//		Node oldSource = cdf.getSource();		
//		return !((isBorderNode(newTarget) && isBorderNode(oldTarget)) || (isBorderNode(newTarget) && isBorderNode(oldSource)));
//
//	}
	
	
	public static List<EObject> getInverseReferences(EObject o, String ref){
		return new ArrayList<EObject>(new EObjectQuery(o).getInverseReferences(ref));
	}

	
	public static boolean isSameDFD(EObject nodeA, EObject nodeB) {
		return ComparisonUtil.isEqual(nodeA.eContainer(), nodeB.eContainer());
	}
	
	public static boolean hasEmptyEdgeRefinements(Node n) {
		Tuple<List<EdgeRefinement>, List<EdgeRefinement>> refinements = QueryUtil.getEdgeRefinements(n,
				(DataFlowDiagram) n.eContainer());

		for (EdgeRefinement er : refinements.getFirst()) {
			if (er.getRefiningEdges().isEmpty()) {
				return true;
			}
		}

		for (EdgeRefinement er : refinements.getSecond()) {
			if (er.getRefiningEdges().isEmpty()) {
				return true;
			}
		}

		return false;

	}
	
	/**
	 * 
	 * @param pin
	 * @return whether a dataflow goes through this pin
	 */
	public static boolean isPartOfDF(EObject pin) {
		List<EObject> inputRefs = getInverseReferences(pin, "targetPin").stream()
				.filter(r -> r instanceof CharacterizedDataFlow).collect(Collectors.toList());
		List<EObject> outputRefs = getInverseReferences(pin, "sourcePin").stream()
				.filter(r -> r instanceof CharacterizedDataFlow).collect(Collectors.toList());
		return !inputRefs.isEmpty() || !outputRefs.isEmpty();
	}
	

	public static boolean isBorderNode(Node n) {
		return getContexts(n).size() > 1;
	}
	
	public static Set<DataFlowDiagram> getContexts(Node n) {
		List<EObject> inputRefs = getInverseReferences(n, "target").stream()
				.filter(r -> r instanceof CharacterizedDataFlow).collect(Collectors.toList());
		List<EObject> outputRefs = getInverseReferences(n, "source").stream()
				.filter(r -> r instanceof CharacterizedDataFlow).collect(Collectors.toList());
		Set<DataFlowDiagram> contexts = new HashSet<DataFlowDiagram>();
		for (EObject eo : inputRefs) {
			contexts.add((DataFlowDiagram) eo.eContainer());
		}
		for (EObject eo : outputRefs) {
			contexts.add((DataFlowDiagram) eo.eContainer());
		}

		return contexts;

	}
	
	public static Tuple<List<EdgeRefinement>, List<EdgeRefinement>> getEdgeRefinements(Node n, DataFlowDiagram context) {
		List<EdgeRefinement> inputs = new ArrayList<EdgeRefinement>();
		List<EdgeRefinement> outputs = new ArrayList<EdgeRefinement>();
		for (DataFlowDiagramRefinement ref : context.getRefinedBy()) {
			for (EdgeRefinement er : ref.getRefinedEdges()) {
				if (ComparisonUtil.isEqual(n, er.getRefinedEdge().getSource())) {
					outputs.add(er);
				}
				if (ComparisonUtil.isEqual(n, er.getRefinedEdge().getTarget())) {
					inputs.add(er);
				}
			}
		}

		return new Tuple<List<EdgeRefinement>, List<EdgeRefinement>>(inputs, outputs);

	}
	
}
