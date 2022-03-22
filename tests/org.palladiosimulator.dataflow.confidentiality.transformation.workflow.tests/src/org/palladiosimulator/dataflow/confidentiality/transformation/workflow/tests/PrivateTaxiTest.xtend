package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Behaving
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory
import org.prolog4j.Solution

import static org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedExternalActor

class PrivateTaxiTest extends AnalysisIntegrationTestBase {

	boolean initialized

	@BeforeEach
	def void resetInitializationFlag() {
		initialized = false
	}

	@Test
	def void testNoFlaws() {
		builder.addDFD(getRelativeURI("models/evaluation/privatetaxi/privatetaxi_dfd.xmi"))
		var keySolution = findKeyFlaws()
		assertNumberOfSolutions(keySolution, 0, #["N", "PIN0", "PIN1", "S", "REQ", "PROV"])
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, #["N", "PIN", "R", "D", "S"])
	}

	@Test
	def void testNoEncryptionForRoute() {		
		var dfd = loadAndInitDFD("models/evaluation/privatetaxi/privatetatxi_dd.xmi",
			"models/evaluation/privatetaxi/privatetaxi_dfd.xmi")

		// add possible data flow of unencrypted route
		var directCCDFlow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		directCCDFlow.name = "route direct"
		directCCDFlow.source = dfd.nodes.filter(CharacterizedProcess).findFirst["Driver.createRoute" == name]
		directCCDFlow.sourcePin = (directCCDFlow.source as Behaving).behavior.outputs.iterator.next
		directCCDFlow.target = dfd.nodes.filter(CharacterizedProcess).findFirst["Taxi.storeRoute" == name]
		directCCDFlow.targetPin = (directCCDFlow.target as Behaving).behavior.inputs.get(0)
		dfd.edges += directCCDFlow

		var keySolution = findKeyFlaws()
		assertNumberOfSolutions(keySolution, 0, #["N", "PIN0", "PIN1", "S", "REQ", "PROV"])
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 3, #["N", "PIN", "R", "D", "S"])
	}

	@Test
	def void testCombinationOfUserAndRoute() {
		val dfd = loadAndInitDFD("models/evaluation/privatetaxi/privatetatxi_dd.xmi",
			"models/evaluation/privatetaxi/privatetaxi_dfd.xmi")
		EcoreUtil.resolveAll(dfd.eResource.resourceSet)
		val joinBehavior = dfd.nodes.filter(CharacterizedProcess).findFirst["Taxi.findUser" == name].behavior

		// add possible data flow of unencrypted route
		var joinRouteAndUser = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedProcess
		joinRouteAndUser.name = "Taxi.mergeUserAndRoutes"
		joinRouteAndUser.referencedBehavior = joinBehavior
		dfd.nodes += joinRouteAndUser
		
		// add user flow to join node
		var userToJoinFlow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		userToJoinFlow.name = "user"
		userToJoinFlow.source = dfd.nodes.filter(CharacterizedProcess).findFirst["Taxi.findUser" == name]
		userToJoinFlow.sourcePin = (userToJoinFlow.source as Behaving).behavior.outputs.iterator.next
		userToJoinFlow.target = joinRouteAndUser
		userToJoinFlow.targetPin = joinRouteAndUser.behavior.inputs.get(0)
		dfd.edges += userToJoinFlow
		
		// add route flow to join node
		var routeToJoinFlow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		routeToJoinFlow.name = "route"
		routeToJoinFlow.source = dfd.nodes.filter(CharacterizedStore).findFirst["Taxi.RouteStorage" == name]
		routeToJoinFlow.sourcePin = (routeToJoinFlow.source as Behaving).behavior.outputs.iterator.next
		routeToJoinFlow.target = joinRouteAndUser
		routeToJoinFlow.targetPin = joinRouteAndUser.behavior.inputs.get(1)
		dfd.edges += routeToJoinFlow
		
		// add flow from join node to decryption node
		var joinedFlow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		joinedFlow.name = "routes and user"
		joinedFlow.source = joinRouteAndUser
		joinedFlow.sourcePin = joinRouteAndUser.behavior.outputs.iterator.next
		joinedFlow.target = dfd.nodes.filter(CharacterizedProcess).findFirst["Distance.decryptRoutes" == name]
		joinedFlow.targetPin = (joinedFlow.target as Behaving).behavior.inputs.findFirst["input" == name]
		dfd.edges += joinedFlow

		var keySolution = findKeyFlaws()
		assertNumberOfSolutions(keySolution, 0, #["N", "PIN0", "PIN1", "S", "REQ", "PROV"])
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 6, #["N", "PIN", "R", "D", "S"])
	}

	@Test
	def void testInvalidPrivateKey() {
		val dfd = loadAndInitDFD("models/evaluation/privatetaxi/privatetatxi_dd.xmi",
			"models/evaluation/privatetaxi/privatetaxi_dfd.xmi")
		EcoreUtil.resolveAll(dfd.eResource.resourceSet)
		
		val actor = dfd.nodes.filter(CharacterizedExternalActor).findFirst[name == "Administrator"]
		val lhs = actor.behavior.assignments.get(0).lhs
		lhs.literal = lhs.literal.getEnum().literals.findFirst[name == "Driver"]
		
		var keySolution = findKeyFlaws()
		assertNumberOfSolutions(keySolution, 1, #["N", "PIN0", "PIN1", "REQ", "PROV", "S0", "S1"])
	}

	protected def Solution<Object> findFlaws() {
		'''
		(
			R = 'CalcDistanceService (_-1E2gOHnEeqO9NqdRSqKUA)',
			D = 'ContactData (_pX3RkOHoEeqO9NqdRSqKUA)'
		; 
			R = 'PrivateTaxi (_DkbhkOHoEeqO9NqdRSqKUA)',
			D = 'Route (_ogEG4OHoEeqO9NqdRSqKUA)'
		),
		inputPin(N,PIN),
		nodeCharacteristic(N, 'IsEntity (_9fV10-HrEeqO9NqdRSqKUA)', R),
		characteristic(N, PIN, 'CriticalDataType (_jQ2QA-HoEeqO9NqdRSqKUA)', D, S).
		'''.findFlaws
	}

	protected def Solution<Object> findKeyFlaws() {
		'''
			behavior(N, 'Decryptor (_QIqzVeHqEeqO9NqdRSqKUA)'),
			inputPin(N, PIN0),
			inputPin(N, PIN1),
			PIN0 \== PIN1,
			findall(X, characteristic(N, PIN0, 'PrivateKeyOf (_JZLuc-HoEeqO9NqdRSqKUA)', X, S0), L_PROV),
			findall(X, characteristic(N, PIN1, 'DecryptableBy (_L2LVU-HoEeqO9NqdRSqKUA)', X, S1), L_REQ),
			sort(L_PROV, PROV), sort(L_REQ, REQ),
			REQ \== [],
			intersection(PROV, REQ, []).
		'''.findFlaws
	}
	
	protected def Solution<Object> findFlaws(CharSequence queryString) {
		if (!initialized) {
			initialized = true
			builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
			builder.nameDerivationMethod = NameGenerationStrategie.DETAILED
			var workflow = builder.build()
	
			workflow.run()
			var result = workflow.getSerializedPrologProgram()
			assertFalse(result.isEmpty())
	
			prover.loadTheory(result.get())
		}
		var query = prover.query(queryString.toString)
		var solution = query.solve()
		solution
	}


}
