package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase

import static org.junit.jupiter.api.Assertions.*

class MACAnalysisTests extends AnalysisIntegrationTestBase {
	
	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/mac/mac_dfd.xmi"))
		initProver()
		assertNumberOfSolutions(findReadViolation(), 0, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE"))
		assertNumberOfSolutions(findWriteViolation(), 0, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE"))
	}
	
	@Test
	def void testReadViolation() {
		builder.addDFD(getRelativeURI("models/evaluation/mac/mac_dfd_readViolation.xmi"))
		initProver()
		assertNumberOfSolutions(findWriteViolation(), 0, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE"))
		assertNumberOfSolutions(findReadViolation(), 2, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE"))
	}
	
	@Test
	def void testWriteViolation() {
		builder.addDFD(getRelativeURI("models/evaluation/mac/mac_dfd_writeViolation.xmi"))
		initProver()
		assertNumberOfSolutions(findWriteViolation(), 2, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE"))
	}
	
	@Test
	def void testNoFlawAfterIntegrityViolation() {
		builder.addDFD(getRelativeURI("models/evaluation/mac/mac_dfd_integrityViolation.xmi"))
		initProver()
		assertNumberOfSolutions(findReadViolation(), 0, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE"))
		assertNumberOfSolutions(findWriteViolation(), 0, Arrays.asList("N", "CLASSIFICATION", "CLEARANCE"))
	}
	
	protected def initProver() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.setNameDerivationMethod(NameDerivationMethod.NAME_AND_ID)
		var workflow = builder.build()

		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())

		prover.loadTheory(result.get())
		prover.addTheory(
			getAnalysisRules("Classification (_VD0vQ9MDEeqMaJ4277tZGA)",
				"Clearance (_um9nwNMCEeqMaJ4277tZGA)",
				"TraversedNodes (_067sYYISEeqR5tyIqE6kZA)")
			)
	}
	
	protected def findReadViolation() {
		findViolation("readViolation(N, CLASSIFICATION, CLEARANCE, S).")
	}
	
	protected def findWriteViolation() {
		findViolation("writeViolation(N, CLASSIFICATION, CLEARANCE, S).")
	}
	
	protected def findViolation(String queryString) {
		var query = prover.query(queryString)
		var solution = query.solve()
		solution
	}
	
	protected def String getAnalysisRules(String classificationType, String clearanceType, String traversedNodesType) '''
		readViolation(N, CLASSIFICATION_VALUE, CLEARANCE_VALUE, S) :-
			CLASSIFICATION_TYPE = '«classificationType»',
			CLEARANCE_TYPE = '«clearanceType»',
			nodeCandidate(N, CLEARANCE_VALUE),
			inputPin(N, PIN),
			characteristic(N, PIN, CLASSIFICATION_TYPE, CLASSIFICATION_VALUE, S),
			characteristicTypeValue(CLASSIFICATION_TYPE, CLASSIFICATION_VALUE, CLASSIFICATION_INDEX),
			characteristicTypeValue(CLEARANCE_TYPE, CLEARANCE_VALUE, CLEARANCE_INDEX),
			CLEARANCE_INDEX > CLASSIFICATION_INDEX.
		
		writeViolation(N, CLASSIFICATION_VALUE, CLEARANCE_VALUE, S) :-
			TRAVERSEDNODES_TYPE = '«traversedNodesType»',
			CLEARANCE_TYPE = '«clearanceType»',
			CLASSIFICATION_TYPE = '«classificationType»',
			nodeCandidate(N, CLEARANCE_VALUE),
			nodeLiteral(NOTETYPE_VALUE, N),
			store(STORE),
			inputPin(STORE, PIN),
			characteristic(STORE, PIN, TRAVERSEDNODES_TYPE, NOTETYPE_VALUE, S),
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