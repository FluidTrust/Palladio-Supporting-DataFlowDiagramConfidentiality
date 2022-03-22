package org.palladiosimulator.dataflow.confidentiality.transformation.workflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.impl.TransformDFDToPrologWorkflowImpl;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.CopyModelJob;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.LoadModelJob;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.SerializeModelToStringJob;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.TransformDFDToPrologJob;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.ValidateModelJob;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataDictionary;

import de.uka.ipd.sdq.workflow.WorkflowExceptionHandler;
import de.uka.ipd.sdq.workflow.blackboard.Blackboard;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.SavePartitionToDiskJob;

public class TransformationWorkflowBuilder {

	protected static final ModelLocation DEFAULT_DFD_LOCATION = new ModelLocation("dfd", URI.createFileURI("tmp/dfd.xmi"));
	protected static final ModelLocation DEFAULT_DD_LOCATION = new ModelLocation("dfd", URI.createFileURI("tmp/dd.xmi"));
	protected static final ModelLocation DEFAULT_PROLOG_LOCATION = new ModelLocation("prolog", URI.createFileURI("tmp/prolog.pl"));
	protected static final String DEFAULT_TRACE_KEY = "trace";
	protected static final String DEFAULT_PROLOG_KEY = "prolog";
	protected static final String DEFAULT_DFD_VALIDATION_KEY = "dfdValidationResult";
	private final KeyValueMDSDBlackboard blackboard = new KeyValueMDSDBlackboard();
	private final Collection<IJob> serializationJobs = new ArrayList<>();
	protected ModelLocation dfdLocation;
	protected WorkflowExceptionHandler workflowExceptionHandler = new WorkflowExceptionHandler(false);
	protected IProgressMonitor progressMonitor = new NullProgressMonitor();
	private NameGenerationStrategie nameDerivationMethod = NameGenerationStrategie.SHORTED_ID;
	protected String dfdValidationKey = DEFAULT_DFD_VALIDATION_KEY;
    protected boolean failOnValidationError;
    protected boolean enablePerformanceTweaks = false;
    protected boolean enableDFDValidation = false;
	
	public TransformationWorkflowBuilder() {
		
	}
	
	
	public TransformationWorkflowBuilder addWorkflowExceptionHandler(WorkflowExceptionHandler handler) {
		this.workflowExceptionHandler  = handler;
		return this;
	}
	
	public TransformationWorkflowBuilder addProgressMonitor(IProgressMonitor monitor) {
		this.progressMonitor = monitor;
		return this;
	}
	
	public TransformationWorkflowBuilder addDFD(DataFlowDiagram dfd, DataDictionary dd) {
		blackboard.removePartition(DEFAULT_DFD_LOCATION.getPartitionID());
		blackboard.addPartition(DEFAULT_DFD_LOCATION.getPartitionID(), new ResourceSetPartition());
		blackboard.setContents(DEFAULT_DD_LOCATION, Arrays.asList(dd));
		blackboard.setContents(DEFAULT_DFD_LOCATION, Arrays.asList(dfd));
		dfdLocation = DEFAULT_DFD_LOCATION;
		return this;
	}
	
	public TransformationWorkflowBuilder addDFD(URI dfdURI) {
		blackboard.removePartition(DEFAULT_DFD_LOCATION.getPartitionID());
		blackboard.addPartition(DEFAULT_DFD_LOCATION.getPartitionID(), new ResourceSetPartition());
		dfdLocation = new ModelLocation(DEFAULT_DFD_LOCATION.getPartitionID(), dfdURI);
		return this;
	}
	
	public TransformationWorkflowBuilder setNameDerivationMethod(NameGenerationStrategie method) {
		this.nameDerivationMethod = method;
		return this;
	}
	
	public TransformationWorkflowBuilder addSerializeToString() {
		addSerializeToString(Collections.emptyMap());
		return this;
	}
	
