package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl

import org.eclipse.xtext.resource.SaveOptions
import org.junit.jupiter.api.BeforeEach
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod
import org.prolog4j.Solution

import static org.junit.jupiter.api.Assertions.*

class AccessControlAnalysesIflow extends AnalysisIntegrationTestBase {

	val String roleId
	val String accessRightsId
	val String roleName
	val String accessRightsName
	
	new (String roleId, String accessRightsId) {
		this("Roles", roleId, "AccessRights", accessRightsId)
	}
	
	new (String roleName, String roleId, String accessRightsName, String accessRightsId) {
		this.roleId = roleId
		this.accessRightsId = accessRightsId
		this.roleName = roleName
		this.accessRightsName = accessRightsName
	}

	@BeforeEach
	def void setupBuilder() {
		builder.setDefaultCharacteristicsUsage(false)
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
		query.bind("J$CTROLES", '''«roleName» («roleId»)'''.toString)
		query.bind("J$CTRIGHTS", '''«accessRightsName» («accessRightsId»)'''.toString)
		var solution = query.solve()
		solution
	}

}
