package org.palladiosimulator.dataflow.confidentiality.ui.wizard;

import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.xtext.resource.FileExtensionProvider;

import com.google.inject.Injector;

public abstract class AbstractCharacterizedDataDictionaryWizard extends Wizard implements INewWizard {

    protected final Injector injector;
    protected final String fileExtension;
    protected WizardNewFileCreationPage fileCreationPage;
    protected IWorkbench workbench;

    public AbstractCharacterizedDataDictionaryWizard(Injector injector) {
        this.injector = injector;
        fileExtension = injector.getInstance(FileExtensionProvider.class)
            .getPrimaryFileExtension();
    }

    @Override
    public void addPages() {
        addPage(fileCreationPage);
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        setWindowTitle("Data Dictionary Creation");
        fileCreationPage = new WizardNewFileCreationPage("Data Dictionary Creation", selection);
        fileCreationPage.setAllowExistingResources(false);
        fileCreationPage.setTitle("Data Dictionary Creation");
        fileCreationPage.setDescription("Please select the path for creating the dictionary.");
    }

    @Override
    public boolean canFinish() {
        getCurrentPage().ifPresent(d -> d.setErrorMessage(null));

        if (!super.canFinish() || !fileCreationPage.isPageComplete()) {
            return false;
        }

        if (getCurrentPage().map(fileCreationPage::equals)
            .orElse(false)) {
            if (fileCreationPage.getFileName()
                .endsWith("." + fileExtension)) {
                return true;
            }
            getCurrentPage().ifPresent(d -> d.setErrorMessage("The file name has to end with ." + fileExtension));
        }

        return false;
    }

    protected Optional<DialogPage> getCurrentPage() {
        return Optional.ofNullable(this.getContainer()
            .getCurrentPage())
            .filter(DialogPage.class::isInstance)
            .map(DialogPage.class::cast);
    }

    @Override
    public boolean performFinish() {
        IFile file = getFileToCreate();

        try {
            WizardUtils.addXtextNature(file.getProject(), new NullProgressMonitor());
        } catch (CoreException e) {
            fileCreationPage.setErrorMessage("Could not add required Xtext nature: " + e.getLocalizedMessage());
            return false;
        }
        
        try {
            createDataDictionary(file, new NullProgressMonitor());
        } catch (CoreException e) {
            fileCreationPage.setErrorMessage("Could not create file: " + e.getLocalizedMessage());
            return false;
        }

        try {
            WizardUtils.openEditor(workbench, file);
        } catch (PartInitException e) {
            fileCreationPage.setErrorMessage("Could not open file: " + e.getLocalizedMessage());
            return false;
        }

        return true;
    }
    
    protected abstract void createDataDictionary(IFile file, IProgressMonitor progressMonitor) throws CoreException;

    protected IFile getFileToCreate() {
        IPath containerPath = fileCreationPage.getContainerFullPath();
        IPath fileToCreate = containerPath.append(fileCreationPage.getFileName());

        IFile file = ResourcesPlugin.getWorkspace()
            .getRoot()
            .getFile(fileToCreate);
        return file;
    }

}
