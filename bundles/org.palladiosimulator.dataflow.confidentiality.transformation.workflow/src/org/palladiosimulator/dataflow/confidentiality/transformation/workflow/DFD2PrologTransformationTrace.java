package org.palladiosimulator.dataflow.confidentiality.transformation.workflow;

import java.util.Collection;
import java.util.function.Predicate;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Component;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;

public interface DFD2PrologTransformationTrace {

    DataFlowDiagram getDfd();

    String getFactId(Literal characteristicLiteral);
    
    String getFactId(CharacteristicType characteristicType);

    String getFactId(Component dfdComponent);

    Collection<String> getFactId(Predicate<CharacteristicType> predicate);
    
    String getLiteralFactId(Component dfdComponent);

    /**
     * Resolves nodes and literals of the nodes enumeration.
     * 
     * @param factId
     * @return
     */
    Component getDfdComponent(String factId);

    CharacteristicType getCharacteristicType(String factId);
    
    Literal getLiteral(String factId);

}
