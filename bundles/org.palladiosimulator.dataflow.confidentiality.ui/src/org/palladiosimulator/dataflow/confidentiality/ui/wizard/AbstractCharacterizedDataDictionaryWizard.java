package org.palladiosimulator.dataflow.confidentiality.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.google.inject.Injector;

public abstract class AbstractCharacterizedDataDictionaryWizard extends AbstractXtextFileCreationWizard {

    public AbstractCharacterizedDataDictionaryWizard(Injector injector) {
        super(injector, "Data Dictionary");
    }

    @Override
    protected void createXtextFile(IFile file, IProgressMonitor progressMonitor) throws CoreException {
        createDataDictionary(file, progressMonitor);
    }

    protected abstract void createDataDictionary(IFile file, IProgressMonitor progressMonitor) throws CoreException;

}
