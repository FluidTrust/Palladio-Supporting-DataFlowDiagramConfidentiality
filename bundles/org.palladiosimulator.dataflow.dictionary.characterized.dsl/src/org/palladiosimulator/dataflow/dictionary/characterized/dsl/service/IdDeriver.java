package org.palladiosimulator.dataflow.dictionary.characterized.dsl.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.ComposedSwitch;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataType;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.Entry;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.util.DataDictionarySwitch;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Enumeration;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.util.DataDictionaryCharacterizedSwitch;

public class IdDeriver {

    protected static class SuffixDeriverDataDictionaryCharacterized extends DataDictionaryCharacterizedSwitch<String> {

        @Override
        public String caseEnumCharacteristicType(EnumCharacteristicType object) {
            return getIndexBasedSuffix(object);
        }

        @Override
        public String caseEnumeration(Enumeration object) {
            return getIndexBasedSuffix(object);
        }

        @Override
        public String caseLiteral(Literal object) {
            return getIndexBasedSuffix(object);
        }

        @Override
        public String caseBehaviorDefinition(BehaviorDefinition object) {
            return getIndexBasedSuffix(object);
        }

        @Override
        public String casePin(Pin object) {
            return getIndexBasedSuffix(object);
        }

    }

    protected static class SuffixDeriverDataDictionary extends DataDictionarySwitch<String> {

        @Override
        public String caseDataType(DataType object) {
            return getIndexBasedSuffix(object);
        }

        @Override
        public String caseEntry(Entry object) {
            return getIndexBasedSuffix(object);
        }

    }

    private final Switch<String> suffixSwitch;

    public IdDeriver() {
        suffixSwitch = new ComposedSwitch<>(
                Arrays.asList(new SuffixDeriverDataDictionaryCharacterized(), new SuffixDeriverDataDictionary()));
    }

    public Optional<String> getId(EObject eobject, String baseId) {
        return Optional.ofNullable(suffixSwitch.doSwitch(eobject))
            .map(suffix -> baseId + "-" + suffix);
    }

    protected static String getIndexBasedSuffix(EObject object) {
        List<String> segments = new ArrayList<String>();
        for (var current = object; current.eContainer() != null; current = current.eContainer()) {
            var index = getIndexInContainment(current);
            var name = getContainmentName(current);
            segments.add(name + "@" + index);
        }
        Collections.reverse(segments);
        return segments.stream()
            .collect(Collectors.joining("."));
    }

    protected static int getIndexInContainment(EObject object) {
        var containmentReference = object.eContainmentFeature();
        var containmentContent = object.eContainer()
            .eGet(containmentReference);
        return Optional.ofNullable(containmentContent)
            .filter(List.class::isInstance)
            .map(List.class::cast)
            .map(c -> c.indexOf(object))
            .orElse(0);
    }

    protected static String getContainmentName(EObject object) {
        return object.eContainmentFeature()
            .getName();
    }

}
