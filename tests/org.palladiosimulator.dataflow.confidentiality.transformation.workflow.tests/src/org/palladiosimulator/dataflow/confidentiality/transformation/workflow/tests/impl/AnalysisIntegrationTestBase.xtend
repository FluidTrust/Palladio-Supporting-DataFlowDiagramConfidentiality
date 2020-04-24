package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl;

import java.util.ArrayList
import java.util.Collection
import java.util.HashMap
import java.util.Map
import java.util.function.Predicate
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

import static org.junit.jupiter.api.Assertions.*

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

	protected static def void assertNumberOfSolutionsWithoutTraversedNodes(Solution<Object> solution, int expectedAmount, Collection<String> variableNames) {
		if (!variableNames.contains("CT")) {
			throw new IllegalArgumentException("The name of the characterstic type has to be CT.")
		}
		val Predicate<Map<String, Object>> solutionFilter = [map | map.get("CT") != "TraversedNodes (_067sYYISEeqR5tyIqE6kZA)"]
		assertNumberOfSolutions(solution, expectedAmount, variableNames, solutionFilter)
	}

	protected static def void assertNumberOfSolutions(Solution<Object> solution, int expectedAmount, Iterable<String> variableNames) {
		assertNumberOfSolutions(solution, expectedAmount, variableNames, [true])
	}

	protected static def void assertNumberOfSolutions(Solution<Object> solution, int expectedAmount, Iterable<String> variableNames, Predicate<Map<String, Object>> solutionFilter) {
		if (expectedAmount == 0 && !solution.isSuccess) {
			return;
		}

		// use first given variable as starting point
		var variableIter = variableNames.iterator();
		if (variableIter.hasNext()) {
			solution.on(variableIter.next());			
		}

		assertTrue(solution.isSuccess());

		val solutions = new ArrayList
		for (var iter = solution.iterator(); iter.hasNext(); iter.next()) {
			val solutionVariables = new HashMap();
			for (String variableName : variableNames) {
				solutionVariables.put(variableName, iter.get(variableName))
			}
			solutions += solutionVariables
		}

		val filteredSolutions = solutions.filter[s | solutionFilter.test(s)]
		var solutionCounter = 0;
		var debugMessage = "";
		for (filteredSolution : filteredSolutions) {
			debugMessage += "solution " + solutionCounter + ":\n";
			for (variableName : variableNames) {
				debugMessage += "\t" + variableName + ": " + filteredSolution.get(variableName).toString + "\n";				
			}
			solutionCounter++;
		}

		assertEquals(expectedAmount, solutionCounter, debugMessage);
	}

	protected static def getRelativeURI(String path) {
		return StandaloneUtil.getRelativeURI(path)
	}

}