package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie
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
		assertNumberOfSolutions(findReadViolation(), 2, #["A", "STORE", "S"])
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
		builder.nameDerivationMethod = NameGenerationStrategie.DETAILED
		var workflow = builder.build()

		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())

		prover.loadTheory(result.get())
		prover.addTheory(
			getAnalysisRules(
				"Identity (_o7_1k9VeEeqRbpVUMz5XAQ)",
				"Read Access (_rd9cA9VeEeqRbpVUMz5XAQ)",
				"Write Access (_swJco9VeEeqRbpVUMz5XAQ)"
			)
		)
	}
	
	protected def String getAnalysisRules(String ctIdentity, String ctReadAccess, String ctWriteAccess) '''
		readAccess(V, STORE) :-
			nodeCharacteristic(STORE, '«ctReadAccess»', V).
		readViolation(A, STORE, S) :-
			store(STORE),
			actor(A),
			inputPin(A, PIN),
			flowTree(A, PIN, S),
			traversedNode(S, STORE),
			nodeCharacteristic(A, '«ctIdentity»', Y),
			\+ readAccess(Y, STORE).
		
		writeAccess(V, STORE) :-
			nodeCharacteristic(STORE, '«ctWriteAccess»', V).
		writeViolation(A, STORE, S) :-
			store(STORE),
			actor(A),
			inputPin(STORE, PIN),
			flowTree(STORE, PIN, S),
			traversedNode(S, A),
			nodeCharacteristic(A, '«ctIdentity»', Y),
			\+ writeAccess(Y, STORE).
	'''

}
