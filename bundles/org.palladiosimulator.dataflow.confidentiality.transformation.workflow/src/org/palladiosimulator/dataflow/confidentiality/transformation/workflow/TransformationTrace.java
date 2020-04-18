package org.palladiosimulator.dataflow.confidentiality.transformation.workflow;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Component;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;

public interface TransformationTrace {

    DataFlowDiagram getDfd();
    
    String getFactId(Component dfdComponent);
    
    Component getDfdComponent(String factId);
    
}
