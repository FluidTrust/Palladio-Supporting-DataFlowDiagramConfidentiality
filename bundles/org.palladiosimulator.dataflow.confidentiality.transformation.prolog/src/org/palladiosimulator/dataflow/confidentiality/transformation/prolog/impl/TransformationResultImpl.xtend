package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.impl

import org.eclipse.xtend.lib.annotations.Data
import org.palladiosimulator.supporting.prolog.model.prolog.Program
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.DFD2PrologTransformationTrace
import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.DFD2PrologTransformationResult

@Data
class TransformationResultImpl implements DFD2PrologTransformationResult {
	
	val Program program
	val DFD2PrologTransformationTrace trace
	
}