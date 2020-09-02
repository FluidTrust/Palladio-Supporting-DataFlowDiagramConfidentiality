package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AccessControlAnalysesIflow
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory

class DistanceTrackerAccessControlTest extends AccessControlAnalysesIflow {

	new() {
		super("_g8Baw0NEEeq3NrD2DjPidQ", "_fCiJk0NEEeq3NrD2DjPidQ")
	}

	@Test
	def void testNoFlaws() {
		builder.addDFD(getRelativeURI("models/evaluation/distancetracker/DFDC_DistanceTracker_AccessControl.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "REQ", "ROLES", "S"))
	}
	
	@Test
	def void testUnconfirmedDistance() {
		var dfd = loadAndInitDFD("models/evaluation/distancetracker/DDC_DistanceTracker_AccessControl.xmi",
			"models/evaluation/distancetracker/DFDC_DistanceTracker_AccessControl.xmi")
		
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
		assertNumberOfSolutions(solution, 2, Arrays.asList("P", "REQ", "ROLES", "S"))
	}
}
