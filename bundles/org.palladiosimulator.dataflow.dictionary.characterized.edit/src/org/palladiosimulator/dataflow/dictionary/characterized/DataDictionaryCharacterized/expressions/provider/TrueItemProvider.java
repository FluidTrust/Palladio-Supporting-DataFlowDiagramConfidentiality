package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

public class TrueItemProvider extends TrueItemProviderGen {

    public TrueItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    @Override
    public String getText(Object object) {
        return getString("_UI_True_type");
    }

}
