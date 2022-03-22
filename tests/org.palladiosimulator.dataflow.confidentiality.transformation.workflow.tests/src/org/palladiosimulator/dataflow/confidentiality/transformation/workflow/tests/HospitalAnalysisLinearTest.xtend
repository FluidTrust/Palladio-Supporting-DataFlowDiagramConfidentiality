package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.InformationFlowAnalysesIflow

class HospitalAnalysisLinearTest extends InformationFlowAnalysesIflow {

	new() {
		super("_LNbeM1IoEeqxoa0IdF5JoA", "_R8xrE1IoEeqxoa0IdF5JoA")
	}

	@Test
	def void testOneViolationLoopful() {
		builder.addDFD(getRelativeURI("models/evaluation/hospital/DFDC_HospitalLoopful_Linear.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 1, Arrays.asList("P", "PIN"))
	}
	
	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/hospital/DFDC_HospitalAlternative_Linear.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "PIN"))
	}

}
