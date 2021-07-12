package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Behaving
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedExternalActor
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory
import org.prolog4j.Solution

import static org.junit.jupiter.api.Assertions.*

class ABACAnalysisTests extends AnalysisIntegrationTestBase {
	
	static val DFD_PATH = "models/evaluation/abac/abac_dfd.xmi"
	static val DDC_PATH = "models/evaluation/abac/abac_dd.xmi"

	@Test
	def void testNoFlaws() {
		//builder.addDFD(getRelativeURI(DFD_PATH))
		loadAndInitDFD(DDC_PATH, DFD_PATH)
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, #["A", "PIN", "SUBJ_LOC", "SUBJ_ROLE", "OBJ_LOC", "OBJ_STAT", "S"])
	}
	
	@Test
	def void testCelebrityInRegularCustomers() {		
		var dfd = loadAndInitDFD(DDC_PATH, DFD_PATH)

		var flow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		flow.name = "celebrity customer details"
		flow.source = dfd.nodes.filter(CharacterizedExternalActor).findFirst["Manager" == name]
		flow.sourcePin = (flow.source as Behaving).behavior.outputs.findFirst["celebrityCustomerDetails" == name]
		flow.target = dfd.nodes.filter(CharacterizedProcess).findFirst["US.registerCustomer" == name]
		flow.targetPin = (flow.target as Behaving).behavior.inputs.get(0)
		dfd.edges += flow

		var solution = findFlaws()
		assertNumberOfSolutionsWithoutDuplicates(solution, 2, #["A", "PIN", "SUBJ_LOC", "SUBJ_ROLE", "OBJ_LOC", "OBJ_STAT"])
	}
	
	@Test
	def void testAsianCustomerToUSA() {		
		var dfd = loadAndInitDFD(DDC_PATH, DFD_PATH)

		var flow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		flow.name = "customer details"
		flow.source = dfd.nodes.filter(CharacterizedExternalActor).findFirst["Clerk Asia" == name]
		flow.sourcePin = (flow.source as Behaving).behavior.outputs.findFirst["customerDetails" == name]
		flow.target = dfd.nodes.filter(CharacterizedProcess).findFirst["US.registerCustomer" == name]
		flow.targetPin = (flow.target as Behaving).behavior.inputs.get(0)
		dfd.edges += flow

		var solution = findFlaws()
		assertNumberOfSolutionsWithoutDuplicates(solution, 1, #["A", "PIN", "SUBJ_LOC", "SUBJ_ROLE", "OBJ_LOC", "OBJ_STAT"])
	}
	
	@Test
	def void testSkipCustomerMigration() {		
		var dfd = loadAndInitDFD(DDC_PATH, DFD_PATH)

		var flow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		flow.name = "customer"
		flow.source = dfd.nodes.filter(CharacterizedStore).findFirst["Customer Store US" == name]
		flow.sourcePin = (flow.source as Behaving).behavior.outputs.get(0)
		flow.target = dfd.nodes.filter(CharacterizedStore).findFirst["Customer Store Asia" == name]
		flow.targetPin = (flow.target as Behaving).behavior.inputs.get(0)
		dfd.edges += flow

		var solution = findFlaws()
		assertNumberOfSolutionsWithoutDuplicates(solution, 1, #["A", "PIN", "SUBJ_LOC", "SUBJ_ROLE", "OBJ_LOC", "OBJ_STAT"])
	}

	protected def Solution<Object> findFlaws() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.nameDerivationMethod = NameGenerationStrategie.DETAILED
		var workflow = builder.build()

		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())

		prover.loadTheory(result.get())
		
		var solution = query.solve()
		solution
	}
	
	protected def getQuery() {
		var queryString = '''
			actor(A),
			inputPin(A,PIN),
			nodeCharacteristic(A, 'EmployeeLocation (_j_v1Y-JAEeqO9NqdRSqKUA)', SUBJ_LOC),
			nodeCharacteristic(A, 'EmployeeRole (_nNduk-JAEeqO9NqdRSqKUA)', SUBJ_ROLE),
			characteristic(A, PIN, 'CustomerLocation (_h6k4o-JAEeqO9NqdRSqKUA)', OBJ_LOC, S),
			characteristic(A, PIN, 'CustomerStatus (_lmMOw-JAEeqO9NqdRSqKUA)', OBJ_STAT, S),
			(
				SUBJ_LOC \= OBJ_LOC,
				SUBJ_ROLE \= 'Manager (_dvk30OJAEeqO9NqdRSqKUA)';
				OBJ_STAT = 'Celebrity (_hCxt8OJAEeqO9NqdRSqKUA)',
				SUBJ_ROLE \= 'Manager (_dvk30OJAEeqO9NqdRSqKUA)'
			).
		'''
		var query = prover.query(queryString)
		query
	}
}
