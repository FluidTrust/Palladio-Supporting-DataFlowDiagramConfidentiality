package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.InformationFlowAnalysesTuma

class WebRTCAnalysisTest extends InformationFlowAnalysesTuma {
		
	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/webrtc/DFDC_WebRTC.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "PIN"))
	}
	
	@Test
	def void testManyFlaws() {
		builder.addDFD(getRelativeURI("models/evaluation/webrtc/DFDC_WebRTC_full.xmi"))
		var solution = findFlaws()
		// TODO many duplicate solutions, does not happen with SWI
		assertNumberOfSolutions(solution, 66, Arrays.asList("P", "PIN", "S"))
	}

}
