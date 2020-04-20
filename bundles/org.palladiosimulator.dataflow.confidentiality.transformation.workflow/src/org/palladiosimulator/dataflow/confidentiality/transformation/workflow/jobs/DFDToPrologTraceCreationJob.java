package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs;

import java.util.Optional;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingContext;
import org.eclipse.m2m.internal.qvt.oml.trace.EValue;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.internal.qvt.oml.trace.VarParameterValue;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.impl.DFD2PrologTransformationTraceImpl;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.impl.TraceEntryDeriver;

import de.uka.ipd.sdq.workflow.jobs.AbstractBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;

@SuppressWarnings("restriction")
public class DFDToPrologTraceCreationJob<T extends KeyValueMDSDBlackboard> extends AbstractBlackboardInteractingJob<T> {

    private final String traceKey;
    private final ModelLocation rawTraceLocation;

    public DFDToPrologTraceCreationJob(ModelLocation rawTraceLocation, String traceKey) {
        this.rawTraceLocation = rawTraceLocation;
        this.traceKey = traceKey;
    }

    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        DFD2PrologTransformationTraceImpl newTrace = new DFD2PrologTransformationTraceImpl();
        Trace rawTrace = getRawTrace();

        monitor.beginTask("calculate derived trace", rawTrace.getTraceRecords()
            .size() + 1);

        for (var traceRecord : rawTrace.getTraceRecords()) {
            getContext(traceRecord).flatMap(TraceEntryDeriver.create(traceRecord)::getTraceEntry)
                .ifPresent(entry -> entry.applyToTrace(newTrace));
            monitor.worked(1);
        }

        getBlackboard().put(traceKey, newTrace);

        monitor.worked(1);
        monitor.done();
    }

    protected Optional<EObject> getContext(TraceRecord traceRecord) {
        return Optional.ofNullable(traceRecord.getContext())
            .map(EMappingContext::getContext)
            .map(VarParameterValue::getValue)
            .map(EValue::getModelElement);
    }

    protected Trace getRawTrace() throws JobFailedException {
        if (!getBlackboard().modelExists(rawTraceLocation)) {
            throw new JobFailedException("The raw trace is not available at " + rawTraceLocation);
        }
        return getBlackboard().getContents(rawTraceLocation)
            .stream()
            .filter(Trace.class::isInstance)
            .map(Trace.class::cast)
            .findAny()
            .orElseThrow(() -> new JobFailedException("The raw trace model is no QVT-O trace."));
    }

    @Override
    public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
        // nothing to do there
    }

    @Override
    public String getName() {
        return "Trace calculation";
    }

}
