package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.jobs.AbstractBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

public class LoadModelJob<T extends MDSDBlackboard> extends AbstractBlackboardInteractingJob<T> {

	private final ModelLocation modelLocation;

	public LoadModelJob(ModelLocation modelLocation) {
		this.modelLocation = modelLocation;
	}
	
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		if (!getBlackboard().hasPartition(modelLocation.getPartitionID())) {
			getBlackboard().addPartition(modelLocation.getPartitionID(), new ResourceSetPartition());
		}
		var partition = getBlackboard().getPartition(modelLocation.getPartitionID());
		
		if (partition.hasModel(modelLocation.getModelID())) {
			return;
		}
		
		try {
			partition.loadModel(modelLocation.getModelID());
			partition.resolveAllProxies();
		} catch (RuntimeException e) {
			throw new JobFailedException("Loading the model in the partition failed.", e);
		}
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
