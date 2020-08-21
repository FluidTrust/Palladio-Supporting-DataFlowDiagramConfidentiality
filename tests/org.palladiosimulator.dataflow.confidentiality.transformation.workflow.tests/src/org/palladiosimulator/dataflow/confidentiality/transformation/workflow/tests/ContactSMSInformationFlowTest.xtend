package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import java.util.Arrays
import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory
import org.prolog4j.Solution

import static org.junit.Assert.assertFalse
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving

class ContactSMSInformationFlowTest extends AnalysisIntegrationTestBase {
	
	@BeforeEach
	def void setupBuilder() {
		builder.setDefaultCharacteristicsUsage(false)
	}
	
	@Test
	def void testNoFlaws() {
		builder.addDFD(getRelativeURI("models/evaluation/contactsms/DFDC_ContactSMS_InformationFlow.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, Arrays.asList("P", "PIN", "V_LEVEL", "V_CLEAR"))
	}
	
	@Test
	def void testNoDeclassification() {		
		var dfd = loadAndInitDFD("models/evaluation/contactsms/DDC_ContactSMS_InformationFlow.xmi",
			"models/evaluation/contactsms/DFDC_ContactSMS_InformationFlow.xmi")
		
		// add possible data flow of contact to SMS sending process
		var directCCDFlow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		directCCDFlow.name = "contact direct"
		directCCDFlow.source = dfd.nodes.filter(CharacterizedProcess).findFirst[name.toLowerCase.contains("selectcontact")]
		directCCDFlow.sourcePin = (directCCDFlow.source as Behaving).behavior.outputs.iterator.next
		directCCDFlow.target = dfd.nodes.filter(CharacterizedProcess).findFirst[name.toLowerCase.contains("sendsms")]
		directCCDFlow.targetPin = (directCCDFlow.target as Behaving).behavior.inputs.get(1)
		dfd.edges += directCCDFlow
		
		var solution = findFlaws()
		assertNumberOfSolutionsWithoutDuplicates(solution, 2, Arrays.asList("P", "PIN", "V_LEVEL", "V_CLEAR"))
	}
	
	protected def Solution<Object> findFlaws() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.nameDerivationMethod = NameDerivationMethod.NAME_AND_ID
		builder.defaultCharacteristicsUsage = false
		var workflow = builder.build()
		
		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())
		
		prover.loadTheory(result.get())
		var queryString = '''
			CT_LEVEL = ?CTSECLEVEL,
			CT_CLEARANCE = ?CTCLEARANCE,
			nodeCharacteristic(P, CT_CLEARANCE, V_CLEAR),
			characteristicTypeValue(CT_CLEARANCE, V_CLEAR, N_CLEAR),
			inputPin(P, PIN),
			characteristic(P, PIN, CT_LEVEL, V_LEVEL, S),
			characteristicTypeValue(CT_LEVEL, V_LEVEL, N_LEVEL),
			N_LEVEL > N_CLEAR.
		'''
		var query = prover.query(queryString)
		query.bind("J$CTSECLEVEL", "Classification (_fCiJk0NEEeq3NrD2DjPidQ)")
		query.bind("J$CTCLEARANCE", "Clearance (_g8Baw0NEEeq3NrD2DjPidQ)")
		var solution = query.solve()
		solution
	}
	
}