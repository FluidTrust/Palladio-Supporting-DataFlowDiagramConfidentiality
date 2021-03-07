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
		readViolation(A, STORE, S) :-
			CT_IDENTITY = '«ctIdentity»',
			CT_READ = '«ctReadAccess»',
			store(STORE),
			actor(A),
			nodeCharacteristic(A, CT_IDENTITY, C_IDENTITY),
			\+ nodeCharacteristic(STORE, CT_READ, C_IDENTITY),
			inputPin(A, PIN),
			flowStack(A, PIN, S),
			traversedNode(S, STORE).
			
		writeViolation(A, STORE, S) :-
			CT_IDENTITY = '«ctIdentity»',
			CT_WRITE = '«ctWriteAccess»',
			store(STORE),
			actor(A),
			inputPin(STORE, PIN),
			nodeCharacteristic(A, CT_IDENTITY, C_IDENTITY),
			\+ nodeCharacteristic(STORE, CT_WRITE, C_IDENTITY),
			flowStack(STORE, PIN, S),
			traversedNode(S, A).
	'''

}
