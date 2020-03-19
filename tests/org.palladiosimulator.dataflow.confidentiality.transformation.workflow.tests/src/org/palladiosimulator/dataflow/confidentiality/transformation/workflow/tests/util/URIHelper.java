package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.util;

import org.eclipse.emf.common.util.URI;

public class URIHelper {

	private URIHelper() {
		
	}
	
	public static URI getRelativeURI(String relativePath) {
		return URI.createPlatformPluginURI("/org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests/" + relativePath, false);
	}
	
}
