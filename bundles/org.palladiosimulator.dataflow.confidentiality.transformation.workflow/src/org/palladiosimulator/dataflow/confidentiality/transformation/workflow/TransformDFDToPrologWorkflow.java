package org.palladiosimulator.dataflow.confidentiality.transformation.workflow;

import java.util.Optional;

import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.DFD2PrologTransformationTrace;

public interface TransformDFDToPrologWorkflow extends Runnable {

	public Optional<String> getSerializedPrologProgram();

    public Optional<DFD2PrologTransformationTrace> getTransformationTrace();
	
}
