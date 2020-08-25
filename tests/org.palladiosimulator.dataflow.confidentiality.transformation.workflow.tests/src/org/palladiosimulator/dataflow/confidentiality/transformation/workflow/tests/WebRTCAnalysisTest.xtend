package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.InformationFlowAnalysesTuma
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory

class WebRTCAnalysisTest extends InformationFlowAnalysesTuma {
		
	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/webrtc/DFDC_WebRTC.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "PIN"))
	}
	
	@Test
	def void testNoEncryption() {		
		var dfd = loadAndInitDFD("models/evaluation/webrtc/DDC_WebRTC.xmi",
			"models/evaluation/webrtc/DFDC_WebRTC.xmi")
		
		// add direct data flow of unconfirmed distance data
		var srcNode = dfd.nodes.filter(CharacterizedProcess).findFirst["BrowserB.createBobSessionData" == name]
		var targetNode = dfd.nodes.filter(CharacterizedProcess).findFirst["SignalingServer.dispatchResponseSessionData" == name]
		var directFlow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		directFlow.name = "direct flow"
		directFlow.source = srcNode
		directFlow.sourcePin = srcNode.behavior.outputs.iterator.next
		directFlow.target = targetNode
		directFlow.targetPin = targetNode.behavior.inputs.iterator.next
		dfd.edges += directFlow
		
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 1, Arrays.asList("P", "PIN", "S"))
	}

}
