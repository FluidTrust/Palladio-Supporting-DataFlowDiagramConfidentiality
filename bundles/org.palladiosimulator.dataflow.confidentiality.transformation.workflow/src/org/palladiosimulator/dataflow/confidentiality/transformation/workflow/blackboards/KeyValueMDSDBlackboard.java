package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.blackboards;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class KeyValueMDSDBlackboard extends MDSDBlackboard {

    private final Map<Object, Object> keyValueStore = new HashMap<>();
    
    public void put(Object key, Object value) {
        keyValueStore.put(key, value);
    }
    
    public Optional<Object> get(Object key) {
        return Optional.ofNullable(keyValueStore.get(key));
    }
    
}
