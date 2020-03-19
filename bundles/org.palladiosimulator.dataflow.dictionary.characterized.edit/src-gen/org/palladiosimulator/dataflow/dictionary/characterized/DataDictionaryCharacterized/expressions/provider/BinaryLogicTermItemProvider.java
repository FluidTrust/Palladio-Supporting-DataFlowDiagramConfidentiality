/**
 */
package org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsFactory;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsPackage;

/**
 * This is the item provider adapter for a {@link org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BinaryLogicTermItemProvider extends LogicTermItemProvider
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryLogicTermItemProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
	{
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
	{
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__LEFT);
			childrenFeatures.add(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__RIGHT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child)
	{
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object)
	{
		String label = ((BinaryLogicTerm)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_BinaryLogicTerm_type") :
			getString("_UI_BinaryLogicTerm_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification)
	{
		updateChildren(notification);

		switch (notification.getFeatureID(BinaryLogicTerm.class)) {
			case ExpressionsPackage.BINARY_LOGIC_TERM__LEFT:
			case ExpressionsPackage.BINARY_LOGIC_TERM__RIGHT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
	{
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__LEFT,
				 ExpressionsFactory.eINSTANCE.createTrue()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__LEFT,
				 ExpressionsFactory.eINSTANCE.createFalse()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__LEFT,
				 ExpressionsFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__LEFT,
				 ExpressionsFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__LEFT,
				 ExpressionsFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__LEFT,
				 ExpressionsFactory.eINSTANCE.createContainerCharacteristicReference()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__LEFT,
				 ExpressionsFactory.eINSTANCE.createDataCharacteristicReference()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__RIGHT,
				 ExpressionsFactory.eINSTANCE.createTrue()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__RIGHT,
				 ExpressionsFactory.eINSTANCE.createFalse()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__RIGHT,
				 ExpressionsFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__RIGHT,
				 ExpressionsFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__RIGHT,
				 ExpressionsFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__RIGHT,
				 ExpressionsFactory.eINSTANCE.createContainerCharacteristicReference()));

		newChildDescriptors.add
			(createChildParameter
				(ExpressionsPackage.Literals.BINARY_LOGIC_TERM__RIGHT,
				 ExpressionsFactory.eINSTANCE.createDataCharacteristicReference()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection)
	{
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ExpressionsPackage.Literals.BINARY_LOGIC_TERM__LEFT ||
			childFeature == ExpressionsPackage.Literals.BINARY_LOGIC_TERM__RIGHT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
