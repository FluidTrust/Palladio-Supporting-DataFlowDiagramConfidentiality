package org.palladiosimulator.dataflow.confidentiality.transformation.workflow.tests.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.util.CompareSwitch;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

import tools.mdsd.library.standalone.initialization.StandaloneInitializationException;

public class ReasonableJaccardCoefficientTest {

	enum AnalysisType {
		IF, AC
	}

	protected static class ChangedElementsLeftFinder extends CompareSwitch<Collection<EObject>> {

		@Override
		public Collection<EObject> caseReferenceChange(ReferenceChange object) {
			Set<EObject> changes = new HashSet<>(caseDiff(object));
			if (object.getKind() == DifferenceKind.ADD && object.getSource() == DifferenceSource.LEFT) {
				changes.add(object.getValue());
			}
			return changes;
		}

		@Override
		public Collection<EObject> caseDiff(Diff object) {
			return Arrays.asList(object.getMatch().getLeft());
		}

	}

	protected static class ChangedElementsRightFinder extends CompareSwitch<Collection<EObject>> {

		@Override
		public Collection<EObject> caseReferenceChange(ReferenceChange object) {
			Set<EObject> changes = new HashSet<>(caseDiff(object));
			if (object.getKind() == DifferenceKind.DELETE && object.getSource() == DifferenceSource.LEFT) {
				changes.add(object.getValue());
			}
			return changes;
		}

		@Override
		public Collection<EObject> caseDiff(Diff object) {
			return Arrays.asList(object.getMatch().getRight());
		}

	}

	protected static final ChangedElementsLeftFinder changedElementsLeftFinder = new ChangedElementsLeftFinder();
	protected static final ChangedElementsRightFinder changedElementsRightFinder = new ChangedElementsRightFinder();
	protected static EMFCompare COMPARE;
	protected final Map<AnalysisType, ResourceSet> resourceSets = new HashMap<>();

	@BeforeAll
	static void init() throws StandaloneInitializationException {
		StandaloneUtil.init();
		IEObjectMatcher fallBackMatcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.WHEN_AVAILABLE);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
		@SuppressWarnings("deprecation")
		final MatchEngineFactoryImpl matchEngineFactory = new MatchEngineFactoryImpl(fallBackMatcher,
				comparisonFactory);
		matchEngineFactory.setRanking(20);
		registry.add(matchEngineFactory);
		COMPARE = EMFCompare.builder().setMatchEngineFactoryRegistry(registry).build();
		Logger.getLogger(EMFCompare.class.getPackageName()).setLevel(Level.WARN);
	}

	@AfterEach
	public void setup() {
		resourceSets.clear();
	}

	@Test
	public void testTravelPlanner() {
		ResourceSet rsIf = loadResource(AnalysisType.IF, "travelplanner/DFDC_TravelPlanner_InformationFlow.xmi");
		ResourceSet rsAc = loadResource(AnalysisType.AC, "travelplanner/DFDC_TravelPlanner_AccessControl.xmi");
		doCompare("TravelPlanner", rsIf, rsAc);
	}

	@Test
	public void testDistanceTracker() {
		ResourceSet rsIf = loadResource(AnalysisType.IF, "distancetracker/DFDC_DistanceTracker_InformationFlow.xmi");
		ResourceSet rsAc = loadResource(AnalysisType.AC, "distancetracker/DFDC_DistanceTracker_AccessControl.xmi");
		doCompare("DistanceTracker", rsIf, rsAc);
	}

	@Test
	public void testContactSMS() {
		ResourceSet rsIf = loadResource(AnalysisType.IF, "contactsms/DFDC_ContactSMS_InformationFlow.xmi");
		ResourceSet rsAc = loadResource(AnalysisType.AC, "contactsms/DFDC_ContactSMS_AccessControl.xmi");
		doCompare("ContactSMS", rsIf, rsAc);
	}

	protected void doCompare(String systemName, ResourceSet rsIf, ResourceSet rsAc) {
		DefaultComparisonScope scope = new DefaultComparisonScope(rsIf, rsAc, null);
		Comparison comparison = COMPARE.compare(scope);

		// identify changes
		Set<EObject> ifChanged = new HashSet<>();
		Set<EObject> acChanged = new HashSet<>();
		for (Diff diff : comparison.getDifferences()) {
			ifChanged.addAll(changedElementsLeftFinder.doSwitch(diff));
			acChanged.addAll(changedElementsRightFinder.doSwitch(diff));
		}
		acChanged.remove(null);
		ifChanged.remove(null);

		// build element sets for metric calculation
		Set<EObject> ifContents = getAllContents(rsIf);
		Set<EObject> acContents = getAllContents(rsAc);
		SetView<EObject> ifUnchanged = Sets.difference(ifContents, ifChanged);
		SetView<EObject> acUnchanged = Sets.difference(acContents, acChanged);
		assertTrue(ifUnchanged.size() == acUnchanged.size());

		// calculate metric
		int numIntersection = ifUnchanged.size();
		int numUnion = (ifContents.size() - numIntersection) + (acContents.size() - numIntersection) + numIntersection;
		double jaccard = numIntersection / (double) numUnion;
		assertTrue(jaccard < 1.0);
		assertTrue(jaccard > 0.0);

		// echo coefficient
		System.out.println(String.format("Jaccard coefficient for %s:\t%d/%d = %.2f", systemName, numIntersection,
				numUnion, jaccard));

		// echo involved types
		System.out.println("\tIF unchanged: " + getTypeNames(ifUnchanged));
		System.out.println("\tAC unchanged: " + getTypeNames(acUnchanged));
		System.out.println("\tIF changed: " + getTypeNames(ifChanged));
		System.out.println("\tAC changed: " + getTypeNames(acChanged));
	}

	protected String getTypeNames(Collection<EObject> ifUnchanged) {
		return ifUnchanged.stream().map(EObject::eClass).map(EClass::getName).distinct().sorted()
				.collect(Collectors.joining(", "));
	}

	protected static Set<EObject> getAllContents(ResourceSet rs) {
		Set<EObject> contents = new HashSet<>();
		rs.getAllContents().forEachRemaining(n -> {
			if (n instanceof EObject) {
				contents.add((EObject) n);
			}
		});
		return contents;
	}

	protected ResourceSet loadResource(AnalysisType type, String relativePath) {
		resourceSets.putIfAbsent(type, new ResourceSetImpl());
		ResourceSet rs = resourceSets.get(type);
		URI uri = getRelativeURI(relativePath);
		rs.getResource(uri, true);
		EcoreUtil.resolveAll(rs);
		return rs;
	}

	protected static URI getRelativeURI(String relativePath) {
		return StandaloneUtil.getRelativeURI("models/evaluation/" + relativePath);
	}

}
