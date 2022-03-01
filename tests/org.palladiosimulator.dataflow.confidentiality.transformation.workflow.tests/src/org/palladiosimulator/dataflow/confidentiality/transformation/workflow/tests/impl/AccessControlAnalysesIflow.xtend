package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl

import org.eclipse.xtext.resource.SaveOptions
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie
import org.prolog4j.Solution

import static org.junit.jupiter.api.Assertions.*

class AccessControlAnalysesIflow extends AnalysisIntegrationTestBase {

	protected val String roleId
	protected val String accessRightsId
	protected val String roleName
	protected val String accessRightsName
	
	new (String roleId, String accessRightsId) {
		this("Roles", roleId, "AccessRights", accessRightsId)
	}
	
	new (String roleName, String roleId, String accessRightsName, String accessRightsId) {
		this.roleId = roleId
		this.accessRightsId = accessRightsId
		this.roleName = roleName
		this.accessRightsName = accessRightsName
	}

	protected def Solution<Object> findFlaws() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED)
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
			inputPin(P, PIN),
			findall(R, nodeCharacteristic(P, ?CTROLES, R), L_ROLES),
			flowTree(P, PIN, S),
			findall(R, characteristic(P, PIN, ?CTRIGHTS, R, S), L_REQ),
			sort(L_ROLES, ROLES), sort(L_REQ, REQ),
			intersection(REQ, ROLES, []).
		'''
		var query = prover.query(queryString)
		query.bind("CTROLES", '''«roleName» («roleId»)'''.toString)
		query.bind("CTRIGHTS", '''«accessRightsName» («accessRightsId»)'''.toString)
		
	}

}
