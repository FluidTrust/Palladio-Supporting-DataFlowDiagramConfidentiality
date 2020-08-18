package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Data;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlow;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedExternalActor;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedNode;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.CollectionDataType;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.CompositeDataType;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataType;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.Entry;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.PrimitiveDataType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedFactory;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Entity;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference;

/**
 * 
 * Utility class handling all comparisons between Ecore-objects.
 *
 */

public class ComparisonUtil {

	public static boolean isEqual(EObject e1, EObject e2) {
		return EcoreUtil.equals(e1, e2);

	}

	/**
	 * 
	 * All following methods use recursive comparison to determine if two objects
	 * are equivalent. That is, whether they are equal wrt. all attributes except
	 * their id. These may be modified to achieve a less strict concept of
	 * "equivalence".
	 * 
	 */

	public static boolean isEquivalentPrimitiveDT(PrimitiveDataType a, PrimitiveDataType b) {
		if (isEqual(a, b)) {
			return true;
		}
		return a.getName().equals(b.getName());
	}

	public static boolean isEquivalentCompositeDT(CompositeDataType a, CompositeDataType b) {
		if (isEqual(a, b)) {
			return true;
		}

		if (!a.getName().equals(b.getName()) || a.getComponents().size() != b.getComponents().size()) {
			return false;
		}
		// compare set of entries
		for (Entry e1 : a.getComponents()) {
			for (Entry e2 : b.getComponents()) {
				if (isEquivalent(e1, e2)) {
					break;
				}
			}
			return false;
		}

		for (Entry e1 : b.getComponents()) {
			for (Entry e2 : a.getComponents()) {
				if (isEquivalent(e1, e2)) {
					break;
				}
			}
			return false;
		}

		return true;
	}

	public static boolean isEquivalentCollectionDT(CollectionDataType a, CollectionDataType b) {
		if (isEqual(a, b)) {
			return true;
		}
		return a.getName().equals(b.getName()) && isEquivalent(a.getType(), b.getType());
	}

	public static boolean isEquivalent(DataType a, DataType b) {
		if (a instanceof PrimitiveDataType && b instanceof PrimitiveDataType) {
			return isEquivalentPrimitiveDT((PrimitiveDataType) a, (PrimitiveDataType) b);
		}
		if (a instanceof CollectionDataType && b instanceof CollectionDataType) {
			return isEquivalentCollectionDT((CollectionDataType) a, (CollectionDataType) b);
		}

		if (a instanceof CompositeDataType && b instanceof CompositeDataType) {
			return isEquivalentCompositeDT((CompositeDataType) a, (CompositeDataType) b);
		}
		return false;
	}

	public static boolean isEquivalent(Entry a, Entry b) {
		if (isEqual(a, b)) {
			return true;
		}
		return a.getName().equals(b.getName()) && isEquivalent(a.getType(), b.getType());
	}

	public static boolean isEquivalent(Data a, Data b) {
		if (isEqual(a, b)) {
			return true;
		}

		return a.getName().equals(b.getName()) && isEquivalent(a.getType(), b.getType());
	}

	// TODO check if this works
	public static boolean isEquivalent(CharacterizedDataFlow a, CharacterizedDataFlow b) {
		if (isEqual(a, b)) {
			return true;
		}
		if (!a.getName().equals(b.getName()) || a.getData().size() != b.getData().size()) {
			return false;
		}

		if (!isEquivalent(a.getTarget(), b.getTarget()) && !isEqual(a.getSource(), b.getSource())) { // must at least share
			// one of source or
			// target
			return false;
		}


		if (!isEqual(a.getTargetPin(), b.getTargetPin()) && !isEqual(a.getSourcePin(), b.getSourcePin())) { // must at least share
			// one of source or
			// target
			return false;
		}


		// compare set of entries
		for (Data d1 : a.getData()) {
			if (!findMatch(d1, b.getData())) {
				return false;
			}
		}
		for (Data d1 : b.getData()) {
			if (!findMatch(d1, a.getData())) {
				return false;
			}
		}
		return true;
	}

	private static boolean findMatch(Data d, List<Data> candidates) {
		for (Data c : candidates) {
			if (isEquivalent(d, c)) {
				return true;
			}
		}
		return false;
	}

	private static boolean findMatch(Pin p, List<Pin> candidates) {
		for (Pin c : candidates) {
			if (isEquivalent(p, c)) {
				return true;
			}
		}
		return false;
	}

	private static boolean findMatch(Assignment p, List<Assignment> candidates) {
		for (Assignment c : candidates) {
			if (isEquivalent(p, c)) {
				return true;
			}
		}
		return false;
	}


	public static boolean isEquivalent(Node a, Node b) {
		if (isEqual(a, b)) {
			return true;
		}
		if (!a.getName().equals(b.getName())) {
			return false;
		}

		if (a instanceof CharacterizedNode && b instanceof CharacterizedNode) {
			if (!isEquivalent(((CharacterizedNode)a).getBehavior(), ((CharacterizedNode )b).getBehavior())) {
				return false;
			}

			// TODO characterized actor process
		}

		// TODO missing cases

		return true;
	}



	private static boolean isEquivalent(Pin a, Pin b) {
		if (isEqual(a, b)) {
			return true;
		}
		if (!a.getName().equals(b.getName())) {
			return false;
		}
		return true;			
	}


	private static boolean isEquivalent(Assignment a, Assignment b) {
		if (isEqual(a, b)) {
			return true;
		}
		// TODO handle pins, literals, characteristic type
		return true;			
	}


	private static boolean isEquivalent(BehaviorDefinition a, BehaviorDefinition b) {
		if (isEqual(a, b)) {
			return true;
		}

		if (!a.getName().equals(b.getName()) || a.getOutputs().size() != b.getOutputs().size()
				|| a.getOutputs().size() != b.getOutputs().size()) {
			return false;
		}

		// compare pins			
		for (Pin p1 : a.getOutputs()) {
			if (!findMatch(p1, b.getOutputs())) {
				return false;
			}
		}
		for (Pin p1 : b.getOutputs()) {
			if (!findMatch(p1, a.getOutputs())) {
				return false;
			}
		}
		for (Pin p1 : a.getOutputs()) {
			if (!findMatch(p1, b.getOutputs())) {
				return false;
			}
		}
		for (Pin p1 : b.getOutputs()) {
			if (!findMatch(p1, a.getOutputs())) {
				return false;
			}
		}

		// compare assignments			
		for (Assignment as1 : a.getAssignments()) {
			if (!findMatch(as1, b.getAssignments())) {
				return false;
			}
		}
		for (Assignment as1 : b.getAssignments()) {
			if (!findMatch(as1, a.getAssignments())) {
				return false;
			}
		}
		return true;
	}
}
