package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.eclipse.emf.common.util.URI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.TransformationWorkflowBuilder;

public class WorkflowBuilderTest {

	private TransformationWorkflowBuilder builder;

	@BeforeEach
	public void setup() {
		builder = new TransformationWorkflowBuilder();
	}
	
	@Test
	public void testIllegalStateAfterBuildWithoutParameters() {
		assertThrows(IllegalStateException.class, builder::build);
	}
	
	@Test
	public void testIllegalStateAfterBuildWithoutDFD() {
		builder.addSerializeModelToFile(URI.createFileURI("/tmp/bla.pl"));
		assertThrows(IllegalStateException.class, builder::build);
	}
	
	@Test
	public void testIllegalStateAfterBuildWithoutSerialization() {
		builder.addDFD(URI.createFileURI("/tmp/bla.xmi"));
		assertThrows(IllegalStateException.class, builder::build);
	}
	
	@Test
	public void testMinimalMandatoryParameters() {
		builder.addDFD(URI.createFileURI("/tmp/bla.xmi")).addSerializeModelToFile(URI.createFileURI("/tmp/bla.pl"));
		assertNotNull(builder.build());
	}
}
