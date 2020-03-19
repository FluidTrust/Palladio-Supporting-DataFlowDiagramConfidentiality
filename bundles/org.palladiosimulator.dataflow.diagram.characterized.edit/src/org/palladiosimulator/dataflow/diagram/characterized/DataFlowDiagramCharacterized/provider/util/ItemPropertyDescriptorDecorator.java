package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.provider.util;

import java.util.Collection;

import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

public class ItemPropertyDescriptorDecorator implements IItemPropertyDescriptor {

	private final IItemPropertyDescriptor descriptor;

	public ItemPropertyDescriptorDecorator(IItemPropertyDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	public Object getPropertyValue(Object object) {
		return descriptor.getPropertyValue(object);
	}

	public boolean isPropertySet(Object object) {
		return descriptor.isPropertySet(object);
	}

	public boolean canSetProperty(Object object) {
		return descriptor.canSetProperty(object);
	}

	public void resetPropertyValue(Object object) {
		descriptor.resetPropertyValue(object);
	}

	public void setPropertyValue(Object object, Object value) {
		descriptor.setPropertyValue(object, value);
	}

	public String getCategory(Object object) {
		return descriptor.getCategory(object);
	}

	public String getDescription(Object object) {
		return descriptor.getDescription(object);
	}

	public String getDisplayName(Object object) {
		return descriptor.getDisplayName(object);
	}

	public String[] getFilterFlags(Object object) {
		return descriptor.getFilterFlags(object);
	}

	public Object getHelpContextIds(Object object) {
		return descriptor.getHelpContextIds(object);
	}

	public String getId(Object object) {
		return descriptor.getId(object);
	}

	public IItemLabelProvider getLabelProvider(Object object) {
		return descriptor.getLabelProvider(object);
	}

	public boolean isCompatibleWith(Object object, Object anotherObject,
			IItemPropertyDescriptor anotherPropertyDescriptor) {
		return descriptor.isCompatibleWith(object, anotherObject, anotherPropertyDescriptor);
	}

	public Object getFeature(Object object) {
		return descriptor.getFeature(object);
	}

	public boolean isMany(Object object) {
		return descriptor.isMany(object);
	}

	public Collection<?> getChoiceOfValues(Object object) {
		return descriptor.getChoiceOfValues(object);
	}

	public boolean isMultiLine(Object object) {
		return descriptor.isMultiLine(object);
	}

	public boolean isSortChoices(Object object) {
		return descriptor.isSortChoices(object);
	}

}
