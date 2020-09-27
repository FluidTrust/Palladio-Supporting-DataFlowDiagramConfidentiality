package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.provider;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;

public class BehaviorDefinitionItemProvider extends BehaviorDefinitionItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public BehaviorDefinitionItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    @Override
    public Object getCreateChildImage(Object owner, Object feature, Object child, Collection<?> selection) {
        if (Arrays
            .asList(DataDictionaryCharacterizedPackage.Literals.BEHAVIOR_DEFINITION__INPUTS,
                    DataDictionaryCharacterizedPackage.Literals.BEHAVIOR_DEFINITION__OUTPUTS)
            .contains(feature)) {
            var reference = (EReference) feature;
            String name = "full/ctool16/Create" + reference.getEContainingClass()
                .getName() + "_" + reference.getName();
            if (child instanceof EObject) {
                name += "_" + ((EObject) child).eClass()
                    .getName();
            }
            name += ".png";
            return getResourceLocator().getImage(name);
        }
        return super.getCreateChildImage(owner, feature, child, selection);
    }

}
