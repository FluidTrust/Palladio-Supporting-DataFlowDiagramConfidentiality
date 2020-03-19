/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Characteristic Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference#getPin <em>Pin</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage#getDataCharacteristicReference()
 * @model
 * @generated
 */
public interface DataCharacteristicReference extends CharacteristicReference
{
	/**
	 * Returns the value of the '<em><b>Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pin</em>' reference.
	 * @see #setPin(Pin)
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage#getDataCharacteristicReference_Pin()
	 * @model required="true"
	 * @generated
	 */
	Pin getPin();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference#getPin <em>Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pin</em>' reference.
	 * @see #getPin()
	 * @generated
	 */
	void setPin(Pin value);

} // DataCharacteristicReference
