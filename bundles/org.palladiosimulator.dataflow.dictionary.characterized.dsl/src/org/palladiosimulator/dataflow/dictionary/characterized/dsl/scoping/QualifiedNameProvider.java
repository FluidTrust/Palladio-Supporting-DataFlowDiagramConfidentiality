package org.palladiosimulator.dataflow.dictionary.characterized.dsl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

import com.google.common.base.Function;

public class QualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

    @Override
    protected Function<EObject, String> getResolver() {
        return eobject -> {
            var originalName = super.getResolver().apply(eobject);
            if (eobject instanceof Pin) {
                var containmentFeature = eobject.eContainmentFeature();
                var discriminator = "";
                if (containmentFeature == DataDictionaryCharacterizedPackage.Literals.BEHAVIOR_DEFINITION__INPUTS) {
                    discriminator = "inputs";
                } else if (containmentFeature == DataDictionaryCharacterizedPackage.Literals.BEHAVIOR_DEFINITION__OUTPUTS) {
                    discriminator = "outputs";
                }
                return String.format("%s.%s", discriminator, originalName);
            }
            return originalName;
        };
    }

}
