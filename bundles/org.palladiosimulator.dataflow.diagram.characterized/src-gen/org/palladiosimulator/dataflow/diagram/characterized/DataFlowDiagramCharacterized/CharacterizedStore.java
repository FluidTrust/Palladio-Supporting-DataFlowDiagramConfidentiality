/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Store;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characterized Store</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage#getCharacterizedStore()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='storeHasNoAssignmentsInBehavior storeHasExactlyOneInputAndOneOutputPin'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL storeHasNoAssignmentsInBehavior='self.behavior.assignments-&gt;isEmpty()' storeHasExactlyOneInputAndOneOutputPin='self.behavior.inputs-&gt;size() = 1 and self.behavior.outputs-&gt;size() = 1'"
 * @generated
 */
public interface CharacterizedStore extends Store, CharacterizedNode {
} // CharacterizedStore
