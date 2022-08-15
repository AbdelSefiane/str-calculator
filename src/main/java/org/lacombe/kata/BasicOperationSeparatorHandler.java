package org.lacombe.kata;

class BasicOperationSeparatorHandler extends OperationSeparatorHandler {

    @Override
    protected String extractSeparator(String input) {
        return input.replace("\n", defaultSeparator);
    }

}
