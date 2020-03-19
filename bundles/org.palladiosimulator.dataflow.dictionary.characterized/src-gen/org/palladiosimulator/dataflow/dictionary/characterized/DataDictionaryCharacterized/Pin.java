/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getPin()
 * @model
 * @generated
 */
public interface Pin extends Entity
{
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#getPin_Owner()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='self.oclAsType(ecore::EObject).eContainer().oclAsType(BehaviorDefinition)'"
	 * @generated
	 */
	BehaviorDefinition getOwner();

} // Pin
