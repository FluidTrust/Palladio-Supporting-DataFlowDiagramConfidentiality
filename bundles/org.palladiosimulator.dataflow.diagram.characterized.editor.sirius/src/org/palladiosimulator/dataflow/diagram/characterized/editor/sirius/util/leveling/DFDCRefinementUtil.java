package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Data;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlow;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagramFactory;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagramRefinement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Edge;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.EdgeRefinement;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification.ComponentFactory;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification.QueryUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.naming.NamingScheme;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.naming.NumberedSuffixes;
//import org.palladiosimulator.dataflow.diagram.editor.sirius.util.modification.ComponentFactory;
//import org.palladiosimulator.dataflow.diagram.editor.sirius.util.naming.NamingScheme;
//import org.palladiosimulator.dataflow.diagram.editor.sirius.util.naming.NumberedSuffixes;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.CompositeDataType;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataType;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.Entry;


/**
 * 
 * Utility class implementing references between refining dfds and edges.
 *
 */
public class DFDCRefinementUtil {

	private static EdgeRefinement currentRefinement = null;

	public static void setCurrentRefinement(EdgeRefinement ncurrentRefinement) {
		currentRefinement = ncurrentRefinement;
	}

	public static EdgeRefinement getCurrentRefinement() {
		return currentRefinement;
	}

	public static List<Edge> refineEdge(Edge edge) {
		CharacterizedDataFlow df = (CharacterizedDataFlow) edge;
		Session session = new ArrayList<Session>(SessionManager.INSTANCE.getSessions()).get(0);
		List<Edge> results = new ArrayList<Edge>();
		if (df.getData().size() > 1) {
			// one df per data
			for (Data d : df.getData()) {
				CharacterizedDataFlow ndf = ComponentFactory.makeSingleDataFlow(d, df);
				results.add(ndf);
			}

		} 
		// TODO composite data types
		else {
			// one df per type
			Data origin = df.getData().get(0);
			DataType type = origin.getType();
			String name = origin.getName();
			NamingScheme namingScheme = new NumberedSuffixes(1);
			List<CharacterizedDataFlow> dfs = new ArrayList<CharacterizedDataFlow>();
			if (type instanceof CompositeDataType) {
				List<Entry> entries = DFDCTypeUtil.refineDT(type, session);
				for (Entry e : entries) {
					Data data = ComponentFactory.makeData(e);
					CharacterizedDataFlow ndf = ComponentFactory.makeSingleDataFlow(data, df);
					ndf.setName(namingScheme.makeSuffix(name));
					dfs.add(ndf);
				}
				results.addAll(dfs);
			}
		}
		return results;

	}

	public static boolean needsRef(EObject a, EObject b) {
		boolean sameDFD = QueryUtil.isSameDFD(a, b);
		boolean toRef = isRefined(a);
		boolean fromRef = isRefined(b);
		return (!sameDFD || toRef || fromRef);
	}

	public static DataFlowDiagramRefinement getRefinement(EObject node) {
		return (DataFlowDiagramRefinement) QueryUtil.getInverseReferences(node, "refinedProcess").get(0);
	}

	public static EdgeRefinement getRefinedEdge(CharacterizedDataFlow refiningDF) {
		List<EObject> refs = QueryUtil.getInverseReferences(refiningDF, "refiningEdges");
		if (refs.isEmpty())
			return null;
		return (EdgeRefinement) refs.get(0);
	}

	public static boolean isRefined(EObject self) {
		List<EObject> refs = QueryUtil.getInverseReferences(self, "refinedProcess");
		return !refs.isEmpty();
	}

	public static boolean isRefinedDFD(EObject self) {
		List<EObject> refs = QueryUtil.getInverseReferences(self, "refiningDiagram");
		return !refs.isEmpty();
	}

	
	// FIXME does not work without pins
	public static void addNewRefinedDF(EObject self, EObject source, EObject target) {

		DataFlowDiagram sourceDFD = (DataFlowDiagram) source.eContainer();
		CharacterizedDataFlow df = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow();
		df.setSource((Node) source);
		df.setTarget((Node) target);
		df.setName("new Data Flow");
		if (QueryUtil.isSameDFD(source, target)) { // to/from refinedNode
			sourceDFD.getEdges().add(df);

			if (isRefined(source) && isRefined(target)) {
				DataFlowDiagramRefinement sourceRef = getRefinement(source);
				addToRef(df, null, sourceRef);
				DataFlowDiagramRefinement targetRef = getRefinement(target);
				addToRef(df, null, targetRef);
			} else {
				DataFlowDiagramRefinement ref = isRefined(source) ? getRefinement(source) : getRefinement(target);
				addToRef(df, null, ref);
			}
		}
	}

