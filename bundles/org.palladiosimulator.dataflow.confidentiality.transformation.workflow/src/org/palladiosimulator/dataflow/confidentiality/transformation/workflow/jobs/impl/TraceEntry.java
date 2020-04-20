package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.impl;

import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.impl.DFD2PrologTransformationTraceImpl;

@FunctionalInterface
public interface TraceEntry {

    void applyToTrace(DFD2PrologTransformationTraceImpl trace);
    
}
