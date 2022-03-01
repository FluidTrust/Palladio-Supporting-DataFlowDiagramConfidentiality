package org.palladiosimulator.dataflow.confidentiality.ui.wizard;

import java.util.function.Consumer;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class ValidatingWizardNewFileCreationPage extends WizardNewFileCreationPage {

    @FunctionalInterface
    public interface IFileValidator {

        default boolean validate(String filename, Consumer<String> errorMessageConsumer) {
            var errorMessageToSet = new String[1];
            Consumer<String> cachingErrorMessageConsumer = msg -> errorMessageToSet[0] = msg;
            boolean validationSuccessfull = doValidate(filename, cachingErrorMessageConsumer);
            if (validationSuccessfull) {
                errorMessageConsumer.accept(null);
            } else {
                errorMessageConsumer.accept(errorMessageToSet[0]);
            }
            return validationSuccessfull;
        }

        boolean doValidate(String filename, Consumer<String> errorMessage);
    }

    protected IFileValidator validator;

    public ValidatingWizardNewFileCreationPage(String pageName, IStructuredSelection selection,
            IFileValidator validator) {
        super(pageName, selection);
        this.validator = validator;
    }

    @Override
    protected boolean validatePage() {
        if (!super.validatePage()) {
            return false;
        }
        return validator.validate(getFileName(), this::setErrorMessage);
    }

}
