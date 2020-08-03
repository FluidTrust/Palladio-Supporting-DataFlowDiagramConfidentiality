package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase

import static org.junit.jupiter.api.Assertions.*

class DACAnalysisTests extends AnalysisIntegrationTestBase {

	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/dac/dac_dfd.xmi"))
		initProver()
		assertNumberOfSolutions(findReadViolation(), 0, #["A", "STORE", "S"])
		assertNumberOfSolutions(findWriteViolation(), 0, #["A", "STORE", "S"])
	}
	
	@Test
	def void testReadViolation() {
		builder.addDFD(getRelativeURI("models/evaluation/dac/dac_dfd_readViolation.xmi"))
		initProver()
		assertNumberOfSolutions(findWriteViolation(), 0, #["A", "STORE", "S"])
		assertNumberOfSolutions(findReadViolation(), 1, #["A", "STORE", "S"])
	}
	
	@Test
	def void testWriteViolation() {
		builder.addDFD(getRelativeURI("models/evaluation/dac/dac_dfd_writeViolation.xmi"))
		initProver()
		assertNumberOfSolutions(findReadViolation(), 0, #["A", "STORE", "S"])
		assertNumberOfSolutions(findWriteViolation(), 1, #["A", "STORE", "S"])
	}

	protected def findReadViolation() {
		findViolation("readViolation(A, STORE, S).")
	}
	
	protected def findWriteViolation() {
		findViolation("writeViolation(A, STORE, S).")
	}
	
	protected def findViolation(String queryString) {
		var query = prover.query(queryString)
		var solution = query.solve()
		solution
	}

	protected def initProver() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.nameDerivationMethod = NameDerivationMethod.NAME_AND_ID
		var workflow = builder.build()

		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())

		prover.loadTheory(result.get())
		prover.addTheory(
			getAnalysisRules(
				"Identity (_o7_1k9VeEeqRbpVUMz5XAQ)",
				"TraversedNodes (_067sYYISEeqR5tyIqE6kZA)",
				"Read Access (_rd9cA9VeEeqRbpVUMz5XAQ)",
				"Write Access (_swJco9VeEeqRbpVUMz5XAQ)"
			)
		)
	}
	
	protected def String getAnalysisRules(String ctIdentity, String ctTraversedNodes, String ctReadAccess, String ctWriteAccess) '''
		readViolation(A, STORE, S) :-
			CT_IDENTITY = '«ctIdentity»',
			CT_TRAVERSEDNODES = '«ctTraversedNodes»',
			CT_READ = '«ctReadAccess»',
			store(STORE),
			nodeLiteral(C_TRAVERSEDNODE, STORE),
			actor(A),
			inputPin(A, PIN),
			nodeCharacteristic(A, CT_IDENTITY, C_IDENTITY),
			characteristic(A, PIN, CT_TRAVERSEDNODES, C_TRAVERSEDNODE, S),
			\+ nodeCharacteristic(STORE, CT_READ, C_IDENTITY).
			
		writeViolation(A, STORE, S) :-
			CT_IDENTITY = '«ctIdentity»',
			CT_TRAVERSEDNODES = '«ctTraversedNodes»',
			CT_WRITE = '«ctWriteAccess»',
			store(STORE),
			actor(A),
			nodeLiteral(C_TRAVERSEDNODE, A),
			inputPin(STORE, PIN),
			nodeCharacteristic(A, CT_IDENTITY, C_IDENTITY),
			characteristic(STORE, PIN, CT_TRAVERSEDNODES, C_TRAVERSEDNODE, S),
			\+ nodeCharacteristic(STORE, CT_WRITE, C_IDENTITY).
	'''

}
