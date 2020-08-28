package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.EdgeRefinement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.datastructures.Tuple;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification.QueryUtil;


/**
 * 
 * Utility class to generate error messages centrally.
 *
 */
public class DFDCErrorMessageUtil {

	private final static String ERROR_MESSAGE = "Node %s is in an inconsistent state because %s not consistently refined.";
	
	public static String getErrorMessage(EObject self) {
		List<String> inputErrors = new ArrayList<String>();
		List<String> outputErrors = new ArrayList<String>();
		Node n = (Node) self;

		Set<DataFlowDiagram> allContexts = QueryUtil.getContexts(n);

		for (DataFlowDiagram context : allContexts) {
			Tuple<List<EdgeRefinement>, List<EdgeRefinement>> toCheck = QueryUtil.getEdgeRefinements(n, context);
			for (Tuple<EdgeRefinement, Boolean> r : DFDCValidationUtil.isConsistent(toCheck.getFirst())) {
				if (!r.getSecond()) {
					inputErrors.add(r.getFirst().getRefinedEdge().getName());
				}
			}
			for (Tuple<EdgeRefinement, Boolean> r : DFDCValidationUtil.isConsistent(toCheck.getSecond())) {
				if (!r.getSecond()) {
					outputErrors.add(r.getFirst().getRefinedEdge().getName());
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		String inputIntro = (inputErrors.size() > 1) ? " inputs" : " input ";
		String outputIntro = (outputErrors.size() > 1) ? "outputs " : "output ";
		String verb = ((!inputErrors.isEmpty() && !outputErrors.isEmpty()) || inputErrors.size() > 1
				|| outputErrors.size() > 1) ? " are" : " is";
		String connective = (!inputErrors.isEmpty() && !outputErrors.isEmpty()) ? " and " : "";
		if (!inputErrors.isEmpty()) {
			sb.append(inputIntro);
			sb.append(String.join(", ", inputErrors));
			sb.append(connective);
		}

		if (!outputErrors.isEmpty()) {
			sb.append(outputIntro);
			sb.append(String.join(", ", outputErrors));
		}
		sb.append(verb);

		return String.format(ERROR_MESSAGE, n.getName(), sb.toString());
	}
}
