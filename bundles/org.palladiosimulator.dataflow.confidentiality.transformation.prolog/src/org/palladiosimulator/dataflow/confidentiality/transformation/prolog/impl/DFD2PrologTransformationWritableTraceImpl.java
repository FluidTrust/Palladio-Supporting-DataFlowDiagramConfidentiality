package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Entity;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Behaving;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataType;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;
import org.palladiosimulator.supporting.prolog.model.prolog.Program;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class DFD2PrologTransformationWritableTraceImpl implements DFD2PrologTransformationWritableTrace {

    private final BiMap<List<String>, String> trace = HashBiMap.create();
    private DataFlowDiagram dfd;
    private Program program;

    @Override
    public DataFlowDiagram getDfd() {
        return dfd;
    }

    @Override
    public Program getPrologProgram() {
        return program;
    }

    @Override
    public Optional<String> getFactId(Entity entity) {
        return Optional.ofNullable(trace.get(Arrays.asList(entity.getId())));
    }

    @Override
    public Optional<String> getFactId(
            org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Entity entity) {
        return Optional.ofNullable(trace.get(Arrays.asList(entity.getId())));
    }

    @Override
    public Optional<String> getFactId(DataType entity) {
        return Optional.ofNullable(trace.get(Arrays.asList(entity.getId())));
    }

    @Override
    public Optional<String> getFactId(Behaving entity, Pin pin) {
        return Optional.ofNullable(trace.get(Arrays.asList(((Entity) entity).getId(), pin.getId())));
    }

    @Override
    public Optional<String> getDfdId(String factId) {
        return Optional.ofNullable(trace.inverse()
            .get(factId))
            .map(l -> l.get(0));
    }

    @Override
    public Optional<PinId> getDfdPinId(String factId) {
        return Optional.ofNullable(trace.inverse()
            .get(factId))
            .map(list -> new PinId(list.get(0), list.get(1)));
    }

    @Override
    public void add(DataFlowDiagram dfd, Program program) {
        this.dfd = dfd;
        this.program = program;
    }

    @Override
    public void add(Entity entity, String factId) {
        trace.put(Arrays.asList(entity.getId()), factId);
    }

    @Override
    public void add(org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Entity entity,
            String factId) {
        trace.put(Arrays.asList(entity.getId()), factId);
    }

    @Override
    public void add(Behaving entity, Pin pin, String factId) {
        var key = Arrays.asList(((Entity) entity).getId(), pin.getId());
        trace.put(key, factId);
    }

    @Override
    public void add(DataType dataType, String factId) {
        trace.put(Arrays.asList(dataType.getId()), factId);
    }

    @Override
    public <T extends EObject> Optional<T> resolveDfdElement(String dfdId, Class<T> type) {
        return dfd.eResource()
            .getResourceSet()
            .getResources()
            .stream()
            .map(r -> r.getEObject(dfdId))
            .filter(Objects::nonNull)
            .filter(type::isInstance)
            .map(type::cast)
            .findFirst();
    }

}
