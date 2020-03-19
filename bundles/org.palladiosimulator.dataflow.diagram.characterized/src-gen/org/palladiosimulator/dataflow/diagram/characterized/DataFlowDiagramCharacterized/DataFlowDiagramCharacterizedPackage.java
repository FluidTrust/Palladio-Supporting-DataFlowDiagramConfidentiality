/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagramPackage;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;

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
 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface DataFlowDiagramCharacterizedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DataFlowDiagramCharacterized";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/dataflow/diagram/characterized/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "DataFlowDiagramCharacterized";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataFlowDiagramCharacterizedPackage eINSTANCE = org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizableImpl <em>Characterizable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizableImpl
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizable()
	 * @generated
	 */
	int CHARACTERIZABLE = 0;

	/**
	 * The feature id for the '<em><b>Characteristics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZABLE__CHARACTERISTICS = 0;

	/**
	 * The number of structural features of the '<em>Characterizable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacteristicImpl <em>Characteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacteristicImpl
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacteristic()
	 * @generated
	 */
	int CHARACTERISTIC = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__ID = DataFlowDiagramPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__NAME = DataFlowDiagramPackage.ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__TYPE = DataFlowDiagramPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_FEATURE_COUNT = DataFlowDiagramPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.EnumCharacteristicImpl <em>Enum Characteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.EnumCharacteristicImpl
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getEnumCharacteristic()
	 * @generated
	 */
	int ENUM_CHARACTERISTIC = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC__ID = CHARACTERISTIC__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC__NAME = CHARACTERISTIC__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC__TYPE = CHARACTERISTIC__TYPE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC__VALUES = CHARACTERISTIC_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enum Characteristic Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC__ENUM_CHARACTERISTIC_TYPE = CHARACTERISTIC_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enum Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_CHARACTERISTIC_FEATURE_COUNT = CHARACTERISTIC_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedExternalActorImpl <em>Characterized External Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedExternalActorImpl
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedExternalActor()
	 * @generated
	 */
	int CHARACTERIZED_EXTERNAL_ACTOR = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_EXTERNAL_ACTOR__ID = DataFlowDiagramPackage.EXTERNAL_ACTOR__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_EXTERNAL_ACTOR__NAME = DataFlowDiagramPackage.EXTERNAL_ACTOR__NAME;

	/**
	 * The feature id for the '<em><b>Requiring Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_EXTERNAL_ACTOR__REQUIRING_NODES = DataFlowDiagramPackage.EXTERNAL_ACTOR__REQUIRING_NODES;

	/**
	 * The feature id for the '<em><b>Providing Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_EXTERNAL_ACTOR__PROVIDING_NODES = DataFlowDiagramPackage.EXTERNAL_ACTOR__PROVIDING_NODES;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_EXTERNAL_ACTOR__BEHAVIOR = DataFlowDiagramPackage.EXTERNAL_ACTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_EXTERNAL_ACTOR__OWNED_BEHAVIOR = DataFlowDiagramPackage.EXTERNAL_ACTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_EXTERNAL_ACTOR__REFERENCED_BEHAVIOR = DataFlowDiagramPackage.EXTERNAL_ACTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Characteristics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_EXTERNAL_ACTOR__CHARACTERISTICS = DataFlowDiagramPackage.EXTERNAL_ACTOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Characterized External Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_EXTERNAL_ACTOR_FEATURE_COUNT = DataFlowDiagramPackage.EXTERNAL_ACTOR_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedStoreImpl <em>Characterized Store</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedStoreImpl
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedStore()
	 * @generated
	 */
	int CHARACTERIZED_STORE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_STORE__ID = DataFlowDiagramPackage.STORE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_STORE__NAME = DataFlowDiagramPackage.STORE__NAME;

	/**
	 * The feature id for the '<em><b>Requiring Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_STORE__REQUIRING_NODES = DataFlowDiagramPackage.STORE__REQUIRING_NODES;

	/**
	 * The feature id for the '<em><b>Providing Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_STORE__PROVIDING_NODES = DataFlowDiagramPackage.STORE__PROVIDING_NODES;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_STORE__BEHAVIOR = DataFlowDiagramPackage.STORE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_STORE__OWNED_BEHAVIOR = DataFlowDiagramPackage.STORE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_STORE__REFERENCED_BEHAVIOR = DataFlowDiagramPackage.STORE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Characteristics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_STORE__CHARACTERISTICS = DataFlowDiagramPackage.STORE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Characterized Store</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_STORE_FEATURE_COUNT = DataFlowDiagramPackage.STORE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedProcessImpl <em>Characterized Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedProcessImpl
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedProcess()
	 * @generated
	 */
	int CHARACTERIZED_PROCESS = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_PROCESS__ID = DataFlowDiagramPackage.PROCESS__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_PROCESS__NAME = DataFlowDiagramPackage.PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Requiring Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_PROCESS__REQUIRING_NODES = DataFlowDiagramPackage.PROCESS__REQUIRING_NODES;

	/**
	 * The feature id for the '<em><b>Providing Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_PROCESS__PROVIDING_NODES = DataFlowDiagramPackage.PROCESS__PROVIDING_NODES;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_PROCESS__BEHAVIOR = DataFlowDiagramPackage.PROCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_PROCESS__OWNED_BEHAVIOR = DataFlowDiagramPackage.PROCESS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_PROCESS__REFERENCED_BEHAVIOR = DataFlowDiagramPackage.PROCESS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Characteristics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_PROCESS__CHARACTERISTICS = DataFlowDiagramPackage.PROCESS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Characterized Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_PROCESS_FEATURE_COUNT = DataFlowDiagramPackage.PROCESS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedDataImpl <em>Characterized Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedDataImpl
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedData()
	 * @generated
	 */
	int CHARACTERIZED_DATA = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA__ID = DataFlowDiagramPackage.DATA__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA__NAME = DataFlowDiagramPackage.DATA__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA__TYPE = DataFlowDiagramPackage.DATA__TYPE;

	/**
	 * The feature id for the '<em><b>Characteristics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA__CHARACTERISTICS = DataFlowDiagramPackage.DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Characterized Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA_FEATURE_COUNT = DataFlowDiagramPackage.DATA_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedDataFlowImpl <em>Characterized Data Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedDataFlowImpl
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedDataFlow()
	 * @generated
	 */
	int CHARACTERIZED_DATA_FLOW = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA_FLOW__ID = DataFlowDiagramPackage.EDGE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA_FLOW__NAME = DataFlowDiagramPackage.EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA_FLOW__TARGET = DataFlowDiagramPackage.EDGE__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA_FLOW__SOURCE = DataFlowDiagramPackage.EDGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Characteristics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA_FLOW__CHARACTERISTICS = DataFlowDiagramPackage.EDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA_FLOW__SOURCE_PIN = DataFlowDiagramPackage.EDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA_FLOW__TARGET_PIN = DataFlowDiagramPackage.EDGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Characterized Data Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_DATA_FLOW_FEATURE_COUNT = DataFlowDiagramPackage.EDGE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedActorProcessImpl <em>Characterized Actor Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedActorProcessImpl
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedActorProcess()
	 * @generated
	 */
	int CHARACTERIZED_ACTOR_PROCESS = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_ACTOR_PROCESS__ID = CHARACTERIZED_PROCESS__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_ACTOR_PROCESS__NAME = CHARACTERIZED_PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Requiring Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_ACTOR_PROCESS__REQUIRING_NODES = CHARACTERIZED_PROCESS__REQUIRING_NODES;

	/**
	 * The feature id for the '<em><b>Providing Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_ACTOR_PROCESS__PROVIDING_NODES = CHARACTERIZED_PROCESS__PROVIDING_NODES;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_ACTOR_PROCESS__BEHAVIOR = CHARACTERIZED_PROCESS__BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_ACTOR_PROCESS__OWNED_BEHAVIOR = CHARACTERIZED_PROCESS__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Referenced Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_ACTOR_PROCESS__REFERENCED_BEHAVIOR = CHARACTERIZED_PROCESS__REFERENCED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Characteristics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_ACTOR_PROCESS__CHARACTERISTICS = CHARACTERIZED_PROCESS__CHARACTERISTICS;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_ACTOR_PROCESS__ACTOR = CHARACTERIZED_PROCESS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Characterized Actor Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_ACTOR_PROCESS_FEATURE_COUNT = CHARACTERIZED_PROCESS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedNodeImpl <em>Characterized Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedNodeImpl
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedNode()
	 * @generated
	 */
	int CHARACTERIZED_NODE = 9;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_NODE__BEHAVIOR = DataDictionaryCharacterizedPackage.BEHAVING__BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Owned Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_NODE__OWNED_BEHAVIOR = DataDictionaryCharacterizedPackage.BEHAVING__OWNED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Referenced Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_NODE__REFERENCED_BEHAVIOR = DataDictionaryCharacterizedPackage.BEHAVING__REFERENCED_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Characteristics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_NODE__CHARACTERISTICS = DataDictionaryCharacterizedPackage.BEHAVING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Characterized Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERIZED_NODE_FEATURE_COUNT = DataDictionaryCharacterizedPackage.BEHAVING_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characterizable <em>Characterizable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characterizable</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characterizable
	 * @generated
	 */
	EClass getCharacterizable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characterizable#getCharacteristics <em>Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Characteristics</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characterizable#getCharacteristics()
	 * @see #getCharacterizable()
	 * @generated
	 */
	EReference getCharacterizable_Characteristics();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characteristic <em>Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characteristic</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characteristic
	 * @generated
	 */
	EClass getCharacteristic();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characteristic#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characteristic#getType()
	 * @see #getCharacteristic()
	 * @generated
	 */
	EReference getCharacteristic_Type();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic <em>Enum Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Characteristic</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic
	 * @generated
	 */
	EClass getEnumCharacteristic();

	/**
	 * Returns the meta object for the reference list '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic#getValues()
	 * @see #getEnumCharacteristic()
	 * @generated
	 */
	EReference getEnumCharacteristic_Values();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic#getEnumCharacteristicType <em>Enum Characteristic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enum Characteristic Type</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic#getEnumCharacteristicType()
	 * @see #getEnumCharacteristic()
	 * @generated
	 */
	EReference getEnumCharacteristic_EnumCharacteristicType();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedExternalActor <em>Characterized External Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characterized External Actor</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedExternalActor
	 * @generated
	 */
	EClass getCharacterizedExternalActor();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore <em>Characterized Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characterized Store</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore
	 * @generated
	 */
	EClass getCharacterizedStore();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess <em>Characterized Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characterized Process</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
	 * @generated
	 */
	EClass getCharacterizedProcess();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedData <em>Characterized Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characterized Data</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedData
	 * @generated
	 */
	EClass getCharacterizedData();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow <em>Characterized Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characterized Data Flow</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow
	 * @generated
	 */
	EClass getCharacterizedDataFlow();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow#getSourcePin <em>Source Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Pin</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow#getSourcePin()
	 * @see #getCharacterizedDataFlow()
	 * @generated
	 */
	EReference getCharacterizedDataFlow_SourcePin();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow#getTargetPin <em>Target Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Pin</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow#getTargetPin()
	 * @see #getCharacterizedDataFlow()
	 * @generated
	 */
	EReference getCharacterizedDataFlow_TargetPin();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedActorProcess <em>Characterized Actor Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characterized Actor Process</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedActorProcess
	 * @generated
	 */
	EClass getCharacterizedActorProcess();

	/**
	 * Returns the meta object for the reference '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedActorProcess#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedActorProcess#getActor()
	 * @see #getCharacterizedActorProcess()
	 * @generated
	 */
	EReference getCharacterizedActorProcess_Actor();

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedNode <em>Characterized Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characterized Node</em>'.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedNode
	 * @generated
	 */
	EClass getCharacterizedNode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataFlowDiagramCharacterizedFactory getDataFlowDiagramCharacterizedFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizableImpl <em>Characterizable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizableImpl
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizable()
		 * @generated
		 */
		EClass CHARACTERIZABLE = eINSTANCE.getCharacterizable();

		/**
		 * The meta object literal for the '<em><b>Characteristics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERIZABLE__CHARACTERISTICS = eINSTANCE.getCharacterizable_Characteristics();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacteristicImpl <em>Characteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacteristicImpl
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacteristic()
		 * @generated
		 */
		EClass CHARACTERISTIC = eINSTANCE.getCharacteristic();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERISTIC__TYPE = eINSTANCE.getCharacteristic_Type();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.EnumCharacteristicImpl <em>Enum Characteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.EnumCharacteristicImpl
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getEnumCharacteristic()
		 * @generated
		 */
		EClass ENUM_CHARACTERISTIC = eINSTANCE.getEnumCharacteristic();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_CHARACTERISTIC__VALUES = eINSTANCE.getEnumCharacteristic_Values();

		/**
		 * The meta object literal for the '<em><b>Enum Characteristic Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_CHARACTERISTIC__ENUM_CHARACTERISTIC_TYPE = eINSTANCE.getEnumCharacteristic_EnumCharacteristicType();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedExternalActorImpl <em>Characterized External Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedExternalActorImpl
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedExternalActor()
		 * @generated
		 */
		EClass CHARACTERIZED_EXTERNAL_ACTOR = eINSTANCE.getCharacterizedExternalActor();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedStoreImpl <em>Characterized Store</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedStoreImpl
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedStore()
		 * @generated
		 */
		EClass CHARACTERIZED_STORE = eINSTANCE.getCharacterizedStore();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedProcessImpl <em>Characterized Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedProcessImpl
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedProcess()
		 * @generated
		 */
		EClass CHARACTERIZED_PROCESS = eINSTANCE.getCharacterizedProcess();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedDataImpl <em>Characterized Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedDataImpl
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedData()
		 * @generated
		 */
		EClass CHARACTERIZED_DATA = eINSTANCE.getCharacterizedData();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedDataFlowImpl <em>Characterized Data Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedDataFlowImpl
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedDataFlow()
		 * @generated
		 */
		EClass CHARACTERIZED_DATA_FLOW = eINSTANCE.getCharacterizedDataFlow();

		/**
		 * The meta object literal for the '<em><b>Source Pin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERIZED_DATA_FLOW__SOURCE_PIN = eINSTANCE.getCharacterizedDataFlow_SourcePin();

		/**
		 * The meta object literal for the '<em><b>Target Pin</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERIZED_DATA_FLOW__TARGET_PIN = eINSTANCE.getCharacterizedDataFlow_TargetPin();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedActorProcessImpl <em>Characterized Actor Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedActorProcessImpl
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedActorProcess()
		 * @generated
		 */
		EClass CHARACTERIZED_ACTOR_PROCESS = eINSTANCE.getCharacterizedActorProcess();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHARACTERIZED_ACTOR_PROCESS__ACTOR = eINSTANCE.getCharacterizedActorProcess_Actor();

		/**
		 * The meta object literal for the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedNodeImpl <em>Characterized Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.CharacterizedNodeImpl
		 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedPackageImpl#getCharacterizedNode()
		 * @generated
		 */
		EClass CHARACTERIZED_NODE = eINSTANCE.getCharacterizedNode();

	}

} //DataFlowDiagramCharacterizedPackage
