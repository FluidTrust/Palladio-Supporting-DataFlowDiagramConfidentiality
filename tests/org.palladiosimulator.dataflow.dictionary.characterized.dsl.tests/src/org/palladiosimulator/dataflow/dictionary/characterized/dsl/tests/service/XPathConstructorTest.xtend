package org.palladiosimulator.dataflow.dictionary.characterized.dsl.tests.service

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.DataDictionaryCharacterizedFactory
import org.palladiosimulator.dataflow.dictionary.characterized.DataDictionaryCharacterized.expressions.ExpressionsFactory
import org.palladiosimulator.dataflow.dictionary.characterized.dsl.service.XPathConstructor

import static org.junit.jupiter.api.Assertions.*

class XPathConstructorTest {

	extension val DataDictionaryCharacterizedFactory dictionaryFactory = DataDictionaryCharacterizedFactory.eINSTANCE
	extension val ExpressionsFactory expressionsFactory = ExpressionsFactory.eINSTANCE
	XPathConstructor subject

	@BeforeEach
	def void setup() {
		subject = new XPathConstructor
	}

	@Test
	def testRootElement() {
		val id = subject.getId(exampleModel, "rootId")
		assertEquals("rootId", id)
	}

	@Test
	def testFirstChild() {
		val element = exampleModel.enumerations.get(1)
		val id = subject.getId(element, "rootId")
		assertEquals("rootId-enumerations@1", id)
	}

	@Test
	def testSecondChild() {
		val element = exampleModel.enumerations.get(0).literals.get(1)
		val id = subject.getId(element, "rootId")
		assertEquals("rootId-enumerations@0.literals@1", id)
	}

	@Test
	def testNonListChild() {
		val element = exampleModel.behaviorDefinitions.get(0).assignments.get(0).lhs
		val id = subject.getId(element, "rootId")
		assertEquals("rootId-behaviorDefinitions@0.assignments@0.lhs@0", id)
	}

	protected def getExampleModel() {
		createDataDictionaryCharacterized => [
			id = "rootId"
			enumerations += createEnumeration => [
				name = "Test"
				literals += createLiteral => [
					name = "Literal1"
				]
				literals += createLiteral => [
					name = "Literal2"
				]
			]
			enumerations += createEnumeration => [
				name = "Test2"
			]
			behaviorDefinitions += createBehaviorDefinition => [
				assignments += createAssignment => [
					lhs = createDataCharacteristicReference
				]
			]
		]
	}

}
