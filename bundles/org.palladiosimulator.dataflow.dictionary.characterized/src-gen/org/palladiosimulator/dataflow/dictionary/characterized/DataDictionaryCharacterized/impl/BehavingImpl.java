/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behaving</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehavingImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehavingImpl#getOwnedBehavior <em>Owned Behavior</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehavingImpl#getReferencedBehavior <em>Referenced Behavior</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BehavingImpl extends MinimalEObjectImpl.Container implements Behaving {
	/**
	 * The cached setting delegate for the '{@link #getBehavior() <em>Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate BEHAVIOR__ESETTING_DELEGATE = ((EStructuralFeature.Internal)DataDictionaryCharacterizedPackage.Literals.BEHAVING__BEHAVIOR).getSettingDelegate();

	/**
	 * The cached value of the '{@link #getOwnedBehavior() <em>Owned Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBehavior()
	 * @generated
	 * @ordered
	 */
	protected BehaviorDefinition ownedBehavior;

	/**
	 * The cached value of the '{@link #getReferencedBehavior() <em>Referenced Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedBehavior()
	 * @generated
	 * @ordered
	 */
	protected BehaviorDefinition referencedBehavior;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehavingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataDictionaryCharacterizedPackage.Literals.BEHAVING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorDefinition getBehavior() {
		return (BehaviorDefinition)BEHAVIOR__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorDefinition basicGetBehavior() {
		return (BehaviorDefinition)BEHAVIOR__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorDefinition getOwnedBehavior() {
		return ownedBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedBehavior(BehaviorDefinition newOwnedBehavior, NotificationChain msgs) {
		BehaviorDefinition oldOwnedBehavior = ownedBehavior;
		ownedBehavior = newOwnedBehavior;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataDictionaryCharacterizedPackage.BEHAVING__OWNED_BEHAVIOR, oldOwnedBehavior, newOwnedBehavior);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedBehavior(BehaviorDefinition newOwnedBehavior) {
		if (newOwnedBehavior != ownedBehavior) {
			NotificationChain msgs = null;
			if (ownedBehavior != null)
				msgs = ((InternalEObject)ownedBehavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataDictionaryCharacterizedPackage.BEHAVING__OWNED_BEHAVIOR, null, msgs);
			if (newOwnedBehavior != null)
				msgs = ((InternalEObject)newOwnedBehavior).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataDictionaryCharacterizedPackage.BEHAVING__OWNED_BEHAVIOR, null, msgs);
			msgs = basicSetOwnedBehavior(newOwnedBehavior, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataDictionaryCharacterizedPackage.BEHAVING__OWNED_BEHAVIOR, newOwnedBehavior, newOwnedBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorDefinition getReferencedBehavior() {
		if (referencedBehavior != null && referencedBehavior.eIsProxy()) {
			InternalEObject oldReferencedBehavior = (InternalEObject)referencedBehavior;
			referencedBehavior = (BehaviorDefinition)eResolveProxy(oldReferencedBehavior);
			if (referencedBehavior != oldReferencedBehavior) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataDictionaryCharacterizedPackage.BEHAVING__REFERENCED_BEHAVIOR, oldReferencedBehavior, referencedBehavior));
			}
		}
		return referencedBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorDefinition basicGetReferencedBehavior() {
		return referencedBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedBehavior(BehaviorDefinition newReferencedBehavior) {
		BehaviorDefinition oldReferencedBehavior = referencedBehavior;
		referencedBehavior = newReferencedBehavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataDictionaryCharacterizedPackage.BEHAVING__REFERENCED_BEHAVIOR, oldReferencedBehavior, referencedBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataDictionaryCharacterizedPackage.BEHAVING__OWNED_BEHAVIOR:
				return basicSetOwnedBehavior(null, msgs);
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
			case DataDictionaryCharacterizedPackage.BEHAVING__BEHAVIOR:
				if (resolve) return getBehavior();
				return basicGetBehavior();
			case DataDictionaryCharacterizedPackage.BEHAVING__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case DataDictionaryCharacterizedPackage.BEHAVING__REFERENCED_BEHAVIOR:
				if (resolve) return getReferencedBehavior();
				return basicGetReferencedBehavior();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DataDictionaryCharacterizedPackage.BEHAVING__OWNED_BEHAVIOR:
				setOwnedBehavior((BehaviorDefinition)newValue);
				return;
			case DataDictionaryCharacterizedPackage.BEHAVING__REFERENCED_BEHAVIOR:
				setReferencedBehavior((BehaviorDefinition)newValue);
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
			case DataDictionaryCharacterizedPackage.BEHAVING__OWNED_BEHAVIOR:
				setOwnedBehavior((BehaviorDefinition)null);
				return;
			case DataDictionaryCharacterizedPackage.BEHAVING__REFERENCED_BEHAVIOR:
				setReferencedBehavior((BehaviorDefinition)null);
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
			case DataDictionaryCharacterizedPackage.BEHAVING__BEHAVIOR:
				return BEHAVIOR__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case DataDictionaryCharacterizedPackage.BEHAVING__OWNED_BEHAVIOR:
				return ownedBehavior != null;
			case DataDictionaryCharacterizedPackage.BEHAVING__REFERENCED_BEHAVIOR:
				return referencedBehavior != null;
		}
		return super.eIsSet(featureID);
	}

} //BehavingImpl
