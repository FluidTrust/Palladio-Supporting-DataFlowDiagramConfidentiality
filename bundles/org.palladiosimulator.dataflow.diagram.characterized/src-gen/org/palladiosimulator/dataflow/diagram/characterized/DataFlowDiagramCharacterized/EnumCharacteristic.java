/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized;

import org.eclipse.emf.common.util.EList;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Characteristic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic#getValues <em>Values</em>}</li>
 *   <li>{@link org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic#getEnumCharacteristicType <em>Enum Characteristic Type</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage#getEnumCharacteristic()
 * @model
 * @generated
 */
public interface EnumCharacteristic extends Characteristic {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' reference list.
	 * The list contents are of type {@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' reference list.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage#getEnumCharacteristic_Values()
	 * @model
	 * @generated
	 */
	EList<Literal> getValues();

	/**
	 * Returns the value of the '<em><b>Enum Characteristic Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Characteristic Type</em>' reference.
	 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage#getEnumCharacteristic_EnumCharacteristicType()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='self.type.oclAsType(DataDictionaryCharacterized::EnumCharacteristicType)'"
	 * @generated
	 */
	EnumCharacteristicType getEnumCharacteristicType();

} // EnumCharacteristic
