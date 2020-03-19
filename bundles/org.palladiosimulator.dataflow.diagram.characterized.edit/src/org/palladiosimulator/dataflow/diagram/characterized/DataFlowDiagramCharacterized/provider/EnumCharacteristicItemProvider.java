package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.provider.util.ItemPropertyDescriptorDecorator;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;

public class EnumCharacteristicItemProvider extends EnumCharacteristicItemProviderGen {

	public EnumCharacteristicItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected void addValuesPropertyDescriptor(Object object) {
		super.addValuesPropertyDescriptor(object);
		IItemPropertyDescriptor originalItemDescriptor = itemPropertyDescriptors.remove(itemPropertyDescriptors.size() - 1);
		ItemPropertyDescriptorDecorator decorator = new ItemPropertyDescriptorDecorator(originalItemDescriptor) {

			@Override
			public Collection<?> getChoiceOfValues(Object thisObject) {
				Collection<?> originalChoice = super.getChoiceOfValues(thisObject);
				if (thisObject instanceof EnumCharacteristic) {
					CharacteristicType characteristicType = ((EnumCharacteristic) thisObject).getType();
					if (characteristicType instanceof EnumCharacteristicType) {
						return ((EnumCharacteristicType) characteristicType).getType().getLiterals();
					}
				}
				return originalChoice;
			}

		};
		itemPropertyDescriptors.add(decorator);
	}

}
