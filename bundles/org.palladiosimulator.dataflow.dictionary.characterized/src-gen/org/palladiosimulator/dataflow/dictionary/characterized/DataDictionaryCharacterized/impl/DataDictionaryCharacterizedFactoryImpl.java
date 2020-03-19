/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataDictionaryCharacterizedFactoryImpl extends EFactoryImpl implements DataDictionaryCharacterizedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataDictionaryCharacterizedFactory init() {
		try {
			DataDictionaryCharacterizedFactory theDataDictionaryCharacterizedFactory = (DataDictionaryCharacterizedFactory)EPackage.Registry.INSTANCE.getEFactory(DataDictionaryCharacterizedPackage.eNS_URI);
			if (theDataDictionaryCharacterizedFactory != null) {
				return theDataDictionaryCharacterizedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DataDictionaryCharacterizedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataDictionaryCharacterizedFactoryImpl() {
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
			case DataDictionaryCharacterizedPackage.DATA_DICTIONARY_CHARACTERIZED: return createDataDictionaryCharacterized();
			case DataDictionaryCharacterizedPackage.ENUM_CHARACTERISTIC_TYPE: return createEnumCharacteristicType();
			case DataDictionaryCharacterizedPackage.ENUMERATION: return createEnumeration();
			case DataDictionaryCharacterizedPackage.LITERAL: return createLiteral();
			case DataDictionaryCharacterizedPackage.BEHAVIOR_DEFINITION: return createBehaviorDefinition();
			case DataDictionaryCharacterizedPackage.PIN: return createPin();
			case DataDictionaryCharacterizedPackage.ASSIGNMENT: return createAssignment();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataDictionaryCharacterized createDataDictionaryCharacterized() {
		DataDictionaryCharacterizedImpl dataDictionaryCharacterized = new DataDictionaryCharacterizedImpl();
		return dataDictionaryCharacterized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumCharacteristicType createEnumCharacteristicType() {
		EnumCharacteristicTypeImpl enumCharacteristicType = new EnumCharacteristicTypeImpl();
		return enumCharacteristicType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal createLiteral() {
		LiteralImpl literal = new LiteralImpl();
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorDefinition createBehaviorDefinition() {
		BehaviorDefinitionImpl behaviorDefinition = new BehaviorDefinitionImpl();
		return behaviorDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pin createPin() {
		PinImpl pin = new PinImpl();
		return pin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataDictionaryCharacterizedPackage getDataDictionaryCharacterizedPackage() {
		return (DataDictionaryCharacterizedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DataDictionaryCharacterizedPackage getPackage() {
		return DataDictionaryCharacterizedPackage.eINSTANCE;
	}

} //DataDictionaryCharacterizedFactoryImpl
