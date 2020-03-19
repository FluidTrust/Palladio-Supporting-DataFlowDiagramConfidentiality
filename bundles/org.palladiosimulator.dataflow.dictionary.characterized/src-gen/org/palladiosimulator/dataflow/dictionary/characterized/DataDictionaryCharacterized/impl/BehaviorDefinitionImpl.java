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

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehaviorDefinitionImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehaviorDefinitionImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehaviorDefinitionImpl#getAssignments <em>Assignments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BehaviorDefinitionImpl extends EntityImpl implements BehaviorDefinition
{
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Pin> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Pin> outputs;

	/**
	 * The cached value of the '{@link #getAssignments() <em>Assignments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<Assignment> assignments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehaviorDefinitionImpl()
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
		return DataDictionaryCharacterizedPackage.Literals.BEHAVIOR_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Pin> getInputs()
	{
		if (inputs == null) {
			inputs = new EObjectContainmentEList<Pin>(Pin.class, this, DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Pin> getOutputs()
	{
		if (outputs == null) {
			outputs = new EObjectContainmentEList<Pin>(Pin.class, this, DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assignment> getAssignments()
	{
		if (assignments == null) {
			assignments = new EObjectContainmentEList<Assignment>(Assignment.class, this, DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__ASSIGNMENTS);
		}
		return assignments;
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
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__ASSIGNMENTS:
				return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
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
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__INPUTS:
				return getInputs();
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__OUTPUTS:
				return getOutputs();
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__ASSIGNMENTS:
				return getAssignments();
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
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Pin>)newValue);
				return;
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Pin>)newValue);
				return;
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__ASSIGNMENTS:
				getAssignments().clear();
				getAssignments().addAll((Collection<? extends Assignment>)newValue);
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
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__INPUTS:
				getInputs().clear();
				return;
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__OUTPUTS:
				getOutputs().clear();
				return;
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__ASSIGNMENTS:
				getAssignments().clear();
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
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION__ASSIGNMENTS:
				return assignments != null && !assignments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BehaviorDefinitionImpl
