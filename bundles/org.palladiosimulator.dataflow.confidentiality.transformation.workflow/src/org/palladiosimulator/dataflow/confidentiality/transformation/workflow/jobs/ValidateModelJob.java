package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards.KeyValueMDSDBlackboard;

import de.uka.ipd.sdq.workflow.jobs.AbstractBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;

public class ValidateModelJob<T extends KeyValueMDSDBlackboard> extends AbstractBlackboardInteractingJob<T> {

    protected final ModelLocation modelLocation;
    protected final String diagnosticKey;
    protected final boolean abortOnValidationFailed;

    public ValidateModelJob(ModelLocation modelToValidate, String diagnosticKey, boolean abortOnValidationFailed) {
        this.modelLocation = modelToValidate;
        this.diagnosticKey = diagnosticKey;
        this.abortOnValidationFailed = abortOnValidationFailed;
    }

    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        monitor.beginTask("Validate DFD model.", 1);
        var modelContents = getBlackboard().getContents(modelLocation);
        var diagnostic = new BasicDiagnostic();
        modelContents.stream()
            .map(Diagnostician.INSTANCE::validate)
            .forEach(diagnostic::add);
        getBlackboard().put(diagnosticKey, diagnostic);
        monitor.worked(1);
        if (abortOnValidationFailed && diagnostic.getSeverity() >= Diagnostic.WARNING) {
            throw new JobFailedException(new CoreException(BasicDiagnostic.toIStatus(diagnostic)));
        }
    }

    @Override
    public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
        // nothing to do here
    }

    @Override
    public String getName() {
        return "Validate Model";
    }

}
