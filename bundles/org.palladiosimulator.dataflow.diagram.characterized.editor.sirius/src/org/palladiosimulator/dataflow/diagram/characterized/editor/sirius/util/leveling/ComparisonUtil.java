package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Data;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characteristic;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedActorProcess;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedNode;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.CollectionDataType;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.CompositeDataType;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataType;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.Entry;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.PrimitiveDataType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.And;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.EnumCharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.False;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.LogicTerm;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Not;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Or;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Term;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.True;

/**
 * 
 * Utility class handling all comparisons between Ecore-objects.
 *
 *
 * needs to be cleaned up!
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

	/**
	 * compare data types
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
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

	/**
	 * compare entry of a composite data type
	 */
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

	public static boolean isEquivalent(CharacterizedDataFlow a, CharacterizedDataFlow b) {
		if (isEqual(a, b)) {
			return true;
		}
		if (!a.getName().equals(b.getName()) || a.getData().size() != b.getData().size()) {
			return false;
		}

		if (!isEquivalent(a.getTarget(), b.getTarget()) && !isEqual(a.getSource(), b.getSource())) { // must at least
			// share
			// one of source or
			// target
			return false;
		}

		if (!isEquivalent(a.getTargetPin(), b.getTargetPin()) && !isEquivalent(a.getSourcePin(), b.getSourcePin())) {
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

	private static boolean findMatch(Characteristic ec, List<Characteristic> candidates) {
		for (Characteristic c : candidates) {
			if (isEquivalent(ec, c)) {
				return true;
			}
		}
		return false;
	}

	private static boolean findMatch(Literal l, List<Literal> candidates) {
		for (Literal c : candidates) {
			if (isEqual(l, c)) {
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

	private static boolean findMatch(Term t, List<Term> candidates) {
		for (Term c : candidates) {
			if (isEquivalent(t, c)) {
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
			if (a instanceof CharacterizedActorProcess && b instanceof CharacterizedActorProcess) {
				return !isEquivalent(((CharacterizedActorProcess) a).getActor(),
						((CharacterizedActorProcess) b).getActor());
			}

			for (Characteristic c : ((CharacterizedNode) a).getCharacteristics()) {
				if (!findMatch(c, ((CharacterizedNode) b).getCharacteristics())) {
					return false;
				}
			}
			for (Characteristic c : ((CharacterizedNode) b).getCharacteristics()) {
				if (!findMatch(c, ((CharacterizedNode) a).getCharacteristics())) {
					return false;
				}
			}

			if (!isEquivalent(((CharacterizedNode) a).getBehavior(), ((CharacterizedNode) b).getBehavior())) {
				return false;
			}

		}

		return true;
	}

	public static boolean isEquivalent(Pin a, Pin b) {
		if (isEqual(a, b)) {
			return true;
		}
		if (!a.getName().equals(b.getName())) {
			return false;
		}
		return true;
	}

	public static boolean isEquivalent(Characteristic a, Characteristic b) {
		if (isEqual(a, b)) {
			return true;
		}
		if (!a.getName().equals(b.getName())) {
			return false;
		}
		if (!isEqual(a.getType(), b.getType())) {
			return false;
		}

		for (Literal l : ((EnumCharacteristic) a).getValues()) {
			if (!findMatch(l, ((EnumCharacteristic) b).getValues())) {
				return false;
			}
		}
		for (Literal l : ((EnumCharacteristic) b).getValues()) {
			if (!findMatch(l, ((EnumCharacteristic) a).getValues())) {
				return false;
			}
		}

		return true;
	}

	public static boolean isEquivalent(Assignment a, Assignment b) {
		if (isEqual(a, b)) {
			return true;
		}

		// compare rhs
		if (!isEquivalent(a.getRhs(), b.getRhs())) {
			return false;
		}
		// compare lhs
		if (!isEquivalent(a.getLhs(), b.getLhs())) {
			return false;
		}

		return true;
	}

	public static boolean isEquivalent(Term a, Term b) {
		if (isEqual(a, b)) {
			return true;
		}
		// enum characteristic references
		if (a instanceof EnumCharacteristicReference && b instanceof EnumCharacteristicReference) {
			return !isEquivalent((EnumCharacteristicReference) a, (EnumCharacteristicReference) b);
		}
		// constants
		else if (a instanceof True && b instanceof False || a instanceof False && b instanceof True)
			return false;
		// logic terms
		else if (a instanceof LogicTerm && b instanceof LogicTerm) {
			return !isEquivalent((LogicTerm) a, (LogicTerm) b);
		}

		return true;
	}

	public static boolean isEquivalent(EnumCharacteristicReference a, EnumCharacteristicReference b) {

		if (!isEqual(a.getCharacteristicType(), b.getCharacteristicType()))
			return false;
		if (!isEqual(a.getLiteral(), b.getLiteral()))
			return false;
		if (a instanceof DataCharacteristicReference && b instanceof DataCharacteristicReference) {
			return !isEquivalent(((DataCharacteristicReference) a).getPin(),
					((DataCharacteristicReference) b).getPin());
		}
		return true;
	}

	public static boolean isEquivalent(LogicTerm a, LogicTerm b) {

		if (a.getTerms().size() != b.getTerms().size())
			return false;

		for (Term t : b.getTerms()) {
			if (!findMatch(t, a.getTerms())) {
				return false;
			}
		}
		for (Term t : a.getTerms()) {
			if (!findMatch(t, b.getTerms())) {
				return false;
			}
		}
		// unary logic term
		if (a instanceof Not && !(b instanceof Not) || b instanceof Not && !(a instanceof Not)) {
			return false;
		} else if (a instanceof BinaryLogicTerm && b instanceof BinaryLogicTerm) {
			if (a instanceof Or && b instanceof And || a instanceof And && b instanceof Or)
				return false;
			if (!isEquivalent(((BinaryLogicTerm) a).getLeft(), ((BinaryLogicTerm) b).getLeft()))
				return false;
			if (!isEquivalent(((BinaryLogicTerm) a).getRight(), ((BinaryLogicTerm) b).getRight()))
				return false;
		}

		return true;
	}

	public static boolean isEquivalent(BehaviorDefinition a, BehaviorDefinition b) {
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
