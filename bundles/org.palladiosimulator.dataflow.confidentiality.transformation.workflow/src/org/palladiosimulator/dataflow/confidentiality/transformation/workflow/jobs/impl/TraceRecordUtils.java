package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingContext;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingResults;
import org.eclipse.m2m.internal.qvt.oml.trace.EValue;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.internal.qvt.oml.trace.VarParameterValue;
import org.palladiosimulator.supporting.prolog.model.prolog.CompoundTerm;

@SuppressWarnings("restriction")
public interface TraceRecordUtils {

    TraceRecord getTraceRecord();

    default boolean isOperationNameEqual(String expectedName) {
        return expectedName.equals(getTraceRecord().getMappingOperation()
            .getName());
    }

    default CompoundTerm getResultCompoundTerm() {
        return getResult(CompoundTerm.class);
    }

    default <T extends EObject> T getResult(Class<T> clz) {
        return getResult(getTraceRecord(), clz);
    }

    default <T extends EObject> T getResult(TraceRecord traceRecord, Class<T> clz) {
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

    default <T extends EObject> T getContext(TraceRecord traceRecord, Class<T> clz) {
        return Optional.ofNullable(traceRecord.getContext())
            .map(EMappingContext::getContext)
            .map(VarParameterValue::getValue)
            .map(EValue::getModelElement)
            .filter(clz::isInstance)
            .map(clz::cast)
            .get();
    }

}
