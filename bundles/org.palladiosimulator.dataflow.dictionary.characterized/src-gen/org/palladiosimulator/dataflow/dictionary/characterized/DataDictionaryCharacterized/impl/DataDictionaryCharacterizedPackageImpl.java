/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataDictionaryPackage;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedFactory;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Entity;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Enumeration;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl.ExpressionsPackageImpl;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.util.DataDictionaryCharacterizedValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataDictionaryCharacterizedPackageImpl extends EPackageImpl implements DataDictionaryCharacterizedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataDictionaryCharacterizedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characteristicTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumCharacteristicTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pinEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behavingEClass = null;

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
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataDictionaryCharacterizedPackageImpl() {
		super(eNS_URI, DataDictionaryCharacterizedFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DataDictionaryCharacterizedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataDictionaryCharacterizedPackage init() {
		if (isInited) return (DataDictionaryCharacterizedPackage)EPackage.Registry.INSTANCE.getEPackage(DataDictionaryCharacterizedPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDataDictionaryCharacterizedPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DataDictionaryCharacterizedPackageImpl theDataDictionaryCharacterizedPackage = registeredDataDictionaryCharacterizedPackage instanceof DataDictionaryCharacterizedPackageImpl ? (DataDictionaryCharacterizedPackageImpl)registeredDataDictionaryCharacterizedPackage : new DataDictionaryCharacterizedPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		DataDictionaryPackage.eINSTANCE.eClass();
		IdentifierPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(registeredPackage instanceof ExpressionsPackageImpl ? registeredPackage : ExpressionsPackage.eINSTANCE);

		// Create package meta-data objects
		theDataDictionaryCharacterizedPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();

		// Initialize created meta-data
		theDataDictionaryCharacterizedPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theDataDictionaryCharacterizedPackage,
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return DataDictionaryCharacterizedValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theDataDictionaryCharacterizedPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataDictionaryCharacterizedPackage.eNS_URI, theDataDictionaryCharacterizedPackage);
		return theDataDictionaryCharacterizedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntity_Name() {
		return (EAttribute)entityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataDictionaryCharacterized() {
		return dataDictionaryCharacterizedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataDictionaryCharacterized_CharacteristicTypes() {
		return (EReference)dataDictionaryCharacterizedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataDictionaryCharacterized_Enumerations() {
		return (EReference)dataDictionaryCharacterizedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataDictionaryCharacterized_BehaviorDefinitions() {
		return (EReference)dataDictionaryCharacterizedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacteristicType() {
		return characteristicTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumCharacteristicType() {
		return enumCharacteristicTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumCharacteristicType_Type() {
		return (EReference)enumCharacteristicTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumeration() {
		return enumerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumeration_Literals() {
		return (EReference)enumerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLiteral_Enum() {
		return (EReference)literalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorDefinition() {
		return behaviorDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorDefinition_Inputs() {
		return (EReference)behaviorDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorDefinition_Outputs() {
		return (EReference)behaviorDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaviorDefinition_Assignments() {
		return (EReference)behaviorDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPin() {
		return pinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPin_Owner() {
		return (EReference)pinEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignment() {
		return assignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_Lhs() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_Rhs() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaving() {
		return behavingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaving_Behavior() {
		return (EReference)behavingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaving_OwnedBehavior() {
		return (EReference)behavingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehaving_ReferencedBehavior() {
		return (EReference)behavingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataDictionaryCharacterizedFactory getDataDictionaryCharacterizedFactory() {
		return (DataDictionaryCharacterizedFactory)getEFactoryInstance();
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
		entityEClass = createEClass(ENTITY);
		createEAttribute(entityEClass, ENTITY__NAME);

		dataDictionaryCharacterizedEClass = createEClass(DATA_DICTIONARY_CHARACTERIZED);
		createEReference(dataDictionaryCharacterizedEClass, DATA_DICTIONARY_CHARACTERIZED__CHARACTERISTIC_TYPES);
		createEReference(dataDictionaryCharacterizedEClass, DATA_DICTIONARY_CHARACTERIZED__ENUMERATIONS);
		createEReference(dataDictionaryCharacterizedEClass, DATA_DICTIONARY_CHARACTERIZED__BEHAVIOR_DEFINITIONS);

		characteristicTypeEClass = createEClass(CHARACTERISTIC_TYPE);

		enumCharacteristicTypeEClass = createEClass(ENUM_CHARACTERISTIC_TYPE);
		createEReference(enumCharacteristicTypeEClass, ENUM_CHARACTERISTIC_TYPE__TYPE);

		enumerationEClass = createEClass(ENUMERATION);
		createEReference(enumerationEClass, ENUMERATION__LITERALS);

		literalEClass = createEClass(LITERAL);
		createEReference(literalEClass, LITERAL__ENUM);

		behaviorDefinitionEClass = createEClass(BEHAVIOR_DEFINITION);
		createEReference(behaviorDefinitionEClass, BEHAVIOR_DEFINITION__INPUTS);
		createEReference(behaviorDefinitionEClass, BEHAVIOR_DEFINITION__OUTPUTS);
		createEReference(behaviorDefinitionEClass, BEHAVIOR_DEFINITION__ASSIGNMENTS);

		pinEClass = createEClass(PIN);
		createEReference(pinEClass, PIN__OWNER);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__LHS);
		createEReference(assignmentEClass, ASSIGNMENT__RHS);

		behavingEClass = createEClass(BEHAVING);
		createEReference(behavingEClass, BEHAVING__BEHAVIOR);
		createEReference(behavingEClass, BEHAVING__OWNED_BEHAVIOR);
		createEReference(behavingEClass, BEHAVING__REFERENCED_BEHAVIOR);
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
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		DataDictionaryPackage theDataDictionaryPackage = (DataDictionaryPackage)EPackage.Registry.INSTANCE.getEPackage(DataDictionaryPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theExpressionsPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		entityEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		dataDictionaryCharacterizedEClass.getESuperTypes().add(theDataDictionaryPackage.getDataDictionary());
		characteristicTypeEClass.getESuperTypes().add(this.getEntity());
		enumCharacteristicTypeEClass.getESuperTypes().add(this.getCharacteristicType());
		enumerationEClass.getESuperTypes().add(this.getEntity());
		literalEClass.getESuperTypes().add(this.getEntity());
		behaviorDefinitionEClass.getESuperTypes().add(this.getEntity());
		pinEClass.getESuperTypes().add(this.getEntity());
		assignmentEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(entityEClass, Entity.class, "Entity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntity_Name(), ecorePackage.getEString(), "name", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataDictionaryCharacterizedEClass, DataDictionaryCharacterized.class, "DataDictionaryCharacterized", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataDictionaryCharacterized_CharacteristicTypes(), this.getCharacteristicType(), null, "characteristicTypes", null, 0, -1, DataDictionaryCharacterized.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataDictionaryCharacterized_Enumerations(), this.getEnumeration(), null, "enumerations", null, 0, -1, DataDictionaryCharacterized.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataDictionaryCharacterized_BehaviorDefinitions(), this.getBehaviorDefinition(), null, "behaviorDefinitions", null, 0, -1, DataDictionaryCharacterized.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(characteristicTypeEClass, CharacteristicType.class, "CharacteristicType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumCharacteristicTypeEClass, EnumCharacteristicType.class, "EnumCharacteristicType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumCharacteristicType_Type(), this.getEnumeration(), null, "type", null, 1, 1, EnumCharacteristicType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationEClass, Enumeration.class, "Enumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumeration_Literals(), this.getLiteral(), this.getLiteral_Enum(), "literals", null, 1, -1, Enumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteral_Enum(), this.getEnumeration(), this.getEnumeration_Literals(), "enum", null, 1, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorDefinitionEClass, BehaviorDefinition.class, "BehaviorDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorDefinition_Inputs(), this.getPin(), null, "inputs", null, 0, -1, BehaviorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorDefinition_Outputs(), this.getPin(), null, "outputs", null, 0, -1, BehaviorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorDefinition_Assignments(), this.getAssignment(), null, "assignments", null, 0, -1, BehaviorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pinEClass, Pin.class, "Pin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPin_Owner(), this.getBehaviorDefinition(), null, "owner", null, 1, 1, Pin.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_Lhs(), theExpressionsPackage.getDataCharacteristicReference(), null, "lhs", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignment_Rhs(), theExpressionsPackage.getTerm(), null, "rhs", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behavingEClass, Behaving.class, "Behaving", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaving_Behavior(), this.getBehaviorDefinition(), null, "behavior", null, 1, 1, Behaving.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getBehaving_OwnedBehavior(), this.getBehaviorDefinition(), null, "ownedBehavior", null, 0, 1, Behaving.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaving_ReferencedBehavior(), this.getBehaviorDefinition(), null, "referencedBehavior", null, 0, 1, Behaving.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (assignmentEClass,
		   source,
		   new String[] {
			   "constraints", "leftHandSideRefersOutputPin characteristicWildcardHasToBeOnLhsAndRhs literalWildcardHasToBeOnLhsAndRhs"
		   });
		addAnnotation
		  (behavingEClass,
		   source,
		   new String[] {
			   "constraints", "exactlyOneBehaviorHasToBeSpecified"
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
		  (getPin_Owner(),
		   source,
		   new String[] {
			   "derivation", "self.oclAsType(ecore::EObject).eContainer().oclAsType(BehaviorDefinition)"
		   });
		addAnnotation
		  (assignmentEClass,
		   source,
		   new String[] {
			   "leftHandSideRefersOutputPin", "self.oclAsType(ecore::EObject).eContainer().oclAsType(BehaviorDefinition).outputs->includes(self.lhs.pin)",
			   "characteristicWildcardHasToBeOnLhsAndRhs", "not self.rhs.oclIsKindOf(expressions::CharacteristicReference) or\n(\n\tself.rhs.oclAsType(expressions::CharacteristicReference).characteristicType.oclIsUndefined()\n\tand\n\tself.lhs.characteristicType.oclIsUndefined()\n)\nor\n(\n\tnot self.rhs.oclAsType(expressions::CharacteristicReference).characteristicType.oclIsUndefined()\n\tand\n\tnot self.lhs.characteristicType.oclIsUndefined()\n)",
			   "literalWildcardHasToBeOnLhsAndRhs", "not self.rhs.oclIsKindOf(expressions::CharacteristicReference) or\n(\n\tself.rhs.oclAsType(expressions::CharacteristicReference).literal.oclIsUndefined()\n\tand\n\tself.lhs.literal.oclIsUndefined()\n)\nor\n(\n\tnot self.rhs.oclAsType(expressions::CharacteristicReference).literal.oclIsUndefined()\n\tand\n\tnot self.lhs.literal.oclIsUndefined()\n)"
		   });
		addAnnotation
		  (behavingEClass,
		   source,
		   new String[] {
			   "exactlyOneBehaviorHasToBeSpecified", "self.ownedBehavior->including(self.referencedBehavior)->selectByKind(BehaviorDefinition)->size() = 1"
		   });
		addAnnotation
		  (getBehaving_Behavior(),
		   source,
		   new String[] {
			   "derivation", "self.ownedBehavior->including(self.referencedBehavior)->selectByKind(BehaviorDefinition)->any(true)"
		   });
	}

} //DataDictionaryCharacterizedPackageImpl
