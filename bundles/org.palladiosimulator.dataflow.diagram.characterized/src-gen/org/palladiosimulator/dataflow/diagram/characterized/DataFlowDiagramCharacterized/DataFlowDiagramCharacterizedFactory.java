/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage
 * @generated
 */
public interface DataFlowDiagramCharacterizedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataFlowDiagramCharacterizedFactory eINSTANCE = org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.impl.DataFlowDiagramCharacterizedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Enum Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Characteristic</em>'.
	 * @generated
	 */
	EnumCharacteristic createEnumCharacteristic();

	/**
	 * Returns a new object of class '<em>Characterized External Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characterized External Actor</em>'.
	 * @generated
	 */
	CharacterizedExternalActor createCharacterizedExternalActor();

	/**
	 * Returns a new object of class '<em>Characterized Store</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characterized Store</em>'.
	 * @generated
	 */
	CharacterizedStore createCharacterizedStore();

	/**
	 * Returns a new object of class '<em>Characterized Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characterized Process</em>'.
	 * @generated
	 */
	CharacterizedProcess createCharacterizedProcess();

	/**
	 * Returns a new object of class '<em>Characterized Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characterized Data</em>'.
	 * @generated
	 */
	CharacterizedData createCharacterizedData();

	/**
	 * Returns a new object of class '<em>Characterized Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characterized Data Flow</em>'.
	 * @generated
	 */
	CharacterizedDataFlow createCharacterizedDataFlow();

	/**
	 * Returns a new object of class '<em>Characterized Actor Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characterized Actor Process</em>'.
	 * @generated
	 */
	CharacterizedActorProcess createCharacterizedActorProcess();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DataFlowDiagramCharacterizedPackage getDataFlowDiagramCharacterizedPackage();

} //DataFlowDiagramCharacterizedFactory
