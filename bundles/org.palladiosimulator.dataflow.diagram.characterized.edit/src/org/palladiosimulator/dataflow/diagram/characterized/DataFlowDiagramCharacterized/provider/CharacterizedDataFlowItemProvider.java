package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Entity;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.provider.util.ItemPropertyDescriptorDecorator;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;

public class CharacterizedDataFlowItemProvider extends CharacterizedDataFlowItemProviderGen {

	public CharacterizedDataFlowItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected void addSourcePinPropertyDescriptor(Object object) {
		super.addSourcePinPropertyDescriptor(object);
		IItemPropertyDescriptor originalItemDescriptor = itemPropertyDescriptors.remove(itemPropertyDescriptors.size() - 1);
		ItemPropertyDescriptorDecorator decorator = new ItemPropertyDescriptorDecorator(originalItemDescriptor) {

			@Override
			public Collection<?> getChoiceOfValues(Object thisObject) {
				Collection<?> originalChoice = super.getChoiceOfValues(thisObject);
				if (thisObject instanceof CharacterizedDataFlow) {
					Node sourceNode = ((CharacterizedDataFlow) thisObject).getSource();
					if (sourceNode instanceof Behaving) {
						return Optional.ofNullable(((Behaving) sourceNode).getBehavior())
								.map(BehaviorDefinition::getOutputs).map(Collection.class::cast)
								.orElse(Collections.emptyList());
					}
				}
				return originalChoice;
			}

		};
		itemPropertyDescriptors.add(decorator);
	}

	@Override
	protected void addTargetPinPropertyDescriptor(Object object) {
		super.addTargetPinPropertyDescriptor(object);
		IItemPropertyDescriptor originalItemDescriptor = itemPropertyDescriptors.remove(itemPropertyDescriptors.size() - 1);
		ItemPropertyDescriptorDecorator decorator = new ItemPropertyDescriptorDecorator(originalItemDescriptor) {

			@Override
			public Collection<?> getChoiceOfValues(Object thisObject) {
				Collection<?> originalChoice = super.getChoiceOfValues(thisObject);
				if (thisObject instanceof CharacterizedDataFlow) {
					Node destinationNode = ((CharacterizedDataFlow) thisObject).getTarget();
					if (destinationNode instanceof Behaving) {
						return Optional.ofNullable(((Behaving) destinationNode).getBehavior())
								.map(BehaviorDefinition::getInputs).map(Collection.class::cast)
								.orElse(Collections.emptyList());
					}
				}
				return originalChoice;
			}

		};
		itemPropertyDescriptors.add(decorator);
	}

	@Override
	protected void addSourcePropertyDescriptor(Object object) {
		super.addSourcePropertyDescriptor(object);
		IItemPropertyDescriptor originalItemDescriptor = itemPropertyDescriptors.remove(itemPropertyDescriptors.size() - 1);
		ItemPropertyDescriptorDecorator decorator = new ItemPropertyDescriptorDecorator(originalItemDescriptor) {

			@Override
			public Collection<?> getChoiceOfValues(Object thisObject) {
				Collection<?> originalChoice = super.getChoiceOfValues(thisObject);
				return originalChoice.stream().filter(
						node -> !(node instanceof Behaving) || Optional.ofNullable(((Behaving) node).getBehavior())
								.map(BehaviorDefinition::getOutputs).map(c -> !c.isEmpty()).orElse(false))
						.collect(Collectors.toList());
			}

		};
		itemPropertyDescriptors.add(decorator);
	}

	@Override
	protected void addTargetPropertyDescriptor(Object object) {
		super.addTargetPropertyDescriptor(object);
		IItemPropertyDescriptor originalItemDescriptor = itemPropertyDescriptors.remove(itemPropertyDescriptors.size() - 1);
		ItemPropertyDescriptorDecorator decorator = new ItemPropertyDescriptorDecorator(originalItemDescriptor) {

			@Override
			public Collection<?> getChoiceOfValues(Object thisObject) {
				Collection<?> originalChoice = super.getChoiceOfValues(thisObject);
				return originalChoice.stream().filter(
						node -> !(node instanceof Behaving) || Optional.ofNullable(((Behaving) node).getBehavior())
								.map(BehaviorDefinition::getInputs).map(c -> !c.isEmpty()).orElse(false))
						.collect(Collectors.toList());
			}

		};
		itemPropertyDescriptors.add(decorator);
	}

	@Override
	public String getText(Object object) {
		if (object instanceof CharacterizedDataFlow) {
			CharacterizedDataFlow flow = (CharacterizedDataFlow) object;
			return String.format("%s %s: %s.%s -> %s.%s", getString("_UI_CharacterizedDataFlow_type"),
					getNameSafe(flow), getNameSafe(flow.getSource()), getNameSafe(flow.getSourcePin()),
					getNameSafe(flow.getTarget()), getNameSafe(flow.getTargetPin()));
		}
		return super.getText(object);
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		
		switch (notification.getFeatureID(CharacterizedDataFlow.class))
		{
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__SOURCE:
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__SOURCE_PIN:
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__TARGET:
			case DataFlowDiagramCharacterizedPackage.CHARACTERIZED_DATA_FLOW__TARGET_PIN:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
	}

	private Object getNameSafe(Pin pin) {
		return Optional.ofNullable(pin).map(Pin::getName).orElse("");
	}

	private static String getNameSafe(Entity entity) {
		return Optional.ofNullable(entity).map(Entity::getName).orElse("");
	}
	
	
}
