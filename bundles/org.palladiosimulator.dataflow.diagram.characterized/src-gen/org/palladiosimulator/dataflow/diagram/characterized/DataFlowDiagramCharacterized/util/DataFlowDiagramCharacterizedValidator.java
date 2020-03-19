/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.util;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.*;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.util.DataDictionaryCharacterizedValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage
 * @generated
 */
public class DataFlowDiagramCharacterizedValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final DataFlowDiagramCharacterizedValidator INSTANCE = new DataFlowDiagramCharacterizedValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized";

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
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataDictionaryCharacterizedValidator dataDictionaryCharacterizedValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowDiagramCharacterizedValidator() {
		super();
		identifierValidator = IdentifierValidator.INSTANCE;
		dataDictionaryCharacterizedValidator = DataDictionaryCharacterizedValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return DataFlowDiagramCharacterizedPackage.eINSTANCE;
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
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZABLE:
				return validateCharacterizable((Characterizable)value, diagnostics, context);
			case DataFlowDiagramCharacterizedPackage.CHARACTERISTIC:
				return validateCharacteristic((Characteristic)value, diagnostics, context);
			case DataFlowDiagramCharacterizedPackage.ENUM_CHARACTERISTIC:
				return validateEnumCharacteristic((EnumCharacteristic)value, diagnostics, context);
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_EXTERNAL_ACTOR:
				return validateCharacterizedExternalActor((CharacterizedExternalActor)value, diagnostics, context);
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE:
				return validateCharacterizedStore((CharacterizedStore)value, diagnostics, context);
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_PROCESS:
				return validateCharacterizedProcess((CharacterizedProcess)value, diagnostics, context);
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA:
				return validateCharacterizedData((CharacterizedData)value, diagnostics, context);
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW:
				return validateCharacterizedDataFlow((CharacterizedDataFlow)value, diagnostics, context);
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_ACTOR_PROCESS:
				return validateCharacterizedActorProcess((CharacterizedActorProcess)value, diagnostics, context);
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_NODE:
				return validateCharacterizedNode((CharacterizedNode)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizable(Characterizable characterizable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(characterizable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacteristic(Characteristic characteristic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(characteristic, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(characteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(characteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characteristic, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(characteristic, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumCharacteristic(EnumCharacteristic enumCharacteristic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(enumCharacteristic, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(enumCharacteristic, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(enumCharacteristic, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedExternalActor(CharacterizedExternalActor characterizedExternalActor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(characterizedExternalActor, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(characterizedExternalActor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characterizedExternalActor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characterizedExternalActor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(characterizedExternalActor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characterizedExternalActor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characterizedExternalActor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characterizedExternalActor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characterizedExternalActor, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(characterizedExternalActor, diagnostics, context);
		if (result || diagnostics != null) result &= dataDictionaryCharacterizedValidator.validateBehaving_exactlyOneBehaviorHasToBeSpecified(characterizedExternalActor, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacterizedNode_atLeastOneInputFlowForEachInputPin(characterizedExternalActor, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedStore(CharacterizedStore characterizedStore, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(characterizedStore, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(characterizedStore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characterizedStore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characterizedStore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(characterizedStore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characterizedStore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characterizedStore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characterizedStore, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characterizedStore, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(characterizedStore, diagnostics, context);
		if (result || diagnostics != null) result &= dataDictionaryCharacterizedValidator.validateBehaving_exactlyOneBehaviorHasToBeSpecified(characterizedStore, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacterizedNode_atLeastOneInputFlowForEachInputPin(characterizedStore, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacterizedStore_storeHasNoAssignmentsInBehavior(characterizedStore, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacterizedStore_storeHasExactlyOneInputAndOneOutputPin(characterizedStore, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the storeHasNoAssignmentsInBehavior constraint of '<em>Characterized Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHARACTERIZED_STORE__STORE_HAS_NO_ASSIGNMENTS_IN_BEHAVIOR__EEXPRESSION = "self.behavior.assignments->isEmpty()";

	/**
	 * Validates the storeHasNoAssignmentsInBehavior constraint of '<em>Characterized Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedStore_storeHasNoAssignmentsInBehavior(CharacterizedStore characterizedStore, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DataFlowDiagramCharacterizedPackage.Literals.CHARACTERIZED_STORE,
				 characterizedStore,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "storeHasNoAssignmentsInBehavior",
				 CHARACTERIZED_STORE__STORE_HAS_NO_ASSIGNMENTS_IN_BEHAVIOR__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the storeHasExactlyOneInputAndOneOutputPin constraint of '<em>Characterized Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHARACTERIZED_STORE__STORE_HAS_EXACTLY_ONE_INPUT_AND_ONE_OUTPUT_PIN__EEXPRESSION = "self.behavior.inputs->size() = 1 and self.behavior.outputs->size() = 1";

	/**
	 * Validates the storeHasExactlyOneInputAndOneOutputPin constraint of '<em>Characterized Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedStore_storeHasExactlyOneInputAndOneOutputPin(CharacterizedStore characterizedStore, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DataFlowDiagramCharacterizedPackage.Literals.CHARACTERIZED_STORE,
				 characterizedStore,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "storeHasExactlyOneInputAndOneOutputPin",
				 CHARACTERIZED_STORE__STORE_HAS_EXACTLY_ONE_INPUT_AND_ONE_OUTPUT_PIN__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedProcess(CharacterizedProcess characterizedProcess, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(characterizedProcess, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(characterizedProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characterizedProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characterizedProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(characterizedProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characterizedProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characterizedProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characterizedProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characterizedProcess, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(characterizedProcess, diagnostics, context);
		if (result || diagnostics != null) result &= dataDictionaryCharacterizedValidator.validateBehaving_exactlyOneBehaviorHasToBeSpecified(characterizedProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacterizedNode_atLeastOneInputFlowForEachInputPin(characterizedProcess, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedData(CharacterizedData characterizedData, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(characterizedData, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(characterizedData, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characterizedData, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characterizedData, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(characterizedData, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characterizedData, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characterizedData, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characterizedData, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characterizedData, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(characterizedData, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedDataFlow(CharacterizedDataFlow characterizedDataFlow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(characterizedDataFlow, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacterizedDataFlow_sourcePinIsEntityOutputPin(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacterizedDataFlow_destinationPinIsEntityInputPin(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacterizedDataFlow_sourcePinOwnerMatchesSource(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacterizedDataFlow_destinationPinOwnerMatchesDestination(characterizedDataFlow, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacterizedDataFlow_notPartOfLoop(characterizedDataFlow, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the sourcePinIsEntityOutputPin constraint of '<em>Characterized Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHARACTERIZED_DATA_FLOW__SOURCE_PIN_IS_ENTITY_OUTPUT_PIN__EEXPRESSION = "self.sourcePin.owner.outputs->includes(self.sourcePin)";

	/**
	 * Validates the sourcePinIsEntityOutputPin constraint of '<em>Characterized Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedDataFlow_sourcePinIsEntityOutputPin(CharacterizedDataFlow characterizedDataFlow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DataFlowDiagramCharacterizedPackage.Literals.CHARACTERIZED_DATA_FLOW,
				 characterizedDataFlow,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "sourcePinIsEntityOutputPin",
				 CHARACTERIZED_DATA_FLOW__SOURCE_PIN_IS_ENTITY_OUTPUT_PIN__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the destinationPinIsEntityInputPin constraint of '<em>Characterized Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHARACTERIZED_DATA_FLOW__DESTINATION_PIN_IS_ENTITY_INPUT_PIN__EEXPRESSION = "self.targetPin.owner.inputs->includes(self.targetPin)";

	/**
	 * Validates the destinationPinIsEntityInputPin constraint of '<em>Characterized Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedDataFlow_destinationPinIsEntityInputPin(CharacterizedDataFlow characterizedDataFlow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DataFlowDiagramCharacterizedPackage.Literals.CHARACTERIZED_DATA_FLOW,
				 characterizedDataFlow,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "destinationPinIsEntityInputPin",
				 CHARACTERIZED_DATA_FLOW__DESTINATION_PIN_IS_ENTITY_INPUT_PIN__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the sourcePinOwnerMatchesSource constraint of '<em>Characterized Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHARACTERIZED_DATA_FLOW__SOURCE_PIN_OWNER_MATCHES_SOURCE__EEXPRESSION = "not self.source.oclIsKindOf(DataDictionaryCharacterized::Behaving) or self.source.oclAsType(DataDictionaryCharacterized::Behaving).behavior.outputs->includes(self.sourcePin)";

	/**
	 * Validates the sourcePinOwnerMatchesSource constraint of '<em>Characterized Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedDataFlow_sourcePinOwnerMatchesSource(CharacterizedDataFlow characterizedDataFlow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DataFlowDiagramCharacterizedPackage.Literals.CHARACTERIZED_DATA_FLOW,
				 characterizedDataFlow,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "sourcePinOwnerMatchesSource",
				 CHARACTERIZED_DATA_FLOW__SOURCE_PIN_OWNER_MATCHES_SOURCE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the destinationPinOwnerMatchesDestination constraint of '<em>Characterized Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHARACTERIZED_DATA_FLOW__DESTINATION_PIN_OWNER_MATCHES_DESTINATION__EEXPRESSION = "not self.target.oclIsKindOf(DataDictionaryCharacterized::Behaving) or self.target.oclAsType(DataDictionaryCharacterized::Behaving).behavior.inputs->includes(self.targetPin)";

	/**
	 * Validates the destinationPinOwnerMatchesDestination constraint of '<em>Characterized Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedDataFlow_destinationPinOwnerMatchesDestination(CharacterizedDataFlow characterizedDataFlow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DataFlowDiagramCharacterizedPackage.Literals.CHARACTERIZED_DATA_FLOW,
				 characterizedDataFlow,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "destinationPinOwnerMatchesDestination",
				 CHARACTERIZED_DATA_FLOW__DESTINATION_PIN_OWNER_MATCHES_DESTINATION__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the notPartOfLoop constraint of '<em>Characterized Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHARACTERIZED_DATA_FLOW__NOT_PART_OF_LOOP__EEXPRESSION = "not self.oclAsType(DataFlowDiagram::Edge)->closure(e |\n" +
		"\tself.oclAsType(ecore::EObject).eContainer().oclAsType(DataFlowDiagram::DataFlowDiagram).edges->select(f |\n" +
		"\t\tf.source = e.target and\n" +
		"\t\tnot f.source->including(f.target)->exists(n | n.oclIsKindOf(CharacterizedExternalActor))\n" +
		"\t)\n" +
		")->exists(f | f.target = self.source)";

	/**
	 * Validates the notPartOfLoop constraint of '<em>Characterized Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedDataFlow_notPartOfLoop(CharacterizedDataFlow characterizedDataFlow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DataFlowDiagramCharacterizedPackage.Literals.CHARACTERIZED_DATA_FLOW,
				 characterizedDataFlow,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "notPartOfLoop",
				 CHARACTERIZED_DATA_FLOW__NOT_PART_OF_LOOP__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedActorProcess(CharacterizedActorProcess characterizedActorProcess, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(characterizedActorProcess, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(characterizedActorProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characterizedActorProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characterizedActorProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(characterizedActorProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characterizedActorProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characterizedActorProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characterizedActorProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characterizedActorProcess, diagnostics, context);
		if (result || diagnostics != null) result &= identifierValidator.validateIdentifier_identifierIsUnique(characterizedActorProcess, diagnostics, context);
		if (result || diagnostics != null) result &= dataDictionaryCharacterizedValidator.validateBehaving_exactlyOneBehaviorHasToBeSpecified(characterizedActorProcess, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacterizedNode_atLeastOneInputFlowForEachInputPin(characterizedActorProcess, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedNode(CharacterizedNode characterizedNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(characterizedNode, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(characterizedNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(characterizedNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(characterizedNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(characterizedNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(characterizedNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(characterizedNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(characterizedNode, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(characterizedNode, diagnostics, context);
		if (result || diagnostics != null) result &= dataDictionaryCharacterizedValidator.validateBehaving_exactlyOneBehaviorHasToBeSpecified(characterizedNode, diagnostics, context);
		if (result || diagnostics != null) result &= validateCharacterizedNode_atLeastOneInputFlowForEachInputPin(characterizedNode, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the atLeastOneInputFlowForEachInputPin constraint of '<em>Characterized Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String CHARACTERIZED_NODE__AT_LEAST_ONE_INPUT_FLOW_FOR_EACH_INPUT_PIN__EEXPRESSION = "self.behavior.inputs->isEmpty() or CharacterizedDataFlow.allInstances()->select(f | f.target = self).targetPin->asSet()->includesAll(self.behavior.inputs->asSet())";

	/**
	 * Validates the atLeastOneInputFlowForEachInputPin constraint of '<em>Characterized Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCharacterizedNode_atLeastOneInputFlowForEachInputPin(CharacterizedNode characterizedNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(DataFlowDiagramCharacterizedPackage.Literals.CHARACTERIZED_NODE,
				 characterizedNode,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "atLeastOneInputFlowForEachInputPin",
				 CHARACTERIZED_NODE__AT_LEAST_ONE_INPUT_FLOW_FOR_EACH_INPUT_PIN__EEXPRESSION,
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

} //DataFlowDiagramCharacterizedValidator
