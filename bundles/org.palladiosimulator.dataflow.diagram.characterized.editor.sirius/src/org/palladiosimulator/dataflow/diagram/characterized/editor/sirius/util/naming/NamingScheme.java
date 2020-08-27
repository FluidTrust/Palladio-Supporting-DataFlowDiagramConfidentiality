package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.naming;

/**
 * 
 * Interface for suffix generation while refining dataflows; may be extended in the future
 *
 */

public interface NamingScheme {

	public String makeSuffix(String name);
	public String makeIncrementedSuffix(String name);

}
