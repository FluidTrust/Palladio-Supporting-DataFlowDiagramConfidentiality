package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.xtext.resource.SaveOptions;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase;
import org.prolog4j.Query;
import org.prolog4j.Solution;

public class SimpleModelsAnalysisIntegrationTest extends AnalysisIntegrationTestBase {

	@Test
	public void testStaticTrueAndDataReference() {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_staticTrueAndDataReference.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query(getCharacteristicQuery("?P", "?PIN", "?CT"));
		query.bind("P", "P1 - CopyInToOut (_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("PIN", "P1.out (_8KIucUsyEeqBeZX3QKuNVA_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("CT", "CT_1 (_iwJnY0syEeqBeZX3QKuNVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutions(solution, 1, Arrays.asList("V", "S"));
	}
	
	@Test
	public void testStaticTrueFalseOverridingAndDataReference() {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_staticFalse-TrueAndDataReference.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query(getCharacteristicQuery("?P", "?PIN", "?CT"));
		query.bind("P", "P1 - CopyInToOut (_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("PIN", "P1.out (_8KIucUsyEeqBeZX3QKuNVA_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("CT", "CT_1 (_iwJnY0syEeqBeZX3QKuNVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutions(solution, 2, Arrays.asList("V", "S"));
	}
	
	@Test
	public void testTwoSourcesForOnePin() {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_twoSourcesForOnePin.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query(getCharacteristicQuery("?P", "?PIN", "?CT"));
		query.bind("P", "P1 - CopyInToOut (_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("PIN", "P1.out (_8KIucUsyEeqBeZX3QKuNVA_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("CT", "CT_1 (_iwJnY0syEeqBeZX3QKuNVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutions(solution, 2, Arrays.asList("V", "S"));
	}
	
	@Test
	public void testTwoSourcesForTwoPins() {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_twoSourcesForTwoPins.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query(getCharacteristicQuery("?P", "?PIN", "?CT"));
		query.bind("P", "P1 - CopyInToOut (_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("PIN", "P1.out (_8KIucUsyEeqBeZX3QKuNVA_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("CT", "CT_1 (_iwJnY0syEeqBeZX3QKuNVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutions(solution, 2, Arrays.asList("V", "S"));
	}
	
	@Test
	public void testLoadFromDataStore() {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_loadFromDataStore.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query(getCharacteristicQuery("?P", "?PIN", "?CT"));
		query.bind("P", "A2 (_I1hvJUz4EeqyWs80cS8siQ)");
		query.bind("PIN", "A2.in (_LEsVYEz4EeqyWs80cS8siQ_I1hvJUz4EeqyWs80cS8siQ)");
		query.bind("CT", "CT_1 (_iwJnY0syEeqBeZX3QKuNVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutions(solution, 1, Arrays.asList("V", "S"));
	}
	
	@Test
	public void testCopyCompatibleContainerCharacteristics() throws IOException {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_copyCompatibleContainerCharacteristic.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query(getCharacteristicQuery("?P", "?PIN", "CT"));
		query.bind("P", "P1 - SetToContainer (_44_t0ksyEeqBeZX3QKuNVA)");
		query.bind("PIN", "P1.out (_8KIucUsyEeqBeZX3QKuNVA_44_t0ksyEeqBeZX3QKuNVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutionsWithoutTraversedNodes(solution, 2, Arrays.asList("CT", "V", "S"));
	}
	
	@Test
	public void testSimpleCycle() throws IOException {
		builder.addDFD(getRelativeURI("models/unitTestExamples/dfd_simpleCycle.xmi"));
		builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED);
		var workflow = builder.build();

		workflow.run();
		var result = workflow.getSerializedPrologProgram();
		assertFalse(result.isEmpty());

		prover.loadTheory(result.get());
		Query query = prover.query(getCharacteristicQuery("?P", "?PIN", "CT"));
		query.bind("P", "A1 (_21ryRUsyEeqBeZX3QKuNVA)");
		query.bind("PIN", "A1.in (_kYwxUFSxEeqnLp_48pbpVA_21ryRUsyEeqBeZX3QKuNVA)");
		Solution<Object> solution = query.solve();
		
		assertNumberOfSolutionsWithoutTraversedNodes(solution, 1, Arrays.asList("CT", "V", "S"));
	}


	@Test
	public void testFlowTree() {
	    builder.addDFD(getRelativeURI("models/unitTestExamples/DFDC_FlowStack.xmi"));
        builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
        builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED);
        var workflow = builder.build();

        workflow.run();
        var result = workflow.getSerializedPrologProgram();
        assertFalse(result.isEmpty());
        
        prover.loadTheory(result.get());
        Query query = prover.query("CT=?CTV, " + getCharacteristicQuery("?P", "?PIN", "CT"));
        query.bind("P", "P5 (_A95iyYM2EeqgDLgDYuvGtg)");
        query.bind("PIN", "P5.out (_Eo6b8YM2EeqgDLgDYuvGtg_A95iyYM2EeqgDLgDYuvGtg)");
        query.bind("CTV", "ValueCharacteristic (_NpqAg4MyEeqgDLgDYuvGtg)");
        Solution<Object> solution = query.solve();
        
        assertNumberOfSolutionsWithoutTraversedNodes(solution, 4, Arrays.asList("CT", "V", "S"));
	}
	
	@Test
	public void testOtherLoop() throws IOException {
        builder.addDFD(getRelativeURI("models/unitTestExamples/loop_dfd.xmi"));
        builder.addSerializeToString(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
        builder.setNameDerivationMethod(NameGenerationStrategie.DETAILED);
        var workflow = builder.build();

        workflow.run();
        var result = workflow.getSerializedPrologProgram();
        assertFalse(result.isEmpty());

        prover.loadTheory(result.get());
        Query query = prover.query(getCharacteristicQuery("N", "PIN", "CT"));
        Solution<Object> solution = query.solve();
        assertNumberOfSolutionsWithoutTraversedNodes(solution, 22, Arrays.asList("N", "PIN", "CT", "V", "S"));
	}
	
	protected String getCharacteristicQuery(String node, String pin, String chartype) {
		return "characteristic(" + node + ", " + pin + ", " + chartype + ", V, S).";
	}
	
}
