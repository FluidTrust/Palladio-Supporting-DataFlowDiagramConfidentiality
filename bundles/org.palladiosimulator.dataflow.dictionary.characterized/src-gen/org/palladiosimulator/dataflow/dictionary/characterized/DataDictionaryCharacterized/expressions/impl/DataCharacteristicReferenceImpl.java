/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Characteristic Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.DataCharacteristicReferenceImpl#getPin <em>Pin</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataCharacteristicReferenceImpl extends CharacteristicReferenceImpl implements DataCharacteristicReference
{
	/**
	 * The cached value of the '{@link #getPin() <em>Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPin()
	 * @generated
	 * @ordered
	 */
	protected Pin pin;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataCharacteristicReferenceImpl()
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
		return ExpressionsPackage.Literals.DATA_CHARACTERISTIC_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin getPin()
	{
		if (pin != null && pin.eIsProxy()) {
			InternalEObject oldPin = (InternalEObject)pin;
			pin = (Pin)eResolveProxy(oldPin);
			if (pin != oldPin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.DATA_CHARACTERISTIC_REFERENCE__PIN, oldPin, pin));
			}
		}
		return pin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin basicGetPin()
	{
		return pin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPin(Pin newPin)
	{
		Pin oldPin = pin;
		pin = newPin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.DATA_CHARACTERISTIC_REFERENCE__PIN, oldPin, pin));
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
			case ExpressionsPackage.DATA_CHARACTERISTIC_REFERENCE__PIN:
				if (resolve) return getPin();
				return basicGetPin();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case ExpressionsPackage.DATA_CHARACTERISTIC_REFERENCE__PIN:
				setPin((Pin)newValue);
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
			case ExpressionsPackage.DATA_CHARACTERISTIC_REFERENCE__PIN:
				setPin((Pin)null);
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
			case ExpressionsPackage.DATA_CHARACTERISTIC_REFERENCE__PIN:
				return pin != null;
		}
		return super.eIsSet(featureID);
	}

} //DataCharacteristicReferenceImpl
