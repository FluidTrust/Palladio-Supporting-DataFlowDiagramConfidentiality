package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.impl;

import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.TransformationTrace;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Component;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class TransformationTraceImpl implements TransformationTrace {

    private final BiMap<String, Component> componentMap = HashBiMap.create();
    private DataFlowDiagram dfd;
    
    public void addComponentEntry(String factId, Component dfdComponent) {
        componentMap.put(factId, dfdComponent);
        if (dfd == null) {
            dfd = (DataFlowDiagram) dfdComponent.eContainer();
        }
    }
    
    @Override
    public String getFactId(Component dfdComponent) {
        return componentMap.inverse().get(dfdComponent);
    }

    @Override
    public Component getDfdComponent(String factId) {
        return componentMap.get(factId);
    }

    @Override
    public DataFlowDiagram getDfd() {
        return dfd;
    }

}
