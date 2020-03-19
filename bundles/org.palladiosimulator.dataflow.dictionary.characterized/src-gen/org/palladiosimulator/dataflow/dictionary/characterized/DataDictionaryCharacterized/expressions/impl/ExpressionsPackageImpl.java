/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataDictionaryPackage;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.And;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Constant;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ContainerCharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsFactory;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.False;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.LogicTerm;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Not;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Or;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Term;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.True;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.UnaryLogicTerm;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.util.ExpressionsValidator;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsPackageImpl extends EPackageImpl implements ExpressionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass termEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass falseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryLogicTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryLogicTermEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characteristicReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerCharacteristicReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataCharacteristicReferenceEClass = null;

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
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExpressionsPackageImpl() {
		super(eNS_URI, ExpressionsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExpressionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExpressionsPackage init() {
		if (isInited) return (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredExpressionsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ExpressionsPackageImpl theExpressionsPackage = registeredExpressionsPackage instanceof ExpressionsPackageImpl ? (ExpressionsPackageImpl)registeredExpressionsPackage : new ExpressionsPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		DataDictionaryPackage.eINSTANCE.eClass();
		IdentifierPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(DataDictionaryCharacterizedPackage.eNS_URI);
		DataDictionaryCharacterizedPackageImpl theDataDictionaryCharacterizedPackage = (DataDictionaryCharacterizedPackageImpl)(registeredPackage instanceof DataDictionaryCharacterizedPackageImpl ? registeredPackage : DataDictionaryCharacterizedPackage.eINSTANCE);

		// Create package meta-data objects
		theExpressionsPackage.createPackageContents();
		theDataDictionaryCharacterizedPackage.createPackageContents();

		// Initialize created meta-data
		theExpressionsPackage.initializePackageContents();
		theDataDictionaryCharacterizedPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theExpressionsPackage,
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ExpressionsValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theExpressionsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExpressionsPackage.eNS_URI, theExpressionsPackage);
		return theExpressionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTerm() {
		return termEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstant() {
		return constantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrue() {
		return trueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFalse() {
		return falseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicTerm() {
		return logicTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogicTerm_Terms() {
		return (EReference)logicTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryLogicTerm() {
		return unaryLogicTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryLogicTerm_Term() {
		return (EReference)unaryLogicTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNot() {
		return notEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryLogicTerm() {
		return binaryLogicTermEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryLogicTerm_Left() {
		return (EReference)binaryLogicTermEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryLogicTerm_Right() {
		return (EReference)binaryLogicTermEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnd() {
		return andEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOr() {
		return orEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacteristicReference() {
		return characteristicReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacteristicReference_CharacteristicType() {
		return (EReference)characteristicReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCharacteristicReference_Literal() {
		return (EReference)characteristicReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerCharacteristicReference() {
		return containerCharacteristicReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataCharacteristicReference() {
		return dataCharacteristicReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataCharacteristicReference_Pin() {
		return (EReference)dataCharacteristicReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsFactory getExpressionsFactory() {
		return (ExpressionsFactory)getEFactoryInstance();
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
		termEClass = createEClass(TERM);

		constantEClass = createEClass(CONSTANT);

		trueEClass = createEClass(TRUE);

		falseEClass = createEClass(FALSE);

		logicTermEClass = createEClass(LOGIC_TERM);
		createEReference(logicTermEClass, LOGIC_TERM__TERMS);

		unaryLogicTermEClass = createEClass(UNARY_LOGIC_TERM);
		createEReference(unaryLogicTermEClass, UNARY_LOGIC_TERM__TERM);

		notEClass = createEClass(NOT);

		binaryLogicTermEClass = createEClass(BINARY_LOGIC_TERM);
		createEReference(binaryLogicTermEClass, BINARY_LOGIC_TERM__LEFT);
		createEReference(binaryLogicTermEClass, BINARY_LOGIC_TERM__RIGHT);

		andEClass = createEClass(AND);

		orEClass = createEClass(OR);

		characteristicReferenceEClass = createEClass(CHARACTERISTIC_REFERENCE);
		createEReference(characteristicReferenceEClass, CHARACTERISTIC_REFERENCE__CHARACTERISTIC_TYPE);
		createEReference(characteristicReferenceEClass, CHARACTERISTIC_REFERENCE__LITERAL);

		containerCharacteristicReferenceEClass = createEClass(CONTAINER_CHARACTERISTIC_REFERENCE);

		dataCharacteristicReferenceEClass = createEClass(DATA_CHARACTERISTIC_REFERENCE);
		createEReference(dataCharacteristicReferenceEClass, DATA_CHARACTERISTIC_REFERENCE__PIN);
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
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		DataDictionaryCharacterizedPackage theDataDictionaryCharacterizedPackage = (DataDictionaryCharacterizedPackage)EPackage.Registry.INSTANCE.getEPackage(DataDictionaryCharacterizedPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		termEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		constantEClass.getESuperTypes().add(this.getTerm());
		trueEClass.getESuperTypes().add(this.getConstant());
		falseEClass.getESuperTypes().add(this.getConstant());
		logicTermEClass.getESuperTypes().add(this.getTerm());
		unaryLogicTermEClass.getESuperTypes().add(this.getLogicTerm());
		notEClass.getESuperTypes().add(this.getUnaryLogicTerm());
		binaryLogicTermEClass.getESuperTypes().add(this.getLogicTerm());
		andEClass.getESuperTypes().add(this.getBinaryLogicTerm());
		orEClass.getESuperTypes().add(this.getBinaryLogicTerm());
		characteristicReferenceEClass.getESuperTypes().add(this.getTerm());
		containerCharacteristicReferenceEClass.getESuperTypes().add(this.getCharacteristicReference());
		dataCharacteristicReferenceEClass.getESuperTypes().add(this.getCharacteristicReference());

		// Initialize classes and features; add operations and parameters
		initEClass(termEClass, Term.class, "Term", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constantEClass, Constant.class, "Constant", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(trueEClass, True.class, "True", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(falseEClass, False.class, "False", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logicTermEClass, LogicTerm.class, "LogicTerm", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLogicTerm_Terms(), this.getTerm(), null, "terms", null, 0, -1, LogicTerm.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(unaryLogicTermEClass, UnaryLogicTerm.class, "UnaryLogicTerm", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryLogicTerm_Term(), this.getTerm(), null, "term", null, 1, 1, UnaryLogicTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notEClass, Not.class, "Not", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryLogicTermEClass, BinaryLogicTerm.class, "BinaryLogicTerm", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryLogicTerm_Left(), this.getTerm(), null, "left", null, 1, 1, BinaryLogicTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryLogicTerm_Right(), this.getTerm(), null, "right", null, 1, 1, BinaryLogicTerm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andEClass, And.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orEClass, Or.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(characteristicReferenceEClass, CharacteristicReference.class, "CharacteristicReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCharacteristicReference_CharacteristicType(), theDataDictionaryCharacterizedPackage.getCharacteristicType(), null, "characteristicType", null, 0, 1, CharacteristicReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCharacteristicReference_Literal(), theDataDictionaryCharacterizedPackage.getLiteral(), null, "literal", null, 0, 1, CharacteristicReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerCharacteristicReferenceEClass, ContainerCharacteristicReference.class, "ContainerCharacteristicReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataCharacteristicReferenceEClass, DataCharacteristicReference.class, "DataCharacteristicReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataCharacteristicReference_Pin(), theDataDictionaryCharacterizedPackage.getPin(), null, "pin", null, 1, 1, DataCharacteristicReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (characteristicReferenceEClass,
		   source,
		   new String[] {
			   "constraints", "literalHasToBeWildcardIfCharacteristicIsWildcard"
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
		  (getLogicTerm_Terms(),
		   source,
		   new String[] {
			   "derivation", "self.oclAsType(ecore::EObject).eContents()->selectByKind(Term)->asSet()"
		   });
		addAnnotation
		  (characteristicReferenceEClass,
		   source,
		   new String[] {
			   "literalHasToBeWildcardIfCharacteristicIsWildcard", "not self.characteristicType.oclIsUndefined() or self.literal.oclIsUndefined()"
		   });
	}

} //ExpressionsPackageImpl
