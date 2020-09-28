package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.presentation;

import org.palladiosimulator.dataflow.confidentiality.defaultmodels.DefaultModelConstants;

public class DataFlowDiagramCharacterizedEditor extends DataFlowDiagramCharacterizedEditorGen {

    /**
     * {@inheritDoc}
     */
    @Override
    public void createModel() {
        super.createModel();
        for (var dictionaryURI : DefaultModelConstants.getDefaultDataDictionaries()) {
            editingDomain.getResourceSet().getResource(dictionaryURI, true);                    
        }
    }

}
