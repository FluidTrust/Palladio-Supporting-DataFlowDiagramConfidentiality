package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

public class CharacterizedExternalActorItemProvider extends CharacterizedExternalActorItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public CharacterizedExternalActorItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/CharacterizedExternalActor.png"));
    }

}
