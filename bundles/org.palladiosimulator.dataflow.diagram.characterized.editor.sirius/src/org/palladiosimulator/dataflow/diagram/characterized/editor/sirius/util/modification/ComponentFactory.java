package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Data;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagram;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.DataFlowDiagramFactory;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.ExternalActor;
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.Characteristic;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedActorProcess;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedDataFlow;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedExternalActor;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedNode;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedProcess;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedStore;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.DataFlowDiagramCharacterizedFactory;
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.EnumCharacteristic;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling.ComparisonUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.leveling.DFDCRefinementUtil;
import org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.naming.NamingScheme;
import org.palladiosimulator.dataflow.dictionary.DataDictionary.Entry;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Assignment;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.BehaviorDefinition;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedFactory;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.BinaryLogicTerm;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Constant;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ContainerCharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.EnumCharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsFactory;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.LogicTerm;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Or;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.Term;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.True;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.UnaryLogicTerm;

/**
 * 
 * this class should probably be reworked ..
 * 
 */

public class ComponentFactory {

	public static void createCDF(EObject self, EObject sourcePin, EObject targetPin, EObject sourceNode,
			EObject targetNode, boolean needsRef) {
		CharacterizedDataFlow df = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow();
		DataFlowDiagram sourceDFD = (DataFlowDiagram) sourceNode.eContainer();
		DataFlowDiagram targetDFD = (DataFlowDiagram) targetNode.eContainer();

		df.setSource((Node) sourceNode);
		df.setTarget((Node) targetNode);
		df.setSourcePin((Pin) sourcePin);
		df.setTargetPin((Pin) targetPin);

		df.setName("new Data Flow");
		sourceDFD.getEdges().add(df);
		if (!ComparisonUtil.isEqual(sourceDFD, targetDFD)) { // needed for visibility
			targetDFD.getEdges().add(df);

		}

		if (needsRef) {
			DFDCRefinementUtil.getCurrentRefinement().getRefiningEdges().add(df);
		}

	}

	public static Node copyNode(Node n) {
		String name = n.getName();
		Node copy = null;

		if (n instanceof CharacterizedProcess) {
			if (n instanceof CharacterizedActorProcess) {
				CharacterizedActorProcess cap = DataFlowDiagramCharacterizedFactory.eINSTANCE
						.createCharacterizedActorProcess();
				cap.setActor((ExternalActor) copyNode(((CharacterizedActorProcess) n).getActor()));
				copy = cap;
			} else
				copy = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedProcess();
		} else if (n instanceof CharacterizedExternalActor) {
			copy = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedExternalActor();
		} else if (n instanceof CharacterizedStore) {
			copy = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedStore();
		}

		if (n instanceof CharacterizedNode && copy != null) {
			copy.setName(name);
			copyBehavior((CharacterizedNode) n, (CharacterizedNode) copy);
			copyCharacteristics((CharacterizedNode) n, (CharacterizedNode) copy);

		}

		return copy;
	}

	public static void copyCharacteristics(CharacterizedNode cn, CharacterizedNode ncn) {
		ncn.getCharacteristics().addAll(cn.getCharacteristics());

		EList<Characteristic> characteristics = cn.getCharacteristics();
		if (characteristics != null) {
			for (Characteristic c : characteristics) {
				EnumCharacteristic ec = (EnumCharacteristic) c;
				EnumCharacteristic nec = DataFlowDiagramCharacterizedFactory.eINSTANCE.createEnumCharacteristic();
				nec.setName(ec.getName());
				nec.setType(ec.getType());
				for (Literal l : ec.getValues()) {
					ec.getValues().add(l);
				}
				ncn.getCharacteristics().add(nec);
			}
		}

	}

	public static void copyBehavior(CharacterizedNode p, CharacterizedNode np) {
		if (p.getOwnedBehavior() != null) {
			np.setOwnedBehavior(copyBehaviorDefinition(p.getOwnedBehavior()));
		}
		if (p.getReferencedBehavior() != null) {
			//
			np.setReferencedBehavior(copyBehaviorDefinition(p.getReferencedBehavior()));
		}

	}

