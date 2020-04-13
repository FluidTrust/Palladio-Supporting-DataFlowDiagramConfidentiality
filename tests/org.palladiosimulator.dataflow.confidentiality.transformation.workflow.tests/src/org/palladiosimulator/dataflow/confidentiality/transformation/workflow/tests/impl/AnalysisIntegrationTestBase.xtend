package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.TransformationWorkflowBuilder
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.util.StandaloneUtil
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized
import org.prolog4j.IProverFactory
import org.prolog4j.Prover
import org.prolog4j.Solution
import org.prolog4j.tuprolog.TuPrologProverFactory

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertFalse
import static org.junit.jupiter.api.Assertions.assertTrue

class AnalysisIntegrationTestBase {

	static IProverFactory proverFactory;
	protected TransformationWorkflowBuilder builder;
	protected Prover prover;

	new() {
		super();
	}
	
	@BeforeAll
	static def void init() {
		StandaloneUtil.init();
		proverFactory = new TuPrologProverFactory()
		
	}

	@BeforeEach
	def void setup() {
		builder = new TransformationWorkflowBuilder();
		prover = proverFactory.createProver();
	}
	
	protected def DataFlowDiagram loadAndInitDFD(String ddcPath, String dfdPath) {
		var resourceSet = new ResourceSetImpl
		var ddUri = getRelativeURI(ddcPath)
		var ddResource = resourceSet.getResource(ddUri, true)
		var dd = ddResource.contents.iterator.next as DataDictionaryCharacterized
		var dfdUri = getRelativeURI(dfdPath)
		var dfdResource = resourceSet.getResource(dfdUri, true)
		var dfd = dfdResource.contents.iterator.next as DataFlowDiagram
		builder.addDFD(dfd, dd);
		dfd
	}

	protected static def void assertNumberOfSolutions(Solution<Object> solution, int expectedAmount, Iterable<String> variableNames) {
		if (expectedAmount == 0) {
			assertFalse(solution.isSuccess());
			return;
		}
		
		// use first given variable as starting point
		var variableIter = variableNames.iterator();
		if (variableIter.hasNext()) {
			solution.on(variableIter.next());			
		}
		
		assertTrue(solution.isSuccess());
		var solutionCounter = 0;
		var debugMessage = "";
		for (var iter = solution.iterator(); iter.hasNext();) {
			debugMessage += "solution " + solutionCounter + ":\n";
			for (String variableName : variableNames) {
				debugMessage += "\t" + variableName + ": " + iter.get(variableName).toString + "\n";
			}
			iter.next();
			solutionCounter++;
		}
		assertEquals(expectedAmount, solutionCounter, debugMessage);
	}
	
//	private static void printSolution(Solution<Object> solution) {
//		for (SolutionIterator<Object> iter = solution.iterator(); iter.hasNext();) {
//			System.out.println("new solution:");
//			iter.next();
//			System.out.println("P : " + iter.get("P"));
//			System.out.println("CT: " + iter.get("CT"));
//			System.out.println("V : " + iter.get("V"));
//			System.out.println("S : " + iter.get("S"));
//		}
//	}

	protected static def getRelativeURI(String path) {
		return StandaloneUtil.getRelativeURI(path)
	}

}