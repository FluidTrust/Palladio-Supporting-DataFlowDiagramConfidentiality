/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logic Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.LogicTerm#getTerms <em>Terms</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage#getLogicTerm()
 * @model abstract="true"
 * @generated
 */
public interface LogicTerm extends Term
{
	/**
	 * Returns the value of the '<em><b>Terms</b></em>' reference list.
	 * The list contents are of type {@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Term}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terms</em>' reference list.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage#getLogicTerm_Terms()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='self.oclAsType(ecore::EObject).eContents()-&gt;selectByKind(Term)-&gt;asSet()'"
	 * @generated
	 */
	EList<Term> getTerms();

} // LogicTerm