	public static Pin copyPin(Pin p) {
		Pin np = DataDictionaryCharacterizedFactory.eINSTANCE.createPin();
		np.setName(p.getName());
		return np;
	}

	/***
	 * functions for copying terms
	 */

	public static Term copyTerm(Term t, List<Pin> pins) {
		Term nt = null;
		if (t instanceof EnumCharacteristicReference) {
			return copyECR((EnumCharacteristicReference) t, pins);

		} else if (t instanceof Constant) {
			return copyConstant((Constant) t);
		} else if (t instanceof LogicTerm) {
			return copyLogicTerm((LogicTerm) t, pins);
		}

		return nt;
	}

	private static EnumCharacteristicReference copyECR(EnumCharacteristicReference ecr, List<Pin> pins) {

		EnumCharacteristicReference necr = null;
		if (ecr instanceof DataCharacteristicReference) {
			necr = ExpressionsFactory.eINSTANCE.createDataCharacteristicReference();
			String pinName = ((DataCharacteristicReference) ecr).getPin().getName();
			Optional<Pin> pin = pins.stream().filter(i -> i.getName().equals(pinName)).findFirst();
			if (pin.isPresent()) {
				((DataCharacteristicReference) necr).setPin(pin.get());
			}
		} else if (ecr instanceof ContainerCharacteristicReference) {
			necr = ExpressionsFactory.eINSTANCE.createContainerCharacteristicReference();
		}
		
		if (ecr.getCharacteristicType() != null)
			necr.setCharacteristicType(ecr.getCharacteristicType());
		if (ecr.getLiteral() != null)
			necr.setLiteral(ecr.getLiteral());

		return necr;
	}

	public static LogicTerm copyLogicTerm(LogicTerm lt, List<Pin> pins) {
		LogicTerm nlt = null;
		if (lt instanceof UnaryLogicTerm) {
			nlt = ExpressionsFactory.eINSTANCE.createNot();
		} else if (lt instanceof BinaryLogicTerm) {
			if (lt instanceof Or) {
				nlt = ExpressionsFactory.eINSTANCE.createOr();
				((BinaryLogicTerm) nlt).setLeft(copyTerm(((BinaryLogicTerm) lt).getLeft(), pins));
				((BinaryLogicTerm) nlt).setLeft(copyTerm(((BinaryLogicTerm) lt).getLeft(), pins));
			} else {
				nlt = ExpressionsFactory.eINSTANCE.createAnd();
				((BinaryLogicTerm) nlt).setLeft(copyTerm(((BinaryLogicTerm) lt).getLeft(), pins));
				((BinaryLogicTerm) nlt).setLeft(copyTerm(((BinaryLogicTerm) lt).getLeft(), pins));
			}
		}

		for (Term t : lt.getTerms()) {
			nlt.getTerms().add(copyTerm(t, pins));
		}

		return nlt;
	}

	public static Constant copyConstant(Constant c) {
		Constant nc;
		if (c instanceof True) {
			nc = ExpressionsFactory.eINSTANCE.createTrue();
		} else
			nc = ExpressionsFactory.eINSTANCE.createFalse();
		return nc;
	}

	public static BehaviorDefinition copyBehaviorDefinition(BehaviorDefinition b) {
		BehaviorDefinition nb = DataDictionaryCharacterizedFactory.eINSTANCE.createBehaviorDefinition();

		for (Pin ip : b.getInputs()) {
			nb.getInputs().add(copyPin(ip));
		}

		for (Pin op : b.getOutputs()) {
			nb.getOutputs().add(copyPin(op));
		}

		List<Pin> allPins = new ArrayList<>();
		allPins.addAll(nb.getOutputs());
		allPins.addAll(nb.getInputs());

		for (Assignment as : b.getAssignments()) {
			Assignment nas = DataDictionaryCharacterizedFactory.eINSTANCE.createAssignment();
			nas.setLhs((DataCharacteristicReference) copyECR(as.getLhs(), allPins));
			nas.setRhs(copyTerm(as.getRhs(), allPins));

			nb.getAssignments().add(nas);
		}

		return nb;
	}

