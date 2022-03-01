package org.palladiosimulator.dataflow.dictionary.characterized.dsl.service;

import java.util.Optional;

import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;

import de.uka.ipd.sdq.identifier.Identifier;

public class CharacterizedDataDictionaryDerivedStateComputer implements IDerivedStateComputer {

    protected final XPathConstructor xpathConstructor = new XPathConstructor();

    @Override
    public void installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase) {
        var rootElement = Optional.of(resource.getContents())
            .filter(c -> !c.isEmpty())
            .map(c -> c.get(0))
            .filter(Identifier.class::isInstance)
            .map(Identifier.class::cast);
        if (rootElement.isEmpty()) {
            return;
        }

        var foundRootElement = rootElement.get();
        setAllIds(foundRootElement);
    }

    @Override
    public void discardDerivedState(DerivedStateAwareResource resource) {
        // not possible or useful to discard generated IDs
    }

    protected void setAllIds(Identifier rootElement) {
        var baseId = rootElement.getId();
        for (var iter = rootElement.eAllContents(); iter.hasNext();) {
            var eobject = iter.next();
            if (eobject instanceof Identifier) {
                setDerivedId((Identifier) eobject, baseId);
            }
        }
    }

    protected void setDerivedId(Identifier eobject, String baseId) {
        eobject.setId(xpathConstructor.getId(eobject, baseId));
    }

}
