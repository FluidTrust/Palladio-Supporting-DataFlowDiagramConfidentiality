package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory
import org.prolog4j.Solution

import static org.junit.jupiter.api.Assertions.*

class DistanceTrackerAnalysisTest extends AnalysisIntegrationTestBase {
	
	@Test
	def void testNoFlaws() {
		builder.addDFD(getRelativeURI("models/evaluation/distancetracker/DFDC_DistanceTracker.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "REQ", "ROLES", "MATCH", "S"))
	}
	
	@Test
	def void testUnconfirmedDistance() {
		var dfd = loadAndInitDFD("models/evaluation/distancetracker/DDC_DistanceTracker.xmi",
			"models/evaluation/distancetracker/DFDC_DistanceTracker.xmi")
		
		// add direct data flow of unconfirmed distance data
		var targetNode = dfd.nodes.filter(CharacterizedProcess).findFirst[name.toLowerCase.contains("recorddist")]
		var srcNode = dfd.nodes.filter(CharacterizedProcess).findFirst[name.toLowerCase.contains("calculatedist")]
		var directFlow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		directFlow.name = "direct distance"
		directFlow.source = srcNode
		directFlow.sourcePin = srcNode.behavior.outputs.iterator.next
		directFlow.target = targetNode
		directFlow.targetPin = targetNode.behavior.inputs.iterator.next
		dfd.edges += directFlow
			
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 2, Arrays.asList("P", "REQ", "ROLES", "MATCH", "S"))
	}
	
	protected def Solution<Object> findFlaws() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.setNameDerivationMethod(NameDerivationMethod.NAME_AND_ID)
		var workflow = builder.build()
		
		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())

		prover.loadTheory(result.get())
		var queryString = '''
			inputPin(P, PIN),
			bagof(R, nodeCharacteristic(P, ?CTROLES, R), ROLES),
			bagof(A, characteristic(P, PIN, ?CTRIGHTS, A, S), REQ),
			intersection(REQ, ROLES, MATCH),
			length(MATCH, 0).
		'''
		var query = prover.query(queryString)
		query.bind("J$CTROLES", "Roles (_g8Baw0NEEeq3NrD2DjPidQ)")
		query.bind("J$CTRIGHTS", "AccessRights (_fCiJk0NEEeq3NrD2DjPidQ)")
		var solution = query.solve()
		solution
	}
}
