package org.palladiosimulator.dataflow.dictionary.characterized.dsl.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.formatter.FormatterTestHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(CharacterizedDataDictionaryInjectorProvider)
class CharacterizedDataDictionaryFormatterTest {

    @Inject
    FormatterTestHelper formatterHelper;
    
    @Test
    def testPrimitiveDataType() {
    	'''
    	dictionary id "123456"
    	
    	primitiveDataType Dummy
    	primitiveDataType "Dummy 2"
    	primitiveDataType Dummy3
		'''.assertFormatting
    }
    
    @Test
    def testCollectionDataType() {
    	'''
    	dictionary id "123456"
    	
    	primitiveDataType Dummy
    	collectionDataType "Dummy 2" using Dummy
    	collectionDataType Dummy3 using "Dummy 2"
		'''.assertFormatting
    }
    
    @Test
    def testCompositeDataType() {
    	'''
    	dictionary id "123456"
    	
    	primitiveDataType Dummy
    	compositeDataType TestDataType {
    		propertyA using Dummy
    		propertyB using Dummy
    	}'''.assertFormatting
    }
    
	@Test
    def testEnum() {
    	'''
    	dictionary id "123456"
    	
    	enum FirstEnum {
    		A
    		B
    		C
    	}
    	enum "First Enum" {
    		A
    		"B B"
    		C
    	}'''.assertFormatting
    }
    
	@Test
    def testEnumCharacteristicType() {
    	'''
    	dictionary id "123456"
    	
    	enum FirstEnum {
    		A
    	}
    	enumCharacteristicType Type1 using FirstEnum
    	enumCharacteristicType "Type 1" using FirstEnum
    	'''.assertFormatting
    }
    
	@Test
    def testEnumCharacteristic() {
    	'''
    	dictionary id "123456"
    	
    	enum FirstEnum {
    		A
    		B
    		C
    	}
    	enumCharacteristicType Type1 using FirstEnum
    	enumCharacteristic Char1 using Type1 {
    		B
    	}
    	enumCharacteristic "Char 2" using Type1 {
    		A
    		B
    		C
    	}
    	'''.assertFormatting
    }
    
    protected def assertFormatting(CharSequence expected) {
   		val toBeFormatted = expected.toString.replaceAll("\\s(?=([^\"']*[\"'][^\"']*[\"'])*[^\"']*$)", "  ")
   		assertFormatting(expected.toString.trim, toBeFormatted)
    }
    
    protected def assertFormatting(CharSequence expected, CharSequence toBeFormatted) {
    	formatterHelper.assertFormatted([request |
	    	request.toBeFormatted = toBeFormatted
	    	request.expectation = expected
    	])
    }

}