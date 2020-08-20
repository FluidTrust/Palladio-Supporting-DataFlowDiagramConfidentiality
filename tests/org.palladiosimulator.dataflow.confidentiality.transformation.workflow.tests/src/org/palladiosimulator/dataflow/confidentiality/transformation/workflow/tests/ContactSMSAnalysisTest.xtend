package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving
import org.prolog4j.Solution

import static org.junit.jupiter.api.Assertions.*

class ContactSMSAnalysisTest extends AnalysisIntegrationTestBase {
	
	@Test
	def void testNoFlaws() {
		builder.addDFD(getRelativeURI("models/evaluation/contactsms/DFDC_ContactSMS.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "REQ", "ROLES", "MATCH"))
	}
	
	@Test
	def void testNoDeclassification() {		
		var dfd = loadAndInitDFD("models/evaluation/contactsms/DDC_ContactSMS.xmi",
			"models/evaluation/contactsms/DFDC_ContactSMS.xmi")
		
		// add possible data flow of contact to SMS sending process
		var directCCDFlow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		directCCDFlow.name = "contact direct"
		directCCDFlow.source = dfd.nodes.filter(CharacterizedProcess).findFirst[name.toLowerCase.contains("selectcontact")]
		directCCDFlow.sourcePin = (directCCDFlow.source as Behaving).behavior.outputs.iterator.next
		directCCDFlow.target = dfd.nodes.filter(CharacterizedProcess).findFirst[name.toLowerCase.contains("sendsms")]
		directCCDFlow.targetPin = (directCCDFlow.target as Behaving).behavior.inputs.findFirst[name.toLowerCase.contains("number")]
		dfd.edges += directCCDFlow
		
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 2, Arrays.asList("P", "REQ", "ROLES", "MATCH"))
	}
	
	protected def Solution<Object> findFlaws() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.setNameDerivationMethod(NameDerivationMethod.NAME_AND_ID)
		var workflow = builder.build()
		
		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())
		
		prover.loadTheory(result.get())
		var queryString = '''
			inputPin(P, PIN),
			bagof(R, nodeCharacteristic(P, ?CTROLES, R), ROLES),
			bagof(A, characteristic(P, PIN, ?CTRIGHTS, A, S), REQ),
			intersection(REQ, ROLES, MATCH),
			length(MATCH, 0).
		'''
		var query = prover.query(queryString)
		query.bind("J$CTROLES", "Roles (_g8Baw0NEEeq3NrD2DjPidQ)")
		query.bind("J$CTRIGHTS", "AccessRights (_fCiJk0NEEeq3NrD2DjPidQ)")
		var solution = query.solve()
		solution
	}
	
}
