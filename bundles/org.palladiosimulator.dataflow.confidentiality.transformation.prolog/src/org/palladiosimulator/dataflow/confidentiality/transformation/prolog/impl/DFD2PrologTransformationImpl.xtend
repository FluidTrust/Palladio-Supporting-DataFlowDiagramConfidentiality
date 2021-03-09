package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.impl

import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.Iterator
import java.util.LinkedList
import java.util.List
import java.util.Optional
import org.eclipse.emf.ecore.EObject
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.DFD2PrologTransformation
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming.UniqueNameProvider
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowEdge
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Edge
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Entity
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedActorProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedExternalActor
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedNode
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic
import org.palladiosimulator.dataflow.dictionary.DataDictionary.CollectionDataType
import org.palladiosimulator.dataflow.dictionary.DataDictionary.CompositeDataType
import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataType
import org.palladiosimulator.dataflow.dictionary.DataDictionary.PrimitiveDataType
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.And
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Constant
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ContainerCharacteristicReference
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.EnumCharacteristicReference
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.False
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.LogicTerm
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Not
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Or
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Term
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.True
import org.palladiosimulator.supporting.prolog.model.prolog.Clause
import org.palladiosimulator.supporting.prolog.model.prolog.CompoundTerm
import org.palladiosimulator.supporting.prolog.model.prolog.Fact
import org.palladiosimulator.supporting.prolog.model.prolog.Program
import org.palladiosimulator.supporting.prolog.model.prolog.PrologFactory
import org.palladiosimulator.supporting.prolog.model.prolog.Rule
import org.palladiosimulator.supporting.prolog.model.prolog.directives.Discontiguous
import org.palladiosimulator.supporting.prolog.model.prolog.expressions.Expression
import org.palladiosimulator.supporting.prolog.model.prolog.expressions.ExpressionsFactory

class DFD2PrologTransformationImpl implements DFD2PrologTransformation {

	static val extension PrologFactory prologFactory = PrologFactory.eINSTANCE
	static val extension ExpressionsFactory prologExpressionsFactory = ExpressionsFactory.eINSTANCE
	static val extension PrologCreateUtils prologCreateUtils = new PrologCreateUtils
	val extension UniqueNameUtils uniqueNameUtils
	val dfdExpressionsFactory = org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsFactory.eINSTANCE
	val stagedTraces = new HashMap<EObject, Runnable>
	var DFD2PrologTransformationWritableTrace trace
	var Program program	
	var Iterable<EnumCharacteristicType> characteristicTypesInBehaviors
	var Iterable<EnumCharacteristicType> characteristicTypesInNodes
	var Iterable<DataType> usedDataTypes

	new(UniqueNameProvider nameProvider) {
		this.uniqueNameUtils = new UniqueNameUtils(nameProvider)
	}

	override transform(DataFlowDiagram dfd) {
		initTransformationState(dfd)
		
		addPreamble(dfd)
		
		add(createHeaderComment("Characteristic types"))
		#[characteristicTypesInBehaviors, characteristicTypesInNodes].flatten.distinct.forEach[transformCharacteristicType.add]
		
		add(createHeaderComment("Nodes"))
		dfd.nodes.forEach[transformNode.add]
		
		if (!usedDataTypes.isEmpty) {
			add(createHeaderComment("Data Types"))
			usedDataTypes.forEach[transformDataType.add]
		}
		
		add(createHeaderComment("Edges"))
		dfd.edges.forEach[transformEdge.add]
		
		new TransformationResultImpl(program, trace)
	}
	
	protected def void initTransformationState(DataFlowDiagram dfd) {
		this.program = createProgram
		this.trace = new DFD2PrologTransformationWritableTraceImpl
		this.trace.add(dfd, program)
		this.stagedTraces.clear()
		this.characteristicTypesInBehaviors = dfd.findAllCharacteristicTypesInBehaviors
		this.characteristicTypesInNodes = dfd.findAllCharacteristicTypesInNodes
		this.usedDataTypes = dfd.findAllUsedDataTypes
	}

