package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.impl;

import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.DFD2PrologTransformationTrace;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Entity;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Behaving;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;
import org.palladiosimulator.supporting.prolog.model.prolog.Program;

public interface DFD2PrologTransformationWritableTrace extends DFD2PrologTransformationTrace {

    void add (DataFlowDiagram dfd, Program program);
    
    void add(Entity entity, String factId);

    void add(org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Entity entity,
            String factId);

    void add(Behaving entity, Pin pin, String factId);
    
    void add(DataType dataType, String factId);
}
