package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming;

public class ShortUniqueNameProvider extends IdShortingUniqueNameProvider {

    @Override
    protected String constructName(String name, String id) {
        return ID_COMPRESSOR.apply(name + id);
    }

}
