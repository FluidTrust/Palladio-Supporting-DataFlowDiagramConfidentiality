package org.palladiosimulator.dataflow.confidentiality.ui.wizard;

import java.util.Optional;
import java.util.function.Consumer;

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

public abstract class AbstractXtextFileCreationWizard extends Wizard implements INewWizard {

    protected final Injector injector;
    protected final String fileTypeName;
    protected final String fileExtension;
    protected WizardNewFileCreationPage fileCreationPage;
    protected IWorkbench workbench;

    public AbstractXtextFileCreationWizard(Injector injector, String fileTypeName) {
        this.injector = injector;
        this.fileTypeName = fileTypeName;
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
        setWindowTitle(fileTypeName + " Creation");
        fileCreationPage = new ValidatingWizardNewFileCreationPage(fileTypeName + " Creation", selection,
                this::validateFilename);
        fileCreationPage.setAllowExistingResources(false);
        fileCreationPage.setTitle(fileTypeName + " Creation");
        fileCreationPage.setDescription("Please select the path for creating the " + fileTypeName + ".");
    }

    protected boolean validateFilename(String filename, Consumer<String> errorMessageConsumer) {
        var validationResult = Optional.ofNullable(filename)
            .map(fn -> fn.endsWith("." + fileExtension))
            .orElse(false);
        if (!validationResult) {
            errorMessageConsumer.accept("The file name has to end with ." + fileExtension);
        }
        return validationResult;
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
            createXtextFile(file, new NullProgressMonitor());
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

    protected abstract void createXtextFile(IFile file, IProgressMonitor progressMonitor) throws CoreException;

    protected IFile getFileToCreate() {
        IPath containerPath = fileCreationPage.getContainerFullPath();
        IPath fileToCreate = containerPath.append(fileCreationPage.getFileName());

        IFile file = ResourcesPlugin.getWorkspace()
            .getRoot()
            .getFile(fileToCreate);
        return file;
    }

}
