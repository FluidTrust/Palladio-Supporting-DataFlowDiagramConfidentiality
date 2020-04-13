package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.jobs.AbstractBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

public class LoadModelJob<T extends MDSDBlackboard> extends AbstractBlackboardInteractingJob<T> {

    private final Collection<ModelLocation> modelLocations;

    public LoadModelJob(ModelLocation modelLocation) {
        this(Arrays.asList(modelLocation));
    }

    public LoadModelJob(Collection<ModelLocation> modelLocations) {
        this.modelLocations = modelLocations;
    }

    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        monitor.beginTask("Load models", modelLocations.size() + 1);
        Set<ResourceSetPartition> partitions = new HashSet<>();
        for (ModelLocation modelLocation : modelLocations) {
            partitions.add(loadModel(modelLocation));
            monitor.worked(1);
        }
        partitions.forEach(ResourceSetPartition::resolveAllProxies);
        monitor.worked(1);
        monitor.done();
    }

    protected ResourceSetPartition loadModel(ModelLocation modelLocation) throws JobFailedException {
        var partition = getPartition(modelLocation);

        if (partition.hasModel(modelLocation.getModelID())) {
            return partition;
        }

        try {
            partition.loadModel(modelLocation.getModelID());
            return partition;
        } catch (RuntimeException e) {
            throw new JobFailedException("Loading the model in the partition failed.", e);
        }
    }

    protected ResourceSetPartition getPartition(ModelLocation modelLocation) {
        if (!getBlackboard().hasPartition(modelLocation.getPartitionID())) {
            getBlackboard().addPartition(modelLocation.getPartitionID(), new ResourceSetPartition());
        }
        var partition = getBlackboard().getPartition(modelLocation.getPartitionID());
        return partition;
    }

    @Override
    public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
        // nothing to do
    }

    @Override
    public String getName() {
        return "Load Model";
    }

}
