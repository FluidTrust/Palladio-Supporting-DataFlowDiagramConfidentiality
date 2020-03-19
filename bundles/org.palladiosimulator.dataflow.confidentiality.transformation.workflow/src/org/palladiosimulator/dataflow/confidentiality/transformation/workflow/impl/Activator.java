package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.impl;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

	private static Activator instance = null;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		setInstance(this);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		setInstance(null);
	}
	
	public String getPluginId() {
		return this.getBundle().getSymbolicName();
	}
	
	public static Activator getInstance() {
		return instance;
	}

	protected static void setInstance(Activator instance) {
		Activator.instance = instance;
	}
	
}
