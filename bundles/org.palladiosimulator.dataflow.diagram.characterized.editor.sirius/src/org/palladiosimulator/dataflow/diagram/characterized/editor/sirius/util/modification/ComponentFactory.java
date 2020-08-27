package org.palladiosimulator.dataflow.diagram.characterized.editor.sirius.util.modification;

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
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.DataCharacteristicReference;
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsFactory;



public class ComponentFactory {


	public static void createCDF(EObject self, EObject sourcePin, EObject targetPin, EObject sourceNode, EObject targetNode, boolean needsRef) {
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
		// TODO handle characteristics + behavior
		if (n instanceof CharacterizedProcess) {
			CharacterizedProcess cp;
			if (n instanceof CharacterizedActorProcess) {
				CharacterizedActorProcess cap=DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedActorProcess();
				cap.setActor((ExternalActor) copyNode(((CharacterizedActorProcess) n).getActor()));
				cp=cap;
			}
			else cp= DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedProcess();
			cp.setName(name);
			copyBehavior((CharacterizedNode) n, (CharacterizedNode) cp);
			copyCharacteristics((CharacterizedNode) n, (CharacterizedNode) cp);
			copy=cp;
		} else if (n instanceof CharacterizedExternalActor) {
			CharacterizedExternalActor cea = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedExternalActor();
			cea.setName(name);
			copyBehavior((CharacterizedNode) n, (CharacterizedNode) cea);
			copyCharacteristics((CharacterizedNode) n, (CharacterizedNode) cea);
			copy = cea;
		} else if (n instanceof CharacterizedStore) {
			CharacterizedStore cs = DataFlowDiagramCharacterizedFactory.eINSTANCE.createCharacterizedStore();
			cs.setName(name);
			copyBehavior((CharacterizedNode) n, (CharacterizedNode) cs);
			copyCharacteristics((CharacterizedNode) n, (CharacterizedNode) cs);
			copy = cs;
		}

		return copy;
	}
	
	public static void copyCharacteristics(CharacterizedNode cn, CharacterizedNode ncn) {
		EList<Characteristic> characteristics = cn.getCharacteristics();
		if(characteristics!=null) {
			for(Characteristic c: characteristics) {
				EnumCharacteristic ec = (EnumCharacteristic) c;
				EnumCharacteristic nec = DataFlowDiagramCharacterizedFactory.eINSTANCE.createEnumCharacteristic();
				nec.setName(ec.getName());
				nec.setType(ec.getType());
				for(Literal l: ec.getValues()) {
					Literal nl = DataDictionaryCharacterizedFactory.eINSTANCE.createLiteral();
					nl.setName(l.getName());
					nl.setEnum(l.getEnum());
					nec.getValues().add(nl);
				}
				ncn.getCharacteristics().add(nec);
			}
		}
		
	}
	
	

	public static void copyBehavior(CharacterizedNode p, CharacterizedNode np) {
		if(p.getOwnedBehavior()!=null) {
			np.setOwnedBehavior(copyBehaviorDefinition(p.getOwnedBehavior()));
		}
		if(p.getReferencedBehavior()!=null) {
			np.setReferencedBehavior(copyBehaviorDefinition(p.getOwnedBehavior()));
		}

	}
	
	
	public static Pin copyPin(Pin p) {
		Pin np = DataDictionaryCharacterizedFactory.eINSTANCE.createPin();
		np.setName(p.getName());
		return np;
	}

	public static Assignment copyAssignment(Assignment as) {
		Assignment nas = DataDictionaryCharacterizedFactory.eINSTANCE.createAssignment();
		// TODO copy left and right hand side
		DataCharacteristicReference lhs = nas.getLhs();
		//		nas.setLhs();
		//		nas.setRhs();
		//		
		return as;
	}

	public static DataCharacteristicReference copyLhs(DataCharacteristicReference lhs) {
		DataCharacteristicReference nlhs = ExpressionsFactory.eINSTANCE.createDataCharacteristicReference();
		// TODO handle pins, literals, characteristic type
		//		nlhs.setCharacteristicType(todo);
		//		nlhs.setLiteral(todo);
		//		nlhs.setPin(todo); // search for this pin?? 
		return nlhs;
	}

	public static BehaviorDefinition copyBehaviorDefinition(BehaviorDefinition b) {
		BehaviorDefinition nb = DataDictionaryCharacterizedFactory.eINSTANCE.createBehaviorDefinition();

		for(Pin ip: b.getInputs()) {
			nb.getInputs().add(copyPin(ip));
		}

		for(Pin op: b.getOutputs()) {
			nb.getOutputs().add(copyPin(op));
		}

		for(Assignment as: b.getAssignments()) {

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
		Pin tp = ((CharacterizedNode)cp).getBehavior().getInputs().stream().
				filter(i ->  i.getName().equals(targetPinName))
				.findFirst().get();
		ncdf.setTargetPin(tp);
		return ncdf;
	}
	
	public static CharacterizedDataFlow copyOutgoingCharacterizedDataflow(CharacterizedDataFlow cdf, Node cp) {
		CharacterizedDataFlow ncdf = copyCharacterizedDataFlow(cdf);
		ncdf.setSource(cp);
		String sourcePinName = cdf.getSourcePin().getName(); 
		Pin sp = ((CharacterizedNode)cp).getBehavior().getOutputs().stream().
				filter(i ->  i.getName().equals(sourcePinName))
				.findFirst().get();
		ncdf.setSourcePin(sp);
		return ncdf;
	}

	public static Data makeData(Entry e) {
		Data d = DataFlowDiagramFactory.eINSTANCE.createData();
		d.setName(e.getName());
		d.setType(e.getType());
		return d;
	}

}