	public TransformationWorkflowBuilder addSerializeToString(Map<Object, Object> saveOptions) {
		serializationJobs.removeIf(SerializeModelToStringJob.class::isInstance);
		var serializeJob = new SerializeModelToStringJob(DEFAULT_PROLOG_LOCATION, saveOptions, DEFAULT_PROLOG_KEY);
		serializationJobs.add(serializeJob);
		return this;
	}
	
	protected Collection<IJob> getSerializationJobs() {
		return this.serializationJobs;
	}
	
	protected ModelLocation getDFDLocation() {
		return this.dfdLocation;
	}
	
	protected KeyValueMDSDBlackboard getBlackboard() {
		return this.blackboard;
	}
	
	protected ModelLocation getPrologLocation() {
		return DEFAULT_PROLOG_LOCATION;
	}
	
	protected NameGenerationStrategie getNameGenerationStrategie() {
		return this.nameDerivationMethod;
	}
	
	
    public TransformationWorkflowBuilder addSerializeModelToFile(URI destinationURI) {
		addSerializeModelToFile(destinationURI, Collections.emptyMap());
		return this;
	}
	
	public TransformationWorkflowBuilder addSerializeModelToFile(URI destinationURI, Map<String, Object> saveOptions) {
		var serializationJob = new SequentialBlackboardInteractingJob<>("Model Serialization Sequential Job");
		serializationJobs.removeIf(j -> serializationJob.getName().equals(j.getName()));
		var destinationLocation = new ModelLocation("serialization", destinationURI);
		var copyJob = new CopyModelJob<>(DEFAULT_PROLOG_LOCATION, destinationLocation);
		var saveJob = new SavePartitionToDiskJob(destinationLocation.getPartitionID(), saveOptions);
		blackboard.addPartition(destinationLocation.getPartitionID(), new ResourceSetPartition());
		serializationJob.add(copyJob);
		serializationJob.add(saveJob);
		serializationJobs.add(serializationJob);
		return this;
	}
	
	public TransformationWorkflowBuilder addDFDValidation(String validationKey) {
	    this.dfdValidationKey = validationKey;
	    return this;
	}
	
	public TransformationWorkflowBuilder setFailOnValidationError() {
	    this.failOnValidationError = true;
	    return this;
	}
	
	public TransformationWorkflowBuilder enableDFDValidation() {
	    this.enableDFDValidation  = true;
	    return this;
	}
	
	public TransformationWorkflowBuilder enablePerformanceTweaks() {
	    this.enablePerformanceTweaks = true;
	    return this;
	}
	
	public TransformDFDToPrologWorkflow build() {
		// validate state
        Validate.validState(dfdLocation != null, "A DFD diagram has to be given");
        Validate.validState(!serializationJobs.isEmpty(), "At least one serialization option has to be given");

        // create workflow
        return new TransformDFDToPrologWorkflowImpl(createJobSequence(), progressMonitor, workflowExceptionHandler, blackboard,
                DEFAULT_PROLOG_KEY, DEFAULT_TRACE_KEY);
    }
    
    public SequentialBlackboardInteractingJob<Blackboard<?>> createJobSequence() {
    	// create job sequence
        var jobSequence = new SequentialBlackboardInteractingJob<>("DFD to Prolog Transformation");

        // add model loading job
        var loadDFDJob = new LoadModelJob<>(dfdLocation);
        jobSequence.add(loadDFDJob);

        // create transformation job
        blackboard.addPartition(DEFAULT_PROLOG_LOCATION.getPartitionID(), new ResourceSetPartition());
        
        var transformJob = new TransformDFDToPrologJob<KeyValueMDSDBlackboard>(dfdLocation, DEFAULT_PROLOG_LOCATION,
                DEFAULT_TRACE_KEY, nameDerivationMethod, enablePerformanceTweaks);
        jobSequence.add(transformJob);
        
        if (enableDFDValidation) {
            var validationJob = new ValidateModelJob<>(dfdLocation, dfdValidationKey, failOnValidationError);
            jobSequence.add(validationJob);            
        }

        // create serialization job
        jobSequence.addAll(serializationJobs);
        
        return jobSequence;
	}
}
