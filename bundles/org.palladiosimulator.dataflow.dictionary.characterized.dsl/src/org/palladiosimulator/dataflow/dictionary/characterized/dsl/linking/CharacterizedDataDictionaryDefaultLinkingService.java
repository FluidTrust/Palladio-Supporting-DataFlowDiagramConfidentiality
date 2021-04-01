package org.palladiosimulator.dataflow.dictionary.characterized.dsl.linking;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Enumeration;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage;

import com.google.inject.Inject;

public class CharacterizedDataDictionaryDefaultLinkingService extends DefaultLinkingService {

    @Inject
    private IValueConverterService valueConverterService;

    @SuppressWarnings("unchecked")
    @Override
    public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
        var defaultLinkedObjects = super.getLinkedObjects(context, ref, node);

        if (ref == ExpressionsPackage.Literals.ENUM_CHARACTERISTIC_REFERENCE__LITERAL) {
            return Optional.ofNullable(context)
                .filter(CharacteristicReference.class::isInstance)
                .map(CharacteristicReference.class::cast)
                .map(CharacteristicReference::getCharacteristicType)
                .filter(EnumCharacteristicType.class::isInstance)
                .map(EnumCharacteristicType.class::cast)
                .map(EnumCharacteristicType::getType)
                .map(Enumeration::getLiterals)
                .map(literals -> filterLiteralsByNode(literals, node))
                .map(((Class<List<EObject>>) ((Class<?>) List.class))::cast)
                .orElse(defaultLinkedObjects);
        }

        return defaultLinkedObjects;
    }

    protected List<Literal> filterLiteralsByNode(List<Literal> literals, INode node) {
        var nodeText = Optional.ofNullable(node)
            .map(INode::getText)
            .map(text -> valueConverterService.toValue(text, "NameString", node))
            .map(String.class::cast);
        if (nodeText.isEmpty()) {
            return literals;
        }
        return literals.stream()
            .filter(l -> l.getName()
                .equals(nodeText.get()))
            .collect(Collectors.toList());
    }

}
