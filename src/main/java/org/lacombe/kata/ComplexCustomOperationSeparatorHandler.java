package org.lacombe.kata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ComplexCustomOperationSeparatorHandler extends OperationSeparatorHandler {

    public static final String CUSTOM_PREFIX_GROUP_CLOSING = "]";

    @Override
    public String extractSeparator(String input) {
        int configLineEndIndex = input.indexOf("\n");
        String customDelimiter = input.substring(CUSTOM_SEPARATOR_PREFIX_LEN, configLineEndIndex);
        List<String> separatorList = Stream.of(customDelimiter.split(CUSTOM_PREFIX_GROUP_CLOSING))
                                           .map(sep -> sep.substring(1))//opening
                                           .collect(Collectors.toList());
        input = input.substring(configLineEndIndex)
                     .trim();
        for (String delimiter : separatorList) {
            input = input.replace(delimiter, defaultSeparator);
        }
        return input;
    }
}
