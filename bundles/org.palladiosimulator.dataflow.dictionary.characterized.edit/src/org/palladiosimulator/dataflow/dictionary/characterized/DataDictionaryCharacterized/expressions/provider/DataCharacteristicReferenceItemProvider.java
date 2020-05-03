package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.CharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Term;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.provider.util.ItemPropertyDescriptorDecorator;

public class DataCharacteristicReferenceItemProvider extends DataCharacteristicReferenceItemProviderGen {

	public DataCharacteristicReferenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected void addPinPropertyDescriptor(Object object) {
		super.addPinPropertyDescriptor(object);
		IItemPropertyDescriptor originalItemDescriptor = itemPropertyDescriptors.remove(itemPropertyDescriptors.size() - 1);
		ItemPropertyDescriptorDecorator decorator = new ItemPropertyDescriptorDecorator(originalItemDescriptor) {

			@Override
			public Collection<?> getChoiceOfValues(Object thisObject) {
				Collection<?> originalChoice = super.getChoiceOfValues(thisObject);
				if (thisObject instanceof DataCharacteristicReference) {
					DataCharacteristicReference reference = (DataCharacteristicReference) thisObject;
					BehaviorDefinition behaviorDefinition = getParentOfType(reference, BehaviorDefinition.class);
					Collection<Pin> ownPins = originalChoice.stream().filter(Pin.class::isInstance).map(Pin.class::cast)
							.filter(pin -> pin.getOwner() == behaviorDefinition).collect(Collectors.toList());
					Term highestTerm = getLastParentOfType(reference, Term.class);
					EReference containmentFeature = highestTerm.eContainmentFeature();
					Predicate<Pin> predicate = p -> true;
					if (containmentFeature == DataDictionaryCharacterizedPackage.Literals.ASSIGNMENT__LHS) {
						predicate = p -> p.eContainmentFeature() == DataDictionaryCharacterizedPackage.Literals.BEHAVIOR_DEFINITION__OUTPUTS;
					} else if (containmentFeature == DataDictionaryCharacterizedPackage.Literals.ASSIGNMENT__RHS) {
						predicate = p -> p.eContainmentFeature() == DataDictionaryCharacterizedPackage.Literals.BEHAVIOR_DEFINITION__INPUTS;
					}
					return ownPins.stream().filter(predicate::test).collect(Collectors.toList());
				}
				return originalChoice;
			}

		};
		itemPropertyDescriptors.add(decorator);
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

	@SuppressWarnings("unchecked")
	protected static <T> T getLastParentOfType(EObject object, Class<T> parentClass) {
		EObject lastParent = object;
		EObject parent = lastParent;
		while (parent != null && parentClass.isInstance(parent)) {
			lastParent = parent;
			parent = parent.eContainer();
		}
		return (T) lastParent;
	}
	
	@SuppressWarnings("unchecked")
	protected static <T> T getParentOfType(EObject object, Class<T> parentClass) {
		EObject parent = object;
		while (parent != null && !parentClass.isInstance(parent)) {
			parent = parent.eContainer();
		}
		return (T) parent;
	}

}
