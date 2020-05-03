package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.provider.util.ItemPropertyDescriptorDecorator;

public class ContainerCharacteristicReferenceItemProvider extends ContainerCharacteristicReferenceItemProviderGen {

	public ContainerCharacteristicReferenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected void addLiteralPropertyDescriptor(Object object) {
		super.addLiteralPropertyDescriptor(object);
		IItemPropertyDescriptor originalItemDescriptor = itemPropertyDescriptors.remove(itemPropertyDescriptors.size() - 1);
		ItemPropertyDescriptorDecorator decorator = new ItemPropertyDescriptorDecorator(originalItemDescriptor) {

			@Override
			public Collection<?> getChoiceOfValues(Object thisObject) {
				Collection<?> originalChoice = super.getChoiceOfValues(thisObject);
				if (thisObject instanceof CharacteristicReference) {
					CharacteristicType characteristicType = ((CharacteristicReference) thisObject).getCharacteristicType();
					if (characteristicType instanceof EnumCharacteristicType) {
						Collection<Literal> literals = new ArrayList<>(((EnumCharacteristicType) characteristicType).getType().getLiterals());
						literals.add(null);
						return literals;
					}
				}
				return originalChoice;
			}

		};
		itemPropertyDescriptors.add(decorator);
	}
}
