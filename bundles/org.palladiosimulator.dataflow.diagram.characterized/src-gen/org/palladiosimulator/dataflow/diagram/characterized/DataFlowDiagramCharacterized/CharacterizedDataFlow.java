/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Edge;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Characterized Data Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow#getSourcePin <em>Source Pin</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow#getTargetPin <em>Target Pin</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage#getCharacterizedDataFlow()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='sourcePinIsEntityOutputPin destinationPinIsEntityInputPin sourcePinOwnerMatchesSource destinationPinOwnerMatchesDestination notPartOfLoop'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL sourcePinIsEntityOutputPin='self.sourcePin.owner.outputs-&gt;includes(self.sourcePin)' destinationPinIsEntityInputPin='self.targetPin.owner.inputs-&gt;includes(self.targetPin)' sourcePinOwnerMatchesSource='not self.source.oclIsKindOf(DataDictionaryCharacterized::Behaving) or self.source.oclAsType(DataDictionaryCharacterized::Behaving).behavior.outputs-&gt;includes(self.sourcePin)' destinationPinOwnerMatchesDestination='not self.target.oclIsKindOf(DataDictionaryCharacterized::Behaving) or self.target.oclAsType(DataDictionaryCharacterized::Behaving).behavior.inputs-&gt;includes(self.targetPin)' notPartOfLoop='not self.oclAsType(DataFlowDiagram::Edge)-&gt;closure(e |\n\tself.oclAsType(ecore::EObject).eContainer().oclAsType(DataFlowDiagram::DataFlowDiagram).edges-&gt;select(f |\n\t\tf.source = e.target and\n\t\tnot f.source-&gt;including(f.target)-&gt;exists(n | n.oclIsKindOf(CharacterizedExternalActor))\n\t)\n)-&gt;exists(f | f.target = self.source)'"
 * @generated
 */
public interface CharacterizedDataFlow extends Edge, Characterizable {
	/**
	 * Returns the value of the '<em><b>Source Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Pin</em>' reference.
	 * @see #setSourcePin(Pin)
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage#getCharacterizedDataFlow_SourcePin()
	 * @model required="true"
	 * @generated
	 */
	Pin getSourcePin();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow#getSourcePin <em>Source Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Pin</em>' reference.
	 * @see #getSourcePin()
	 * @generated
	 */
	void setSourcePin(Pin value);

	/**
	 * Returns the value of the '<em><b>Target Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Pin</em>' reference.
	 * @see #setTargetPin(Pin)
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage#getCharacterizedDataFlow_TargetPin()
	 * @model required="true"
	 * @generated
	 */
	Pin getTargetPin();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow#getTargetPin <em>Target Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Pin</em>' reference.
	 * @see #getTargetPin()
	 * @generated
	 */
	void setTargetPin(Pin value);

} // CharacterizedDataFlow