	private static boolean isRefinedBy(DataFlowDiagram upper, DataFlowDiagram lower) {
		return upper.getRefinedBy().stream().map(r -> r.getRefiningDiagram())
				.anyMatch(d -> ComparisonUtil.isEqual(d, lower));
	}
//
	public static List<EdgeRefinement> getAllRefinements(EObject self, EObject source, EObject target) {
		List<EdgeRefinement> refs = new ArrayList<EdgeRefinement>();

		DataFlowDiagram sourceDFD = (DataFlowDiagram) source.eContainer();
		DataFlowDiagram targetDFD = (DataFlowDiagram) target.eContainer();
		if (isRefinedBy(sourceDFD, targetDFD)) {
			refs.addAll(getOutputRefs(sourceDFD, targetDFD, (Node) source, (Node) target));
		} else {
			refs.addAll(getInputRefs(sourceDFD, targetDFD, (Node) source, (Node) target));
		}
		return refs;

	}
//
	private static List<EdgeRefinement> getInputRefs(DataFlowDiagram sourceDFD, DataFlowDiagram targetDFD, Node source,
			Node target) {
		List<EdgeRefinement> refs = targetDFD.getRefinedBy().stream()
				.filter(r -> ComparisonUtil.isEqual(r.getRefiningDiagram(), sourceDFD)).map(r -> r.getRefinedEdges())
				.flatMap(List::stream).collect(Collectors.toList());
		return refs.stream().filter(r -> ComparisonUtil.isEqual(r.getRefinedEdge().getTarget(), target))
				.collect(Collectors.toList());
	}

	private static List<EdgeRefinement> getOutputRefs(DataFlowDiagram sourceDFD, DataFlowDiagram targetDFD, Node source,
			Node target) {
		List<EdgeRefinement> refs = sourceDFD.getRefinedBy().stream()
				.filter(r -> ComparisonUtil.isEqual(r.getRefiningDiagram(), targetDFD)).map(r -> r.getRefinedEdges())
				.flatMap(List::stream).collect(Collectors.toList());
		return refs.stream().filter(r -> ComparisonUtil.isEqual(r.getRefinedEdge().getSource(), source))
				.collect(Collectors.toList());
	}

	public static EdgeRefinement addToRef(CharacterizedDataFlow cdf, CharacterizedDataFlow ncdf, DataFlowDiagramRefinement ref) {
		EdgeRefinement er = DataFlowDiagramFactory.eINSTANCE.createEdgeRefinement();
		er.setRefinedEdge(cdf);
		if (ncdf != null) {
			er.getRefiningEdges().add(ncdf);
		}
		ref.getRefinedEdges().add(er);
		return er;
	}
//
	public static void refineCDF(EObject self, CharacterizedDataFlow df, DataFlowDiagram dfd) {
		Session session = SessionManager.INSTANCE.getSession(df);

		if (df.getData().isEmpty() || !DFDCValidationUtil.isRefinable(df)) {
			return;
		}

		EdgeRefinement ref = getRefinedEdge(df);
		if (ref != null) {
			ref.getRefiningEdges().remove(df);
		}

		if (df.getData().size() > 1) {
			// one df per data
			for (Data d : df.getData()) {
				NamingScheme namingScheme = new NumberedSuffixes(1);
				CharacterizedDataFlow ndf = ComponentFactory.makeSingleDataFlow(d, df);
				dfd.getEdges().add(ndf);
				if (ref != null) {
					ref.getRefiningEdges().add(ndf);
				}

			}
			dfd.getEdges().remove(df);

		} 
//		 TODO composite data types
		else {
			// one df per type
			Data origin = df.getData().get(0);
			DataType type = origin.getType();
			if (type instanceof CompositeDataType) {
				String name = origin.getName();
				NamingScheme namingScheme = new NumberedSuffixes(1);
				List<CharacterizedDataFlow> dfs = new ArrayList<CharacterizedDataFlow>();
				List<Entry> entries = DFDCTypeUtil.refineDT(type, session);
				for (Entry e : entries) {
					Data data = ComponentFactory.makeData(e);
					CharacterizedDataFlow ndf = ComponentFactory.makeSingleDataFlow(data, df);
					ndf.setName(namingScheme.makeSuffix(name));
					dfs.add(ndf);
					if (ref != null) {
						ref.getRefiningEdges().add(ndf);
					}
				}
				dfd.getEdges().remove(df);
				dfd.getEdges().addAll(dfs);
			}

		}

	}

}
