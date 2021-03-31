package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AccessControlAnalysesIflow
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Behaving
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory

class TravelPlannerAccessControlTest extends AccessControlAnalysesIflow 
{
	new() {
		super("Roles", "_JvuuQ9vqEeqNdo_V4bA-xw", "AccessPermissions", "_k9jB49vTEeqNdo_V4bA-xw")
	}
	
	@Test
	def void testNoFlaws() {
		builder.addDFD(getRelativeURI("models/evaluation/travelplanner/DFDC_TravelPlanner_AccessControl.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "REQ", "ROLES"))
	}
	
	@Test
	def void testNoDeclassification() {		
		var dfd = loadAndInitDFD("models/evaluation/travelplanner/DDC_TravelPlanner_AccessControl.xmi",
			"models/evaluation/travelplanner/DFDC_TravelPlanner_AccessControl.xmi")
		
		// add possible data flow from CCD store to booking process
		var directCCDFlow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		directCCDFlow.name = "ccd direct"
		directCCDFlow.source = dfd.nodes.filter(CharacterizedProcess).findFirst["CCD.readCCD" == name]
		directCCDFlow.sourcePin = (directCCDFlow.source as Behaving).behavior.outputs.iterator.next
		directCCDFlow.target = dfd.nodes.filter(CharacterizedProcess).findFirst["User.bookFlight" == name]
		directCCDFlow.targetPin = (directCCDFlow.target as Behaving).behavior.inputs.get(1)
		dfd.edges += directCCDFlow

		var solution = findFlaws()
		assertNumberOfSolutions(solution, 3, Arrays.asList("P", "REQ", "ROLES"))
	}

}
