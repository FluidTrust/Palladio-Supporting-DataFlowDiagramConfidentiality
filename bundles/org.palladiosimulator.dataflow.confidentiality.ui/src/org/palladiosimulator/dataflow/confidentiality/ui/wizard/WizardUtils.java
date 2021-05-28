package org.palladiosimulator.dataflow.confidentiality.ui.wizard;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedFactory;
import org.palladiosimulator.dataflow.dictionary.characterized.dsl.ui.internal.DslActivator;

public final class WizardUtils {

    private WizardUtils() {
        // intentionally left blank
    }

    public static void addXtextNature(IProject newProject, IProgressMonitor monitor) throws CoreException {
        if (!XtextProjectHelper.hasNature(newProject)) {
            IProjectDescription projectDescription = newProject.getDescription();
            String[] newNatureIds = Arrays.copyOf(projectDescription.getNatureIds(),
                    projectDescription.getNatureIds().length + 1);
            newNatureIds[newNatureIds.length - 1] = XtextProjectHelper.NATURE_ID;
            projectDescription.setNatureIds(newNatureIds);
            newProject.setDescription(projectDescription, monitor);
        }
    }

    public static void createDataDictionary(IFile destinationFile, IProgressMonitor monitor) throws CoreException {
        var injector = DslActivator.getInstance()
            .getInjector(
                    DslActivator.ORG_PALLADIOSIMULATOR_DATAFLOW_DICTIONARY_CHARACTERIZED_DSL_CHARACTERIZEDDATADICTIONARY);
        ISerializer serializer = injector.getInstance(ISerializer.class);
        DataDictionaryCharacterized emptyDictionary = DataDictionaryCharacterizedFactory.eINSTANCE
            .createDataDictionaryCharacterized();
        ResourceSetImpl rs = new ResourceSetImpl();
        Resource r = rs.createResource(URI.createURI("virtual:/tmp/foo." + destinationFile.getFileExtension()));
        r.getContents()
            .add(emptyDictionary);
        String fileContent = serializer.serialize(emptyDictionary);

        try (InputStream sis = new StringInputStream(fileContent)) {
            destinationFile.create(sis, true, monitor);
        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR, WizardUtils.class, "Could not create file.", e));
        }
    }
    
    public static void openEditor(IWorkbench workbench, IFile file) throws PartInitException {
        IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
            .getActivePage();
        IEditorDescriptor desc = PlatformUI.getWorkbench()
            .getEditorRegistry()
            .getDefaultEditor(file.getName());
        page.openEditor(new FileEditorInput(file), desc.getId());
    }

}
