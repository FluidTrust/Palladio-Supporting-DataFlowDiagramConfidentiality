package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.emf;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

/**
 * Dummy adapter to mark diagrams that have already been initialized with default resources.
 */
public class DefaultResourcesLoadedAdapter implements Adapter {

    private Notifier notifier;
    
    @Override
    public void notifyChanged(Notification notification) {
        // intentionally left blank
    }

    @Override
    public Notifier getTarget() {
        return notifier;
    }

    @Override
    public void setTarget(Notifier newTarget) {
        this.notifier = newTarget;
    }

    @Override
    public boolean isAdapterForType(Object type) {
        return false;
    }
    
}