package org.palladiosimulator.dataflow.confidentiality.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.dataflow.dictionary.characterized.dsl.ui.internal.DslActivator;

public class CharacterizedDataDictionaryWizard extends AbstractCharacterizedDataDictionaryWizard {

    public CharacterizedDataDictionaryWizard() {
        super(DslActivator.getInstance()
            .getInjector(
                    DslActivator.ORG_PALLADIOSIMULATOR_DATAFLOW_DICTIONARY_CHARACTERIZED_DSL_CHARACTERIZEDDATADICTIONARY));
    }

    @Override
    protected void createDataDictionary(IFile file, IProgressMonitor progressMonitor) throws CoreException {
        WizardUtils.createDataDictionary(file, progressMonitor);
    }

}
