/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Logic Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm#getLeft <em>Left</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage#getBinaryLogicTerm()
 * @model abstract="true"
 * @generated
 */
public interface BinaryLogicTerm extends LogicTerm
{
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Term)
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage#getBinaryLogicTerm_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getLeft();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Term value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Term)
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage#getBinaryLogicTerm_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Term getRight();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Term value);

} // BinaryLogicTerm
