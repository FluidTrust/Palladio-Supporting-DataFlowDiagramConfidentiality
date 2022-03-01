package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.InformationFlowAnalysesIflow

class FriendMapAnalysisLinearTest extends InformationFlowAnalysesIflow {

	new() {
		super("_LNbeM1IoEeqxoa0IdF5JoA", "_R8xrE1IoEeqxoa0IdF5JoA")
	}
	
	@Test
	def void testOneViolation() {
		builder.addDFD(getRelativeURI("models/evaluation/friendmap/DFDC_FriendMap_Linear.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 2, Arrays.asList("P", "PIN"))
	}
	
	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/friendmap/DFDC_FriendMapAlternative_Linear.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "PIN"))
	}

}
