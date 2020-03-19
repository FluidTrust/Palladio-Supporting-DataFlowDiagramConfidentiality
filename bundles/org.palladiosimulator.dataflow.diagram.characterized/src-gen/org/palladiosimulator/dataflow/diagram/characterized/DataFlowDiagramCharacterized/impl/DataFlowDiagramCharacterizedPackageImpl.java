/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagramPackage;

import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characteristic;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characterizable;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedActorProcess;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedData;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedExternalActor;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedNode;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic;

import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.util.DataFlowDiagramCharacterizedValidator;

import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataDictionaryPackage;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataFlowDiagramCharacterizedPackageImpl extends EPackageImpl implements DataFlowDiagramCharacterizedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterizableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characteristicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumCharacteristicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterizedExternalActorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterizedStoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterizedProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterizedDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterizedDataFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterizedActorProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterizedNodeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataFlowDiagramCharacterizedPackageImpl() {
		super(eNS_URI, DataFlowDiagramCharacterizedFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DataFlowDiagramCharacterizedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataFlowDiagramCharacterizedPackage init() {
		if (isInited) return (DataFlowDiagramCharacterizedPackage)EPackage.Registry.INSTANCE.getEPackage(DataFlowDiagramCharacterizedPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDataFlowDiagramCharacterizedPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DataFlowDiagramCharacterizedPackageImpl theDataFlowDiagramCharacterizedPackage = registeredDataFlowDiagramCharacterizedPackage instanceof DataFlowDiagramCharacterizedPackageImpl ? (DataFlowDiagramCharacterizedPackageImpl)registeredDataFlowDiagramCharacterizedPackage : new DataFlowDiagramCharacterizedPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		DataDictionaryPackage.eINSTANCE.eClass();
		DataDictionaryCharacterizedPackage.eINSTANCE.eClass();
		DataFlowDiagramPackage.eINSTANCE.eClass();
		IdentifierPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDataFlowDiagramCharacterizedPackage.createPackageContents();

		// Initialize created meta-data
		theDataFlowDiagramCharacterizedPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theDataFlowDiagramCharacterizedPackage,
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return DataFlowDiagramCharacterizedValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theDataFlowDiagramCharacterizedPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataFlowDiagramCharacterizedPackage.eNS_URI, theDataFlowDiagramCharacterizedPackage);
		return theDataFlowDiagramCharacterizedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterizable() {
		return characterizableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacterizable_Characteristics() {
		return (EReference)characterizableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacteristic() {
		return characteristicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacteristic_Type() {
		return (EReference)characteristicEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumCharacteristic() {
		return enumCharacteristicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumCharacteristic_Values() {
		return (EReference)enumCharacteristicEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumCharacteristic_EnumCharacteristicType() {
		return (EReference)enumCharacteristicEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterizedExternalActor() {
		return characterizedExternalActorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterizedStore() {
		return characterizedStoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterizedProcess() {
		return characterizedProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterizedData() {
		return characterizedDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterizedDataFlow() {
		return characterizedDataFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacterizedDataFlow_SourcePin() {
		return (EReference)characterizedDataFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacterizedDataFlow_TargetPin() {
		return (EReference)characterizedDataFlowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterizedActorProcess() {
		return characterizedActorProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacterizedActorProcess_Actor() {
		return (EReference)characterizedActorProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacterizedNode() {
		return characterizedNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowDiagramCharacterizedFactory getDataFlowDiagramCharacterizedFactory() {
		return (DataFlowDiagramCharacterizedFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		characterizableEClass = createEClass(CHARACTERIZABLE);
		createEReference(characterizableEClass, CHARACTERIZABLE__CHARACTERISTICS);

		characteristicEClass = createEClass(CHARACTERISTIC);
		createEReference(characteristicEClass, CHARACTERISTIC__TYPE);

		enumCharacteristicEClass = createEClass(ENUM_CHARACTERISTIC);
		createEReference(enumCharacteristicEClass, ENUM_CHARACTERISTIC__VALUES);
		createEReference(enumCharacteristicEClass, ENUM_CHARACTERISTIC__ENUM_CHARACTERISTIC_TYPE);

		characterizedExternalActorEClass = createEClass(CHARACTERIZED_EXTERNAL_ACTOR);

		characterizedStoreEClass = createEClass(CHARACTERIZED_STORE);

		characterizedProcessEClass = createEClass(CHARACTERIZED_PROCESS);

		characterizedDataEClass = createEClass(CHARACTERIZED_DATA);

		characterizedDataFlowEClass = createEClass(CHARACTERIZED_DATA_FLOW);
		createEReference(characterizedDataFlowEClass, CHARACTERIZED_DATA_FLOW__SOURCE_PIN);
		createEReference(characterizedDataFlowEClass, CHARACTERIZED_DATA_FLOW__TARGET_PIN);

		characterizedActorProcessEClass = createEClass(CHARACTERIZED_ACTOR_PROCESS);
		createEReference(characterizedActorProcessEClass, CHARACTERIZED_ACTOR_PROCESS__ACTOR);

		characterizedNodeEClass = createEClass(CHARACTERIZED_NODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		DataFlowDiagramPackage theDataFlowDiagramPackage = (DataFlowDiagramPackage)EPackage.Registry.INSTANCE.getEPackage(DataFlowDiagramPackage.eNS_URI);
		DataDictionaryCharacterizedPackage theDataDictionaryCharacterizedPackage = (DataDictionaryCharacterizedPackage)EPackage.Registry.INSTANCE.getEPackage(DataDictionaryCharacterizedPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		characteristicEClass.getESuperTypes().add(theDataFlowDiagramPackage.getEntity());
		enumCharacteristicEClass.getESuperTypes().add(this.getCharacteristic());
		characterizedExternalActorEClass.getESuperTypes().add(theDataFlowDiagramPackage.getExternalActor());
		characterizedExternalActorEClass.getESuperTypes().add(this.getCharacterizedNode());
		characterizedStoreEClass.getESuperTypes().add(theDataFlowDiagramPackage.getStore());
		characterizedStoreEClass.getESuperTypes().add(this.getCharacterizedNode());
		characterizedProcessEClass.getESuperTypes().add(theDataFlowDiagramPackage.getProcess());
		characterizedProcessEClass.getESuperTypes().add(this.getCharacterizedNode());
		characterizedDataEClass.getESuperTypes().add(theDataFlowDiagramPackage.getData());
		characterizedDataEClass.getESuperTypes().add(this.getCharacterizable());
		characterizedDataFlowEClass.getESuperTypes().add(theDataFlowDiagramPackage.getEdge());
		characterizedDataFlowEClass.getESuperTypes().add(this.getCharacterizable());
		characterizedActorProcessEClass.getESuperTypes().add(this.getCharacterizedProcess());
		characterizedNodeEClass.getESuperTypes().add(theDataDictionaryCharacterizedPackage.getBehaving());
		characterizedNodeEClass.getESuperTypes().add(this.getCharacterizable());

		// Initialize classes and features; add operations and parameters
		initEClass(characterizableEClass, Characterizable.class, "Characterizable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCharacterizable_Characteristics(), this.getCharacteristic(), null, "characteristics", null, 0, -1, Characterizable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(characteristicEClass, Characteristic.class, "Characteristic", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCharacteristic_Type(), theDataDictionaryCharacterizedPackage.getCharacteristicType(), null, "type", null, 1, 1, Characteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumCharacteristicEClass, EnumCharacteristic.class, "EnumCharacteristic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumCharacteristic_Values(), theDataDictionaryCharacterizedPackage.getLiteral(), null, "values", null, 0, -1, EnumCharacteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumCharacteristic_EnumCharacteristicType(), theDataDictionaryCharacterizedPackage.getEnumCharacteristicType(), null, "enumCharacteristicType", null, 1, 1, EnumCharacteristic.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(characterizedExternalActorEClass, CharacterizedExternalActor.class, "CharacterizedExternalActor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(characterizedStoreEClass, CharacterizedStore.class, "CharacterizedStore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(characterizedProcessEClass, CharacterizedProcess.class, "CharacterizedProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(characterizedDataEClass, CharacterizedData.class, "CharacterizedData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(characterizedDataFlowEClass, CharacterizedDataFlow.class, "CharacterizedDataFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCharacterizedDataFlow_SourcePin(), theDataDictionaryCharacterizedPackage.getPin(), null, "sourcePin", null, 1, 1, CharacterizedDataFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCharacterizedDataFlow_TargetPin(), theDataDictionaryCharacterizedPackage.getPin(), null, "targetPin", null, 1, 1, CharacterizedDataFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(characterizedActorProcessEClass, CharacterizedActorProcess.class, "CharacterizedActorProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCharacterizedActorProcess_Actor(), theDataFlowDiagramPackage.getExternalActor(), null, "actor", null, 1, 1, CharacterizedActorProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(characterizedNodeEClass, CharacterizedNode.class, "CharacterizedNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			   "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL"
		   });
		addAnnotation
		  (characterizedStoreEClass,
		   source,
		   new String[] {
			   "constraints", "storeHasNoAssignmentsInBehavior storeHasExactlyOneInputAndOneOutputPin"
		   });
		addAnnotation
		  (characterizedDataFlowEClass,
		   source,
		   new String[] {
			   "constraints", "sourcePinIsEntityOutputPin destinationPinIsEntityInputPin sourcePinOwnerMatchesSource destinationPinOwnerMatchesDestination notPartOfLoop"
		   });
		addAnnotation
		  (characterizedNodeEClass,
		   source,
		   new String[] {
			   "constraints", "atLeastOneInputFlowForEachInputPin"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCLAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL";
		addAnnotation
		  (getEnumCharacteristic_EnumCharacteristicType(),
		   source,
		   new String[] {
			   "derivation", "self.type.oclAsType(DataDictionaryCharacterized::EnumCharacteristicType)"
		   });
		addAnnotation
		  (characterizedStoreEClass,
		   source,
		   new String[] {
			   "storeHasNoAssignmentsInBehavior", "self.behavior.assignments->isEmpty()",
			   "storeHasExactlyOneInputAndOneOutputPin", "self.behavior.inputs->size() = 1 and self.behavior.outputs->size() = 1"
		   });
		addAnnotation
		  (characterizedDataFlowEClass,
		   source,
		   new String[] {
			   "sourcePinIsEntityOutputPin", "self.sourcePin.owner.outputs->includes(self.sourcePin)",
			   "destinationPinIsEntityInputPin", "self.targetPin.owner.inputs->includes(self.targetPin)",
			   "sourcePinOwnerMatchesSource", "not self.source.oclIsKindOf(DataDictionaryCharacterized::Behaving) or self.source.oclAsType(DataDictionaryCharacterized::Behaving).behavior.outputs->includes(self.sourcePin)",
			   "destinationPinOwnerMatchesDestination", "not self.target.oclIsKindOf(DataDictionaryCharacterized::Behaving) or self.target.oclAsType(DataDictionaryCharacterized::Behaving).behavior.inputs->includes(self.targetPin)",
			   "notPartOfLoop", "not self.oclAsType(DataFlowDiagram::Edge)->closure(e |\n\tself.oclAsType(ecore::EObject).eContainer().oclAsType(DataFlowDiagram::DataFlowDiagram).edges->select(f |\n\t\tf.source = e.target and\n\t\tnot f.source->including(f.target)->exists(n | n.oclIsKindOf(CharacterizedExternalActor))\n\t)\n)->exists(f | f.target = self.source)"
		   });
		addAnnotation
		  (characterizedNodeEClass,
		   source,
		   new String[] {
			   "atLeastOneInputFlowForEachInputPin", "self.behavior.inputs->isEmpty() or CharacterizedDataFlow.allInstances()->select(f | f.target = self).targetPin->asSet()->includesAll(self.behavior.inputs->asSet())"
		   });
	}

} //DataFlowDiagramCharacterizedPackageImpl
