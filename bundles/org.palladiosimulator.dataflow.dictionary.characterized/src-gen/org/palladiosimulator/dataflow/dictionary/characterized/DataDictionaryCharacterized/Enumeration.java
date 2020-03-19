/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Enumeration#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends Entity
{
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal}.
	 * It is bidirectional and its opposite is '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal#getEnum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getEnumeration_Literals()
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal#getEnum
	 * @model opposite="enum" containment="true" required="true"
	 * @generated
	 */
	EList<Literal> getLiterals();

} // Enumeration
