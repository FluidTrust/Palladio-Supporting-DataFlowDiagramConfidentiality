package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

public class FalseItemProvider extends FalseItemProviderGen {

    public FalseItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    @Override
    public String getText(Object object) {
        return getString("_UI_False_type");
    }

}
