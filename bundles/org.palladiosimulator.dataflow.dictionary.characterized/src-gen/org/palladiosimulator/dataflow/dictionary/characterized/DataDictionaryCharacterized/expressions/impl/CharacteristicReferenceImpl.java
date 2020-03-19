/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Characteristic Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.CharacteristicReferenceImpl#getCharacteristicType <em>Characteristic Type</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.CharacteristicReferenceImpl#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CharacteristicReferenceImpl extends TermImpl implements CharacteristicReference
{
	/**
	 * The cached value of the '{@link #getCharacteristicType() <em>Characteristic Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacteristicType()
	 * @generated
	 * @ordered
	 */
	protected CharacteristicType characteristicType;

	/**
	 * The cached value of the '{@link #getLiteral() <em>Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteral()
	 * @generated
	 * @ordered
	 */
	protected Literal literal;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CharacteristicReferenceImpl()
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
		return ExpressionsPackage.Literals.CHARACTERISTIC_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacteristicType getCharacteristicType()
	{
		if (characteristicType != null && characteristicType.eIsProxy()) {
			InternalEObject oldCharacteristicType = (InternalEObject)characteristicType;
			characteristicType = (CharacteristicType)eResolveProxy(oldCharacteristicType);
			if (characteristicType != oldCharacteristicType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE, oldCharacteristicType, characteristicType));
			}
		}
		return characteristicType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacteristicType basicGetCharacteristicType()
	{
		return characteristicType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacteristicType(CharacteristicType newCharacteristicType)
	{
		CharacteristicType oldCharacteristicType = characteristicType;
		characteristicType = newCharacteristicType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE, oldCharacteristicType, characteristicType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal getLiteral()
	{
		if (literal != null && literal.eIsProxy()) {
			InternalEObject oldLiteral = (InternalEObject)literal;
			literal = (Literal)eResolveProxy(oldLiteral);
			if (literal != oldLiteral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.CHARACTERISTIC_REFERENCE__LITERAL, oldLiteral, literal));
			}
		}
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal basicGetLiteral()
	{
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiteral(Literal newLiteral)
	{
		Literal oldLiteral = literal;
		literal = newLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CHARACTERISTIC_REFERENCE__LITERAL, oldLiteral, literal));
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
			case ExpressionsPackage.CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE:
				if (resolve) return getCharacteristicType();
				return basicGetCharacteristicType();
			case ExpressionsPackage.CHARACTERISTIC_REFERENCE__LITERAL:
				if (resolve) return getLiteral();
				return basicGetLiteral();
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
			case ExpressionsPackage.CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE:
				setCharacteristicType((CharacteristicType)newValue);
				return;
			case ExpressionsPackage.CHARACTERISTIC_REFERENCE__LITERAL:
				setLiteral((Literal)newValue);
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
			case ExpressionsPackage.CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE:
				setCharacteristicType((CharacteristicType)null);
				return;
			case ExpressionsPackage.CHARACTERISTIC_REFERENCE__LITERAL:
				setLiteral((Literal)null);
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
			case ExpressionsPackage.CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE:
				return characteristicType != null;
			case ExpressionsPackage.CHARACTERISTIC_REFERENCE__LITERAL:
				return literal != null;
		}
		return super.eIsSet(featureID);
	}

} //CharacteristicReferenceImpl
