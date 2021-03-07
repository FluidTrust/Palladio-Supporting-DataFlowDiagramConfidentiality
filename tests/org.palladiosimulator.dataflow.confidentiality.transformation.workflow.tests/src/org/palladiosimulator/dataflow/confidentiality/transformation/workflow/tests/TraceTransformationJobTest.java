package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.xtext.resource.SaveOptions;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.impl.AnalysisIntegrationTestBase;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Component;

public class TraceTransformationJobTest extends AnalysisIntegrationTestBase {

    @Test
    public void testLoadFromDataStore() {
        assertConsistentTrace("models/unitTestExamples/dfd_loadFromDataStore.xmi", 5);
    }

    @Test
    public void testStaticFalse() {
        assertConsistentTrace("models/unitTestExamples/dfd_staticFalse-TrueAndDataReference.xmi", 3);
    }

    private void assertConsistentTrace(String dfdPath, int expectedComponents) {
        builder.addDFD(getRelativeURI(dfdPath));
        builder.addSerializeToString(SaveOptions.newBuilder()
            .format()
            .getOptions()
            .toOptionsMap());
        var workflow = builder.build();
        workflow.run();
        
        var potentialTrace = workflow.getTransformationTrace();
        assertTrue(potentialTrace.isPresent());
        
        var trace = potentialTrace.get();
        Collection<Component> dfdComponents = new ArrayList<>();
        dfdComponents.addAll(trace.getDfd()
            .getNodes());
        dfdComponents.addAll(trace.getDfd()
            .getEdges());
        assertEquals(expectedComponents, dfdComponents.size());
        
        for (Component dfdComponent : dfdComponents) {
            String componentId = trace.getFactId(dfdComponent).get();
            Component recordedComponent = trace.resolveDfdElement(trace.getDfdId(componentId).get(), Component.class).get();
            assertEquals(dfdComponent, recordedComponent);
        }
    }

}
