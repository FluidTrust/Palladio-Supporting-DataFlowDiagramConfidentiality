package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Edge;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.EdgeRefinement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.datastructures.Tuple;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification.QueryUtil;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.CompositeDataType;



/**
 * 
 * Utility class implementing the validation algorithm.
 *
 */
public class DFDCValidationUtil {

	public static boolean inputOutputIsConsistent(EObject self) {

		Node n = (Node) self;

		if (QueryUtil.hasEmptyEdgeRefinements(n)) {
			return false;
		}
		if (!QueryUtil.isBorderNode(n)) {
			return true;
		}

		Set<DataFlowDiagram> allContexts = QueryUtil.getContexts(n);
		for (DataFlowDiagram context : allContexts) {
			Tuple<List<EdgeRefinement>, List<EdgeRefinement>> toCheck = QueryUtil.getEdgeRefinements(n, context);
			if (!isConsistent(toCheck.getFirst()).stream().allMatch(t -> t.getSecond())) { // check inputs
				return false;
			}

			if (!isConsistent(toCheck.getSecond()).stream().allMatch(t -> t.getSecond())) { // check outputs
				return false;
			}
		}

		return true;
	}

	public static List<Tuple<EdgeRefinement, Boolean>> isConsistent(List<EdgeRefinement> toCheck) {
		List<Tuple<EdgeRefinement, Boolean>> results = new ArrayList<Tuple<EdgeRefinement, Boolean>>();
		for (EdgeRefinement ref : toCheck) {
			boolean currentResult = true;
			Edge base = ref.getRefinedEdge();
			if (!canMerge(base, ref.getRefiningEdges())) {
				currentResult = false;
			}
			results.add(new Tuple<EdgeRefinement, Boolean>(ref, currentResult));
		}

		return results;
	}

	private static boolean canMerge(Edge base, List<Edge> refiningEdges) {
		if (isEquivalent(new ArrayList<Edge>(List.of(base)), refiningEdges)) {
			return true;
		}

		if (!isRefinable(base)) {
			return false;
		}
		// generate all candidates; initialized with first refinement
		List<List<Edge>> candidates = new ArrayList<List<Edge>>();
		List<List<Edge>> newCandidates = new ArrayList<List<Edge>>(List.of(DFDCRefinementUtil.refineEdge(base)));

		while (!isEquivalentList(candidates, newCandidates)) {
			candidates.clear();
			candidates.addAll(newCandidates);
			newCandidates.clear();
			for (List<Edge> c : candidates) {
				if (isEquivalent(c, refiningEdges)) { // check if current candidate is solution
					return true;
				}

				for (List<Edge> r : refineOne(c)) { // refine one df of each candidate -> will over time generate all
					// possible combinations of refinements
					if (!contains(r, newCandidates)) { // do not consider duplicates
						newCandidates.add(r);
					}
				}
			}
		}
		return false;
	}

	public static boolean isRefinable(Edge e) {
		CharacterizedDataFlow cdf = (CharacterizedDataFlow) e;
		if (cdf.getData().size() > 1) {
			return true;
		}
		if (cdf.getData().size() > 0 && cdf.getData().get(0).getType() instanceof CompositeDataType
				// composite type must contain entries to be refined
				&&  !((CompositeDataType) cdf.getData().get(0).getType()).getComponents().isEmpty()) {
			return true;
		}

		return false;

	}

	private static List<Integer> findMatches(Edge d, List<Edge> candidates) {
		List<Integer> matches = new ArrayList<Integer>();
		for (Edge c : candidates) {
			if (ComparisonUtil.isEquivalent((CharacterizedDataFlow) d, (CharacterizedDataFlow) c)) {
				matches.add(candidates.indexOf(c));
			}
		}
		return matches;
	}

	private static boolean contains(List<Edge> target, List<List<Edge>> test) {
		for (List<Edge> t : test) {
			if (isEquivalent(t, target)) {
				return true;
			}
		}

		return false;
	}

	private static boolean isEquivalentList(List<List<Edge>> one, List<List<Edge>> two) {
		if (one.size() != two.size()) {
			return false;
		}

		for (List<Edge> o : one) {
			if (!contains(o, two)) {
				return false;
			}
		}

		for (List<Edge> t : two) {
			if (!contains(t, one))
				return false;
		}

		return true;
	}

	private static boolean isEquivalent(List<Edge> base, List<Edge> subFlows) {
		Map<Edge, Integer> baseMatches = new HashMap<Edge, Integer>();
		Map<Edge, Integer> subFlowMatches = new HashMap<Edge, Integer>();
		for (Edge b : base) {
			List<Integer> matches = findMatches(b, subFlows);

			if (matches.isEmpty()) {
				return false;
			}
			for (Integer pos : matches) {
				if (!baseMatches.containsValue(pos)) {
					baseMatches.put(b, pos);

				}
			}
			if (!baseMatches.containsKey(b)) {
				return false;
			}

		}
		for (Edge s : subFlows) {
			List<Integer> matches = findMatches(s, base);
			if (matches.isEmpty()) {
				return false;
			}
			for (Integer pos : matches) {
				if (!subFlowMatches.containsValue(pos)) {
					subFlowMatches.put(s, pos);

				}
			}
			if (!subFlowMatches.containsKey(s)) {
				return false;
			}

		}
		return true;
	}

	/**
	 * 
	 * This method is currently used and represents a conservative strategy for
	 * generating candidates.
	 * 
	 */

	private static List<List<Edge>> refineOne(List<Edge> input) {
		List<List<Edge>> results = new ArrayList<List<Edge>>();

		for (int exception = 0; exception < input.size(); exception++) {

			List<Edge> currentResults = new ArrayList<Edge>();

			for (int i = 0; i < input.size(); i++) {

				if (i == exception && isRefinable(input.get(i))) {
					currentResults.addAll(DFDCRefinementUtil.refineEdge(input.get(i)));
					continue;
				}
				currentResults.add(input.get(i));
			}
			results.add(currentResults);

		}
		return results;

	}
}
