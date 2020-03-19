package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration;

public enum NameDerivationMethod {
	NAME_AND_ID("name-and-id"),
	ID("id");
	
	public static final String QVTO_PROPERTY_KEY = "QualifiedNameDerivation";
	private final String qvtoPropertyValue;

	private NameDerivationMethod(String qvtoPropertyValue) {
		this.qvtoPropertyValue = qvtoPropertyValue;
	}

	public String getQvtoPropertyValue() {
		return qvtoPropertyValue;
	}

}