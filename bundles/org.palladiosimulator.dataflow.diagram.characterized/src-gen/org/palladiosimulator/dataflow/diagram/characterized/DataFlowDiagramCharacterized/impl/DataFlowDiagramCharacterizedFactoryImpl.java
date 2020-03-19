/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataFlowDiagramCharacterizedFactoryImpl extends EFactoryImpl implements DataFlowDiagramCharacterizedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataFlowDiagramCharacterizedFactory init() {
		try {
			DataFlowDiagramCharacterizedFactory theDataFlowDiagramCharacterizedFactory = (DataFlowDiagramCharacterizedFactory)EPackage.Registry.INSTANCE.getEFactory(DataFlowDiagramCharacterizedPackage.eNS_URI);
			if (theDataFlowDiagramCharacterizedFactory != null) {
				return theDataFlowDiagramCharacterizedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataFlowDiagramCharacterizedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowDiagramCharacterizedFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DataFlowDiagramCharacterizedPackage.ENUM_CHARACTERISTIC: return createEnumCharacteristic();
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_EXTERNAL_ACTOR: return createCharacterizedExternalActor();
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE: return createCharacterizedStore();
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_PROCESS: return createCharacterizedProcess();
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA: return createCharacterizedData();
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW: return createCharacterizedDataFlow();
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_ACTOR_PROCESS: return createCharacterizedActorProcess();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumCharacteristic createEnumCharacteristic() {
		EnumCharacteristicImpl enumCharacteristic = new EnumCharacteristicImpl();
		return enumCharacteristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterizedExternalActor createCharacterizedExternalActor() {
		CharacterizedExternalActorImpl characterizedExternalActor = new CharacterizedExternalActorImpl();
		return characterizedExternalActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterizedStore createCharacterizedStore() {
		CharacterizedStoreImpl characterizedStore = new CharacterizedStoreImpl();
		return characterizedStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterizedProcess createCharacterizedProcess() {
		CharacterizedProcessImpl characterizedProcess = new CharacterizedProcessImpl();
		return characterizedProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterizedData createCharacterizedData() {
		CharacterizedDataImpl characterizedData = new CharacterizedDataImpl();
		return characterizedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterizedDataFlow createCharacterizedDataFlow() {
		CharacterizedDataFlowImpl characterizedDataFlow = new CharacterizedDataFlowImpl();
		return characterizedDataFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CharacterizedActorProcess createCharacterizedActorProcess() {
		CharacterizedActorProcessImpl characterizedActorProcess = new CharacterizedActorProcessImpl();
		return characterizedActorProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowDiagramCharacterizedPackage getDataFlowDiagramCharacterizedPackage() {
		return (DataFlowDiagramCharacterizedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DataFlowDiagramCharacterizedPackage getPackage() {
		return DataFlowDiagramCharacterizedPackage.eINSTANCE;
	}

} //DataFlowDiagramCharacterizedFactoryImpl
