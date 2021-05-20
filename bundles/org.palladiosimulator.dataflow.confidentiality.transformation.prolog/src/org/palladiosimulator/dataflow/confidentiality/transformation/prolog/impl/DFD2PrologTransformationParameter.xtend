package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.impl

import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedNode
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.EnumCharacteristicType
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal
import org.eclipse.xtend.lib.annotations.Accessors

class DFD2PrologTransformationParameter {
	
	new(CharacterizedNode node, EnumCharacteristicType ct, Literal l) {
		this.node = node
		this.ct = ct
		this.l = l
		
	}
	
	new(CharacterizedNode node, Pin pin, EnumCharacteristicType ct, Literal l) {
		this(node, ct, l)
		this.pin = pin
	}
	
	@Accessors var CharacterizedNode node
	@Accessors var Pin pin
	@Accessors var EnumCharacteristicType ct
	@Accessors var Literal l
}