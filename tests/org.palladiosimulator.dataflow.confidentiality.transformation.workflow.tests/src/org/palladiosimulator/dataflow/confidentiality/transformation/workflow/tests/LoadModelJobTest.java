package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.util.URIHelper.getRelativeURI;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.jobs.LoadModelJob;
import org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.util.StandaloneInitializer;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;

import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;

public class LoadModelJobTest {

	@BeforeAll
	public static void init() {
		StandaloneInitializer.init();
	}
	
	@Test
	public void testCorrectLoadingOfModelWithCrossReferences() throws JobFailedException, UserCanceledException {
		var blackboard = new MDSDBlackboard();
		var modelLocation = new ModelLocation("test", getRelativeURI("models/firstExample/DataFlowDiagram.xmi"));		
		var job = new LoadModelJob<MDSDBlackboard>(modelLocation);
		job.setBlackboard(blackboard);		
		
		job.execute(new NullProgressMonitor());

		assertTrue(blackboard.hasPartition(modelLocation.getPartitionID()));
		var partition = blackboard.getPartition(modelLocation.getPartitionID());
		assertTrue(partition.hasModel(modelLocation.getModelID()));
		List<EObject> contents = partition.getContents(modelLocation.getModelID());
		assertEquals(1, contents.size());
		var rootObject = contents.iterator().next();
		assertTrue(rootObject instanceof DataFlowDiagram);
		var unresolvedCrossReferences = EcoreUtil.UnresolvedProxyCrossReferencer.find(rootObject);
		assertTrue(unresolvedCrossReferences.isEmpty());
	}
	
}
