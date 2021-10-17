package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase

import static org.junit.jupiter.api.Assertions.*

class DACDelegationAnalysisTests extends AnalysisIntegrationTestBase {

	@Test
	def void testNoFlaw() {
		builder.addDFD(getRelativeURI("models/evaluation/dac_delegation/dac_dfd.xmi"))
		initProver()
		assertNumberOfSolutions(findReadViolation(), 0, #["A", "STORE", "S"])
		assertNumberOfSolutions(findWriteViolation(), 0, #["A", "STORE", "S"])
	}

	@Test
	def void testNoAddedReadAccess() {
		var dfd = loadAndInitDFD("models/evaluation/dac_delegation/dac_dd.xmi",
			"models/evaluation/dac_delegation/dac_dfd.xmi")
			
		dfd.edges.removeIf([e | e.source.name == "Mother" && e.target.name == "add read access"])
			
		initProver()
		assertNumberOfSolutions(findWriteViolation(), 0, #["A", "STORE", "S"])
		assertNumberOfSolutions(findReadViolation(), 4, #["A", "STORE", "S"])
	}
	
	@Test
	def void testNoAddedWriteAccess() {
		var dfd = loadAndInitDFD("models/evaluation/dac_delegation/dac_dd.xmi",
			"models/evaluation/dac_delegation/dac_dfd.xmi")
			
		dfd.edges.removeIf([e | e.source.name == "Dad" && e.target.name == "add write access"])
			
		initProver()
		assertNumberOfSolutions(findReadViolation(), 0, #["A", "STORE", "S"])
		assertNumberOfSolutions(findWriteViolation(), 1, #["A", "STORE", "S"])
	}
	
	@Test
	def void testMissingOwnerPriviledges() {
		var dfd = loadAndInitDFD("models/evaluation/dac_delegation/dac_dd.xmi",
			"models/evaluation/dac_delegation/dac_dfd.xmi")
			
		dfd.edges.removeIf([e | e.source.name == "Mother" && e.target.name == "add owner"])
			
		initProver()
		assertNumberOfSolutions(findReadViolation(), 0, #["A", "STORE", "S"])
		assertNumberOfSolutions(findWriteViolation(), 2, #["A", "STORE", "S"])
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
				"Owner (_uEVoY9VeEeqRbpVUMz5XAQ)",
				"Read Access (_rd9cA9VeEeqRbpVUMz5XAQ)",
				"Write Access (_swJco9VeEeqRbpVUMz5XAQ)",
				"Add Owner (_JjVjMi6kEeyiOr-FRYaMOg)",
				"Add Read Access (_LuTl8y6kEeyiOr-FRYaMOg)",
				"Add Write Access (_NTmv0y6kEeyiOr-FRYaMOg)"
			)
		)
	}
	
	protected def String getAnalysisRules(String ctIdentity, String ctOwner, String ctReadAccess, String ctWriteAccess, String ctAddOwner, String ctAddReadAccess, String ctAddWriteAccess) '''
		dynamic(STORE, CT, V) :-
			inputPin(STORE, PIN),
			characteristic(STORE, PIN, CT, V, S),
			actor(A),
			flowTree(STORE, PIN, S),
			traversedNode(S, A),
			nodeCharacteristic(A, '«ctIdentity»', Y),
			owner(Y, STORE).
		
		owner(V, STORE) :-
			nodeCharacteristic(STORE, '«ctOwner»', V);
			dynamic(STORE, '«ctAddOwner»', V).
		readAccess(V, STORE) :-
			nodeCharacteristic(STORE, '«ctReadAccess»', V);
			dynamic(STORE, '«ctAddReadAccess»', V).
		writeAccess(V, STORE) :-
			nodeCharacteristic(STORE, '«ctWriteAccess»', V);
			dynamic(STORE, '«ctAddWriteAccess»', V).
		
		readViolation(A, STORE, S) :-
			store(STORE),
			actor(A),
			inputPin(A, PIN),
			flowTree(A, PIN, S),
			traversedNode(S, STORE),
			nodeCharacteristic(A, '«ctIdentity»', Y),
			\+ readAccess(Y, STORE).
		
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
