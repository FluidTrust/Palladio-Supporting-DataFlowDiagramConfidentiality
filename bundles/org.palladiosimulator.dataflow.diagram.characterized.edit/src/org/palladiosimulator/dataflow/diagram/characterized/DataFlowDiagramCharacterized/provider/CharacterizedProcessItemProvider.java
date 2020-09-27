package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

public class CharacterizedProcessItemProvider extends CharacterizedProcessItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public CharacterizedProcessItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/CharacterizedProcess.png"));
    }

}
