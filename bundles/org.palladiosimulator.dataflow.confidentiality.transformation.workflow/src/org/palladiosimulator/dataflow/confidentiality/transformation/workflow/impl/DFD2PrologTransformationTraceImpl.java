package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.impl;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.DFD2PrologTransformationTrace;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Component;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class DFD2PrologTransformationTraceImpl implements DFD2PrologTransformationTrace {

    private final BiMap<String, CharacteristicType> characteristicTypeMap = HashBiMap.create();
    private final BiMap<String, Component> componentMap = HashBiMap.create();
    private final BiMap<String, Component> nodeLiteralMap = HashBiMap.create();
    private final BiMap<String, Literal> literalMap = HashBiMap.create();
    private DataFlowDiagram dfd;

    public void addComponentEntry(String factId, Component dfdComponent) {
        componentMap.put(factId, dfdComponent);
        if (dfd == null) {
            dfd = (DataFlowDiagram) dfdComponent.eContainer();
        }
    }

    public void addCharacteristicTypeEntry(String factId, CharacteristicType characteristicType) {
        characteristicTypeMap.put(factId, characteristicType);
    }

    public void addNodeLiteral(String characteristicValueId, Node object) {
        nodeLiteralMap.put(characteristicValueId, object);
    }

    public void addLiteral(String factId, Literal object) {
        literalMap.put(factId, object);
    }

    @Override
    public String getFactId(Component dfdComponent) {
        return componentMap.inverse()
            .get(dfdComponent);
    }

    @Override
    public Component getDfdComponent(String factId) {
        if (nodeLiteralMap.containsKey(factId)) {
            return nodeLiteralMap.get(factId);
        }
        return componentMap.get(factId);
    }

    @Override
    public DataFlowDiagram getDfd() {
        return dfd;
    }

    @Override
    public String getFactId(CharacteristicType characteristicType) {
        return characteristicTypeMap.inverse()
            .get(characteristicType);
    }

    @Override
    public CharacteristicType getCharacteristicType(String factId) {
        return characteristicTypeMap.get(factId);
    }
    
    @Override
    public Collection<String> getFactId(Predicate<CharacteristicType> predicate) {
        return characteristicTypeMap.values()
            .stream()
            .filter(predicate)
            .map(characteristicTypeMap.inverse()::get)
            .collect(Collectors.toList());
    }

    @Override
    public String getLiteralFactId(Component dfdComponent) {
        return nodeLiteralMap.inverse().get(dfdComponent);
    }

    @Override
    public String getFactId(Literal characteristicLiteral) {
        return literalMap.inverse().get(characteristicLiteral);
    }

    @Override
    public Literal getLiteral(String factId) {
        return literalMap.get(factId);
    }


//    @Override
//    public String getLiteralFactId(DataType dataType) {
//        return dataTypeLiteralMap.inverse().get(dataType);
//    }
//
//    @Override
//    public DataType getDataTypeByLiteralId(String factId) {
//        return dataTypeLiteralMap.get(factId);
//    }

}
