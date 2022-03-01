package org.palladiosimulator.dataflow.dictionary.characterized.dsl.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Strings;

public class XPathConstructor {

    public String getId(EObject eobject, String baseId) {
        var constructedIndex = getIndexBasedSuffix(eobject);
        if (Strings.isNullOrEmpty(constructedIndex)) {
            return baseId;
        }
        return baseId + "-" + constructedIndex;
    }

    protected String getIndexBasedSuffix(EObject object) {
        var segments = new ArrayList<String>();
        for (var current = object; current.eContainer() != null; current = current.eContainer()) {
            var index = getIndexInContainment(current);
            var name = getContainmentName(current);
            segments.add(name + "@" + index);
        }
        Collections.reverse(segments);
        return segments.stream()
            .collect(Collectors.joining("."));
    }

    protected int getIndexInContainment(EObject object) {
        var containmentReference = object.eContainmentFeature();
        var containmentContent = object.eContainer()
            .eGet(containmentReference);
        return Optional.ofNullable(containmentContent)
            .filter(List.class::isInstance)
            .map(List.class::cast)
            .map(c -> c.indexOf(object))
            .orElse(0);
    }

    protected String getContainmentName(EObject object) {
        return object.eContainmentFeature()
            .getName();
    }

}
