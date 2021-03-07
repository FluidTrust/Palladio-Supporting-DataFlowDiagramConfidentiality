package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming;

import com.google.common.base.Strings;

public class DetailedUniqueNameProvider extends AbstractUniqueNameProvider {

    @Override
    protected String constructName(String name, String id) {
        if (Strings.isNullOrEmpty(name)) {
            return id;
        }
        return String.format("%s (%s)", name, id);
    }

}
