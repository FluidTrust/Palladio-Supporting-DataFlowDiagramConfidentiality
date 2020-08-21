package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.InformationFlowAnalysesTuma

class JPMailAnalysisTest extends InformationFlowAnalysesTuma {

	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/jpmail/DFDC_JPMail.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "PIN"))
	}

}
