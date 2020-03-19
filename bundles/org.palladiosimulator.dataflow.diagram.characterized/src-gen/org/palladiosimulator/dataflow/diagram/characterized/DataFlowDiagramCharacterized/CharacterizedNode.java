/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characterized Node</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage#getCharacterizedNode()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='atLeastOneInputFlowForEachInputPin'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL atLeastOneInputFlowForEachInputPin='self.behavior.inputs-&gt;isEmpty() or CharacterizedDataFlow.allInstances()-&gt;select(f | f.target = self).targetPin-&gt;asSet()-&gt;includesAll(self.behavior.inputs-&gt;asSet())'"
 * @generated
 */
public interface CharacterizedNode extends Behaving, Characterizable {
} // CharacterizedNode
