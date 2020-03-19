package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.jobs.AbstractBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;

public class CopyModelJob<T extends MDSDBlackboard> extends AbstractBlackboardInteractingJob<T> {

	private final ModelLocation src;
	private final ModelLocation dst;

	public CopyModelJob(ModelLocation src, ModelLocation dst) {
		this.src = src;
		this.dst = dst;
	}
	
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		monitor.beginTask(getName(), 2);
		var modelContents = getBlackboard().getContents(src);
		monitor.worked(1);
		getBlackboard().setContents(dst, modelContents);
		monitor.worked(1);
		monitor.done();
	}

	@Override
	public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
		// intentionally left blank
	}

	@Override
	public String getName() {
		return "Copy Models";
	}

}
