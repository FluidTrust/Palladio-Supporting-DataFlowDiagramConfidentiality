package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.impl;

import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.TransformDFDToPrologWorkflow;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.TransformationTrace;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;

import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.WorkflowExceptionHandler;
import de.uka.ipd.sdq.workflow.jobs.IJob;

public class TransformDFDToPrologWorkflowImpl extends BlackboardBasedWorkflow<KeyValueMDSDBlackboard>
        implements TransformDFDToPrologWorkflow {

    private final KeyValueMDSDBlackboard blackboard;
    private final String serializedProgramKey;
    private final String traceKey;

    public TransformDFDToPrologWorkflowImpl(IJob job, KeyValueMDSDBlackboard blackboard, String serializedProgramKey,
            String traceKey) {
        super(job, blackboard);
        this.blackboard = blackboard;
        this.serializedProgramKey = serializedProgramKey;
        this.traceKey = traceKey;
    }

    public TransformDFDToPrologWorkflowImpl(IJob job, IProgressMonitor monitor, WorkflowExceptionHandler handler,
            KeyValueMDSDBlackboard blackboard, String serializedProgramKey, String traceKey) {
        super(job, monitor, handler, blackboard);
        this.blackboard = blackboard;
        this.serializedProgramKey = serializedProgramKey;
        this.traceKey = traceKey;
    }

    public TransformDFDToPrologWorkflowImpl(IJob job, WorkflowExceptionHandler handler,
            KeyValueMDSDBlackboard blackboard, String serializedProgramKey, String traceKey) {
        super(job, handler, blackboard);
        this.blackboard = blackboard;
        this.serializedProgramKey = serializedProgramKey;
        this.traceKey = traceKey;
    }

    @Override
    public Optional<String> getSerializedPrologProgram() {
        return blackboard.get(serializedProgramKey)
            .map(String.class::cast);
    }

    @Override
    public Optional<TransformationTrace> getTransformationTrace() {
        return blackboard.get(traceKey)
            .filter(TransformationTrace.class::isInstance)
            .map(TransformationTrace.class::cast);
    }

}
