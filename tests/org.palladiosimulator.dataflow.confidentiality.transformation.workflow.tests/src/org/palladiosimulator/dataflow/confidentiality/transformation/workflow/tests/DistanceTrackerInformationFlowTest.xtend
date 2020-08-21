package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory
import org.prolog4j.Solution

import static org.junit.Assert.assertFalse

class DistanceTrackerInformationFlowTest extends AnalysisIntegrationTestBase {
	
	@BeforeEach
	def void setupBuilder() {
		builder.setDefaultCharacteristicsUsage(false)
	}
	
	@Test
	def void testNoFlaws() {
		builder.addDFD(getRelativeURI("models/evaluation/distancetracker/DFDC_DistanceTracker_InformationFlow.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "PIN", "V_LEVEL", "V_CLEAR", "S"))
	}
	
	@Test
	def void testNoDeclassification() {		
		var dfd = loadAndInitDFD("models/evaluation/distancetracker/DDC_DistanceTracker_InformationFlow.xmi",
			"models/evaluation/distancetracker/DFDC_DistanceTracker_InformationFlow.xmi")
		
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
		query.bind("J$CTSECLEVEL", "Classification (_fCiJk0NEEeq3NrD2DjPidQ)")
		query.bind("J$CTCLEARANCE", "Clearance (_g8Baw0NEEeq3NrD2DjPidQ)")
		var solution = query.solve()
		solution
	}
	
}