package org.palladiosimulator.dataflow.confidentiality.ui.wizard;

import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.palladiosimulator.dataflow.dictionary.characterized.dsl.ui.internal.DslActivator;

import com.google.inject.Injector;

public class CharacterizedDataDictionaryWizard extends Wizard implements INewWizard {

    private final String fileExtension;
    private WizardNewFileCreationPage fileCreationPage;
    private IWorkbench workbench;

    public CharacterizedDataDictionaryWizard() {
        Injector injector = DslActivator.getInstance()
            .getInjector(
                    DslActivator.ORG_PALLADIOSIMULATOR_DATAFLOW_DICTIONARY_CHARACTERIZED_DSL_CHARACTERIZEDDATADICTIONARY);
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
        IPath containerPath = fileCreationPage.getContainerFullPath();
        IPath fileToCreate = containerPath.append(fileCreationPage.getFileName());

        IFile file = ResourcesPlugin.getWorkspace()
            .getRoot()
            .getFile(fileToCreate);

        try {
            WizardUtils.createDataDictionary(file, new NullProgressMonitor());
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

}
