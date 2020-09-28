package org.palladiosimulator.dataflow.confidentiality.defaultmodels;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;

public final class DefaultModelConstants {

    public static final URI DEFAULT_CHARACTERISTIC_TYPES_MODEL = URI
        .createURI("pathmap://DFD_DEFAULT_MODELS/defaultCharacteristicTypes.xmi");
    public static final String CT_TRAVERSED_NODES_ID = "_067sYYISEeqR5tyIqE6kZA";

    public static final URI DEFAULT_BEHAVIOR_TYPES_MODEL = URI
        .createURI("pathmap://DFD_DEFAULT_MODELS/defaultBehaviors.xmi");
    public static final String BEHAVIOR_STORE_ID = "_sIUX5QFhEeugPIAarorGFw";

    private DefaultModelConstants() {
        // intentionally left blank
    }

    public static Collection<URI> getDefaultDataDictionaries() {
        return Arrays.asList(DEFAULT_BEHAVIOR_TYPES_MODEL, DEFAULT_CHARACTERISTIC_TYPES_MODEL);
    }
}
