package org.palladiosimulator.dataflow.confidentiality.transformation.prolog;

import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming.DetailedUniqueNameProvider;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming.IdShortingUniqueNameProvider;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming.ShortUniqueNameProvider;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming.UniqueNameProvider;

public enum NameGenerationStrategie {

    SHORT(new ShortUniqueNameProvider()), DETAILED(new DetailedUniqueNameProvider()), SHORTED_ID(
            new IdShortingUniqueNameProvider());

    private final UniqueNameProvider nameProvider;

    NameGenerationStrategie(UniqueNameProvider nameProvider) {
        this.nameProvider = nameProvider;
    }

    public UniqueNameProvider getNameProvider() {
        return nameProvider;
    }
}
