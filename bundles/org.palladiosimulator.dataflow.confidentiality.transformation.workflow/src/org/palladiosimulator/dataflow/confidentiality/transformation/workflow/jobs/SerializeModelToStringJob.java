package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;

import de.uka.ipd.sdq.workflow.jobs.AbstractBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

public class SerializeModelToStringJob extends AbstractBlackboardInteractingJob<KeyValueMDSDBlackboard> {

	protected final ModelLocation modelToSerialize;
	protected final Map<Object, Object> saveOptions;
    protected final Object targetKey;

	public SerializeModelToStringJob(ModelLocation modelToSerialize, Object targetKey) {
		this(modelToSerialize, Collections.emptyMap(), targetKey);
	}
	
	public SerializeModelToStringJob(ModelLocation modelToSerialize, Map<Object, Object> saveOptions, Object targetKey) {
		super();
		this.modelToSerialize = modelToSerialize;
		this.saveOptions = saveOptions;
		this.targetKey = targetKey;
	}
	
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		monitor.beginTask(getName(), 2);
		
		ResourceSetPartition partition = myBlackboard.getPartition(modelToSerialize.getPartitionID());
		Resource resourceToSerialize = partition.getResourceSet().getResource(modelToSerialize.getModelID(), false);
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			resourceToSerialize.save(baos, saveOptions);
			monitor.worked(1);
			getBlackboard().put(targetKey, baos.toString());
			monitor.worked(1);
		} catch (IOException e) {
			throw new JobFailedException("Serializing the model failed.", e);
		}

		monitor.done();
	}

	@Override
	public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
		// nothing to cleanup
	}

	@Override
	public String getName() {
		return "Serialize model to string";
	}

}
