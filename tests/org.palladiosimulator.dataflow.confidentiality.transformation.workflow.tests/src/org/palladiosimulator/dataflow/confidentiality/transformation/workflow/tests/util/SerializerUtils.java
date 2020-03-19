package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

import org.eclipse.emf.ecore.resource.Resource;

public class SerializerUtils {

	public static void serializeString(String filename, String value) throws IOException {
		var dir = new File("D:\\tmp\\eval-fse");
		var file = new File(dir, filename);
		Files.writeString(file.toPath(), value);
	}
	
	public static void serializeModel(String filename, Resource r) throws IOException {
		var baos = new ByteArrayOutputStream();
		r.save(baos, Collections.emptyMap());
		serializeString(filename, baos.toString());
		baos.close();
	}

}