	protected def transformCharacteristicType(EnumCharacteristicType characteristicType) {
		val facts = new ArrayList
		facts += createFact(createCompoundTerm("characteristicType", characteristicType.uniqueQuotedString))
		facts.last.stageTrace[trace.add(characteristicType, characteristicType.uniqueQuotedString.value)]
		for (var i = 0; i < characteristicType.type.literals.size; i++) {
			val literal = characteristicType.type.literals.get(i)
			facts += createFact(createCompoundTerm("characteristicTypeValue", characteristicType.uniqueQuotedString, literal.uniqueQuotedString, i.toInt))
			stageTrace(facts.last, [trace.add(literal, literal.uniqueQuotedString.value)])
		}
		facts
	}
	

	
	protected def dispatch transformDataType(CollectionDataType dataType) {
		val facts = new ArrayList<Fact>
		facts += (dataType as DataType)._transformDataType
		facts += createFact(createCompoundTerm("collectionDataType", dataType.uniqueQuotedString, dataType.type.uniqueQuotedString))
		facts
	}
	
	protected def dispatch transformDataType(CompositeDataType dataType) {
		val facts = new ArrayList
		facts += (dataType as DataType)._transformDataType
		facts += createFact(createCompoundTerm("compositeDataType", dataType.uniqueQuotedString))
		for (component : dataType.components) {
			facts += createFact(createCompoundTerm("compositeDataTypeEntry", dataType.uniqueQuotedString, component.name.toQuotedString, component.type.uniqueQuotedString))
		}
		facts
	}
	
	protected def dispatch transformDataType(PrimitiveDataType dataType) {
		(dataType as DataType)._transformDataType
	}
	
	protected def dispatch List<Fact> transformDataType(DataType dataType) {
		val fact = createFact(createCompoundTerm("dataType", dataType.uniqueQuotedString))
		fact.stageTrace[trace.add(dataType, dataType.uniqueQuotedString.value)]
		#[fact]
	}
	
	interface OutputBehaviorCreator {
	    def Rule createOutputCharacteristicRule(CharacterizedNode node, Pin pin, EnumCharacteristicType ct, Literal l);
	}
	
	protected def dispatch transformNode(CharacterizedProcess process) {
		process.transformNode("process", [node, pin, ct, l |
			val assignmentToTransform = node.behavior.assignments.findLastMatchingAssignment(pin, ct, l)
			val transformedAssignment = assignmentToTransform.transformAssignment(node, pin, ct, l)
			if (assignmentToTransform.needsFlowTree) {
				val flowClauses = new ArrayList<Expression>(createFlowTreeClauses(node, node.behavior.inputs))
				flowClauses += transformedAssignment
				createRule(
					createCompoundTerm("characteristic", node.uniqueQuotedString, pin.getUniqueQuotedString(process as Node), ct.uniqueQuotedString, l.uniqueQuotedString, "S".toVar, "VISITED".toVar),
					createConjunction(flowClauses)
				)
			} else {
				createRule(
					createCompoundTerm("characteristic", node.uniqueQuotedString, pin.getUniqueQuotedString(process as Node), ct.uniqueQuotedString, l.uniqueQuotedString, "_".toVar, "_".toVar),
					createConjunction(transformedAssignment)
				)
			}
		])
	}
	
	protected def dispatch transformNode(CharacterizedActorProcess process) {
		val clauses = new ArrayList<Clause>
		clauses += createFact(createCompoundTerm("actorProcess", (process as CharacterizedNode).uniqueQuotedString, process.actor.uniqueQuotedString))
		clauses += (process as CharacterizedProcess)._transformNode
		clauses
	}
	
	protected def dispatch transformNode(CharacterizedExternalActor actor) {
		actor.transformNode("actor", [node, pin, ct, l|
			val assignmentToTransform = node.behavior.assignments.findLastMatchingAssignment(pin, ct, l)
			if (assignmentToTransform.needsFlowTree) {
				throw new IllegalArgumentException("Actors must not refer to input pins in their behavior.")
			} else {
				createRule(
					createCompoundTerm("characteristic", node.uniqueQuotedString, pin.getUniqueQuotedString(node), ct.uniqueQuotedString, l.uniqueQuotedString, createList, "_".toVar),
					createConjunction(assignmentToTransform.transformAssignment(node, pin, ct, l))
				)
			}
		])
	}
	
