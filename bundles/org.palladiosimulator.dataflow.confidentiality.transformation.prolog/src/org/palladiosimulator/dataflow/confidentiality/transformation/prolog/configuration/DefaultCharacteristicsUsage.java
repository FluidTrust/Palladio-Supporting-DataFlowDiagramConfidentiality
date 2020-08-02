package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.configuration;

public enum DefaultCharacteristicsUsage {

    TRUE(true),
    FALSE(false);
    
    public static final String QVTO_PROPERTY_KEY = "UseDefaultCharacteristics";
    private final String value;
    
    private DefaultCharacteristicsUsage(boolean value) {
        this.value = Boolean.toString(value);
    }

    public String getQvtoPropertyValue() {
        return value;
    }

}
