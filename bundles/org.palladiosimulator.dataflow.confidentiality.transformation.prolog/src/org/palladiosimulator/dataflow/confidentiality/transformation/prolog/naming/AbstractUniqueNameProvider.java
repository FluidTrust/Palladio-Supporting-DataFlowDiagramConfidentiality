package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Data;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Edge;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

public abstract class AbstractUniqueNameProvider implements UniqueNameProvider {

    @Override
    public String getUniqueName(Edge entity) {
        return constructName(entity.getName(), entity.getId());
    }

    @Override
    public String getUniqueName(Node entity) {
        return constructName(entity.getName(), entity.getId());
    }

    @Override
    public String getUniqueName(CharacteristicType entity) {
        return constructName(entity.getName(), entity.getId());
    }

    @Override
    public String getUniqueName(Literal entity) {
        return constructName(entity.getName(), entity.getId());
    }
    
    @Override
    public String getUniqueName(DataType entity) {
        return constructName(entity.getName(), entity.getId());
    }
    
    @Override
    public String getUniqueName(Data entity) {
        return constructName(entity.getName(), entity.getId());
    }

    @Override
    public String getUniqueName(Pin pin, Node node) {
        return constructName(pin.getName(), pin.getId() + node.getId());
    }

    @Override
    public String getUniqueName(BehaviorDefinition behavior) {
        return constructName(behavior.getName(), behavior.getId());
    }

    protected abstract String constructName(String name, String id);
    
}
