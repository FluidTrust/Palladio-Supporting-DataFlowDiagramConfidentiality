/*
 * generated by Xtext 2.23.0
 */
package org.palladiosimulator.dataflow.dictionary.characterized.dsl;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.palladiosimulator.dataflow.dictionary.characterized.dsl.converter.CharacterizedDataDictionaryValueConverter;
import org.palladiosimulator.dataflow.dictionary.characterized.dsl.linking.CharacterizedDataDictionaryDefaultLinkingService;
import org.palladiosimulator.dataflow.dictionary.characterized.dsl.scoping.QualifiedNameProvider;
import org.palladiosimulator.dataflow.dictionary.characterized.dsl.service.CharacterizedDataDictionaryDerivedStateComputer;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension
 * registry.
 */
public class CharacterizedDataDictionaryRuntimeModule extends AbstractCharacterizedDataDictionaryRuntimeModule {

    @Override
    public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
        return QualifiedNameProvider.class;
    }

    @Override
    public Class<? extends ILinkingService> bindILinkingService() {
        return CharacterizedDataDictionaryDefaultLinkingService.class;
    }

    @Override
    public Class<? extends IValueConverterService> bindIValueConverterService() {
        return CharacterizedDataDictionaryValueConverter.class;
    }

    public Class<? extends IDerivedStateComputer> bindIDerivedStateComputer() {
        return CharacterizedDataDictionaryDerivedStateComputer.class;
    }

    @Override
    public Class<? extends XtextResource> bindXtextResource() {
        return DerivedStateAwareResource.class;
    }

    public Class<? extends IResourceDescription.Manager> bindIResourceDescriptionManager() {
        return DerivedStateAwareResourceDescriptionManager.class;
    }

}
