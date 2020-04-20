package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

import org.eclipse.xtext.resource.SaveOptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase;
import org.prolog4j.Query;
import org.prolog4j.Solution;

public class SimpleModelsAnalysisIntegrationTest extends AnalysisIntegrationTestBase {

	@Test
	public void testStaticTrueAndDataReference() {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_staticTrueAndDataReference.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameDerivationMethod.NAME_AND_ID);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query("characteristic(?P, ?PIN, ?CT, V, S).");
		query.bind("J$P", "P1 - CopyInToOut (_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("J$PIN", "P1.out (_8KIucUsyEeqBeZX3QKuNVA)");
		query.bind("J$CT", "CT_1 (_iwJnY0syEeqBeZX3QKuNVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutions(solution, 1, Arrays.asList("P", "PIN", "CT", "V", "S"));
	}
	
	@Test
	public void testStaticTrueFalseOverridingAndDataReference() {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_staticFalse-TrueAndDataReference.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameDerivationMethod.NAME_AND_ID);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query("characteristic(?P, ?PIN, ?CT, V, S).");
		query.bind("J$P", "P1 - CopyInToOut (_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("J$PIN", "P1.out (_8KIucUsyEeqBeZX3QKuNVA)");
		query.bind("J$CT", "CT_1 (_iwJnY0syEeqBeZX3QKuNVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutions(solution, 2, Arrays.asList("P", "PIN", "CT", "V", "S"));
	}
	
	@Test
	public void testTwoSourcesForOnePin() {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_twoSourcesForOnePin.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameDerivationMethod.NAME_AND_ID);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query("characteristic(?P, ?PIN, ?CT, V, S).");
		query.bind("J$P", "P1 - CopyInToOut (_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("J$PIN", "P1.out (_8KIucUsyEeqBeZX3QKuNVA)");
		query.bind("J$CT", "CT_1 (_iwJnY0syEeqBeZX3QKuNVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutions(solution, 2, Arrays.asList("P", "PIN", "CT", "V", "S"));
	}
	
	@Test
	public void testTwoSourcesForTwoPins() {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_twoSourcesForTwoPins.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameDerivationMethod.NAME_AND_ID);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query("characteristic(?P, ?PIN, ?CT, V, S).");
		query.bind("J$P", "P1 - CopyInToOut (_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("J$PIN", "P1.out (_8KIucUsyEeqBeZX3QKuNVA)");
		query.bind("J$CT", "CT_1 (_iwJnY0syEeqBeZX3QKuNVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutions(solution, 2, Arrays.asList("P", "PIN", "CT", "V", "S"));
	}
	
	@Test
	public void testLoadFromDataStore() {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_loadFromDataStore.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameDerivationMethod.NAME_AND_ID);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query("characteristic(?P, ?PIN, CT, V, S).");
		query.bind("J$P", "A2 (_I1hvJUz4EeqyWs80cS8siQ)");
		query.bind("J$PIN", "A2.in (_LEsVYEz4EeqyWs80cS8siQ)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutions(solution, 3, Arrays.asList("P", "PIN", "CT", "V", "S"));
	}
	
	@Test
	public void testCopyCompatibleContainerCharacteristics() {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_copyCompatibleContainerCharacteristic.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameDerivationMethod.NAME_AND_ID);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query("characteristic(?P, ?PIN, CT, V, S).");
		query.bind("J$P", "P1 - SetToContainer (_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("J$PIN", "P1.out (_8KIucUsyEeqBeZX3QKuNVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutions(solution, 3, Arrays.asList("P", "PIN", "CT", "V"));
	}
	
	@Test
	@Disabled("The used embedded solver does not support tabling, which results in an endless recursion")
	public void testSimpleCycle() {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_simpleCycle.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameDerivationMethod.NAME_AND_ID);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());
		
		prover.loadTheory(result.get());
		Query query = prover.query("characteristic(?P, ?PIN, CT, V, S).");
		query.bind("J$P", "A1 (_21ryRUsyEeqBeZX3QKuNVA)");
		query.bind("J$PIN", "A1.in (_kYwxUFSxEeqnLp_48pbpVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutions(solution, 1, Arrays.asList("P", "PIN", "CT", "V"));
	}


	@Test
	public void testFlowStack() {
	    builder.addDFD(getRelativeURI("models/unitTestExamples/DFDC_FlowStack.xmi"));
        builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
        builder.setNameDerivationMethod(NameDerivationMethod.NAME_AND_ID);
        var workflow = builder.build();

        workflow.run();
        var result = workflow.getSerializedPrologProgram();
        assertFalse(result.isEmpty());
        System.out.println(result);
	}
	
}
