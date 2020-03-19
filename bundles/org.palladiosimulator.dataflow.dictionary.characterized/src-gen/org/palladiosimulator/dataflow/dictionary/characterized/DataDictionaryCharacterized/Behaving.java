/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behaving</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving#getOwnedBehavior <em>Owned Behavior</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving#getReferencedBehavior <em>Referenced Behavior</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getBehaving()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='exactlyOneBehaviorHasToBeSpecified'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL exactlyOneBehaviorHasToBeSpecified='self.ownedBehavior-&gt;including(self.referencedBehavior)-&gt;selectByKind(BehaviorDefinition)-&gt;size() = 1'"
 * @generated
 */
public interface Behaving extends EObject {
	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' reference.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getBehaving_Behavior()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='self.ownedBehavior-&gt;including(self.referencedBehavior)-&gt;selectByKind(BehaviorDefinition)-&gt;any(true)'"
	 * @generated
	 */
	BehaviorDefinition getBehavior();

	/**
	 * Returns the value of the '<em><b>Owned Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Behavior</em>' containment reference.
	 * @see #setOwnedBehavior(BehaviorDefinition)
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getBehaving_OwnedBehavior()
	 * @model containment="true"
	 * @generated
	 */
	BehaviorDefinition getOwnedBehavior();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving#getOwnedBehavior <em>Owned Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Behavior</em>' containment reference.
	 * @see #getOwnedBehavior()
	 * @generated
	 */
	void setOwnedBehavior(BehaviorDefinition value);

	/**
	 * Returns the value of the '<em><b>Referenced Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Behavior</em>' reference.
	 * @see #setReferencedBehavior(BehaviorDefinition)
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getBehaving_ReferencedBehavior()
	 * @model
	 * @generated
	 */
	BehaviorDefinition getReferencedBehavior();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving#getReferencedBehavior <em>Referenced Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Behavior</em>' reference.
	 * @see #getReferencedBehavior()
	 * @generated
	 */
	void setReferencedBehavior(BehaviorDefinition value);

} // Behaving