	public static CharacterizedDataFlow makeSingleDataFlow(Data data, CharacterizedDataFlow df, NamingScheme ns) {
		CharacterizedDataFlow ndf = copyCharacterizedDataFlow(df);
		ndf.setName(data.getName());
		ndf.getData().clear();
		ndf.getData().add(copyData(data));

		Pin sourcePin = df.getSourcePin();
		Pin newSourcePin = copyPin(sourcePin);

		newSourcePin.setName(ns.makeIncrementedSuffix(sourcePin.getName()));
		ndf.setSourcePin(newSourcePin);
		((CharacterizedNode) df.getSource()).getBehavior().getOutputs().add(newSourcePin);

		Pin targetPin = df.getTargetPin();
		Pin newTargetPin = copyPin(targetPin);
		newTargetPin.setName(ns.makeSuffix(targetPin.getName()));
		ndf.setTargetPin(newTargetPin);
		((CharacterizedNode) df.getTarget()).getBehavior().getInputs().add(newTargetPin);

		return ndf;
	}

	public static CharacterizedDataFlow makeSingleDataFlow(Data data, CharacterizedDataFlow df) {
		CharacterizedDataFlow ndf = copyCharacterizedDataFlow(df);
		ndf.setName(data.getName());
		ndf.getData().clear();
		ndf.getData().add(copyData(data));

		return ndf;
	}

	public static Data copyData(Data d) {
		Data nd = DataFlowDiagramFactory.eINSTANCE.createData();
		nd.setName(d.getName());
		nd.setType(d.getType());
		return nd;
	}

	private static CharacterizedDataFlow copyCharacterizedDataFlow(CharacterizedDataFlow cdf) {
		CharacterizedDataFlow ncdf = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedDataFlow();
		ncdf.setName(cdf.getName());
		for (Data d : cdf.getData()) {
			Data nd = copyData(d);
			ncdf.getData().add(nd);
		}

		ncdf.setSource(cdf.getSource());
		ncdf.setTarget(cdf.getTarget());
		ncdf.setSourcePin(cdf.getSourcePin());
		ncdf.setTargetPin(cdf.getTargetPin());

		return ncdf;
	}

	public static CharacterizedDataFlow copyIncomingCharacterizedDataflow(CharacterizedDataFlow cdf, Node cp) {
		CharacterizedDataFlow ncdf = copyCharacterizedDataFlow(cdf);
		ncdf.setTarget(cp);
		String targetPinName = cdf.getTargetPin().getName();
		Optional<Pin> tp = ((CharacterizedNode) cp).getBehavior().getInputs().stream()
				.filter(i -> i.getName().equals(targetPinName)).findFirst();
		if (tp.isPresent())
			ncdf.setTargetPin(tp.get());
		return ncdf;
	}

	public static CharacterizedDataFlow copyOutgoingCharacterizedDataflow(CharacterizedDataFlow cdf, Node cp) {
		CharacterizedDataFlow ncdf = copyCharacterizedDataFlow(cdf);
		ncdf.setSource(cp);
		String sourcePinName = cdf.getSourcePin().getName();
		Optional<Pin> sp = ((CharacterizedNode) cp).getBehavior().getOutputs().stream()
				.filter(i -> i.getName().equals(sourcePinName)).findFirst();
		if (sp.isPresent())
			ncdf.setSourcePin(sp.get());
		return ncdf;
	}

	public static Data makeData(Entry e) {
		Data d = DataFlowDiagramFactory.eINSTANCE.createData();
		d.setName(e.getName());
		d.setType(e.getType());
		return d;
	}

}
