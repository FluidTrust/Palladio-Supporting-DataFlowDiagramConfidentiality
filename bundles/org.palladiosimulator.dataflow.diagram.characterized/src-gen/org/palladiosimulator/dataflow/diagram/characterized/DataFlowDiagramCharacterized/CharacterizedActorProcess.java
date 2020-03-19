/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.ExternalActor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characterized Actor Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedActorProcess#getActor <em>Actor</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage#getCharacterizedActorProcess()
 * @model
 * @generated
 */
public interface CharacterizedActorProcess extends CharacterizedProcess {
	/**
	 * Returns the value of the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor</em>' reference.
	 * @see #setActor(ExternalActor)
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage#getCharacterizedActorProcess_Actor()
	 * @model required="true"
	 * @generated
	 */
	ExternalActor getActor();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedActorProcess#getActor <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor</em>' reference.
	 * @see #getActor()
	 * @generated
	 */
	void setActor(ExternalActor value);

} // CharacterizedActorProcess
