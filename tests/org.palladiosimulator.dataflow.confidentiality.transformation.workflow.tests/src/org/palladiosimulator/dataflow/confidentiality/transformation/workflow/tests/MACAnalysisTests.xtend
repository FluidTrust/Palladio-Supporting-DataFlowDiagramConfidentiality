package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase

import static org.junit.jupiter.api.Assertions.*

class MACAnalysisTests extends AnalysisIntegrationTestBase {
	
	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/mac/mac_dfd.xmi"))
		initProver()
		assertNumberOfSolutions(findReadViolation(), 0, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE", "S"))
		assertNumberOfSolutions(findWriteViolation(), 0, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE", "S"))
	}
	
	@Test
	def void testReadViolation() {
		builder.addDFD(getRelativeURI("models/evaluation/mac/mac_dfd_readViolation.xmi"))
		initProver()
		assertNumberOfSolutions(findWriteViolation(), 0, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE", "S"))
		assertNumberOfSolutions(findReadViolation(), 2, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE", "S"))
	}
	
	@Test
	def void testWriteViolation() {
		builder.addDFD(getRelativeURI("models/evaluation/mac/mac_dfd_writeViolation.xmi"))
		initProver()
		assertNumberOfSolutions(findWriteViolation(), 2, Arrays.asList("N", "CLEARANCE", "STORE", "CLASSIFICATION", "S"))
	}
	
	@Test
	def void testNoFlawAfterIntegrityViolation() {
		builder.addDFD(getRelativeURI("models/evaluation/mac/mac_dfd_integrityViolation.xmi"))
		initProver()
		assertNumberOfSolutions(findReadViolation(), 0, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE", "S"))
		assertNumberOfSolutions(findWriteViolation(), 0, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE", "S"))
	}
	
	protected def initProver() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED)
		var workflow = builder.build()

		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())

		prover.loadTheory(result.get())
		prover.addTheory(
			getAnalysisRules("Classification (_VD0vQ9MDEeqMaJ4277tZGA)",
				"Clearance (_um9nwNMCEeqMaJ4277tZGA)")
			)
	}
	
	protected def findReadViolation() {
		findViolation("readViolation(N, CLASSIFICATION, CLEARANCE, S).")
	}
	
	protected def findWriteViolation() {
		findViolation("writeViolation(N, CLEARANCE, STORE, CLASSIFICATION, S).")
	}
	
	protected def findViolation(String queryString) {
		var query = prover.query(queryString)
		var solution = query.solve()
		solution
	}
	
	protected def String getAnalysisRules(String classificationType, String clearanceType) '''
		readViolation(N, CLASSIFICATION_VALUE, CLEARANCE_VALUE, S) :-
			CLASSIFICATION_TYPE = '«classificationType»',
			CLEARANCE_TYPE = '«clearanceType»',
			nodeCandidate(N, CLEARANCE_VALUE),
			inputPin(N, PIN),
			characteristic(N, PIN, CLASSIFICATION_TYPE, CLASSIFICATION_VALUE, S),
			characteristicTypeValue(CLASSIFICATION_TYPE, CLASSIFICATION_VALUE, CLASSIFICATION_INDEX),
			characteristicTypeValue(CLEARANCE_TYPE, CLEARANCE_VALUE, CLEARANCE_INDEX),
			CLEARANCE_INDEX > CLASSIFICATION_INDEX.
		
		writeViolation(N, CLEARANCE_VALUE, STORE, CLASSIFICATION_VALUE, S) :-
			CLEARANCE_TYPE = '«clearanceType»',
			CLASSIFICATION_TYPE = '«classificationType»',
			nodeCandidate(N, CLEARANCE_VALUE),
			store(STORE),
			inputPin(STORE, PIN),
			flowTree(STORE, PIN, S),
			traversedNode(S, N),
			nodeCharacteristic(STORE, CLASSIFICATION_TYPE, CLASSIFICATION_VALUE),
			characteristicTypeValue(CLASSIFICATION_TYPE, CLASSIFICATION_VALUE, CLASSIFICATION_INDEX),
			characteristicTypeValue(CLEARANCE_TYPE, CLEARANCE_VALUE, CLEARANCE_INDEX),
			CLEARANCE_INDEX < CLASSIFICATION_INDEX.
		
		nodeCandidate(A, CLEARANCE_VALUE) :-
			CLEARANCE_TYPE = '«clearanceType»',
			actor(A),
			nodeCharacteristic(A, CLEARANCE_TYPE, CLEARANCE_VALUE).
		
		nodeCandidate(N, CLEARANCE_VALUE) :-
			actor(A),
			actorProcess(N, A),
			nodeCandidate(A, CLEARANCE_VALUE).
	'''

}