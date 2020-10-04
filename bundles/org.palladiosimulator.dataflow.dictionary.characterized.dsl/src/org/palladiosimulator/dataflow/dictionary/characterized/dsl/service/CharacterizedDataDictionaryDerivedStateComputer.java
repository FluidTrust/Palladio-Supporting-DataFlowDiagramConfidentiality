package org.palladiosimulator.dataflow.dictionary.characterized.dsl.service;

import java.util.Optional;

import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterized;

import de.uka.ipd.sdq.identifier.Identifier;

public class CharacterizedDataDictionaryDerivedStateComputer implements IDerivedStateComputer {

    protected final IdDeriver idDeriver = new IdDeriver();

    @Override
    public void installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase) {
        var rootElement = Optional.of(resource.getContents())
            .filter(c -> !c.isEmpty())
            .map(c -> c.get(0))
            .filter(DataDictionaryCharacterized.class::isInstance)
            .map(DataDictionaryCharacterized.class::cast);
        if (rootElement.isEmpty()) {
            return;
        }

        var dataDictionary = rootElement.get();
        setAllIds(dataDictionary);
    }

    @Override
    public void discardDerivedState(DerivedStateAwareResource resource) {
        // not possible or useful to discard generated IDs
    }

    protected void setAllIds(DataDictionaryCharacterized dictionary) {
        var baseId = dictionary.getId();
        for (var iter = dictionary.eAllContents(); iter.hasNext();) {
            var eobject = iter.next();
            if (eobject instanceof Identifier) {
                setDerivedId((Identifier) eobject, baseId);
            }
        }
    }

    protected void setDerivedId(Identifier eobject, String baseId) {
        idDeriver.getId(eobject, baseId)
            .ifPresent(eobject::setId);
    }
}