	protected def dispatch transformNode(CharacterizedStore store) {
		store.transformNode("store", [node, pin, ct, l|
				val flowClauses = new ArrayList<Expression>(createFlowTreeClauses(node, node.behavior.inputs))
				val term = dfdExpressionsFactory.createDataCharacteristicReference
				term.pin = node.behavior.inputs.get(0)
				term.characteristicType = ct
				term.literal = l
				flowClauses += term.transformAssignmentTerm(node, pin, ct, l)
				createRule(
					createCompoundTerm("characteristic", node.uniqueQuotedString, pin.getUniqueQuotedString(node), ct.uniqueQuotedString, l.uniqueQuotedString, "S".toVar, "VISITED".toVar),
					createConjunction(flowClauses)
				)
		])
	}

	protected def dispatch transformEdge(CharacterizedDataFlow dataflow) {
		val facts = new ArrayList
		facts += createFact(createCompoundTerm("dataflow", dataflow.uniqueQuotedString, dataflow.source.uniqueQuotedString, dataflow.sourcePin.getUniqueQuotedString(dataflow.source), dataflow.target.uniqueQuotedString, dataflow.targetPin.getUniqueQuotedString(dataflow.target)))
		facts.last.stageTrace[trace.add(dataflow, dataflow.uniqueQuotedString.value)]
		for (data : dataflow.data) {
			facts += createFact(createCompoundTerm("dataflowData", dataflow.uniqueQuotedString, data.uniqueQuotedString, data.name.toQuotedString, data.type.uniqueQuotedString))
			facts.last.stageTrace[trace.add(data, data.uniqueQuotedString.value)]
		}
		facts
	}
	
	protected def dispatch transformEdge(Edge dataflow) {
		throw new IllegalArgumentException("Plain edges are not supported as of now.")
	}
	
	protected def transformNode(CharacterizedNode node, String factName, OutputBehaviorCreator outputBehaviorCreator) {
		val clauses = new ArrayList<Clause>
		
		// type-specific fact
		clauses += createComment('''«factName.toFirstUpper» «(node as Entity).name»''')
		clauses += createFact(createCompoundTerm(factName, node.uniqueQuotedString))
		clauses.last.stageTrace[trace.add(node as Entity, node.uniqueQuotedString.value)]
		
		// node characteristics
		node.characteristics.filter(EnumCharacteristic).forEach[characteristic |
			characteristic.values.forEach[literal |
				clauses += createFact(createCompoundTerm("nodeCharacteristic", node.uniqueQuotedString, characteristic.type.uniqueQuotedString, literal.uniqueQuotedString))
			]
		]
		
		// behavior
		node.behavior.inputs.forEach[pin |
			clauses += createFact(createCompoundTerm("inputPin", node.uniqueQuotedString, pin.getUniqueQuotedString(node)))
			clauses.last.stageTrace[trace.add(node, pin, pin.getUniqueQuotedString(node).value)]
		]
		node.behavior.outputs.forEach[pin |
			clauses += createFact(createCompoundTerm("outputPin", node.uniqueQuotedString, pin.getUniqueQuotedString(node)))
			clauses.last.stageTrace[trace.add(node, pin, pin.getUniqueQuotedString(node).value)]
			characteristicTypesInBehaviors.forEach[ct |
				ct.type.literals.forEach[l |
					clauses += outputBehaviorCreator.createOutputCharacteristicRule(node, pin, ct, l)
				]
			]
		]
		
		clauses
	}
	
