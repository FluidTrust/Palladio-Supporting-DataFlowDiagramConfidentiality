package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import java.util.concurrent.Callable
import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase
import org.prolog4j.Solution

import static org.junit.jupiter.api.Assertions.*

class DataPropagationAnalysisTest extends AnalysisIntegrationTestBase {
		
	@Test
	def void testFlawByActorOutput() {
		assertOneFlaw("DFDC_Actor_Output")
	}
	
	@Test
	def void testNoFlawByActorOutput() {
		assertNoFlaw("DFDC_Actor_Output_noFlaw")
	}
	
	@Test
	def void testFlawByActorOneInput() {
		assertOneFlaw("DFDC_Actor_OneInput")
	}
	
	@Test
	def void testNoFlawByActorOneInput() {
		assertNoFlaw("DFDC_Actor_OneInput_noFlaw")
	}
	
	@Test
	def void testFlawByActorTwoInputs() {
		assertOneFlaw("DFDC_Actor_TwoInputs")
	}
	
	@Test
	def void testNoFlawByActorTwoInputs() {
		assertNoFlaw("DFDC_Actor_TwoInputs_noFlaw")
	}
	
	@Test
	def void testFlawByStoreOneInput() {
		assertOneFlaw("DFDC_Store_OneInput")
	}
	
	@Test
	def void testNoFlawByStoreOneInput() {
		assertNoFlaw("DFDC_Store_OneInput_noFlaw")
	}
	
	@Test
	def void testFlawByStoreTwoInputs() {
		assertOneFlaw("DFDC_Store_TwoInputs")
	}
	
	@Test
	def void testNoFlawByStoreTwoInputs() {
		assertNoFlaw("DFDC_Store_TwoInputs_noFlaw")
	}
	
	@Test
	def void testFlawByProcessOneInput() {
		assertOneFlaw("DFDC_Process_OneInput")
	}
	
	@Test
	def void testNoFlawByProcessOneInput() {
		assertNoFlaw("DFDC_Process_OneInput_noFlaw")
	}

	@Test
	def void testFlawByProcessTwoInputs() {
		assertOneFlaw("DFDC_Process_TwoInputs")
	}

	@Test
	def void testNoFlawByProcessTwoInputs() {
		assertNoFlaw("DFDC_Process_TwoInputs_noFlaw")
	}
	
	@Test
	def void testFlawByProcessDataReference() {
		assertOneFlaw("DFDC_Process_DataReference")
	}
	
	@Test
	def void testNoFlawByProcessDataReference() {
		assertNoFlaw("DFDC_Process_DataReference_noFlaw")
	}
	
	@Test
	def void testFlawByProcessContainerReference() {
		assertFlawCount("DFDC_Process_ContainerReference", 1)
	}
	
	@Test
	def void testNoFlawByProcessContainerReference() {
		assertNoFlaw("DFDC_Process_ContainerReference_noFlaw")
	}
	
	@Test
	def void testFlawByProcessConstantTrue() {
		assertFlawCount("DFDC_Process_ConstantTrue", 1)
	}
	
	@Test
	def void testNoFlawByProcessConstantTrue() {
		assertNoFlaw("DFDC_Process_ConstantTrue_noFlaw")
	}
	
	@Test
	def void testFlawByProcessConstantFalse() {
		builder.addDFD(getRelativeURI("models/evaluation/unittests/DFDC_Process_ConstantFalse.xmi"))
		var solution = findFlaws([findLowViolation])
		assertNumberOfSolutions(solution, 1, Arrays.asList("P", "PIN"))
	}
	
