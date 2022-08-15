package org.lacombe.kata;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class OperationSeparatorHandler {
    String defaultSeparator = ",";
    public static final int CUSTOM_SEPARATOR_PREFIX_LEN = 2;

    protected abstract String extractSeparator(String input);

    public List<Integer> parseLine(String input) {
        input = this.extractSeparator(input);
        String harmonizedOutput = input.replace("\n", defaultSeparator);
        return Stream.of(harmonizedOutput.split(defaultSeparator))
                     .filter(str -> !str.isBlank())
                     .map(Integer::valueOf)
                     .collect(Collectors.toList());
    }
}