	/**
	 * Creates all clauses required to build a valid flow tree.
	 * 
	 * This includes the selection of a flow for every input pin as well as building the appropriate flow tree variables.
	 * The flow tree variable Sn represents the flow tree to be used for the input pin n.
	 */
	protected def createFlowTreeClauses(CharacterizedNode node, Iterable<Pin> inputPins) {
		val clauses = new ArrayList<Expression>
		val hasMultipleInputs = inputPins.size > 1
		val treeList = createList
		for (var i = 0; i < inputPins.size; i++) {
			val inputPin = inputPins.get(i)
			clauses += createCompoundTerm("inputFlow", node.uniqueQuotedString, inputPin.getUniqueQuotedString(node), (hasMultipleInputs ? "FLOWS" : "_").toVar, '''F«i»'''.toVar, "VISITED".toVar)
			clauses += createUnification('''S«i»'''.toVar, createList(#['''F«i»'''], #["_"]))
			treeList.heads += '''S«i»'''.toVar
		}
		clauses += createUnification("S".toVar, treeList)
		clauses
	}
	
	/**
	 * Transforms the right hand side of an assignment to an expression. 
	 */
	protected def Expression transformAssignment(Optional<Assignment> assignment, CharacterizedNode node, Pin pin, EnumCharacteristicType ct, Literal l) {
		assignment.map[rhs.transformAssignmentTerm(node, pin, ct, l)].orElse(createFalse)
	}
	
	protected def dispatch Expression transformAssignmentTerm(True rhs, CharacterizedNode node, Pin pin, EnumCharacteristicType ct, Literal l) {
		createTrue
	}
	
	protected def dispatch Expression transformAssignmentTerm(False rhs, CharacterizedNode node, Pin pin, EnumCharacteristicType ct, Literal l) {
		createFalse
	}
	
	protected def dispatch Expression transformAssignmentTerm(Or rhs, CharacterizedNode node, Pin pin, EnumCharacteristicType ct, Literal l) {
		createLogicalOr => [
			left = rhs.left.transformAssignmentTerm(node, pin, ct, l)
			right = rhs.right.transformAssignmentTerm(node, pin, ct, l)
		]
	}
	
	protected def dispatch Expression transformAssignmentTerm(And rhs, CharacterizedNode node, Pin pin, EnumCharacteristicType ct, Literal l) {
		createLogicalAnd => [
			left = rhs.left.transformAssignmentTerm(node, pin, ct, l)
			right = rhs.right.transformAssignmentTerm(node, pin, ct, l)
		]
	}
	
	protected def dispatch Expression transformAssignmentTerm(Not rhs, CharacterizedNode node, Pin pin, EnumCharacteristicType ct, Literal l) {
		createNotProvable => [
			expr = rhs.term.transformAssignmentTerm(node, pin, ct, l)
		]
	}
	
	protected def dispatch Expression transformAssignmentTerm(DataCharacteristicReference rhs, CharacterizedNode node, Pin pin, EnumCharacteristicType ct, Literal l) {
		var referencedCharacteristicType = rhs.characteristicType ?: ct
		var referencedLiteral = rhs.literal ?: l
		var treeVariable = '''S«node.behavior.inputs.indexOf(rhs.pin)»''' 
		createCompoundTerm(
			"characteristic",
			node.uniqueQuotedString,
			rhs.pin.getUniqueQuotedString(node),
			referencedCharacteristicType.uniqueQuotedString,
			referencedLiteral.uniqueQuotedString,
			treeVariable.toVar,
			"VISITED".toVar
		)
	}
	
	protected def dispatch Expression transformAssignmentTerm(ContainerCharacteristicReference rhs, CharacterizedNode node, Pin pin, EnumCharacteristicType ct, Literal l) {
		var referencedCharacteristicType = rhs.characteristicType ?: ct
		var referencedLiteral = rhs.literal ?: l
		createCompoundTerm(
			"nodeCharacteristic",
			node.uniqueQuotedString,
			referencedCharacteristicType.uniqueQuotedString,
			referencedLiteral.uniqueQuotedString
		)
	}



	protected def addPreamble(DataFlowDiagram dfd) {
		add(createHeaderComment("HELPER: input flow selection"))
		add(createComment('''
			Select the input flow (FLOW) for the pin (PIN) of node (P) from a set of available flows (AVAILABLE_FLOWS) but do not pick a flow listed in already visited flows (VISITED).
			Assumption: the set contains exactly one flow for the pin'''))
		add(createRule(
			createCompoundTerm("inputFlow", "P", "PIN", "AVAILABLE_FLOWS", "FLOW", "VISITED"),
			createConjunction(
				createCompoundTerm("inputPin", "P", "PIN"),
				createCompoundTerm("inputFlowsSelection", "P", "AVAILABLE_FLOWS"),
				createCompoundTerm("inputFlowSelection", "PIN", "AVAILABLE_FLOWS", "FLOW"),
				createCompoundTerm("intersection", "VISITED".toVar, createList(#["FLOW"], #[]), createList)
			)
		))
		
		add(createComment('''
			Find one arbitrary set of flows (SELECTED_FLOWS) for a given node (P) in a way that for every input pin, there is exactly one input flow.
			Using this rule in conjunction with findall would yield all possible combinations of input flows that meet the described condition.
			This rule is non-deterministic because inputPinsFlowSelection/3 is non-deterministic.'''))
		add(createRule(
			createCompoundTerm("inputFlowsSelection", "P", "SELECTED_FLOWS"),
			createConjunction(
				createCompoundTerm("findall", "X".toVar, createCompoundTerm("inputPin", "P", "X"), "INPUT_PINS".toVar),
				createCompoundTerm("inputPinsFlowSelection", "INPUT_PINS", "SELECTED_FLOWS")
			)
		))
		
		add(createComment('''
			Find one arbitrary set of flows for a given set of input pins in a way that for every input pin, there is exactly one input flow.
			This rule is non-deterministic because it succeeds many times if there are multiple possible combinations that meet the described condition.'''))
		add(createFact(createCompoundTerm("inputPinsFlowSelection", createList, createList)))
		add(createRule(
			createCompoundTerm("inputPinsFlowSelection", createList(#["PIN"], #["T"]), createList(#["FLOW_TO_PIN"], #["RECURSE_FLOWS"])),
			createConjunction(
				createCompoundTerm("dataflow", "FLOW_TO_PIN", "_", "_", "_", "PIN"),
				createCompoundTerm("inputPinsFlowSelection", "T", "RECURSE_FLOWS")//,
			)
		))
		
		add(createComment("Select the input flow (FLOW) for the pin (PIN) from a set of available flows. Here: list head matches."))
		add(createRule(
			createCompoundTerm("inputFlowSelection", "PIN".toVar, createList(#["FLOW"], #["_"]), "FLOW".toVar),
			createConjunction(
				createCompoundTerm("dataflow", "FLOW", "_", "_", "_", "PIN"),
				createCut				
			)
		))
		
		add(createComment("Select the input flow (FLOW) for the pin (PIN) from a set of available flows. Here: use an entry of list tail."))
		add(createRule(
			createCompoundTerm("inputFlowSelection", "PIN".toVar, createList(#["H"], #["T"]), "FLOW".toVar),
			createConjunction(
				createCompoundTerm("dataflow", "H", "_", "_", "_", "PIN2"),
				createNotUnifiable("PIN", "PIN2"),
				createCompoundTerm("inputFlowSelection", "PIN", "T", "FLOW")
			)
		))

		add(createHeaderComment("HELPER: Shortcuts for common use cases"))
		add(createComment("Shortcut for characteristic queries"))
		add(createRule(
			createCompoundTerm("characteristic", "N", "PIN", "CT", "V", "S"),
			createCompoundTerm("characteristic", "N".toVar, "PIN".toVar, "CT".toVar, "V".toVar, "S".toVar, createList)
		))
		
		if (!dfd.nodes.filter(CharacterizedActorProcess).empty) {
			add(createComment("Always inherit node characteristics from parent"))
			add(createRule(
				createCompoundTerm("nodeCharacteristic", "N", "CT", "V"),
				createConjunction(
					createCompoundTerm("actorProcess", "N", "A"),
					createCompoundTerm("nodeCharacteristic", "A", "CT", "V")
				)
			))			
		}

		add(createHeaderComment("HELPER: collect all available data characteristics"))
		add(createRule(
			createCompoundTerm("setof_characteristics", "N", "PIN", "CT", "RESULT", "S"),
			createConjunction(
				createCompoundTerm("flowTree", "N".toVar, "PIN".toVar, "S".toVar),
				createCompoundTerm("setof", "V".toVar, createCompoundTerm("characteristic", "N", "PIN", "CT", "V", "S"), "RESULT".toVar)
			)
		))

		add(createHeaderComment("HELPER: create valid flow tree"))
		add(createRule(
			createCompoundTerm("flowTree", "N", "PIN", "S"),
			createCompoundTerm("flowTree", "N".toVar, "PIN".toVar, createList(#["S"]), createList)
		))
		add(createRule(
			createCompoundTerm("flowTree", "N".toVar, "PIN".toVar, createList, "_".toVar),
			createConjunction(
				createCompoundTerm("actor", "N"),
				createCompoundTerm("outputPin", "N", "PIN"),
				createCut
			)
		))
		
		add(createRule(
			createCompoundTerm("flowTree", "N", "PIN", "S", "VISITED"),
			createConjunction(
				createCompoundTerm("inputPin", "N", "PIN"),
				createCompoundTerm("dataflow", "F", "NSRC", "PINSRC", "N", "PIN"),
				createCompoundTerm("flowTree", "NSRC".toVar, "PINSRC".toVar, "TMP".toVar, createList(#["F"], #["VISITED"])),
				createUnification("S".toVar, createListExpressions(#[createList(#["F"], #["TMP"])]))
			)
		))
		
		val processOrStoreDisjunction =
			createDisjunction(
				createCompoundTerm("process", "N"),
				createCompoundTerm("store", "N")
			);
		val processFact = createCompoundTerm("process", "N")
		val processOrStore = dfd.nodes.exists[n | n instanceof CharacterizedStore] ? processOrStoreDisjunction : processFact
		
		add(createRule(
			createCompoundTerm("flowTree", "N", "PIN", "S", "VISITED"),
			createConjunction(
				createCompoundTerm("outputPin", "N", "PIN"),
				processOrStore,
				createCompoundTerm("inputFlowsSelection", "N", "FLOWS"),
				createCompoundTerm("flowTreeForFlows", "N", "S", "FLOWS", "VISITED")
			)
		))
		add(createFact(createCompoundTerm("flowTreeForFlows", "_".toVar, createList, createList, "_".toVar)))
		add(createRule(
			createCompoundTerm("flowTreeForFlows", "N".toVar, "S".toVar, createList(#["F"], #["T"]), "VISITED".toVar),
			createConjunction(
				createCompoundTerm("intersection", createList(#["F"]), "VISITED".toVar, createList),
				createCompoundTerm("flowTreeForFlows", "N", "STAIL", "T", "VISITED"),
				createCompoundTerm("dataflow", "F", "NSRC", "PINSRC", "_", "_"),
				createCompoundTerm("flowTree", "NSRC".toVar, "PINSRC".toVar, "TMP".toVar, createList(#["F"], #["VISITED"])),
				createUnification("SHEAD".toVar, createList(#["F"], #["TMP"])),
				createUnification("S".toVar, createList(#["SHEAD"], #["STAIL"]))
			)
		))
		
		add(createHeaderComment("HELPER: find traversed nodes from flow tree"))
		add(createRule(
			createCompoundTerm("traversedNode", "S", "N"),
			createConjunction(
				createCompoundTerm("flatten", "S", "SFLAT"),
				createCompoundTerm("list_to_set", "SFLAT", "FLOWS"),
				createCompoundTerm("setof", "X".toVar, createCompoundTerm("involvesNode", "FLOWS", "X"), "NODES".toVar),
				createCompoundTerm("member", "N", "NODES")
				
			)
		))
		add(createRule(
			createCompoundTerm("involvesNode", createList(#["F"], #["_"]), "N".toVar),
			createConjunction(
				createCompoundTerm("dataflow", "F", "N", "_", "_", "_"),
				createNotProvable(createCompoundTerm("dataflow", "F", "_", "_", "N", "_"))
			)
		))
		add(createRule(
			createCompoundTerm("involvesNode", createList(#["F"], #["_"]), "N".toVar),
			createConjunction(
				createCompoundTerm("dataflow", "F", "_", "_", "N", "_"),
				createNotProvable(createCompoundTerm("dataflow", "F", "N", "_", "_", "_"))
			)
		))
		add(createRule(
			createCompoundTerm("involvesNode", createList(#["_"], #["T"]), "N".toVar),
			createCompoundTerm("involvesNode", "T", "N")
		))
		
		add(createHeaderComment("HELPER: find input characteristics"))
		add(createRule(
			createCompoundTerm("characteristic", "N".toVar, "PIN".toVar, "CT".toVar, "V".toVar, createList(#["F"], #["S"]), "VISITED".toVar),
			createConjunction(
				createCompoundTerm("inputPin", "N", "PIN"),
				createCompoundTerm("dataflow", "F", "NSRC", "PINSRC", "N", "PIN"),
				createCompoundTerm("intersection", createList(#["F"]), "VISITED".toVar, createList),
				createCompoundTerm("characteristic", "NSRC".toVar, "PINSRC".toVar, "CT".toVar, "V".toVar, "S".toVar, createList(#["F"], #["VISITED"]))
			)
		))
	}

	// queries
	protected def static Iterable<EnumCharacteristicType> findAllCharacteristicTypesInNodes(DataFlowDiagram dfd) {
		val characterizedNodes = dfd.eAllContents.filter(CharacterizedNode)
		characterizedNodes.flatMap[characteristics.iterator].filter(EnumCharacteristic).map[enumCharacteristicType].distinct
	}
	
	protected def static Iterable<EnumCharacteristicType> findAllCharacteristicTypesInBehaviors(DataFlowDiagram dfd) {
		val characterizedNodes = dfd.eAllContents.filter(CharacterizedNode)
		val assignments = characterizedNodes.map[behavior].flatMap[assignments.iterator].toSet
		assignments.map[lhs].map[characteristicType].filter(EnumCharacteristicType).distinct
	}
	
	protected def static Iterable<DataType> findAllUsedDataTypes(DataFlowDiagram dfd) {
		val foundData = new HashSet(dfd.edges.filter(DataFlowEdge).flatMap[data].map[type].toSet)
		val queue = new LinkedList(foundData)
		while (!queue.isEmpty) {
			val dataType = queue.pop
			queue += dataType.usedDataTypes.filter[d|foundData.add(d)]
		}
		foundData.distinctDataTypes
	}
	
	protected def static dispatch getUsedDataTypes(CollectionDataType dataType) {
		#[dataType.type]
	}
	
	protected def static dispatch getUsedDataTypes(CompositeDataType dataType) {
		dataType.components.map[dataType]
	}
	
	protected def static dispatch getUsedDataTypes(DataType dataType) {
		#[]
	}
	
	protected def static Iterable<EnumCharacteristicType> distinct(Iterable<EnumCharacteristicType> sequence) {
		sequence.iterator.distinct
	}
	
	protected def static Iterable<EnumCharacteristicType> distinct(Iterator<EnumCharacteristicType> sequence) {
		sequence.toMap[id].values.toList.sortBy[name]
	}
	
	protected def static Iterable<DataType> distinctDataTypes(Iterable<DataType> sequence) {
		sequence.toMap[id].values.toList.sortBy[name]
	}
	
	protected static def needsFlowTree(Optional<Assignment> assignment) {
		assignment.map[needsFlowTree].orElse(false)
	}
	
	protected static def needsFlowTree(Assignment assignment) {
		assignment.rhs instanceof DataCharacteristicReference || !assignment.rhs.eAllContents.filter(DataCharacteristicReference).empty
	}
	
	
    protected static def Optional<Assignment> findLastMatchingAssignment(List<Assignment> assignments, Pin pin,
            EnumCharacteristicType ct, Literal l) {
        for (assignment : assignments.reverseView) {
			if (isMatchingAssignment(assignment, pin, ct, l)) {
				return Optional.of(assignment);
			}
        }
        // there is no matching assignment
        return Optional.empty();
    }
    
    protected static def isMatchingAssignment(Assignment assignment, Pin pin,
            EnumCharacteristicType ct, Literal l) {
           var lhs = assignment.getLhs()

            // pin does not match
            if (lhs.getPin() !== pin) {
                return false
            }

            // characteristic type is not null and does not match
            if (lhs.getCharacteristicType() !== null && lhs.getCharacteristicType() !== ct) {
                return false
            }

            // literal is not null and does not match
            if (lhs.getLiteral() !== null && lhs.getLiteral() !== l) {
                return false
            }

            // lhs is compatible up to here, so test rhs
            if (!isRhsTermCompatible(assignment.rhs, ct, l)) {
                return false
            }
            
            return true;
    }
	
	protected static def dispatch boolean isRhsTermCompatible(Constant term, EnumCharacteristicType ct, Literal l) {
		true
	}
	
	protected static def dispatch boolean isRhsTermCompatible(LogicTerm term, EnumCharacteristicType ct, Literal l) {
		term.terms.forall[isRhsTermCompatible(ct, l)]
	}
	
	protected static def dispatch boolean isRhsTermCompatible(EnumCharacteristicReference term, EnumCharacteristicType ct, Literal l) {
        var termCharacteristicType = term.getCharacteristicType() as EnumCharacteristicType;
        var termLiteral = term.getLiteral();

        // case 0: no wildcards -> compatible
        if (termCharacteristicType !== null && termLiteral !== null) {
            return true;
        }

        // case 1: only literal wildcard -> characteristic type has to be compatbile
        if (termCharacteristicType !== null && termLiteral === null
                && termCharacteristicType.getType() == ct.getType()) {
            return true;
        }

        // case 2: characteristic type wildcard and literal wildcard -> compatbile
        if (termCharacteristicType === null && termLiteral === null) {
            return true;
        }

        // incompatible in any other case
        return false;
	}
	
	protected static def dispatch boolean isRhsTermCompatible(Term term, EnumCharacteristicType ct, Literal l) {
		false
	}
	
	// add utils

	protected def stageTrace(EObject prologElement, Runnable traceAdder) {
		stagedTraces.put(prologElement, traceAdder)
	}

	protected def createAndAddDiscontiguousDirective(CompoundTerm term) {
		createAndAddDiscontiguousDirective(term.value, term.arguments.size)
	}

	protected def create directive : createDiscontiguousDirective(predicateName, arity) createAndAddDiscontiguousDirective(String predicateName, int arity) {
		val clausesList = new ArrayList<Discontiguous>(program.clauses.filter(Discontiguous).toList)
		clausesList.add(directive);
		clausesList.sort([d1, d2|d1.predicates.get(0).name.compareTo(d2.predicates.get(0).name)])
		val predecessorIndex = clausesList.indexOf(directive) - 1
		var destinationIndex = 0
		if (predecessorIndex >= 0) {
			val predecessor = clausesList.get(predecessorIndex)
			destinationIndex = program.clauses.indexOf(predecessor) + 1
		}
		program.clauses.add(destinationIndex, directive)
	}
	
	protected def dispatch void add(Iterable<? extends Clause> clauses) {
		clauses.forEach[add]
	}
	
	protected def dispatch void add(Fact clause) {
		createAndAddDiscontiguousDirective(clause.head)
		(clause as Clause)._add
	}
	
	protected def dispatch void add(Rule clause) {
		createAndAddDiscontiguousDirective(clause.head)
		(clause as Clause)._add
	}
	
	protected def dispatch void add(Clause clause) {
		program.clauses += clause
		clause.submitTrace
	}

	protected def submitTrace(EObject prologElement) {
		val traceAdder = stagedTraces.remove(prologElement)
		if (traceAdder !== null) {
			traceAdder.run
		}
	}
	
}