	@Test
	def void testNoFlawByProcessConstantFalse() {
		builder.addDFD(getRelativeURI("models/evaluation/unittests/DFDC_Process_ConstantFalse_noFlaw.xmi"))
		var solution = findFlaws([findLowViolation])
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "PIN"))
	}
	
	@Test
	def void testFlawByProcessAnd() {
		assertOneFlaw("DFDC_Process_And")
	}
	
	@Test
	def void testNoFlawByProcessAnd() {
		assertNoFlaw("DFDC_Process_And_noFlaw")
	}

	@Test
	def void testFlawByProcessOr() {
		assertOneFlaw("DFDC_Process_Or")
	}
	
	@Test
	def void testNoFlawByProcessOr() {
		assertNoFlaw("DFDC_Process_Or_noFlaw")
	}
	
	@Test
	def void testFlawByProcessCycleDataReference() {
		assertOneFlaw("DFDC_Process_Cycle_DataReference")
	}
	
	@Test
	def void testNoFlawByProcessCycleDataReference() {
		assertNoFlaw("DFDC_Process_Cycle_DataReference_noFlaw")
	}
	
	@Test
	def void testFlawByProcessCycleSingleAnd() {
		assertOneFlaw("DFDC_Process_Cycle_SingleAnd")
	}
	
	@Test
	def void testNoFlawByProcessCycleSingleAnd() {
		assertNoFlaw("DFDC_Process_Cycle_SingleAnd_noFlaw")
	}
	
	@Test
	def void testFlawByProcessCycleSingleOr() {
		assertFlawCount("DFDC_Process_Cycle_SingleOr", 2)
	}
	
	@Test
	def void testNoFlawByProcessCycleSingleOr() {
		assertNoFlaw("DFDC_Process_Cycle_SingleOr_noFlaw")
	}

	protected def assertNoFlaw(String modelName) {
		assertFlawCount(modelName, 0)
	}
	
	protected def assertOneFlaw(String modelName) {
		assertFlawCount(modelName, 1)
	}
	
	protected def assertFlawCount(String modelName, int flawCount) {
		builder.addDFD(getRelativeURI("models/evaluation/unittests/" + modelName + ".xmi"))
		var solution = findFlaws([findHighViolation])
		assertNumberOfSolutions(solution, flawCount, Arrays.asList("P", "PIN", "S"))
	}

	protected def findHighViolation() {
		var queryString = '''
			inputPin(P, PIN),
			nodeCharacteristic(P, ?CTGRANTS, ?CGRANTS),
			characteristic(P, PIN, ?CTLEVEL, ?CLEVEL, S).
		'''
		var query = prover.query(queryString)
		query.bind("CTGRANTS", "AllowedLevel (_Kqg1s11dEequxah3HlaYJg)")
		query.bind("CGRANTS", "Low (_xzDM4F1cEequxah3HlaYJg)")
		query.bind("CTLEVEL", "Level (_yuQ3811cEequxah3HlaYJg)")
		query.bind("CLEVEL", "High (_w90ODl1cEequxah3HlaYJg)")
		var solution = query.solve()
		solution
	}
	
	protected def findLowViolation() {
		var queryString = '''
			inputPin(P, PIN),
			nodeCharacteristic(P, ?CTGRANTS, ?CGRANTS),
			\+ characteristic(P, PIN, ?CTLEVEL, ?CLEVEL, S).
		'''
		var query = prover.query(queryString)
		query.bind("CTGRANTS", "AllowedLevel (_Kqg1s11dEequxah3HlaYJg)")
		query.bind("CGRANTS", "Low (_xzDM4F1cEequxah3HlaYJg)")
		query.bind("CTLEVEL", "Level (_yuQ3811cEequxah3HlaYJg)")
		query.bind("CLEVEL", "Low (_xzDM4F1cEequxah3HlaYJg)")
		var solution = query.solve()
		solution
	}

	protected def Solution<Object> findFlaws(Callable<Solution<Object>> solutionProvider) {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.setNameDerivationMethod(NameDerivationMethod.NAME_AND_ID)
		var workflow = builder.build()

		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())

		prover.loadTheory(result.get())
		solutionProvider.call
	}
	
}
