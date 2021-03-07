package org.palladiosimulator.dataflow.confidentiality.transformation.prolog;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;

public interface DFD2PrologTransformation {

    DFD2PrologTransformationResult transform(DataFlowDiagram dfd);

}
