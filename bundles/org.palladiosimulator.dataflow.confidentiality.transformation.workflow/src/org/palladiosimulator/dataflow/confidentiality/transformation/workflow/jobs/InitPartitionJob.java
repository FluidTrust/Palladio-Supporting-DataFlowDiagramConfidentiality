package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.jobs.AbstractBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

public class InitPartitionJob extends AbstractBlackboardInteractingJob<MDSDBlackboard> {

    private final String partitionId;

    public InitPartitionJob(String partitionId) {
        this.partitionId = partitionId;
    }
    
    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        monitor.beginTask("init", 1);
        if (!getBlackboard().hasPartition(partitionId)) {
            getBlackboard().addPartition(partitionId, new ResourceSetPartition());
        }
        monitor.worked(1);
        monitor.done();
    }

    @Override
    public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
        // nothing to do here
    }

    @Override
    public String getName() {
        return "Initialize partition";
    }

}
