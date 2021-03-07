package org.palladiosimulator.dataflow.confidentiality.transformation.prolog.impl

import org.palladiosimulator.dataflow.confidentiality.transformation.prolog.naming.UniqueNameProvider
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Edge
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Node
import org.palladiosimulator.dataflow.diagram.characterized.DataFlowDiagramCharacterized.CharacterizedNode
import org.palladiosimulator.dataflow.dictionary.DataDictionary.DataType
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.CharacteristicType
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Literal
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.Pin
import org.palladiosimulator.dataflow.diagram.DataFlowDiagram.Data

class UniqueNameUtils {
	
	static val extension PrologCreateUtils prologCreateUtils = new PrologCreateUtils
	val extension UniqueNameProvider provider
	
	new(UniqueNameProvider provider) {
		this.provider = provider;
	}
	
	def getUniqueQuotedString(Edge entity) {
		entity.uniqueName.toQuotedString
	}
	
	def getUniqueQuotedString(Node entity) {
		entity.uniqueName.toQuotedString
	}
	
	def getUniqueQuotedString(CharacterizedNode entity) {
		(entity as Node).uniqueQuotedString
	}
	
	def getUniqueQuotedString(CharacteristicType entity) {
		entity.uniqueName.toQuotedString
	}
	
	def getUniqueQuotedString(Literal entity) {
		entity.uniqueName.toQuotedString
	}
	
	def getUniqueQuotedString(DataType entity) {
		entity.uniqueName.toQuotedString
	}
	
	def getUniqueQuotedString(Data entity) {
		entity.uniqueName.toQuotedString
	}
	
	def getUniqueQuotedString(Pin pin, CharacterizedNode node) {
		getUniqueQuotedString(pin, node as Node)
	}
	
	def getUniqueQuotedString(Pin pin, Node node) {
		getUniqueName(pin, node as Node).toQuotedString
	}
	
}