/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataDictionaryPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface DataDictionaryCharacterizedPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DataDictionaryCharacterized";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/dataflow/dictionary/characterized/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "DataDictionaryCharacterized";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataDictionaryCharacterizedPackage eINSTANCE = org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.EntityImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedImpl <em>Data Dictionary Characterized</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getDataDictionaryCharacterized()
	 * @generated
	 */
	int DATA_DICTIONARY_CHARACTERIZED = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DICTIONARY_CHARACTERIZED__ID = DataDictionaryPackage.DATA_DICTIONARY__ID;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DICTIONARY_CHARACTERIZED__ENTRIES = DataDictionaryPackage.DATA_DICTIONARY__ENTRIES;

	/**
	 * The feature id for the '<em><b>Characteristic Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DICTIONARY_CHARACTERIZED__CHARACTERISTIC_TYPES = DataDictionaryPackage.DATA_DICTIONARY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enumerations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DICTIONARY_CHARACTERIZED__ENUMERATIONS = DataDictionaryPackage.DATA_DICTIONARY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Behavior Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DICTIONARY_CHARACTERIZED__BEHAVIOR_DEFINITIONS = DataDictionaryPackage.DATA_DICTIONARY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Data Dictionary Characterized</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DICTIONARY_CHARACTERIZED_FEATURE_COUNT = DataDictionaryPackage.DATA_DICTIONARY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.CharacteristicTypeImpl <em>Characteristic Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.CharacteristicTypeImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getCharacteristicType()
	 * @generated
	 */
	int CHARACTERISTIC_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_TYPE__ID = ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_TYPE__NAME = ENTITY__NAME;

	/**
	 * The number of structural features of the '<em>Characteristic Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_TYPE_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.EnumCharacteristicTypeImpl <em>Enum Characteristic Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.EnumCharacteristicTypeImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getEnumCharacteristicType()
	 * @generated
	 */
	int ENUM_CHARACTERISTIC_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_TYPE__ID = CHARACTERISTIC_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_TYPE__NAME = CHARACTERISTIC_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_TYPE__TYPE = CHARACTERISTIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Characteristic Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_TYPE_FEATURE_COUNT = CHARACTERISTIC_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.EnumerationImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__ID = ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__LITERALS = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.LiteralImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__ID = ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__ENUM = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehaviorDefinitionImpl <em>Behavior Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehaviorDefinitionImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getBehaviorDefinition()
	 * @generated
	 */
	int BEHAVIOR_DEFINITION = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DEFINITION__ID = ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DEFINITION__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DEFINITION__INPUTS = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DEFINITION__OUTPUTS = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DEFINITION__ASSIGNMENTS = ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Behavior Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_DEFINITION_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.PinImpl <em>Pin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.PinImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getPin()
	 * @generated
	 */
	int PIN = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIN__ID = ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIN__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIN__OWNER = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIN_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.AssignmentImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__LHS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__RHS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehavingImpl <em>Behaving</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehavingImpl
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getBehaving()
	 * @generated
	 */
	int BEHAVING = 9;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVING__BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVING__OWNED_BEHAVIOR = 1;

	/**
	 * The feature id for the '<em><b>Referenced Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVING__REFERENCED_BEHAVIOR = 2;

	/**
	 * The number of structural features of the '<em>Behaving</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVING_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the attribute '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Entity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Entity#getName()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Name();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized <em>Data Dictionary Characterized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Dictionary Characterized</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized
	 * @generated
	 */
	EClass getDataDictionaryCharacterized();

	/**
	 * Returns the meta object for the containment reference list '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized#getCharacteristicTypes <em>Characteristic Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Characteristic Types</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized#getCharacteristicTypes()
	 * @see #getDataDictionaryCharacterized()
	 * @generated
	 */
	EReference getDataDictionaryCharacterized_CharacteristicTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized#getEnumerations <em>Enumerations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enumerations</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized#getEnumerations()
	 * @see #getDataDictionaryCharacterized()
	 * @generated
	 */
	EReference getDataDictionaryCharacterized_Enumerations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized#getBehaviorDefinitions <em>Behavior Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavior Definitions</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized#getBehaviorDefinitions()
	 * @see #getDataDictionaryCharacterized()
	 * @generated
	 */
	EReference getDataDictionaryCharacterized_BehaviorDefinitions();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType <em>Characteristic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characteristic Type</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType
	 * @generated
	 */
	EClass getCharacteristicType();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType <em>Enum Characteristic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Characteristic Type</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType
	 * @generated
	 */
	EClass getEnumCharacteristicType();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType#getType()
	 * @see #getEnumCharacteristicType()
	 * @generated
	 */
	EReference getEnumCharacteristicType_Type();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Enumeration#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Enumeration#getLiterals()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_Literals();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for the container reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal#getEnum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Enum</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal#getEnum()
	 * @see #getLiteral()
	 * @generated
	 */
	EReference getLiteral_Enum();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition <em>Behavior Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior Definition</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition
	 * @generated
	 */
	EClass getBehaviorDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition#getInputs()
	 * @see #getBehaviorDefinition()
	 * @generated
	 */
	EReference getBehaviorDefinition_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition#getOutputs()
	 * @see #getBehaviorDefinition()
	 * @generated
	 */
	EReference getBehaviorDefinition_Outputs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assignments</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition#getAssignments()
	 * @see #getBehaviorDefinition()
	 * @generated
	 */
	EReference getBehaviorDefinition_Assignments();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin <em>Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pin</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin
	 * @generated
	 */
	EClass getPin();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin#getOwner()
	 * @see #getPin()
	 * @generated
	 */
	EReference getPin_Owner();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment#getLhs()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Lhs();

	/**
	 * Returns the meta object for the containment reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment#getRhs()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Rhs();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving <em>Behaving</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behaving</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving
	 * @generated
	 */
	EClass getBehaving();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Behavior</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving#getBehavior()
	 * @see #getBehaving()
	 * @generated
	 */
	EReference getBehaving_Behavior();

	/**
	 * Returns the meta object for the containment reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving#getOwnedBehavior <em>Owned Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Behavior</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving#getOwnedBehavior()
	 * @see #getBehaving()
	 * @generated
	 */
	EReference getBehaving_OwnedBehavior();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving#getReferencedBehavior <em>Referenced Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Behavior</em>'.
	 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving#getReferencedBehavior()
	 * @see #getBehaving()
	 * @generated
	 */
	EReference getBehaving_ReferencedBehavior();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataDictionaryCharacterizedFactory getDataDictionaryCharacterizedFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.EntityImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedImpl <em>Data Dictionary Characterized</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getDataDictionaryCharacterized()
		 * @generated
		 */
		EClass DATA_DICTIONARY_CHARACTERIZED = eINSTANCE.getDataDictionaryCharacterized();

		/**
		 * The meta object literal for the '<em><b>Characteristic Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DICTIONARY_CHARACTERIZED__CHARACTERISTIC_TYPES = eINSTANCE.getDataDictionaryCharacterized_CharacteristicTypes();

		/**
		 * The meta object literal for the '<em><b>Enumerations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DICTIONARY_CHARACTERIZED__ENUMERATIONS = eINSTANCE.getDataDictionaryCharacterized_Enumerations();

		/**
		 * The meta object literal for the '<em><b>Behavior Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DICTIONARY_CHARACTERIZED__BEHAVIOR_DEFINITIONS = eINSTANCE.getDataDictionaryCharacterized_BehaviorDefinitions();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.CharacteristicTypeImpl <em>Characteristic Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.CharacteristicTypeImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getCharacteristicType()
		 * @generated
		 */
		EClass CHARACTERISTIC_TYPE = eINSTANCE.getCharacteristicType();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.EnumCharacteristicTypeImpl <em>Enum Characteristic Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.EnumCharacteristicTypeImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getEnumCharacteristicType()
		 * @generated
		 */
		EClass ENUM_CHARACTERISTIC_TYPE = eINSTANCE.getEnumCharacteristicType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_CHARACTERISTIC_TYPE__TYPE = eINSTANCE.getEnumCharacteristicType_Type();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.EnumerationImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__LITERALS = eINSTANCE.getEnumeration_Literals();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.LiteralImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '<em><b>Enum</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL__ENUM = eINSTANCE.getLiteral_Enum();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehaviorDefinitionImpl <em>Behavior Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehaviorDefinitionImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getBehaviorDefinition()
		 * @generated
		 */
		EClass BEHAVIOR_DEFINITION = eINSTANCE.getBehaviorDefinition();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_DEFINITION__INPUTS = eINSTANCE.getBehaviorDefinition_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_DEFINITION__OUTPUTS = eINSTANCE.getBehaviorDefinition_Outputs();

		/**
		 * The meta object literal for the '<em><b>Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR_DEFINITION__ASSIGNMENTS = eINSTANCE.getBehaviorDefinition_Assignments();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.PinImpl <em>Pin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.PinImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getPin()
		 * @generated
		 */
		EClass PIN = eINSTANCE.getPin();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PIN__OWNER = eINSTANCE.getPin_Owner();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.AssignmentImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__LHS = eINSTANCE.getAssignment_Lhs();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__RHS = eINSTANCE.getAssignment_Rhs();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehavingImpl <em>Behaving</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.BehavingImpl
		 * @see org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl.DataDictionaryCharacterizedPackageImpl#getBehaving()
		 * @generated
		 */
		EClass BEHAVING = eINSTANCE.getBehaving();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVING__BEHAVIOR = eINSTANCE.getBehaving_Behavior();

		/**
		 * The meta object literal for the '<em><b>Owned Behavior</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVING__OWNED_BEHAVIOR = eINSTANCE.getBehaving_OwnedBehavior();

		/**
		 * The meta object literal for the '<em><b>Referenced Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVING__REFERENCED_BEHAVIOR = eINSTANCE.getBehaving_ReferencedBehavior();

	}

} //DataDictionaryCharacterizedPackage
