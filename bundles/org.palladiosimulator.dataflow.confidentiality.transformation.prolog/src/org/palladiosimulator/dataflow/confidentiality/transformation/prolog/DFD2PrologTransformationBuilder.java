package org.palladiosimulator.dataflow.confidentiality.transformation.prolog;

import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.impl.DFD2PrologTransformationImpl;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming.IdShortingUniqueNameProvider;
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming.UniqueNameProvider;

public class DFD2PrologTransformationBuilder {

    private UniqueNameProvider nameProvider = new IdShortingUniqueNameProvider();
    private boolean performanceTweaks = false;

    private DFD2PrologTransformationBuilder() {
    }

    public DFD2PrologTransformationBuilder setNameProvider(UniqueNameProvider nameProvider) {
        this.nameProvider = nameProvider;
        return this;
    }

    public DFD2PrologTransformationBuilder setNameProvider(NameGenerationStrategie strategy) {
        this.nameProvider = strategy.getNameProvider();
        return this;
    }

    public DFD2PrologTransformationBuilder enablePerformanceTweaks() {
        this.performanceTweaks = true;
        return this;
    }
    
    public DFD2PrologTransformation build() {
        return new DFD2PrologTransformationImpl(nameProvider, performanceTweaks);
    }
    
    
    public static DFD2PrologTransformationBuilder create() {
        return new DFD2PrologTransformationBuilder();
    }

}
