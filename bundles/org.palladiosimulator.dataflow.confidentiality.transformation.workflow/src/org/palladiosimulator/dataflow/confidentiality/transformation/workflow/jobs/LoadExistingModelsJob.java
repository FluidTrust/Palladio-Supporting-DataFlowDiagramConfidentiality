package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

public class LoadExistingModelsJob<T extends MDSDBlackboard> extends LoadModelJob<T> {

    public static class ModelContent {
        private final ModelLocation location;
        private final List<EObject> content;

        public ModelContent(ModelLocation location) {
            this(location, Collections.emptyList());
        }
        
        public ModelContent(ModelLocation location, List<EObject> content) {
            super();
            this.location = location;
            this.content = content;
        }

        public ModelContent(ModelLocation location, EObject usageModel) {
            this(location, Arrays.asList(usageModel));
        }

        public ModelLocation getLocation() {
            return location;
        }

        public List<EObject> getContent() {
            return content;
        }

    }

    private final Map<ModelLocation, List<EObject>> modelContents;

    public LoadExistingModelsJob(ModelContent modelContent) {
        this(Arrays.asList(modelContent));
    }

    public LoadExistingModelsJob(Collection<ModelContent> modelContents) {
        super(getLocations(modelContents));
        this.modelContents = modelContents.stream()
            .collect(Collectors.toMap(ModelContent::getLocation, ModelContent::getContent));
    }

    protected static Collection<ModelLocation> getLocations(Collection<ModelContent> content) {
        return content.stream()
            .map(ModelContent::getLocation)
            .collect(Collectors.toList());
    }

    @Override
    protected ResourceSetPartition loadModel(ModelLocation modelLocation) throws JobFailedException {
        Optional<List<EObject>> modelContent = Optional.ofNullable(modelContents.get(modelLocation)).filter(content -> !content.isEmpty());
        if (modelContent.isPresent()) {
            ResourceSetPartition partition = getPartition(modelLocation);
            partition.setContents(modelLocation.getModelID(), modelContent.get());
        }
        return super.loadModel(modelLocation);
    }

}
