/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.util;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsSwitch() {
		if (modelPackage == null) {
			modelPackage = ExpressionsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExpressionsPackage.TERM: {
				Term term = (Term)theEObject;
				T result = caseTerm(term);
				if (result == null) result = caseIdentifier(term);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CONSTANT: {
				Constant constant = (Constant)theEObject;
				T result = caseConstant(constant);
				if (result == null) result = caseTerm(constant);
				if (result == null) result = caseIdentifier(constant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.TRUE: {
				True true_ = (True)theEObject;
				T result = caseTrue(true_);
				if (result == null) result = caseConstant(true_);
				if (result == null) result = caseTerm(true_);
				if (result == null) result = caseIdentifier(true_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.FALSE: {
				False false_ = (False)theEObject;
				T result = caseFalse(false_);
				if (result == null) result = caseConstant(false_);
				if (result == null) result = caseTerm(false_);
				if (result == null) result = caseIdentifier(false_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.LOGIC_TERM: {
				LogicTerm logicTerm = (LogicTerm)theEObject;
				T result = caseLogicTerm(logicTerm);
				if (result == null) result = caseTerm(logicTerm);
				if (result == null) result = caseIdentifier(logicTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.UNARY_LOGIC_TERM: {
				UnaryLogicTerm unaryLogicTerm = (UnaryLogicTerm)theEObject;
				T result = caseUnaryLogicTerm(unaryLogicTerm);
				if (result == null) result = caseLogicTerm(unaryLogicTerm);
				if (result == null) result = caseTerm(unaryLogicTerm);
				if (result == null) result = caseIdentifier(unaryLogicTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.NOT: {
				Not not = (Not)theEObject;
				T result = caseNot(not);
				if (result == null) result = caseUnaryLogicTerm(not);
				if (result == null) result = caseLogicTerm(not);
				if (result == null) result = caseTerm(not);
				if (result == null) result = caseIdentifier(not);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.BINARY_LOGIC_TERM: {
				BinaryLogicTerm binaryLogicTerm = (BinaryLogicTerm)theEObject;
				T result = caseBinaryLogicTerm(binaryLogicTerm);
				if (result == null) result = caseLogicTerm(binaryLogicTerm);
				if (result == null) result = caseTerm(binaryLogicTerm);
				if (result == null) result = caseIdentifier(binaryLogicTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.AND: {
				And and = (And)theEObject;
				T result = caseAnd(and);
				if (result == null) result = caseBinaryLogicTerm(and);
				if (result == null) result = caseLogicTerm(and);
				if (result == null) result = caseTerm(and);
				if (result == null) result = caseIdentifier(and);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.OR: {
				Or or = (Or)theEObject;
				T result = caseOr(or);
				if (result == null) result = caseBinaryLogicTerm(or);
				if (result == null) result = caseLogicTerm(or);
				if (result == null) result = caseTerm(or);
				if (result == null) result = caseIdentifier(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CHARACTERISTIC_REFERENCE: {
				CharacteristicReference characteristicReference = (CharacteristicReference)theEObject;
				T result = caseCharacteristicReference(characteristicReference);
				if (result == null) result = caseTerm(characteristicReference);
				if (result == null) result = caseIdentifier(characteristicReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.CONTAINER_CHARACTERISTIC_REFERENCE: {
				ContainerCharacteristicReference containerCharacteristicReference = (ContainerCharacteristicReference)theEObject;
				T result = caseContainerCharacteristicReference(containerCharacteristicReference);
				if (result == null) result = caseCharacteristicReference(containerCharacteristicReference);
				if (result == null) result = caseTerm(containerCharacteristicReference);
				if (result == null) result = caseIdentifier(containerCharacteristicReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionsPackage.DATA_CHARACTERISTIC_REFERENCE: {
				DataCharacteristicReference dataCharacteristicReference = (DataCharacteristicReference)theEObject;
				T result = caseDataCharacteristicReference(dataCharacteristicReference);
				if (result == null) result = caseCharacteristicReference(dataCharacteristicReference);
				if (result == null) result = caseTerm(dataCharacteristicReference);
				if (result == null) result = caseIdentifier(dataCharacteristicReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerm(Term object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstant(Constant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrue(True object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>False</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>False</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFalse(False object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logic Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logic Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicTerm(LogicTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Logic Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Logic Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryLogicTerm(UnaryLogicTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNot(Not object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Logic Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Logic Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryLogicTerm(BinaryLogicTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnd(And object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOr(Or object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characteristic Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characteristic Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacteristicReference(CharacteristicReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Characteristic Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Characteristic Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerCharacteristicReference(ContainerCharacteristicReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Characteristic Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Characteristic Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataCharacteristicReference(DataCharacteristicReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ExpressionsSwitch
