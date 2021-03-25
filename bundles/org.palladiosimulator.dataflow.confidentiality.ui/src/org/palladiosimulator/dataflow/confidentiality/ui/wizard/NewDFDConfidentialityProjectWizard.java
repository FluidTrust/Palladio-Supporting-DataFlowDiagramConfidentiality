package org.palladiosimulator.dataflow.confidentiality.ui.wizard;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.ui.business.api.session.UserSession;
import org.eclipse.sirius.ui.tools.api.project.ModelingProjectManager;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagramFactory;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.api.CharacterizedDFDSiriusConstants;
import org.palladiosimulator.dataflow.diagram.editor.sirius.api.DFDSiriusConstants;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedFactory;
import org.palladiosimulator.dataflow.dictionary.characterized.dsl.ui.internal.DslActivator;

public class NewDFDConfidentialityProjectWizard extends Wizard implements INewWizard {

    private WizardNewProjectCreationPage mainPage;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        // nothing to do here
    }

    @Override
    public void addPages() {
        super.addPages();
        mainPage = new WizardNewProjectCreationPage("Create new DataFlow Confidentiality project");
        mainPage.setTitle("Project");
        mainPage.setDescription("Create a new project.");
        addPage(mainPage);
    }

    @Override
    public boolean performFinish() {
        IProgressMonitor monitor = new NullProgressMonitor();
        String projectName = mainPage.getProjectName();
        IPath projectLocation = mainPage.getLocationPath();
        try {
            createNewProject(projectName, projectLocation, monitor);
        } catch (CoreException e) {
            setErrorMessage("Error while creating the project: " + e.getMessage());
            return false;
        }
        return true;
    }

    protected void setErrorMessage(String message) {
        Optional.ofNullable(getContainer().getCurrentPage())
            .filter(DialogPage.class::isInstance)
            .map(DialogPage.class::cast)
            .ifPresent(page -> page.setErrorMessage(message));
    }

    protected void createNewProject(String projectName, IPath projectLocation, IProgressMonitor monitor)
            throws CoreException {
        // create modeling project
        IProject newProject = createModelingProject(projectName, projectLocation, monitor);

        // add xtext nature
        addXtextNature(newProject, monitor);

        // create initial resources
        URI ddUri = addDd(newProject, monitor);
        URI dfdUri = addDfd(newProject, monitor);

        // initialize session
        Session session = createSession(newProject, monitor);

        // add semantic resources
        registerInitialResources(session, ddUri, dfdUri, monitor);

        // create view for DFD
        createViewForDFD(session, dfdUri, monitor);
    }

    protected IProject createModelingProject(String projectName, IPath projectLocation, IProgressMonitor monitor)
            throws CoreException {
        return ModelingProjectManager.INSTANCE.createNewModelingProject(projectName, projectLocation, true,
                monitor);
    }

    protected Session createSession(IProject project, IProgressMonitor monitor) {
        URI sessionResourceURI = URI.createPlatformResourceURI(
                "/" + project.getName() + "/" + ModelingProject.DEFAULT_REPRESENTATIONS_FILE_NAME, true);
        Session session = SessionManager.INSTANCE.getSession(sessionResourceURI, monitor);
        return session;
    }

    protected void registerInitialResources(Session session, URI ddUri, URI dfdUri, IProgressMonitor monitor) {
        TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
        ted.getCommandStack()
            .execute(new AddSemanticResourceCommand(session, ddUri, monitor));
        ted.getCommandStack()
            .execute(new AddSemanticResourceCommand(session, dfdUri, monitor));
    }

    protected void createViewForDFD(Session session, URI dfdUri, IProgressMonitor monitor) {
        // enable viewpoints
        UserSession userSession = UserSession.from(session);
        userSession.selectViewpoints(
                Arrays.asList(DFDSiriusConstants.VIEWPOINT_NAME, CharacterizedDFDSiriusConstants.VIEWPOINT_NAME));

        // create view
        Viewpoint dfdViewpoint = ViewpointRegistry.getInstance()
            .getViewpoint(DFDSiriusConstants.VIEWPOINT_URI);
        @SuppressWarnings("unchecked")
        List<EObject> semanticElements = session.getSemanticResources()
            .stream()
            .filter(r -> dfdUri.equals(r.getURI()))
            .findFirst()
            .map(Resource::getContents)
            .map(((Class<List<EObject>>) ((Class<?>) List.class))::cast)
            .orElse(Collections.emptyList());
        session.createView(dfdViewpoint, semanticElements, monitor);
    }

    protected void addXtextNature(IProject newProject, IProgressMonitor monitor) throws CoreException {
        if (!XtextProjectHelper.hasNature(newProject)) {
            IProjectDescription projectDescription = newProject.getDescription();
            String[] newNatureIds = Arrays.copyOf(projectDescription.getNatureIds(),
                    projectDescription.getNatureIds().length + 1);
            newNatureIds[newNatureIds.length - 1] = XtextProjectHelper.NATURE_ID;
            projectDescription.setNatureIds(newNatureIds);
            newProject.setDescription(projectDescription, monitor);
        }
    }

    protected URI addDd(IProject project, IProgressMonitor monitor) throws CoreException {
        ResourceSetImpl rs = new ResourceSetImpl();
        URI ddURI = createURI(project, "dataDictionary.ddc");

        Resource ddR = rs.createResource(ddURI);

        // create data dictionary (textual model)
        var ddc = DataDictionaryCharacterizedFactory.eINSTANCE.createDataDictionaryCharacterized();
        ddc.setId(UUID.randomUUID()
            .toString());
        ddR.getContents()
            .add(ddc);
        var injector = DslActivator.getInstance()
            .getInjector(
                    DslActivator.ORG_PALLADIOSIMULATOR_DATAFLOW_DICTIONARY_CHARACTERIZED_DSL_CHARACTERIZEDDATADICTIONARY);
        ISerializer serializer = injector.getInstance(ISerializer.class);
        var ddcText = serializer.serialize(ddc);
        var ddcFile = project.getFile("dataDictionary.ddc");
        try (InputStream sis = new StringInputStream(ddcText)) {
            ddcFile.create(sis, true, monitor);
        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR, getClass(), "Could not create file.", e));
        }
        return ddURI;
    }

    protected URI addDfd(IProject project, IProgressMonitor monitor) throws CoreException {
        ResourceSetImpl rs = new ResourceSetImpl();
        URI dfdURI = createURI(project, "dataFlowDiagram.dfd");
        // create data flow diagram (EMF model)
        var dfd = DataFlowDiagramFactory.eINSTANCE.createDataFlowDiagram();
        var rDfd = rs.createResource(dfdURI);
        rDfd.getContents()
            .add(dfd);
        var dfdFile = project.getFile("dataFlowDiagram.dfd");
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            rDfd.save(baos, Collections.emptyMap());
            try (InputStream sis = new StringInputStream(baos.toString())) {
                dfdFile.create(sis, true, monitor);
            }
        } catch (IOException e) {
            throw new CoreException(new Status(IStatus.ERROR, getClass(), "Could not create file.", e));
        }
        return dfdURI;
    }

    protected URI createURI(IProject project, String fileName) {
        URI baseURI = URI.createPlatformResourceURI("/" + project.getName(), true);
        return baseURI.appendSegment(fileName);
    }

}
