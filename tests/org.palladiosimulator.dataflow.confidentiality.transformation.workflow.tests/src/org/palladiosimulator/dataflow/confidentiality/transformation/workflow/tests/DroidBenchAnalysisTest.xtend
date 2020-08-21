package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.InformationFlowAnalysesTuma

class DroidBenchAnalysisTest extends InformationFlowAnalysesTuma {
	
	@Test
	def void testDroidBenchActivityCommunication1() {
		// https://github.com/secure-software-engineering/DroidBench/tree/master/eclipse-project/InterComponentCommunication/ActivityCommunication1
		builder.addDFD(getRelativeURI("models/evaluation/droidbench/DFDC_DroidBench_ActivityCommunication1.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 1, Arrays.asList("P", "PIN"))
	}

	@Test
	def void testDroidBenchActivityCommunication2to8() {
		// https://github.com/secure-software-engineering/DroidBench/tree/master/eclipse-project/InterComponentCommunication/ActivityCommunication2
		// all scenarios 2-8 have same data flow but different implementations on how to identify target
		builder.addDFD(getRelativeURI("models/evaluation/droidbench/DFDC_DroidBench_ActivityCommunication2-8.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 1, Arrays.asList("P", "PIN"))
	}
	
	@Test
	def void testDroidBenchBroadcastTaintAndLeak1() {
		// https://github.com/secure-software-engineering/DroidBench/tree/master/eclipse-project/InterComponentCommunication/BroadcastTaintAndLeak1
		builder.addDFD(getRelativeURI("models/evaluation/droidbench/DFDC_DroidBench_BroadcastTaintAndLeak1.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 1, Arrays.asList("P", "PIN"))
	}

}
