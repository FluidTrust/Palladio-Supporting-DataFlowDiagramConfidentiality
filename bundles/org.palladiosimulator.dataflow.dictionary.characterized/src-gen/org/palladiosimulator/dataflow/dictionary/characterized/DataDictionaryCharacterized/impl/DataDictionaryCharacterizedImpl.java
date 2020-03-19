/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.dataflow.dictionary.DataDictionary.impl.DataDictionaryImpl;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Enumeration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Dictionary Characterized</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedImpl#getCharacteristicTypes <em>Characteristic Types</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedImpl#getEnumerations <em>Enumerations</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedImpl#getBehaviorDefinitions <em>Behavior Definitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataDictionaryCharacterizedImpl extends DataDictionaryImpl implements DataDictionaryCharacterized
{
	/**
	 * The cached value of the '{@link #getCharacteristicTypes() <em>Characteristic Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacteristicTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<CharacteristicType> characteristicTypes;

	/**
	 * The cached value of the '{@link #getEnumerations() <em>Enumerations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumerations()
	 * @generated
	 * @ordered
	 */
	protected EList<Enumeration> enumerations;

	/**
	 * The cached value of the '{@link #getBehaviorDefinitions() <em>Behavior Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<BehaviorDefinition> behaviorDefinitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataDictionaryCharacterizedImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return DataDictionaryCharacterizedPackage.Literals.DATA_DICTIONARY_CHARACTERIZED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CharacteristicType> getCharacteristicTypes()
	{
		if (characteristicTypes == null) {
			characteristicTypes = new EObjectContainmentEList<CharacteristicType>(CharacteristicType.class, this, DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__CHARACTERISTIC_TYPES);
		}
		return characteristicTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Enumeration> getEnumerations()
	{
		if (enumerations == null) {
			enumerations = new EObjectContainmentEList<Enumeration>(Enumeration.class, this, DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__ENUMERATIONS);
		}
		return enumerations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BehaviorDefinition> getBehaviorDefinitions()
	{
		if (behaviorDefinitions == null) {
			behaviorDefinitions = new EObjectContainmentEList<BehaviorDefinition>(BehaviorDefinition.class, this, DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__BEHAVIOR_DEFINITIONS);
		}
		return behaviorDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__CHARACTERISTIC_TYPES:
				return ((InternalEList<?>)getCharacteristicTypes()).basicRemove(otherEnd, msgs);
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__ENUMERATIONS:
				return ((InternalEList<?>)getEnumerations()).basicRemove(otherEnd, msgs);
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__BEHAVIOR_DEFINITIONS:
				return ((InternalEList<?>)getBehaviorDefinitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__CHARACTERISTIC_TYPES:
				return getCharacteristicTypes();
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__ENUMERATIONS:
				return getEnumerations();
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__BEHAVIOR_DEFINITIONS:
				return getBehaviorDefinitions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__CHARACTERISTIC_TYPES:
				getCharacteristicTypes().clear();
				getCharacteristicTypes().addAll((Collection<? extends CharacteristicType>)newValue);
				return;
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__ENUMERATIONS:
				getEnumerations().clear();
				getEnumerations().addAll((Collection<? extends Enumeration>)newValue);
				return;
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__BEHAVIOR_DEFINITIONS:
				getBehaviorDefinitions().clear();
				getBehaviorDefinitions().addAll((Collection<? extends BehaviorDefinition>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID) {
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__CHARACTERISTIC_TYPES:
				getCharacteristicTypes().clear();
				return;
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__ENUMERATIONS:
				getEnumerations().clear();
				return;
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__BEHAVIOR_DEFINITIONS:
				getBehaviorDefinitions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID) {
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__CHARACTERISTIC_TYPES:
				return characteristicTypes != null && !characteristicTypes.isEmpty();
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__ENUMERATIONS:
				return enumerations != null && !enumerations.isEmpty();
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED__BEHAVIOR_DEFINITIONS:
				return behaviorDefinitions != null && !behaviorDefinitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataDictionaryCharacterizedImpl
