/**
 */
package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.provider;

import de.uka.ipd.sdq.identifier.provider.IdentifierEditPlugin;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.provider.DataFlowDiagramEditPlugin;

import org.palladiosimulator.dataflow.dictionary.DataDictionary.provider.DataDictionaryEditPlugin;

import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.provider.DataDictionaryCharacterizedEditPlugin;

/**
 * This is the central singleton for the DataFlowDiagramCharacterized edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class DataFlowDiagramCharacterizedEditPlugin extends EMFPlugin
{
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final DataFlowDiagramCharacterizedEditPlugin INSTANCE = new DataFlowDiagramCharacterizedEditPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowDiagramCharacterizedEditPlugin()
	{
		super
		  (new ResourceLocator [] {
		     DataDictionaryEditPlugin.INSTANCE,
		     DataDictionaryCharacterizedEditPlugin.INSTANCE,
		     DataFlowDiagramEditPlugin.INSTANCE,
		     IdentifierEditPlugin.INSTANCE,
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator()
	{
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin()
	{
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin
	{
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation()
		{
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

}
