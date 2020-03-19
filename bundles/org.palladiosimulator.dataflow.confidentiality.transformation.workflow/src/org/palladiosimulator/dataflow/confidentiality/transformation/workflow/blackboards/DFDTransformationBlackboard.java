package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards;

import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class DFDTransformationBlackboard extends MDSDBlackboard {

	private String value;
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
