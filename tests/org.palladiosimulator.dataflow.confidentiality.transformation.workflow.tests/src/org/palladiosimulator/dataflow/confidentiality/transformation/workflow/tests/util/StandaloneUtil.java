package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.util;

import org.eclipse.emf.common.util.URI;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration.NameDerivationMethod;
import org.palladiosimulator.supporting.prolog.PrologStandaloneSetup;

import tools.mdsd.library.standalone.initialization.StandaloneInitializationException;
import tools.mdsd.library.standalone.initialization.StandaloneInitializer;
import tools.mdsd.library.standalone.initialization.StandaloneInitializerBuilder;
import tools.mdsd.library.standalone.initialization.log4j.Log4jInitilizationTask;

public class StandaloneUtil {

    private StandaloneUtil() {
        // intentionally left blank
    }

    public static void init() throws StandaloneInitializationException {
        StandaloneInitializer initializer = StandaloneInitializerBuilder.builder()
            .registerProjectURI(NameDerivationMethod.class,
                    "org.palladiosimulator.dataflow.confidentiality.transformation.prolog")
            .registerProjectURI(StandaloneUtil.class,
                    "org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests")
            .addCustomTask(new Log4jInitilizationTask())
            .addCustomTask(PrologStandaloneSetup::doSetup)
            .build();
        initializer.init();
    }

    public static URI getRelativeURI(String relativePath) {
        return URI.createPlatformPluginURI("/org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests/" + relativePath, false);
    }
}