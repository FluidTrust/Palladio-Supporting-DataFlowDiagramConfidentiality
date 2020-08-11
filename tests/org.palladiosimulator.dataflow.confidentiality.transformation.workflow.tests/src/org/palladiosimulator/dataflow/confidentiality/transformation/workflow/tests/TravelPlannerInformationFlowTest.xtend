package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving
import org.prolog4j.Solution

import static org.junit.Assert.assertFalse

class TravelPlannerInformationFlowTest extends AnalysisIntegrationTestBase {
	
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
			CT_LEVEL = ?CTSECLEVEL,
			CT_CLEARANCE = ?CTCLEARANCE,
			nodeCharacteristic(P, CT_CLEARANCE, V_CLEAR),
			characteristicTypeValue(CT_CLEARANCE, V_CLEAR, N_CLEAR),
			inputPin(P, PIN),
			characteristic(P, PIN, CT_LEVEL, V_LEVEL, S),
			characteristicTypeValue(CT_LEVEL, V_LEVEL, N_LEVEL),
			N_LEVEL > N_CLEAR.
		'''
		var query = prover.query(queryString)
		query.bind("J$CTSECLEVEL", "SecurityLevel (_k9jB49vTEeqNdo_V4bA-xw)")
		query.bind("J$CTCLEARANCE", "Clearance (_JvuuQ9vqEeqNdo_V4bA-xw)")
		var solution = query.solve()
		solution
	}
	
}