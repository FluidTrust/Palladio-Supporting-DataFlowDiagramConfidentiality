/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized;

import org.eclipse.emf.common.util.EList;

import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataDictionary;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Dictionary Characterized</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized#getCharacteristicTypes <em>Characteristic Types</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized#getEnumerations <em>Enumerations</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized#getBehaviorDefinitions <em>Behavior Definitions</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getDataDictionaryCharacterized()
 * @model
 * @generated
 */
public interface DataDictionaryCharacterized extends DataDictionary
{
	/**
	 * Returns the value of the '<em><b>Characteristic Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characteristic Types</em>' containment reference list.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getDataDictionaryCharacterized_CharacteristicTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<CharacteristicType> getCharacteristicTypes();

	/**
	 * Returns the value of the '<em><b>Enumerations</b></em>' containment reference list.
	 * The list contents are of type {@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Enumeration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumerations</em>' containment reference list.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getDataDictionaryCharacterized_Enumerations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Enumeration> getEnumerations();

	/**
	 * Returns the value of the '<em><b>Behavior Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Definitions</em>' containment reference list.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getDataDictionaryCharacterized_BehaviorDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<BehaviorDefinition> getBehaviorDefinitions();

} // DataDictionaryCharacterized
