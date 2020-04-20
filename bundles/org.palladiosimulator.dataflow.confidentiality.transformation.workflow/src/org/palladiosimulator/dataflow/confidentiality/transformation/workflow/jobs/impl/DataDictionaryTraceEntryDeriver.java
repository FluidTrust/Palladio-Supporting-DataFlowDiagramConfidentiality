package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.impl;

import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.util.DataDictionaryCharacterizedSwitch;
import org.palladiosimulator.supporting.prolog.model.prolog.AtomicQuotedString;

@SuppressWarnings("restriction")
public class DataDictionaryTraceEntryDeriver extends DataDictionaryCharacterizedSwitch<TraceEntry>
        implements TraceRecordUtils {

    private final TraceRecord traceRecord;

    public DataDictionaryTraceEntryDeriver(TraceRecord traceRecord) {
        this.traceRecord = traceRecord;
    }

    @Override
    public TraceRecord getTraceRecord() {
        return traceRecord;
    }

    @Override
    public TraceEntry caseEnumCharacteristicType(EnumCharacteristicType object) {
        if (!isOperationNameEqual("enumCharacteristicTypeToFactHead")) {
            return super.caseEnumCharacteristicType(object);
        }
        var factId = ((AtomicQuotedString) getResultCompoundTerm().getArguments()
            .get(0)).getValue();

        return trace -> trace.addCharacteristicTypeEntry(factId, object);
    }

    @Override
    public TraceEntry caseLiteral(Literal object) {
        if (!isOperationNameEqual("enumCharacteristicTypeLiteralToFactHead")) {
            return super.caseLiteral(object);
        }
        var factId = ((AtomicQuotedString) getResultCompoundTerm().getArguments()
            .get(1)).getValue();

        return trace -> trace.addLiteral(factId, object);
    }

}