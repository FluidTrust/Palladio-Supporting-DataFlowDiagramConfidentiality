package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.InformationFlowAnalysesTuma

class HospitalAnalysisTest extends InformationFlowAnalysesTuma {

	@Test
	def void testOneViolation() {
		builder.addDFD(getRelativeURI("models/evaluation/hospital/DFDC_Hospital.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 1, Arrays.asList("P", "PIN"))
	}
	
	@Test
	def void testOneViolationLoopful() {
		builder.addDFD(getRelativeURI("models/evaluation/hospital/DFDC_HospitalLoopful.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 1, Arrays.asList("P", "PIN"))
	}
	
	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/hospital/DFDC_HospitalAlternative.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "PIN"))
	}

}
