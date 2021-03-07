package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase

import static org.junit.jupiter.api.Assertions.*

class DataTypesTest extends AnalysisIntegrationTestBase {
	
	@Test
	def void testDataTypeTranslation() {
		translateAndLoadExample
		assertPrimitiveDataType("int (_auP1sHNvEeqbvrpGxoLSUQ)")
		assertCollectionDataType("IntArray (_dyPLIHNvEeqbvrpGxoLSUQ)", "int (_auP1sHNvEeqbvrpGxoLSUQ)")
		assertCompositeDataType("PhoneBookEntry (_f28N0XNvEeqbvrpGxoLSUQ)")
		assertCompositeDataTypeEntry("PhoneBookEntry (_f28N0XNvEeqbvrpGxoLSUQ)", "name", "string (_cjk_onNvEeqbvrpGxoLSUQ)")
	}
	
	@Test
	def void testDataFlowTranslation() {
		translateAndLoadExample
		assertDataFlowData("EmployeeToQuery (_U29nW3NxEeqbvrpGxoLSUQ)", "query (_Y10pkHNxEeqbvrpGxoLSUQ)", "query", "string (_cjk_onNvEeqbvrpGxoLSUQ)")
	}
	
	@Test
	def void testDataFlowDataQuery() {
		translateAndLoadExample
		prover.addTheory('''''')
	}

	protected def translateAndLoadExample() {
		builder.addDFD(getRelativeURI("models/evaluation/datatypes/DFD_DataTypes.xmi"))
		
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED)
		var workflow = builder.build()
		
		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())
		
		prover.loadTheory(result.get())
	}
	
	protected def assertCompositeDataTypeEntry(String dataType, String entryName, String entryType) {
		var queryString = '''DT=?DATATYPE,
		ET=?ETYPE,
		dataType(DT),
		compositeDataType(DT),
		compositeDataTypeEntry(DT, ?ENAME, ET),
		dataType(ET).'''
		var query = prover.query(queryString)
		query.bind("DATATYPE", dataType)
		query.bind("ENAME", entryName)
		query.bind("ETYPE", entryType)
		var solution = query.solve()
		assertTrue(solution.success)
	}
	
	protected def assertCompositeDataType(String dataType) {
		var queryString = '''DT=?DATATYPE,
		dataType(DT),
		\+collectionDataType(DT, _),
		compositeDataType(DT).'''
		var query = prover.query(queryString)
		query.bind("DATATYPE", dataType)
		var solution = query.solve()
		assertTrue(solution.success)
	}
	
	protected def assertCollectionDataType(String dataType, String innerType) {
		var queryString = '''DT=?DATATYPE,
		dataType(DT),
		collectionDataType(DT, ?INNERTYPE),
		\+compositeDataType(DT).'''
		var query = prover.query(queryString)
		query.bind("DATATYPE", dataType)
		query.bind("INNERTYPE", innerType)
		var solution = query.solve()
		assertTrue(solution.success)
	}
	
	protected def assertPrimitiveDataType(String dataType) {
		var queryString = '''DT=?DATATYPE,
		dataType(DT),
		\+collectionDataType(DT, _),
		\+compositeDataType(DT).'''
		var query = prover.query(queryString)
		query.bind("DATATYPE", dataType)
		var solution = query.solve()
		assertTrue(solution.success)
	}
	
	protected def assertDataFlowData(String dataFlow, String dataId, String dataName, String dataType) {
		var queryString = '''dataflowData(?DF, ?ID, ?NAME, ?TYPE).'''
		var query = prover.query(queryString)
		query.bind("DF", dataFlow)
		query.bind("ID", dataId)
		query.bind("NAME", dataName)
		query.bind("TYPE", dataType)
		var solution = query.solve()
		assertTrue(solution.success)
	}
	
}