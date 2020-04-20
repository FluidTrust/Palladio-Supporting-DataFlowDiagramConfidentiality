package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Component;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedExternalActor;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.util.DataFlowDiagramCharacterizedSwitch;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.palladiosimulator.supporting.prolog.model.prolog.AtomicQuotedString;
import org.palladiosimulator.supporting.prolog.model.prolog.CompoundTerm;

@SuppressWarnings("restriction")
public class DataFlowDiagramTraceEntryDeriver extends DataFlowDiagramCharacterizedSwitch<TraceEntry>
        implements TraceRecordUtils {

    private final TraceRecord traceRecord;

    public DataFlowDiagramTraceEntryDeriver(TraceRecord traceRecord) {
        this.traceRecord = traceRecord;
    }

    @Override
    public TraceEntry caseCharacterizedProcess(CharacterizedProcess object) {
        return getCharacterizedComponentResult("processToFactHead", object);
    }

    @Override
    public TraceEntry caseCharacterizedStore(CharacterizedStore object) {
        return getCharacterizedComponentResult("storeToFactHead", object);
    }

    @Override
    public TraceEntry caseCharacterizedExternalActor(CharacterizedExternalActor object) {
        return getCharacterizedComponentResult("actorToFactHead", object);
    }

    @Override
    public TraceEntry caseCharacterizedDataFlow(CharacterizedDataFlow object) {
        return getCharacterizedComponentResult("dataFlowToFactHead", object);
    }

    @Override
    public TraceEntry caseNode(Node object) {
        if (!isOperationNameEqual("nodeToEnumLiteral")) {
            return super.caseNode(object);
        }

        Literal nodeLiteral = getResult(Literal.class);

        Trace fullTrace = (Trace) getTraceRecord().eContainer();
        Optional<MappingOperation> literalMappingOperation = fullTrace.getTraceRecordMap()
            .keySet()
            .stream()
            .filter(mo -> "enumCharacteristicTypeLiteralToFactHead".equals(mo.getName()))
            .findFirst();
        @SuppressWarnings("unchecked")
        Collection<TraceRecord> literalMappingtraceRecords = literalMappingOperation
            .map(fullTrace.getTraceRecordMap()::get)
            .map(Collection.class::cast)
            .orElse(Collections.emptyList());

        Optional<String> foundLiteralId = literalMappingtraceRecords.stream()
            .filter(tr -> getContext(tr, Literal.class) == nodeLiteral)
            .map(tr -> getResult(tr, CompoundTerm.class))
            .map(term -> ((AtomicQuotedString) term.getArguments()
                .get(1)).getValue())
            .findFirst();

        return trace -> trace.addNodeLiteral(foundLiteralId.get(), object);
    }

    protected TraceEntry getCharacterizedComponentResult(String mappingName, Component object) {
        if (!isOperationNameEqual(mappingName)) {
            return null;
        }

        CompoundTerm term = getResultCompoundTerm();
        String processId = ((AtomicQuotedString) term.getArguments()
            .get(0)).getValue();
        return trace -> trace.addComponentEntry(processId, object);
    }

    @Override
    public TraceRecord getTraceRecord() {
        return traceRecord;
    }

}