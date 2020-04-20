package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.impl;

import java.util.Arrays;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.ComposedSwitch;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;

@SuppressWarnings("restriction")
public class TraceEntryDeriver {

    private ComposedSwitch<TraceEntry> composedSwitch;

    public TraceEntryDeriver(TraceRecord traceRecord) {
        composedSwitch = new ComposedSwitch<>(Arrays.asList(new DataDictionaryTraceEntryDeriver(traceRecord),
                new DataFlowDiagramTraceEntryDeriver(traceRecord)));
    }

    public Optional<TraceEntry> getTraceEntry(EObject contextElement) {
        return Optional.ofNullable(composedSwitch.doSwitch(contextElement));
    }

    public static TraceEntryDeriver create(TraceRecord traceRecord) {
        return new TraceEntryDeriver(traceRecord);
    }

}
