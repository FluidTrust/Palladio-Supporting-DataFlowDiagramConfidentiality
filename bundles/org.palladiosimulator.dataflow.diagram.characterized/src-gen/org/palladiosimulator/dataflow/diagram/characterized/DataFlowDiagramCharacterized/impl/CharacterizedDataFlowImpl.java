/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.impl.EdgeImpl;

import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characteristic;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characterizable;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Characterized Data Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedDataFlowImpl#getCharacteristics <em>Characteristics</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedDataFlowImpl#getSourcePin <em>Source Pin</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedDataFlowImpl#getTargetPin <em>Target Pin</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CharacterizedDataFlowImpl extends EdgeImpl implements CharacterizedDataFlow {
	/**
	 * The cached value of the '{@link #getCharacteristics() <em>Characteristics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacteristics()
	 * @generated
	 * @ordered
	 */
	protected EList<Characteristic> characteristics;

	/**
	 * The cached value of the '{@link #getSourcePin() <em>Source Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourcePin()
	 * @generated
	 * @ordered
	 */
	protected Pin sourcePin;

	/**
	 * The cached value of the '{@link #getTargetPin() <em>Target Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPin()
	 * @generated
	 * @ordered
	 */
	protected Pin targetPin;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CharacterizedDataFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataFlowDiagramCharacterizedPackage.Literals.CHARACTERIZED_DATA_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Characteristic> getCharacteristics() {
		if (characteristics == null) {
			characteristics = new EObjectContainmentEList<Characteristic>(Characteristic.class, this, DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__CHARACTERISTICS);
		}
		return characteristics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin getSourcePin() {
		if (sourcePin != null && sourcePin.eIsProxy()) {
			InternalEObject oldSourcePin = (InternalEObject)sourcePin;
			sourcePin = (Pin)eResolveProxy(oldSourcePin);
			if (sourcePin != oldSourcePin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__SOURCE_PIN, oldSourcePin, sourcePin));
			}
		}
		return sourcePin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin basicGetSourcePin() {
		return sourcePin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePin(Pin newSourcePin) {
		Pin oldSourcePin = sourcePin;
		sourcePin = newSourcePin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__SOURCE_PIN, oldSourcePin, sourcePin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin getTargetPin() {
		if (targetPin != null && targetPin.eIsProxy()) {
			InternalEObject oldTargetPin = (InternalEObject)targetPin;
			targetPin = (Pin)eResolveProxy(oldTargetPin);
			if (targetPin != oldTargetPin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__TARGET_PIN, oldTargetPin, targetPin));
			}
		}
		return targetPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin basicGetTargetPin() {
		return targetPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPin(Pin newTargetPin) {
		Pin oldTargetPin = targetPin;
		targetPin = newTargetPin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__TARGET_PIN, oldTargetPin, targetPin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__CHARACTERISTICS:
				return ((InternalEList<?>)getCharacteristics()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__CHARACTERISTICS:
				return getCharacteristics();
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__SOURCE_PIN:
				if (resolve) return getSourcePin();
				return basicGetSourcePin();
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__TARGET_PIN:
				if (resolve) return getTargetPin();
				return basicGetTargetPin();
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
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__CHARACTERISTICS:
				getCharacteristics().clear();
				getCharacteristics().addAll((Collection<? extends Characteristic>)newValue);
				return;
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__SOURCE_PIN:
				setSourcePin((Pin)newValue);
				return;
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__TARGET_PIN:
				setTargetPin((Pin)newValue);
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
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__CHARACTERISTICS:
				getCharacteristics().clear();
				return;
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__SOURCE_PIN:
				setSourcePin((Pin)null);
				return;
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__TARGET_PIN:
				setTargetPin((Pin)null);
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
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__CHARACTERISTICS:
				return characteristics != null && !characteristics.isEmpty();
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__SOURCE_PIN:
				return sourcePin != null;
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__TARGET_PIN:
				return targetPin != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Characterizable.class) {
			switch (derivedFeatureID) {
				case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__CHARACTERISTICS: return DataFlowDiagramCharacterizedPackage.CHARACTERIZABLE__CHARACTERISTICS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Characterizable.class) {
			switch (baseFeatureID) {
				case DataFlowDiagramCharacterizedPackage.CHARACTERIZABLE__CHARACTERISTICS: return DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__CHARACTERISTICS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CharacterizedDataFlowImpl
