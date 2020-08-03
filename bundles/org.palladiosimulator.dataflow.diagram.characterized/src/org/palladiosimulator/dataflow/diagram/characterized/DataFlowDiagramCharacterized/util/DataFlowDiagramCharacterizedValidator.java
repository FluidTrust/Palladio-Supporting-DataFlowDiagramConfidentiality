package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedPackage;

/**
 * @see DataFlowDiagramCharacterizedValidatorGen
 */
public class DataFlowDiagramCharacterizedValidator extends DataFlowDiagramCharacterizedValidatorGen {

    /**
     * Changes the severity of the constraint to an information because the analysis logic should be
     * able to handle loops. However, if the model introduces or wants to make use of flapping
     * characteristics, the behavior might not be as expected.
     * 
     * @see DataFlowDiagramCharacterizedValidatorGen#validateCharacterizedDataFlow_notPartOfLoop(CharacterizedDataFlow,
     *      DiagnosticChain, Map)
     */
    @Override
    public boolean validateCharacterizedDataFlow_notPartOfLoop(CharacterizedDataFlow characterizedDataFlow,
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        return
                validate
                    (DataFlowDiagramCharacterizedPackage.Literals.CHARACTERIZED_DATA_FLOW,
                     (EObject)characterizedDataFlow,
                     diagnostics,
                     context,
                     "http://www.eclipse.org/emf/2002/Ecore/OCL",
                     "notPartOfLoop",
                     CHARACTERIZED_DATA_FLOW__NOT_PART_OF_LOOP__EEXPRESSION,
                     Diagnostic.INFO,
                     DIAGNOSTIC_SOURCE,
                     0);
    }

}
