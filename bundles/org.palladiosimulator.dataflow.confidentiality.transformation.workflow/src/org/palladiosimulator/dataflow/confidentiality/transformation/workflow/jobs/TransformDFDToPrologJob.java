package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.DFD2PrologTransformationBuilder;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.NameGenerationStrategie;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;

import de.uka.ipd.sdq.workflow.jobs.AbstractBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;

public class TransformDFDToPrologJob<T extends KeyValueMDSDBlackboard> extends AbstractBlackboardInteractingJob<T> {

    private final ModelLocation dfdLocation;
    private final ModelLocation prologLocation;
    private final String traceKey;
    private final DFD2PrologTransformationBuilder transformationBuilder;

    public TransformDFDToPrologJob(ModelLocation dfdLocation, ModelLocation prologLocation, String traceKey,
            NameGenerationStrategie nameGenerationStrategy, boolean usePerformanceTweaks) {
        this.dfdLocation = dfdLocation;
        this.prologLocation = prologLocation;
        this.traceKey = traceKey;
        this.transformationBuilder = DFD2PrologTransformationBuilder.create()
            .setNameProvider(nameGenerationStrategy);
        if (usePerformanceTweaks) {
            transformationBuilder.enablePerformanceTweaks();
        }
    }

    @Override
    public String getName() {
        return "Transform DFD to Prolog";
    }

    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        monitor.beginTask("Transform DFD to Prolog", 1);

        var dfds = getBlackboard().getContents(dfdLocation)
            .stream()
            .filter(DataFlowDiagram.class::isInstance)
            .map(DataFlowDiagram.class::cast)
            .collect(Collectors.toList());
        if (dfds.size() != 1) {
            new JobFailedException("There is not exactly one " + DataFlowDiagram.class.getSimpleName() + " available.");
        }

        var transformation = transformationBuilder.build();
        var result = transformation.transform(dfds.get(0));

        getBlackboard().setContents(prologLocation, Arrays.asList(result.getProgram()));
        getBlackboard().put(traceKey, result.getTrace());
        
        monitor.worked(1);
        monitor.done();
    }

    @Override
    public void cleanup(IProgressMonitor arg0) throws CleanupFailedException {
        // nothing to do here
    }

}
