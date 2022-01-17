package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests

import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Behaving
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedExternalActor
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory
import org.prolog4j.Solution

import static org.junit.Assert.assertFalse

class TravelPlannerTMACTest extends AnalysisIntegrationTestBase {
	
	@Test
	def void testNoFlaws() {
		builder.addDFD(getRelativeURI("models/evaluation/travelplanner/DFDC_TravelPlanner_TMAC.xmi"))
		var solution = findFlaws()
		assertNumberOfSolutions(solution, 0, #["P", "PIN", "REQ", "ROLES", "C", "V"])
	}
	
	@Test
	def void testNoDeclassification() {		
		var dfd = loadAndInitDFD("models/evaluation/travelplanner/DDC_TravelPlanner_TMAC.xmi",
			"models/evaluation/travelplanner/DFDC_TravelPlanner_TMAC.xmi")
		
		// add possible data flow from User to CCD Store
		var directCCDFlow = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow
		directCCDFlow.name = "ccd direct"
		directCCDFlow.source = dfd.nodes.filter(CharacterizedExternalActor).findFirst["User" == name]
		directCCDFlow.sourcePin = (directCCDFlow.source as Behaving).behavior.outputs.findFirst[name.contains("ccd")]
		directCCDFlow.target = dfd.nodes.filter(CharacterizedStore).findFirst["CCD.CCDStorage" == name]
		directCCDFlow.targetPin = (directCCDFlow.target as Behaving).behavior.inputs.iterator.next
		dfd.edges += directCCDFlow

		var solution = findFlaws()
		assertNumberOfSolutions(solution, 6, #["P", "PIN", "REQ", "ROLES", "C", "V"])
	}
	
	protected def Solution<Object> findFlaws() {	
		val roleName = "Roles"
		val roleId = "_JvuuQ9vqEeqNdo_V4bA-xw"
		val accessRightsName = "AccessPermissions"
		val accessRightsId = "_k9jB49vTEeqNdo_V4bA-xw"
		val criticalityName = "Criticality"
		val criticalityId = "_nzAkk27TEey6fcb9AA1YiQ"
		val validationName = "Validation"
		val validationId = "_so-N827TEey6fcb9AA1YiQ"

		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED)
		var workflow = builder.build()

		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())

		prover.loadTheory(result.get())
		var queryString = '''
			inputPin(P, PIN), flowTree(P, PIN, S),
			((
				findall(R, nodeCharacteristic(P, ?CTROLES, R), L_ROLES),
				findall(R, characteristic(P, PIN, ?CTRIGHTS, R, S), L_REQ),
				sort(L_ROLES, ROLES), sort(L_REQ, REQ),
				intersection(REQ, ROLES, [])
			) ; (
				CT_CRITICALITY=?CTCRIT,
				CT_VALIDATION=?CTVAL,
				nodeCharacteristic(P, CT_CRITICALITY, C),
				characteristicTypeValue(CT_CRITICALITY, C, NC),
				characteristic(P, PIN, CT_VALIDATION, V, S),
				characteristicTypeValue(CT_VALIDATION, V, NV),
				NV > NC
			)).
		'''
		var query = prover.query(queryString)
		query.bind("CTROLES", '''«roleName» («roleId»)'''.toString)
		query.bind("CTRIGHTS", '''«accessRightsName» («accessRightsId»)'''.toString)
		query.bind("CTCRIT", '''«criticalityName» («criticalityId»)'''.toString)
		query.bind("CTVAL", '''«validationName» («validationId»)'''.toString)
		var solution = query.solve()
		solution
	}
	
}