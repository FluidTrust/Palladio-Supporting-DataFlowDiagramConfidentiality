package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving
import org.prolog4j.Solution

import static org.junit.jupiter.api.Assertions.*

class PrivateTaxiTest extends AnalysisIntegrationTestBase {

	@Test
	def void testNoFlaws() {
		builder.addDFD(getRelativeURI("models/evaluation/privatetaxi/privatetaxi_dfd.xmi"))
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

		var solution = findFlaws()
		assertNumberOfSolutionsWithoutDuplicates(solution, 6, #["N", "PIN", "R", "D", "S"])
	}

	protected def Solution<Object> findFlaws() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.nameDerivationMethod = NameDerivationMethod.NAME_AND_ID
		builder.defaultCharacteristicsUsage = false
		var workflow = builder.build()

		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())

		prover.loadTheory(result.get())
		var queryString = '''
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
		'''
		var query = prover.query(queryString)
		var solution = query.solve()
		solution
	}

}
