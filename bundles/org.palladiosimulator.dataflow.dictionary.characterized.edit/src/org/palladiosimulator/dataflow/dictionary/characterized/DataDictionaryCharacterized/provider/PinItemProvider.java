package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

public class PinItemProvider extends PinItemProviderGen {

    /**
     * {@inheritDoc}
     */
    public PinItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText(Object object) {
        if (object instanceof Pin) {
            var pin = (Pin) object;
            String directionString = null;
            if (isInputPin(pin)) {
                directionString = "in";
            } else if (isOutputPin(pin)) {
                directionString = "out";
            }
            if (directionString != null) {
                return String.format("%s [%s] %s", getString("_UI_Pin_type"), directionString,
                        ((Pin) object).getName());
            }
        }
        return super.getText(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getImage(Object object) {
        if (object instanceof Pin) {
            var pin = (Pin) object;
            if (isInputPin(pin)) {
                return overlayImage(object, getResourceLocator().getImage("full/obj16/InputPin.png"));
            }
            if (isOutputPin(pin)) {
                return overlayImage(object, getResourceLocator().getImage("full/obj16/OutputPin.png"));
            }
        }
        return super.getImage(object);
    }

    protected boolean isInputPin(Pin pin) {
        return pin.eContainmentFeature() == DataDictionaryCharacterizedPackage.Literals.BEHAVIOR_DEFINITION__INPUTS;
    }

    protected boolean isOutputPin(Pin pin) {
        return pin.eContainmentFeature() == DataDictionaryCharacterizedPackage.Literals.BEHAVIOR_DEFINITION__OUTPUTS;
    }

}
