/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.impl.StoreImpl;

import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characteristic;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characterizable;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedNode;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Characterized Store</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedStoreImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedStoreImpl#getOwnedBehavior <em>Owned Behavior</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedStoreImpl#getReferencedBehavior <em>Referenced Behavior</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedStoreImpl#getCharacteristics <em>Characteristics</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CharacterizedStoreImpl extends StoreImpl implements CharacterizedStore {
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
	 * The cached value of the '{@link #getCharacteristics() <em>Characteristics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacteristics()
	 * @generated
	 * @ordered
	 */
	protected EList<Characteristic> characteristics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CharacterizedStoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataFlowDiagramCharacterizedPackage.Literals.CHARACTERIZED_STORE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__OWNED_BEHAVIOR, oldOwnedBehavior, newOwnedBehavior);
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
				msgs = ((InternalEObject)ownedBehavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__OWNED_BEHAVIOR, null, msgs);
			if (newOwnedBehavior != null)
				msgs = ((InternalEObject)newOwnedBehavior).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__OWNED_BEHAVIOR, null, msgs);
			msgs = basicSetOwnedBehavior(newOwnedBehavior, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__OWNED_BEHAVIOR, newOwnedBehavior, newOwnedBehavior));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__REFERENCED_BEHAVIOR, oldReferencedBehavior, referencedBehavior));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__REFERENCED_BEHAVIOR, oldReferencedBehavior, referencedBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Characteristic> getCharacteristics() {
		if (characteristics == null) {
			characteristics = new EObjectContainmentEList<Characteristic>(Characteristic.class, this, DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__CHARACTERISTICS);
		}
		return characteristics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__OWNED_BEHAVIOR:
				return basicSetOwnedBehavior(null, msgs);
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__CHARACTERISTICS:
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
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__BEHAVIOR:
				if (resolve) return getBehavior();
				return basicGetBehavior();
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__OWNED_BEHAVIOR:
				return getOwnedBehavior();
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__REFERENCED_BEHAVIOR:
				if (resolve) return getReferencedBehavior();
				return basicGetReferencedBehavior();
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__CHARACTERISTICS:
				return getCharacteristics();
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
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__OWNED_BEHAVIOR:
				setOwnedBehavior((BehaviorDefinition)newValue);
				return;
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__REFERENCED_BEHAVIOR:
				setReferencedBehavior((BehaviorDefinition)newValue);
				return;
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__CHARACTERISTICS:
				getCharacteristics().clear();
				getCharacteristics().addAll((Collection<? extends Characteristic>)newValue);
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
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__OWNED_BEHAVIOR:
				setOwnedBehavior((BehaviorDefinition)null);
				return;
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__REFERENCED_BEHAVIOR:
				setReferencedBehavior((BehaviorDefinition)null);
				return;
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__CHARACTERISTICS:
				getCharacteristics().clear();
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
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__BEHAVIOR:
				return BEHAVIOR__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__OWNED_BEHAVIOR:
				return ownedBehavior != null;
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__REFERENCED_BEHAVIOR:
				return referencedBehavior != null;
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__CHARACTERISTICS:
				return characteristics != null && !characteristics.isEmpty();
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
		if (baseClass == Behaving.class) {
			switch (derivedFeatureID) {
				case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__BEHAVIOR: return DataDictionaryCharacterizedPackage.BEHAVING__BEHAVIOR;
				case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__OWNED_BEHAVIOR: return DataDictionaryCharacterizedPackage.BEHAVING__OWNED_BEHAVIOR;
				case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__REFERENCED_BEHAVIOR: return DataDictionaryCharacterizedPackage.BEHAVING__REFERENCED_BEHAVIOR;
				default: return -1;
			}
		}
		if (baseClass == Characterizable.class) {
			switch (derivedFeatureID) {
				case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__CHARACTERISTICS: return DataFlowDiagramCharacterizedPackage.CHARACTERIZABLE__CHARACTERISTICS;
				default: return -1;
			}
		}
		if (baseClass == CharacterizedNode.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == Behaving.class) {
			switch (baseFeatureID) {
				case DataDictionaryCharacterizedPackage.BEHAVING__BEHAVIOR: return DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__BEHAVIOR;
				case DataDictionaryCharacterizedPackage.BEHAVING__OWNED_BEHAVIOR: return DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__OWNED_BEHAVIOR;
				case DataDictionaryCharacterizedPackage.BEHAVING__REFERENCED_BEHAVIOR: return DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__REFERENCED_BEHAVIOR;
				default: return -1;
			}
		}
		if (baseClass == Characterizable.class) {
			switch (baseFeatureID) {
				case DataFlowDiagramCharacterizedPackage.CHARACTERIZABLE__CHARACTERISTICS: return DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE__CHARACTERISTICS;
				default: return -1;
			}
		}
		if (baseClass == CharacterizedNode.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CharacterizedStoreImpl
