package org.lacombe.kata;

class SimpleCustomOperationSeparatorHandler extends OperationSeparatorHandler {

    @Override
    public String extractSeparator(String input) {
        int configLineEndIndex = input.indexOf("\n");
        String customDelimiter = input.substring(CUSTOM_SEPARATOR_PREFIX_LEN, configLineEndIndex);
        defaultSeparator = customDelimiter;
        input = input.substring(configLineEndIndex)
                     .trim();
        return input;
    }
}
