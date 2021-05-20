package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AccessControlAnalysesIflow
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory

class DistanceTrackerAccessControlTest extends AccessControlAnalysesIflow {
	
	static val DFD_PATH = "models/evaluation/distancetracker/DFDC_DistanceTracker_AccessControl.xmi"
	static val DDC_PATH = "models/evaluation/distancetracker/DDC_DistanceTracker_AccessControl.xmi"

	new() {
		super("_g8Baw0NEEeq3NrD2DjPidQ", "_fCiJk0NEEeq3NrD2DjPidQ")
	}

	@Test
	def void testNoFlaws() {
		loadAndInitDFD(DDC_PATH, DFD_PATH)
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "REQ", "ROLES", "S"))
	}
	
	@Test
	def void testUnconfirmedDistance() {
		var dfd = loadAndInitDFD(DDC_PATH, DFD_PATH)
		
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
