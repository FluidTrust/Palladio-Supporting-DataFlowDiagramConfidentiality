package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.impl;

import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.TransformDFDToPrologWorkflow;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.DFDTransformationBlackboard;

import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.WorkflowExceptionHandler;
import de.uka.ipd.sdq.workflow.jobs.IJob;

public class TransformDFDToPrologWorkflowImpl extends BlackboardBasedWorkflow<DFDTransformationBlackboard> implements TransformDFDToPrologWorkflow {

	private final DFDTransformationBlackboard blackboard;
	
	public TransformDFDToPrologWorkflowImpl(IJob job, DFDTransformationBlackboard blackboard) {
		super(job, blackboard);
		this.blackboard = blackboard;
	}

	public TransformDFDToPrologWorkflowImpl(IJob job, IProgressMonitor monitor, WorkflowExceptionHandler handler,
			DFDTransformationBlackboard blackboard) {
		super(job, monitor, handler, blackboard);
		this.blackboard = blackboard;
	}

	public TransformDFDToPrologWorkflowImpl(IJob job, WorkflowExceptionHandler handler,
			DFDTransformationBlackboard blackboard) {
		super(job, handler, blackboard);
		this.blackboard = blackboard;
	}

	@Override
	public Optional<String> getSerializedPrologProgram() {
		return Optional.ofNullable(blackboard.getValue());
	}

}
