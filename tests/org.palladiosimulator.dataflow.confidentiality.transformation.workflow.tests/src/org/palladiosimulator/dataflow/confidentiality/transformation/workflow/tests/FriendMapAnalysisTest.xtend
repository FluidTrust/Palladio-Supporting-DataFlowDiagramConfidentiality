package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.InformationFlowAnalysesTuma

class FriendMapAnalysisTest extends InformationFlowAnalysesTuma {

	@Test
	def void testOneViolation() {
		builder.addDFD(getRelativeURI("models/evaluation/friendmap/DFDC_FriendMap.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 2, Arrays.asList("P", "PIN"))
	}
	
	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/friendmap/DFDC_FriendMapAlternative.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "PIN"))
	}

}
