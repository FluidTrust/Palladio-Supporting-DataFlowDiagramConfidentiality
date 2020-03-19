/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characteristic Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference#getCharacteristicType <em>Characteristic Type</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage#getCharacteristicReference()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='literalHasToBeWildcardIfCharacteristicIsWildcard'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL literalHasToBeWildcardIfCharacteristicIsWildcard='not self.characteristicType.oclIsUndefined() or self.literal.oclIsUndefined()'"
 * @generated
 */
public interface CharacteristicReference extends Term
{
	/**
	 * Returns the value of the '<em><b>Characteristic Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characteristic Type</em>' reference.
	 * @see #setCharacteristicType(CharacteristicType)
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage#getCharacteristicReference_CharacteristicType()
	 * @model
	 * @generated
	 */
	CharacteristicType getCharacteristicType();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference#getCharacteristicType <em>Characteristic Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Characteristic Type</em>' reference.
	 * @see #getCharacteristicType()
	 * @generated
	 */
	void setCharacteristicType(CharacteristicType value);

	/**
	 * Returns the value of the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' reference.
	 * @see #setLiteral(Literal)
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage#getCharacteristicReference_Literal()
	 * @model
	 * @generated
	 */
	Literal getLiteral();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference#getLiteral <em>Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' reference.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(Literal value);

} // CharacteristicReference
