package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.InformationFlowAnalysesTuma
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory

class JPMailAnalysisTest extends InformationFlowAnalysesTuma {

	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/jpmail/DFDC_JPMail.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "PIN"))
	}

	@Test
	def void testNoDeclassification() {		
		var dfd = loadAndInitDFD("models/evaluation/jpmail/DDC_JPMail.xmi",
			"models/evaluation/jpmail/DFDC_JPMail.xmi")
		
		// add direct data flow of unconfirmed distance data
		var targetNode = dfd.nodes.filter(CharacterizedProcess).findFirst["SMTP" == name]
		var srcNode = dfd.nodes.filter(CharacterizedProcess).findFirst["Encrypt.prepareEncryption" == name]
		var directFlow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		directFlow.name = "direct flow"
		directFlow.source = srcNode
		directFlow.sourcePin = srcNode.behavior.outputs.iterator.next
		directFlow.target = targetNode
		directFlow.targetPin = targetNode.behavior.inputs.iterator.next
		dfd.edges += directFlow

		var solution = findFlaws()
		assertNumberOfSolutions(solution, 2, Arrays.asList("P", "PIN"))
	}

}
