package org.palladiosimulator.dataflow.confidentiality.ui.wizard;

import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.ui.business.api.session.UserSession;

public final class SiriusUtils {

    private SiriusUtils() {
        // intentionally left blank
    }

    public static Session createSession(IProject project, IProgressMonitor monitor) {
        URI sessionResourceURI = URI.createPlatformResourceURI(
                "/" + project.getName() + "/" + ModelingProject.DEFAULT_REPRESENTATIONS_FILE_NAME, true);
        Session session = SessionManager.INSTANCE.getSession(sessionResourceURI, monitor);
        return session;
    }

    public static void addSemanticResource(Session session, URI resourceUri, IProgressMonitor monitor) {
        TransactionalEditingDomain ted = session.getTransactionalEditingDomain();
        ted.getCommandStack()
            .execute(new AddSemanticResourceCommand(session, resourceUri, monitor));
    }
    
    public static UserSession enableViewpoint(Session session, String viewpointName) {
        return enableViewpoints(session, Arrays.asList(viewpointName));
    }

    public static UserSession enableViewpoints(Session session, Iterable<String> viewpointNames) {
        UserSession userSession = UserSession.from(session);
        return userSession.selectViewpoints(viewpointNames);
    }
    
}
