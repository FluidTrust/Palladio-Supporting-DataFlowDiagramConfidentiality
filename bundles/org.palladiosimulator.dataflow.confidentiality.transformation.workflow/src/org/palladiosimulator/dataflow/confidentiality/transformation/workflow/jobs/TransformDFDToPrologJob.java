package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJobConfiguration;

public class TransformDFDToPrologJob extends QVTOTransformationJob {

    private static final String TRANSFORMATION_BUNDLE_ID = "org.palladiosimulator.dataflow.confidentiality.transformation.prolog";
    private static final String TRANSFORMATION_PATH = "transforms/DFD2Prolog.qvto";
    private static final URI DEFAULT_CHARACTERISTICS_URI = URI
        .createURI("pathmap://DFD_DEFAULT_MODELS/defaultCharacteristicTypes.xmi");
    private final ModelLocation defaultCharacteristicTypesLocation;
    protected MDSDBlackboard blackboard;

    public TransformDFDToPrologJob(ModelLocation dfdLocation, ModelLocation prologLocation, ModelLocation traceLocation,
            NameDerivationMethod nameDerivationMethod) {
        super(createQVTOConfiguration(dfdLocation, prologLocation, traceLocation, nameDerivationMethod));
        defaultCharacteristicTypesLocation = createDefaultCharacteristicTypeLocation(dfdLocation);
    }

    public TransformDFDToPrologJob(ModelLocation dfdLocation, ModelLocation prologLocation,
            ModelLocation traceLocation) {
        this(dfdLocation, prologLocation, traceLocation, NameDerivationMethod.NAME_AND_ID);
    }

    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        loadDefaultCharacteristicTypesModel();
        monitor.beginTask("Transform DFD to Prolog", 1);
        super.execute(monitor);
        monitor.worked(1);
        monitor.done();
    }

    protected void loadDefaultCharacteristicTypesModel() {
        ResourceSetPartition partition = blackboard.getPartition(defaultCharacteristicTypesLocation.getPartitionID());
        partition.loadModel(defaultCharacteristicTypesLocation.getModelID());
    }

    protected static QVTOTransformationJobConfiguration createQVTOConfiguration(ModelLocation dfdLocation,
            ModelLocation prologLocation, ModelLocation traceLocation, NameDerivationMethod nameDerivationMethod) {
        var transformationConfiguration = new QVTOTransformationJobConfiguration();

        // script path
        var uriString = String.format("/%s/%s", TRANSFORMATION_BUNDLE_ID, TRANSFORMATION_PATH);
        transformationConfiguration.setScriptFileURI(URI.createPlatformPluginURI(uriString, false));

        // involved models
        var defaultCharacteristicTypesLocation = createDefaultCharacteristicTypeLocation(dfdLocation);
        transformationConfiguration
            .setInoutModels(new ModelLocation[] { dfdLocation, defaultCharacteristicTypesLocation, prologLocation });

        transformationConfiguration.setTraceLocation(traceLocation);

        // init options
        Map<String, Object> options = new HashMap<>();
        options.put(NameDerivationMethod.QVTO_PROPERTY_KEY, nameDerivationMethod.getQvtoPropertyValue());
        transformationConfiguration.setOptions(options);

        // job creation
        return transformationConfiguration;
    }

    protected static ModelLocation createDefaultCharacteristicTypeLocation(ModelLocation dfdLocation) {
        return new ModelLocation(dfdLocation.getPartitionID(), DEFAULT_CHARACTERISTICS_URI);
    }

    @Override
    public void setBlackboard(MDSDBlackboard blackboard) {
        super.setBlackboard(blackboard);
        this.blackboard = blackboard;
    }

}
