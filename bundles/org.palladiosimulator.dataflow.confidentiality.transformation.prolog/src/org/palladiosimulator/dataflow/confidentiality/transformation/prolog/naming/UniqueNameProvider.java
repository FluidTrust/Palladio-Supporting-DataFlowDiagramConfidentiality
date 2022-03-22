package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Data;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Edge;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

public interface UniqueNameProvider {

    String getUniqueName(Edge entity);
    String getUniqueName(Node entity);
    String getUniqueName(CharacteristicType entity);
    String getUniqueName(Literal entity);
    String getUniqueName(DataType entity);
    String getUniqueName(Data entity);
    String getUniqueName(Pin pin, Node node);
    String getUniqueName(BehaviorDefinition behavior);
    
}
