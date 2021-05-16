package org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.presentation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.ui.action.PasteAction;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedPackage;

import de.uka.ipd.sdq.identifier.Identifier;

public class DataFlowDiagramCharacterizedActionBarContributor
        extends DataFlowDiagramCharacterizedActionBarContributorGen {

    protected static class IdRandomizingPastAction extends PasteAction {

        private final Collection<EClass> typesToRandomize;

        public IdRandomizingPastAction(Collection<EClass> typesToRandomize) {
            this.typesToRandomize = typesToRandomize;
        }

        @Override
        public Command createCommand(Collection<?> selection) {
            Command createdCommand = super.createCommand(selection);
            return new CommandWrapper(createdCommand) {
                @Override
                public void execute() {
                    super.execute();
                    Optional.of(getCommand())
                        .filter(PasteFromClipboardCommand.class::isInstance)
                        .map(PasteFromClipboardCommand.class::cast)
                        .ifPresent(c -> {
                            c.getAffectedObjects()
                                .stream()
                                .filter(Identifier.class::isInstance)
                                .map(Identifier.class::cast)
                                .filter(o -> typesToRandomize.stream()
                                    .anyMatch(t -> t.isInstance(o)))
                                .forEach(i -> i.setId(EcoreUtil.generateUUID()));
                        });
                }
            };
        }

    }

    @Override
    protected PasteAction createPasteAction() {
        return new IdRandomizingPastAction(Arrays.asList(DataDictionaryCharacterizedPackage.Literals.CHARACTERISTIC));
    }

}
