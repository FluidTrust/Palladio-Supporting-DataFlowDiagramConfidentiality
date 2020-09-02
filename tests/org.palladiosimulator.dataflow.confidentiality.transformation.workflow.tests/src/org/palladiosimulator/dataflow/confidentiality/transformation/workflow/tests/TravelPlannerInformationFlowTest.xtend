package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.InformationFlowAnalysesIflow
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving

class TravelPlannerInformationFlowTest extends InformationFlowAnalysesIflow {

	new() {
		super("SecurityLevel", "_k9jB49vTEeqNdo_V4bA-xw", "Clearance", "_JvuuQ9vqEeqNdo_V4bA-xw")
	}
	
	@Test
	def void testNoFlaws() {
		builder.addDFD(getRelativeURI("models/evaluation/travelplanner/DFDC_TravelPlanner_InformationFlow.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "PIN", "V_LEVEL", "V_CLEAR", "S"))
	}
	
	@Test
	def void testNoDeclassification() {		
		var dfd = loadAndInitDFD("models/evaluation/travelplanner/DDC_TravelPlanner_InformationFlow.xmi",
			"models/evaluation/travelplanner/DFDC_TravelPlanner_InformationFlow.xmi")
		
		// add possible data flow from CCD store to booking process
		var directCCDFlow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		directCCDFlow.name = "ccd direct"
		directCCDFlow.source = dfd.nodes.filter(CharacterizedProcess).findFirst["CCD.readCCD" == name]
		directCCDFlow.sourcePin = (directCCDFlow.source as Behaving).behavior.outputs.iterator.next
		directCCDFlow.target = dfd.nodes.filter(CharacterizedProcess).findFirst["User.bookFlight" == name]
		directCCDFlow.targetPin = (directCCDFlow.target as Behaving).behavior.inputs.get(1)
		dfd.edges += directCCDFlow

		var solution = findFlaws()
		assertNumberOfSolutions(solution, 2, Arrays.asList("P", "PIN", "V_LEVEL", "V_CLEAR", "S"))
	}
	
}