/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized;

import de.uka.ipd.sdq.identifier.Identifier;
import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Term;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment#getLhs <em>Lhs</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getAssignment()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='leftHandSideRefersOutputPin characteristicWildcardHasToBeOnLhsAndRhs literalWildcardHasToBeOnLhsAndRhs'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL leftHandSideRefersOutputPin='self.oclAsType(ecore::EObject).eContainer().oclAsType(BehaviorDefinition).outputs-&gt;includes(self.lhs.pin)' characteristicWildcardHasToBeOnLhsAndRhs='not self.rhs.oclIsKindOf(expressions::CharacteristicReference) or\n(\n\tself.rhs.oclAsType(expressions::CharacteristicReference).characteristicType.oclIsUndefined()\n\tand\n\tself.lhs.characteristicType.oclIsUndefined()\n)\nor\n(\n\tnot self.rhs.oclAsType(expressions::CharacteristicReference).characteristicType.oclIsUndefined()\n\tand\n\tnot self.lhs.characteristicType.oclIsUndefined()\n)' literalWildcardHasToBeOnLhsAndRhs='not self.rhs.oclIsKindOf(expressions::CharacteristicReference) or\n(\n\tself.rhs.oclAsType(expressions::CharacteristicReference).literal.oclIsUndefined()\n\tand\n\tself.lhs.literal.oclIsUndefined()\n)\nor\n(\n\tnot self.rhs.oclAsType(expressions::CharacteristicReference).literal.oclIsUndefined()\n\tand\n\tnot self.lhs.literal.oclIsUndefined()\n)'"
 * @generated
 */
public interface Assignment extends EObject, Identifier
{
	/**
	 * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lhs</em>' containment reference.
	 * @see #setLhs(DataCharacteristicReference)
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getAssignment_Lhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataCharacteristicReference getLhs();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment#getLhs <em>Lhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lhs</em>' containment reference.
	 * @see #getLhs()
	 * @generated
	 */
	void setLhs(DataCharacteristicReference value);

	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' containment reference.
	 * @see #setRhs(Term)
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getAssignment_Rhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getRhs();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment#getRhs <em>Rhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhs</em>' containment reference.
	 * @see #getRhs()
	 * @generated
	 */
	void setRhs(Term value);

} // Assignment
