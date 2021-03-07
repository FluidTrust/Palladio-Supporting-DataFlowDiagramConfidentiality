package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl

import org.eclipse.xtext.resource.SaveOptions
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie
import org.prolog4j.Solution

import static org.junit.jupiter.api.Assertions.*

class InformationFlowAnalysesIflow extends AnalysisIntegrationTestBase {
	
	val String classificationName
	val String classificationId
	val String clearanceName
	val String clearanceId
	
	new(String classificationId, String clearanceId) {
		this("Classification", classificationId, "Clearance", clearanceId)
	}
	
	new(String classificationName, String classificationId, String clearanceName, String clearanceId) {
		this.classificationName = classificationName
		this.classificationId = classificationId
		this.clearanceName = clearanceName
		this.clearanceId = clearanceId
	}
	
	protected def Solution<Object> findFlaws() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.nameDerivationMethod = NameGenerationStrategie.DETAILED
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
		query.bind("CTSECLEVEL", '''«classificationName» («classificationId»)'''.toString)
		query.bind("CTCLEARANCE", '''«clearanceName» («clearanceId»)'''.toString)
		var solution = query.solve()
		solution
	}
}