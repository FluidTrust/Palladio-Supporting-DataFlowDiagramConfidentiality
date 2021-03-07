package org.palladiosimulator.dataflow.confidentiality.transformation.prolog;

import org.palladiosimulator.supporting.prolog.model.prolog.Program;

public interface DFD2PrologTransformationResult {

    Program getProgram();
    
    DFD2PrologTransformationTrace getTrace();
    
}
