/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.util;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ExpressionsValidator INSTANCE = new ExpressionsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierValidator identifierValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsValidator() {
		super();
		identifierValidator = IdentifierValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ExpressionsPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case ExpressionsPackage.TERM:
				return validateTerm((Term)value, diagnostics, context);
			case ExpressionsPackage.CONSTANT:
				return validateConstant((Constant)value, diagnostics, context);
			case ExpressionsPackage.TRUE:
				return validateTrue((True)value, diagnostics, context);
			case ExpressionsPackage.FALSE:
				return validateFalse((False)value, diagnostics, context);
			case ExpressionsPackage.LOGIC_TERM:
				return validateLogicTerm((LogicTerm)value, diagnostics, context);
			case ExpressionsPackage.UNARY_LOGIC_TERM:
				return validateUnaryLogicTerm((UnaryLogicTerm)value, diagnostics, context);
			case ExpressionsPackage.NOT:
				return validateNot((Not)value, diagnostics, context);
			case ExpressionsPackage.BINARY_LOGIC_TERM:
				return validateBinaryLogicTerm((BinaryLogicTerm)value, diagnostics, context);
			case ExpressionsPackage.AND:
				return validateAnd((And)value, diagnostics, context);
			case ExpressionsPackage.OR:
				return validateOr((Or)value, diagnostics, context);
			case ExpressionsPackage.CHARACTERISTIC_REFERENCE:
				return validateCharacteristicReference((CharacteristicReference)value, diagnostics, context);
			case ExpressionsPackage.CONTAINER_CHARACTERISTIC_REFERENCE:
				return validateContainerCharacteristicReference((ContainerCharacteristicReference)value, diagnostics, context);
			case ExpressionsPackage.DATA_CHARACTERISTIC_REFERENCE:
				return validateDataCharacteristicReference((DataCharacteristicReference)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTerm(Term term, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(term, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(term, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(term, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(term, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstant(Constant constant, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(constant, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(constant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(constant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(constant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(constant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(constant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(constant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(constant, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(constant, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(constant, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTrue(True true_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(true_, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(true_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(true_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(true_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(true_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(true_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(true_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(true_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(true_, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(true_, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFalse(False false_, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(false_, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(false_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(false_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(false_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(false_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(false_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(false_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(false_, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(false_, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(false_, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLogicTerm(LogicTerm logicTerm, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(logicTerm, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(logicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(logicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(logicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(logicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(logicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(logicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(logicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(logicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(logicTerm, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUnaryLogicTerm(UnaryLogicTerm unaryLogicTerm, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(unaryLogicTerm, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(unaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(unaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(unaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(unaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(unaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(unaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(unaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(unaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(unaryLogicTerm, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNot(Not not, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(not, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(not, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(not, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(not, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBinaryLogicTerm(BinaryLogicTerm binaryLogicTerm, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(binaryLogicTerm, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(binaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(binaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(binaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(binaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(binaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(binaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(binaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(binaryLogicTerm, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(binaryLogicTerm, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnd(And and, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(and, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(and, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(and, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(and, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOr(Or or, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(or, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(or, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(or, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(or, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacteristicReference(CharacteristicReference characteristicReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(characteristicReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(characteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(characteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(characteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacteristicReference_literalHasToBeWildcardIfCharacteristicIsWildcard(characteristicReference, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the literalHasToBeWildcardIfCharacteristicIsWildcard constraint of '<em>Characteristic Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHARACTERISTIC_REFERENCE__LITERAL_HAS_TO_BE_WILDCARD_IF_CHARACTERISTIC_IS_WILDCARD__EEXPRESSION = "not self.characteristicType.oclIsUndefined() or self.literal.oclIsUndefined()";

	/**
	 * Validates the literalHasToBeWildcardIfCharacteristicIsWildcard constraint of '<em>Characteristic Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacteristicReference_literalHasToBeWildcardIfCharacteristicIsWildcard(CharacteristicReference characteristicReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(ExpressionsPackage.Literals.CHARACTERISTIC_REFERENCE,
				 characteristicReference,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "literalHasToBeWildcardIfCharacteristicIsWildcard",
				 CHARACTERISTIC_REFERENCE__LITERAL_HAS_TO_BE_WILDCARD_IF_CHARACTERISTIC_IS_WILDCARD__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainerCharacteristicReference(ContainerCharacteristicReference containerCharacteristicReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(containerCharacteristicReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(containerCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(containerCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(containerCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(containerCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(containerCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(containerCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(containerCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(containerCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(containerCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacteristicReference_literalHasToBeWildcardIfCharacteristicIsWildcard(containerCharacteristicReference, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataCharacteristicReference(DataCharacteristicReference dataCharacteristicReference, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataCharacteristicReference, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(dataCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dataCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dataCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dataCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dataCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dataCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dataCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dataCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(dataCharacteristicReference, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacteristicReference_literalHasToBeWildcardIfCharacteristicIsWildcard(dataCharacteristicReference, diagnostics, context);
		return result;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //ExpressionsValidator
