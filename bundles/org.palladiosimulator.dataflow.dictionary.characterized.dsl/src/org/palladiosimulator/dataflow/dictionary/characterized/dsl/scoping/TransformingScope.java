package org.palladiosimulator.dataflow.dictionary.characterized.dsl.scoping;

import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.collect.Iterables;

public class TransformingScope implements IScope {

    private final IScope delegate;
    private final Function<IEObjectDescription, IEObjectDescription> transformation;

    public TransformingScope(IScope delegate, Function<IEObjectDescription, IEObjectDescription> transformation) {
        this.delegate = delegate;
        this.transformation = transformation;
    }

    @Override
    public Iterable<IEObjectDescription> getAllElements() {
        return transform(delegate.getAllElements());
    }

    @Override
    public Iterable<IEObjectDescription> getElements(EObject object) {
        return transform(delegate.getElements(object));
    }

    @Override
    public Iterable<IEObjectDescription> getElements(QualifiedName name) {
        return Iterables.filter(getAllElements(), description -> description.getName().equals(name));
    }

    @Override
    public IEObjectDescription getSingleElement(EObject object) {
        return transform(delegate.getSingleElement(object));
    }

    @Override
    public IEObjectDescription getSingleElement(QualifiedName name) {
        return Iterables.getFirst(getElements(name), null);
    }

    protected Iterable<IEObjectDescription> transform(Iterable<IEObjectDescription> elements) {
        return Iterables.transform(elements, transformation::apply);
    }

    protected IEObjectDescription transform(IEObjectDescription element) {
        return transformation.apply(element);
    }
}
