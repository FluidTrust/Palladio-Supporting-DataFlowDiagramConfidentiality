package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase

import static org.junit.jupiter.api.Assertions.*
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess

class MACAnalysisNeedToKnowTests extends AnalysisIntegrationTestBase {

	protected static extension val DataFlowDiagramCharacterizedFactory DFDC_FACTORY = DataFlowDiagramCharacterizedFactory.
		eINSTANCE

	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/mac_needtoknow/mac_dfd.xmi"))
		initProver()
		assertNumberOfSolutions(findViolation(), 0, Arrays.asList("N", "PIN", "COMP", "NTK", "S"))
	}

	@Test
	def void testNoDeclassification() {
		val dfd = loadAndInitDFD("models/evaluation/mac_needtoknow/mac_dd.xmi",
			"models/evaluation/mac_needtoknow/mac_dfd.xmi")

		dfd.edges += createCharacterizedDataFlow => [
			var medicalStore = dfd.nodes.filter(CharacterizedStore).findFirst[name.toLowerCase.contains("medical")]
			var createInvoiceProcess = dfd.nodes.filter(CharacterizedProcess).findFirst[name.toLowerCase.contains("invoice")]
			name = "treatments"
			source = medicalStore
			sourcePin = medicalStore.behavior.outputs.findFirst[true]
			target = createInvoiceProcess
			targetPin = createInvoiceProcess.behavior.inputs.get(0)
		]

		initProver()
		assertNumberOfSolutions(findViolation(), 2, Arrays.asList("N", "PIN", "COMP", "NTK", "S"))
	}

	protected def initProver() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED)
		var workflow = builder.build()

		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())

		prover.loadTheory(result.get())
	}

	protected def findViolation() {
		var query = prover.query('''
			(actor(N);actorProcess(N, _)),
			inputPin(N, PIN),
			flowTree(N, PIN, S),
			findall(X, characteristic(N, PIN, 'Compartment (_IgunozANEeyxUoEkMpyhIg)', X, S), L_COMP),
			findall(X, nodeCharacteristic(N, 'Need to Know (_hedQgzANEeyxUoEkMpyhIg)', X), L_NTK),
			sort(L_COMP, COMP), sort(L_NTK, NTK),
			\+ subset(COMP, NTK).
		''')
		var solution = query.solve()
		solution
	}

}
