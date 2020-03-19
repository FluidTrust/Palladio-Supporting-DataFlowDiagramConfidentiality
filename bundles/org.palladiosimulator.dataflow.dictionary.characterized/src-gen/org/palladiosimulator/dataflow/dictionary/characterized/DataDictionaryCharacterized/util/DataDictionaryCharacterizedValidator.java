/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.util;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage
 * @generated
 */
public class DataDictionaryCharacterizedValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final DataDictionaryCharacterizedValidator INSTANCE = new DataDictionaryCharacterizedValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized";

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
	public DataDictionaryCharacterizedValidator() {
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
	  return DataDictionaryCharacterizedPackage.eINSTANCE;
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
			case DataDictionaryCharacterizedPackage.ENTITY:
				return validateEntity((Entity)value, diagnostics, context);
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED:
				return validateDataDictionaryCharacterized((DataDictionaryCharacterized)value, diagnostics, context);
			case DataDictionaryCharacterizedPackage.CHARACTERISTIC_TYPE:
				return validateCharacteristicType((CharacteristicType)value, diagnostics, context);
			case DataDictionaryCharacterizedPackage.ENUM_CHARACTERISTIC_TYPE:
				return validateEnumCharacteristicType((EnumCharacteristicType)value, diagnostics, context);
			case DataDictionaryCharacterizedPackage.ENUMERATION:
				return validateEnumeration((Enumeration)value, diagnostics, context);
			case DataDictionaryCharacterizedPackage.LITERAL:
				return validateLiteral((Literal)value, diagnostics, context);
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION:
				return validateBehaviorDefinition((BehaviorDefinition)value, diagnostics, context);
			case DataDictionaryCharacterizedPackage.PIN:
				return validatePin((Pin)value, diagnostics, context);
			case DataDictionaryCharacterizedPackage.ASSIGNMENT:
				return validateAssignment((Assignment)value, diagnostics, context);
			case DataDictionaryCharacterizedPackage.BEHAVING:
				return validateBehaving((Behaving)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntity(Entity entity, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(entity, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(entity, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(entity, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataDictionaryCharacterized(DataDictionaryCharacterized dataDictionaryCharacterized, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(dataDictionaryCharacterized, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(dataDictionaryCharacterized, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dataDictionaryCharacterized, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dataDictionaryCharacterized, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dataDictionaryCharacterized, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dataDictionaryCharacterized, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dataDictionaryCharacterized, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dataDictionaryCharacterized, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dataDictionaryCharacterized, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(dataDictionaryCharacterized, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacteristicType(CharacteristicType characteristicType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(characteristicType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(characteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(characteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(characteristicType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumCharacteristicType(EnumCharacteristicType enumCharacteristicType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumCharacteristicType, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(enumCharacteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enumCharacteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enumCharacteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(enumCharacteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(enumCharacteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(enumCharacteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(enumCharacteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enumCharacteristicType, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(enumCharacteristicType, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumeration(Enumeration enumeration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumeration, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enumeration, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(enumeration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLiteral(Literal literal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(literal, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(literal, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(literal, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(literal, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehaviorDefinition(BehaviorDefinition behaviorDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(behaviorDefinition, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(behaviorDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(behaviorDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(behaviorDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(behaviorDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(behaviorDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(behaviorDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(behaviorDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(behaviorDefinition, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(behaviorDefinition, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePin(Pin pin, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(pin, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(pin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(pin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pin, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pin, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(pin, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignment(Assignment assignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(assignment, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignment_leftHandSideRefersOutputPin(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignment_characteristicWildcardHasToBeOnLhsAndRhs(assignment, diagnostics, context);
		if (result || diagnostics != null) result &= validateAssignment_literalWildcardHasToBeOnLhsAndRhs(assignment, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the leftHandSideRefersOutputPin constraint of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ASSIGNMENT__LEFT_HAND_SIDE_REFERS_OUTPUT_PIN__EEXPRESSION = "self.oclAsType(ecore::EObject).eContainer().oclAsType(BehaviorDefinition).outputs->includes(self.lhs.pin)";

	/**
	 * Validates the leftHandSideRefersOutputPin constraint of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignment_leftHandSideRefersOutputPin(Assignment assignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DataDictionaryCharacterizedPackage.Literals.ASSIGNMENT,
				 assignment,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "leftHandSideRefersOutputPin",
				 ASSIGNMENT__LEFT_HAND_SIDE_REFERS_OUTPUT_PIN__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the characteristicWildcardHasToBeOnLhsAndRhs constraint of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ASSIGNMENT__CHARACTERISTIC_WILDCARD_HAS_TO_BE_ON_LHS_AND_RHS__EEXPRESSION = "not self.rhs.oclIsKindOf(expressions::CharacteristicReference) or\n" +
		"(\n" +
		"\tself.rhs.oclAsType(expressions::CharacteristicReference).characteristicType.oclIsUndefined()\n" +
		"\tand\n" +
		"\tself.lhs.characteristicType.oclIsUndefined()\n" +
		")\n" +
		"or\n" +
		"(\n" +
		"\tnot self.rhs.oclAsType(expressions::CharacteristicReference).characteristicType.oclIsUndefined()\n" +
		"\tand\n" +
		"\tnot self.lhs.characteristicType.oclIsUndefined()\n" +
		")";

	/**
	 * Validates the characteristicWildcardHasToBeOnLhsAndRhs constraint of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignment_characteristicWildcardHasToBeOnLhsAndRhs(Assignment assignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DataDictionaryCharacterizedPackage.Literals.ASSIGNMENT,
				 assignment,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "characteristicWildcardHasToBeOnLhsAndRhs",
				 ASSIGNMENT__CHARACTERISTIC_WILDCARD_HAS_TO_BE_ON_LHS_AND_RHS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the literalWildcardHasToBeOnLhsAndRhs constraint of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ASSIGNMENT__LITERAL_WILDCARD_HAS_TO_BE_ON_LHS_AND_RHS__EEXPRESSION = "not self.rhs.oclIsKindOf(expressions::CharacteristicReference) or\n" +
		"(\n" +
		"\tself.rhs.oclAsType(expressions::CharacteristicReference).literal.oclIsUndefined()\n" +
		"\tand\n" +
		"\tself.lhs.literal.oclIsUndefined()\n" +
		")\n" +
		"or\n" +
		"(\n" +
		"\tnot self.rhs.oclAsType(expressions::CharacteristicReference).literal.oclIsUndefined()\n" +
		"\tand\n" +
		"\tnot self.lhs.literal.oclIsUndefined()\n" +
		")";

	/**
	 * Validates the literalWildcardHasToBeOnLhsAndRhs constraint of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssignment_literalWildcardHasToBeOnLhsAndRhs(Assignment assignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DataDictionaryCharacterizedPackage.Literals.ASSIGNMENT,
				 assignment,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "literalWildcardHasToBeOnLhsAndRhs",
				 ASSIGNMENT__LITERAL_WILDCARD_HAS_TO_BE_ON_LHS_AND_RHS__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehaving(Behaving behaving, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(behaving, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(behaving, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(behaving, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(behaving, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(behaving, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(behaving, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(behaving, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(behaving, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(behaving, diagnostics, context);
		if (result || diagnostics != null) result &= validateBehaving_exactlyOneBehaviorHasToBeSpecified(behaving, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the exactlyOneBehaviorHasToBeSpecified constraint of '<em>Behaving</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String BEHAVING__EXACTLY_ONE_BEHAVIOR_HAS_TO_BE_SPECIFIED__EEXPRESSION = "self.ownedBehavior->including(self.referencedBehavior)->selectByKind(BehaviorDefinition)->size() = 1";

	/**
	 * Validates the exactlyOneBehaviorHasToBeSpecified constraint of '<em>Behaving</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehaving_exactlyOneBehaviorHasToBeSpecified(Behaving behaving, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DataDictionaryCharacterizedPackage.Literals.BEHAVING,
				 behaving,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "exactlyOneBehaviorHasToBeSpecified",
				 BEHAVING__EXACTLY_ONE_BEHAVIOR_HAS_TO_BE_SPECIFIED__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
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

} //DataDictionaryCharacterizedValidator
