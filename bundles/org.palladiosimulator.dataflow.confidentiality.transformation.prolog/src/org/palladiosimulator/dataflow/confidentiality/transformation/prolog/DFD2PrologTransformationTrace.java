package org.palladiosimulator.dataflow.confidentiality.transformation.prolog;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Entity;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Behaving;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;
import org.palladiosimulator.supporting.prolog.model.prolog.Program;

public interface DFD2PrologTransformationTrace {

    public class PinId {
        private final String behavingId;
        private final String pinId;

        public PinId(String behavingId, String pinId) {
            super();
            this.behavingId = behavingId;
            this.pinId = pinId;
        }

        public String getBehavingId() {
            return behavingId;
        }

        public String getPinId() {
            return pinId;
        }

    }

    DataFlowDiagram getDfd();

    Program getPrologProgram();

    Optional<String> getFactId(Entity entity);

    Optional<String> getFactId(
            org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Entity entity);

    Optional<String> getFactId(DataType entity);

    Optional<String> getFactId(Behaving entity, Pin pin);

    Optional<String> getDfdId(String factId);

    Optional<PinId> getDfdPinId(String factId);

    <T extends EObject> Optional<T> resolveDfdElement(String dfdId, Class<T> type);

}
