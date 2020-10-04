package org.palladiosimulator.dataflow.dictionary.characterized.dsl.converter;

import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;

public class CharacterizedDataDictionaryValueConverter extends Ecore2XtextTerminalConverters {

    @ValueConverter(rule = "NameString")
    public IValueConverter<String> NameString() {
        return new AbstractNullSafeConverter<String>() {

            @Override
            protected String internalToString(String value) {
                return String.format("\"%s\"", value);
            }

            @Override
            protected String internalToValue(String string, INode node) throws ValueConverterException {
                if (string.matches("\\\".*\\\"")) {
                    return string.subSequence(1, string.length() - 1)
                        .toString();
                }
                return string;
            }

        };
    }

}
