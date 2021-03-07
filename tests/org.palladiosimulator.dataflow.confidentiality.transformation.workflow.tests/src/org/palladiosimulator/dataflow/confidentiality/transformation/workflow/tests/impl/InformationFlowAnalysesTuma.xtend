package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl

import org.eclipse.xtext.resource.SaveOptions
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie

import static org.junit.jupiter.api.Assertions.*

class InformationFlowAnalysesTuma extends AnalysisIntegrationTestBase {
	
	protected def findFlaws() {
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED)
		var workflow = builder.build()

		workflow.run()
		var result = workflow.getSerializedPrologProgram()
		assertFalse(result.isEmpty())

		prover.loadTheory(result.get())
		var queryString = '''
			inputPin(P, PIN),
			nodeCharacteristic(P, ?CTZONE, ?CZONE),
			characteristic(P, PIN, ?CTLEVEL, ?CLEVEL, S).
		'''
		var query = prover.query(queryString)
		query.bind("CTZONE", "ZoneMembership (_R8xrE1IoEeqxoa0IdF5JoA)")
		query.bind("CZONE", "AttackZone (_exuVgFIuEeqkVaPUPi-ogw)")
		query.bind("CTLEVEL", "ConfidentialityRequirements (_LNbeM1IoEeqxoa0IdF5JoA)")
		query.bind("CLEVEL", "High (_PtJx0FIoEeqxoa0IdF5JoA)")
		var solution = query.solve()
		solution
	}
	
}