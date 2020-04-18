package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs;

import java.util.Optional;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingContext;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingResults;
import org.eclipse.m2m.internal.qvt.oml.trace.EValue;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.internal.qvt.oml.trace.VarParameterValue;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.impl.TransformationTraceImpl;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Component;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedExternalActor;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.util.DataFlowDiagramCharacterizedSwitch;
import org.palladiosimulator.supporting.prolog.model.prolog.AtomicQuotedString;
import org.palladiosimulator.supporting.prolog.model.prolog.CompoundTerm;

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
        TransformationTraceImpl newTrace = new TransformationTraceImpl();
        Trace rawTrace = getRawTrace();

        monitor.beginTask("calculate derived trace", rawTrace.getTraceRecords()
            .size() + 1);

        for (var traceRecord : rawTrace.getTraceRecords()) {
            var contextElement = getContext(traceRecord);
            if (contextElement.isPresent()) {
                var traceEntry = TraceEntryDeriver.create(traceRecord)
                    .doSwitch(contextElement.get());
                if (traceEntry != null) {
                    newTrace.addComponentEntry(traceEntry.getLeft(), traceEntry.getRight());
                }
            }
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

    protected static class TraceEntryDeriver extends DataFlowDiagramCharacterizedSwitch<Pair<String, Component>> {

        private final TraceRecord traceRecord;

        public TraceEntryDeriver(TraceRecord traceRecord) {
            this.traceRecord = traceRecord;
        }

        public static TraceEntryDeriver create(TraceRecord traceRecord) {
            return new TraceEntryDeriver(traceRecord);
        }

        @Override
        public Pair<String, Component> caseCharacterizedProcess(CharacterizedProcess object) {
            return getCharacterizedComponentResult("processToFactHead", object);
        }

        @Override
        public Pair<String, Component> caseCharacterizedStore(CharacterizedStore object) {
            return getCharacterizedComponentResult("storeToFactHead", object);
        }

        @Override
        public Pair<String, Component> caseCharacterizedExternalActor(CharacterizedExternalActor object) {
            return getCharacterizedComponentResult("actorToFactHead", object);
        }

        @Override
        public Pair<String, Component> caseCharacterizedDataFlow(CharacterizedDataFlow object) {
            return getCharacterizedComponentResult("dataFlowToFactHead", object);
        }

        protected Pair<String, Component> getCharacterizedComponentResult(String mappingName, Component object) {
            if (!isOperationNameEqual(mappingName)) {
                return null;
            }

            CompoundTerm term = getResultCompoundTerm();
            String processId = ((AtomicQuotedString) term.getArguments()
                .get(0)).getValue();
            return ImmutablePair.of(processId, object);
        }

        protected CompoundTerm getResultCompoundTerm() {
            return getResult(CompoundTerm.class);
        }

        protected <T extends EObject> T getResult(Class<T> clz) {
            return Optional.ofNullable(traceRecord.getResult())
                .map(EMappingResults::getResult)
                .filter(l -> !l.isEmpty())
                .map(l -> l.get(0))
                .map(VarParameterValue::getValue)
                .map(EValue::getModelElement)
                .filter(clz::isInstance)
                .map(clz::cast)
                .get();
        }

        protected boolean isOperationNameEqual(String expectedName) {
            return expectedName.equals(traceRecord.getMappingOperation()
                .getName());
        }

    }

}
