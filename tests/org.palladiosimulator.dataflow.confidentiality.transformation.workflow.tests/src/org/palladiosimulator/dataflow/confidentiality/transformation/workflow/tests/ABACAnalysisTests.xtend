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
		assertNumberOfSolutions(solution, 0, #["A", "PIN", "S"])
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
		assertNumberOfSolutionsWithoutDuplicates(solution, 4, #["A", "PIN", "S"])
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
		assertNumberOfSolutionsWithoutDuplicates(solution, 2, #["A", "PIN", "S"])
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
		assertNumberOfSolutionsWithoutDuplicates(solution, 2, #["A", "PIN", "S"])
	}

	protected def Solution<Object> findFlaws() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.nameDerivationMethod = NameGenerationStrategie.DETAILED
		var workflow = builder.build()

		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())

		prover.loadTheory(result.get())
		prover.loadTheory('''
			matchSubject('Clerk', N) :-
			  nodeCharacteristic(N, 'EmployeeRole (_nNduk-JAEeqO9NqdRSqKUA)', 'Clerk (_c_En8OJAEeqO9NqdRSqKUA)').
			
			matchSubject('Manager', N) :-
			  nodeCharacteristic(N, 'EmployeeRole (_nNduk-JAEeqO9NqdRSqKUA)', 'Manager (_dvk30OJAEeqO9NqdRSqKUA)').
			
			matchObject('Regular', N, PIN, S) :-
			  exactCharacteristicValues(N, PIN, 'CustomerStatus (_lmMOw-JAEeqO9NqdRSqKUA)', ['Regular (_gYqZ8OJAEeqO9NqdRSqKUA)'], S).
			
			matchObject('all', _, _, _).
			
			read(N, PIN, S) :-
			  matchSubject('Manager', N),
			  matchObject('all', N, PIN, S).
			
			read(N, PIN, S) :-
			  matchSubject('Clerk', N),
			  matchObject('Regular', N, PIN, S),
			  nodeCharacteristic(N, 'EmployeeLocation (_j_v1Y-JAEeqO9NqdRSqKUA)', L),
			  exactCharacteristicValues(N, PIN, 'CustomerLocation (_h6k4o-JAEeqO9NqdRSqKUA)', [L], S).
		''')
		var queryString = '''
			actor(A),
			inputPin(A, PIN),
			flowTree(A, PIN, S),
			\+ read(A, PIN, S).
		'''
		var query = prover.query(queryString)
		var solution = query.solve()
		solution
	}
}
