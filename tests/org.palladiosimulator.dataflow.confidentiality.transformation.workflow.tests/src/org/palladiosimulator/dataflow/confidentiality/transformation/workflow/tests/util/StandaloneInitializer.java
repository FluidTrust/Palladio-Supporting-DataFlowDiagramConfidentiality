package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.util;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod;
import org.palladiosimulator.supporting.prolog.PrologStandaloneSetup;

public class StandaloneInitializer {

	private StandaloneInitializer() {

	}

	/**
	 * Initializes EMF, OCL, and the Prolog printer/parser for standalone usage if
	 * running in standalone mode. In addition, required project URIs are
	 * registered.
	 */
	public static void init() {
		if (!Platform.isRunning()) {
			// OCL initialization
			OCL.initialize(null);
			OCLDelegateDomain.initialize(null);

			// Detection of Meta Models and URIs by classpath magic
			// https://wiki.eclipse.org/EMF/FAQ#How_do_I_make_my_EMF_standalone_application_Eclipse-aware.3F
			EcorePlugin.ExtensionProcessor.process(null);

			// standalone language initializations
			registerProjectURI(NameDerivationMethod.class, "org.palladiosimulator.dataflow.confidentiality.transformation.prolog");
			registerProjectURI(StandaloneInitializer.class,
					"org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests");
		}
		
		// Prolog initialization
		PrologStandaloneSetup.doSetup();

		// initialize log4j logging
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure(new ConsoleAppender(new PatternLayout("%m%n")));
	}

	/**
	 * Registers the project path derived from a class of this project under the
	 * given project name.
	 * 
	 * As a result, the platform:/resource/ URI belonging to the project is
	 * registered. In addition, a URI mapping from the corresponding plugin URI to
	 * the resource URI is registered.
	 * 
	 * @param clz         The class to derive the project path from.
	 * @param projectName The project name to register the path to.
	 */
	private static void registerProjectURI(Class<?> clz, String projectName) {
		File location = getProjectLocation(clz, projectName);
		URI projectURI = URI.createFileURI(location.getAbsolutePath()).appendSegment("");
		EcorePlugin.getPlatformResourceMap().put(projectName, projectURI);
		URI pluginURI = URI.createPlatformPluginURI("/" + projectName + "/", false);
		URI platformURI = URI.createPlatformResourceURI("/" + projectName + "/", false);
		URIMappingRegistryImpl.INSTANCE.put(pluginURI, platformURI);
	}

	/**
	 * Determine the location of a project from a given class.
	 * 
	 * This method assumes that the project name is part of the path. If this is not
	 * the case, the method will fail.
	 * 
	 * @param clz         The class to derive the project path from.
	 * @param projectName The name of the project to be found.
	 * @return Location of the project root.
	 */
	private static File getProjectLocation(Class<?> clz, String projectName) {
		String classLocation = clz.getProtectionDomain().getCodeSource().getLocation().getPath();
		String projectLocation = classLocation.substring(0, classLocation.indexOf(projectName) + projectName.length());
		return new File(projectLocation);
	}

}
