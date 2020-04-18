package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod;

import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJob;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvto.QVTOTransformationJobConfiguration;

public class TransformDFDToPrologJob extends QVTOTransformationJob {

    private static final String TRANSFORMATION_BUNDLE_ID = "org.palladiosimulator.dataflow.confidentiality.transformation.prolog";
    private static final String TRANSFORMATION_PATH = "transforms/DFD2Prolog.qvto";

    public TransformDFDToPrologJob(ModelLocation dfdLocation, ModelLocation prologLocation,
            ModelLocation traceLocation, NameDerivationMethod nameDerivationMethod) {
        super(createQVTOConfiguration(dfdLocation, prologLocation, traceLocation, nameDerivationMethod));
    }

    public TransformDFDToPrologJob(ModelLocation dfdLocation, ModelLocation prologLocation, ModelLocation traceLocation) {
        this(dfdLocation, prologLocation, traceLocation, NameDerivationMethod.NAME_AND_ID);
    }

    private static QVTOTransformationJobConfiguration createQVTOConfiguration(ModelLocation dfdLocation,
            ModelLocation prologLocation, ModelLocation traceLocation, NameDerivationMethod nameDerivationMethod) {
        var transformationConfiguration = new QVTOTransformationJobConfiguration();

        // script path
        var uriString = String.format("/%s/%s", TRANSFORMATION_BUNDLE_ID, TRANSFORMATION_PATH);
        transformationConfiguration.setScriptFileURI(URI.createPlatformPluginURI(uriString, false));

        // involved models
        transformationConfiguration.setInoutModels(new ModelLocation[] { dfdLocation, prologLocation });

        transformationConfiguration.setTraceLocation(traceLocation);
        
        // init options
        Map<String, Object> options = new HashMap<>();
        options.put(NameDerivationMethod.QVTO_PROPERTY_KEY, nameDerivationMethod.getQvtoPropertyValue());
        transformationConfiguration.setOptions(options);

        // job creation
        return transformationConfiguration;
    }

}
