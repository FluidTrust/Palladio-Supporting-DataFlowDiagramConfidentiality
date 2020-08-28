package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.naming;

/**
 * 
 * Simple class generating suffixes simply consisting of (incrementing) numbers
 *
 */

public class NumberedSuffixes implements NamingScheme {

	private int index = 0;

	public NumberedSuffixes(int base) {
		this.index = base;
	}

	public NumberedSuffixes() {

	}

	@Override
	public String makeSuffix(String name) {

		return name + "." + this.index;
	}
	

	@Override
	public String makeIncrementedSuffix(String name) {

		return name + "." + ++this.index;
	}
	
	
}
