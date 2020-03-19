/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.util;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Component;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Data;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Edge;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Entity;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.ExternalActor;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.NamedElement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Store;

import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.*;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage
 * @generated
 */
public class DataFlowDiagramCharacterizedSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataFlowDiagramCharacterizedPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowDiagramCharacterizedSwitch() {
		if (modelPackage == null) {
			modelPackage = DataFlowDiagramCharacterizedPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZABLE: {
				Characterizable characterizable = (Characterizable)theEObject;
				T result = caseCharacterizable(characterizable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataFlowDiagramCharacterizedPackage.CHARACTERISTIC: {
				Characteristic characteristic = (Characteristic)theEObject;
				T result = caseCharacteristic(characteristic);
				if (result == null) result = caseEntity(characteristic);
				if (result == null) result = caseIdentifier(characteristic);
				if (result == null) result = caseNamedElement(characteristic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataFlowDiagramCharacterizedPackage.ENUM_CHARACTERISTIC: {
				EnumCharacteristic enumCharacteristic = (EnumCharacteristic)theEObject;
				T result = caseEnumCharacteristic(enumCharacteristic);
				if (result == null) result = caseCharacteristic(enumCharacteristic);
				if (result == null) result = caseEntity(enumCharacteristic);
				if (result == null) result = caseIdentifier(enumCharacteristic);
				if (result == null) result = caseNamedElement(enumCharacteristic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_EXTERNAL_ACTOR: {
				CharacterizedExternalActor characterizedExternalActor = (CharacterizedExternalActor)theEObject;
				T result = caseCharacterizedExternalActor(characterizedExternalActor);
				if (result == null) result = caseExternalActor(characterizedExternalActor);
				if (result == null) result = caseCharacterizedNode(characterizedExternalActor);
				if (result == null) result = caseNode(characterizedExternalActor);
				if (result == null) result = caseBehaving(characterizedExternalActor);
				if (result == null) result = caseCharacterizable(characterizedExternalActor);
				if (result == null) result = caseComponent(characterizedExternalActor);
				if (result == null) result = caseEntity(characterizedExternalActor);
				if (result == null) result = caseIdentifier(characterizedExternalActor);
				if (result == null) result = caseNamedElement(characterizedExternalActor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_STORE: {
				CharacterizedStore characterizedStore = (CharacterizedStore)theEObject;
				T result = caseCharacterizedStore(characterizedStore);
				if (result == null) result = caseStore(characterizedStore);
				if (result == null) result = caseCharacterizedNode(characterizedStore);
				if (result == null) result = caseNode(characterizedStore);
				if (result == null) result = caseBehaving(characterizedStore);
				if (result == null) result = caseCharacterizable(characterizedStore);
				if (result == null) result = caseComponent(characterizedStore);
				if (result == null) result = caseEntity(characterizedStore);
				if (result == null) result = caseIdentifier(characterizedStore);
				if (result == null) result = caseNamedElement(characterizedStore);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_PROCESS: {
				CharacterizedProcess characterizedProcess = (CharacterizedProcess)theEObject;
				T result = caseCharacterizedProcess(characterizedProcess);
				if (result == null) result = caseProcess(characterizedProcess);
				if (result == null) result = caseCharacterizedNode(characterizedProcess);
				if (result == null) result = caseNode(characterizedProcess);
				if (result == null) result = caseBehaving(characterizedProcess);
				if (result == null) result = caseCharacterizable(characterizedProcess);
				if (result == null) result = caseComponent(characterizedProcess);
				if (result == null) result = caseEntity(characterizedProcess);
				if (result == null) result = caseIdentifier(characterizedProcess);
				if (result == null) result = caseNamedElement(characterizedProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA: {
				CharacterizedData characterizedData = (CharacterizedData)theEObject;
				T result = caseCharacterizedData(characterizedData);
				if (result == null) result = caseData(characterizedData);
				if (result == null) result = caseCharacterizable(characterizedData);
				if (result == null) result = caseEntity(characterizedData);
				if (result == null) result = caseIdentifier(characterizedData);
				if (result == null) result = caseNamedElement(characterizedData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW: {
				CharacterizedDataFlow characterizedDataFlow = (CharacterizedDataFlow)theEObject;
				T result = caseCharacterizedDataFlow(characterizedDataFlow);
				if (result == null) result = caseEdge(characterizedDataFlow);
				if (result == null) result = caseCharacterizable(characterizedDataFlow);
				if (result == null) result = caseComponent(characterizedDataFlow);
				if (result == null) result = caseEntity(characterizedDataFlow);
				if (result == null) result = caseIdentifier(characterizedDataFlow);
				if (result == null) result = caseNamedElement(characterizedDataFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_ACTOR_PROCESS: {
				CharacterizedActorProcess characterizedActorProcess = (CharacterizedActorProcess)theEObject;
				T result = caseCharacterizedActorProcess(characterizedActorProcess);
				if (result == null) result = caseCharacterizedProcess(characterizedActorProcess);
				if (result == null) result = caseProcess(characterizedActorProcess);
				if (result == null) result = caseCharacterizedNode(characterizedActorProcess);
				if (result == null) result = caseNode(characterizedActorProcess);
				if (result == null) result = caseBehaving(characterizedActorProcess);
				if (result == null) result = caseCharacterizable(characterizedActorProcess);
				if (result == null) result = caseComponent(characterizedActorProcess);
				if (result == null) result = caseEntity(characterizedActorProcess);
				if (result == null) result = caseIdentifier(characterizedActorProcess);
				if (result == null) result = caseNamedElement(characterizedActorProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_NODE: {
				CharacterizedNode characterizedNode = (CharacterizedNode)theEObject;
				T result = caseCharacterizedNode(characterizedNode);
				if (result == null) result = caseBehaving(characterizedNode);
				if (result == null) result = caseCharacterizable(characterizedNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characterizable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characterizable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacterizable(Characterizable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characteristic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacteristic(Characteristic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Characteristic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumCharacteristic(EnumCharacteristic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characterized External Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characterized External Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacterizedExternalActor(CharacterizedExternalActor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characterized Store</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characterized Store</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacterizedStore(CharacterizedStore object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characterized Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characterized Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacterizedProcess(CharacterizedProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characterized Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characterized Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacterizedData(CharacterizedData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characterized Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characterized Data Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacterizedDataFlow(CharacterizedDataFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characterized Actor Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characterized Actor Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacterizedActorProcess(CharacterizedActorProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Characterized Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Characterized Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacterizedNode(CharacterizedNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponent(Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalActor(ExternalActor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behaving</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behaving</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaving(Behaving object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Store</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Store</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStore(Store object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcess(org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Process object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseData(Data object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdge(Edge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DataFlowDiagramCharacterizedSwitch
