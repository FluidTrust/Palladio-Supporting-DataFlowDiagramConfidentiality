package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

public class PinItemProvider extends PinItemProviderGen {

	public PinItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		if (object instanceof Pin) {
			String directionString = null;
			EReference containmentReference = ((Pin) object).eContainmentFeature();
			if (containmentReference == DataDictionaryCharacterizedPackage.Literals.BEHAVIOR_DEFINITION__INPUTS) {
				directionString = "in";
			} else if (containmentReference == DataDictionaryCharacterizedPackage.Literals.BEHAVIOR_DEFINITION__OUTPUTS) {
				directionString = "out";
			}
			if (directionString != null) {
				return String.format("%s [%s] %s", getString("_UI_Pin_type"), directionString, ((Pin) object).getName());
			}
		}
		return super.getText(object);
	}


}
