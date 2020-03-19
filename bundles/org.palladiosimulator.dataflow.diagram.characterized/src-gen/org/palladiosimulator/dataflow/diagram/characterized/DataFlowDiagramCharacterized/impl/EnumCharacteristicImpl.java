/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Characteristic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.EnumCharacteristicImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.EnumCharacteristicImpl#getEnumCharacteristicType <em>Enum Characteristic Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumCharacteristicImpl extends CharacteristicImpl implements EnumCharacteristic {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Literal> values;

	/**
	 * The cached setting delegate for the '{@link #getEnumCharacteristicType() <em>Enum Characteristic Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumCharacteristicType()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate ENUM_CHARACTERISTIC_TYPE__ESETTING_DELEGATE = ((EStructuralFeature.Internal)DataFlowDiagramCharacterizedPackage.Literals.ENUM_CHARACTERISTIC__ENUM_CHARACTERISTIC_TYPE).getSettingDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumCharacteristicImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataFlowDiagramCharacterizedPackage.Literals.ENUM_CHARACTERISTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Literal> getValues() {
		if (values == null) {
			values = new EObjectResolvingEList<Literal>(Literal.class, this, DataFlowDiagramCharacterizedPackage.ENUM_CHARACTERISTIC__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumCharacteristicType getEnumCharacteristicType() {
		return (EnumCharacteristicType)ENUM_CHARACTERISTIC_TYPE__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumCharacteristicType basicGetEnumCharacteristicType() {
		return (EnumCharacteristicType)ENUM_CHARACTERISTIC_TYPE__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataFlowDiagramCharacterizedPackage.ENUM_CHARACTERISTIC__VALUES:
				return getValues();
			case DataFlowDiagramCharacterizedPackage.ENUM_CHARACTERISTIC__ENUM_CHARACTERISTIC_TYPE:
				if (resolve) return getEnumCharacteristicType();
				return basicGetEnumCharacteristicType();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataFlowDiagramCharacterizedPackage.ENUM_CHARACTERISTIC__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends Literal>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case DataFlowDiagramCharacterizedPackage.ENUM_CHARACTERISTIC__VALUES:
				getValues().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DataFlowDiagramCharacterizedPackage.ENUM_CHARACTERISTIC__VALUES:
				return values != null && !values.isEmpty();
			case DataFlowDiagramCharacterizedPackage.ENUM_CHARACTERISTIC__ENUM_CHARACTERISTIC_TYPE:
				return ENUM_CHARACTERISTIC_TYPE__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

} //EnumCharacteristicImpl
