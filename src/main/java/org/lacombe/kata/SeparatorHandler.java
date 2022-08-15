package org.lacombe.kata;

public class SeparatorHandler {

    public static final String CUSTOM_COMPLEX_PREFIX = "//[";
    public static final String CUSTOM_SIMPLE_PREFIX = "//";

    public static OperationSeparatorHandler getInstance(String input) {
        if (input.startsWith(CUSTOM_COMPLEX_PREFIX)) {
            return new ComplexCustomOperationSeparatorHandler();
        }
        if (input.startsWith(CUSTOM_SIMPLE_PREFIX)) {
            return new SimpleCustomOperationSeparatorHandler();
        }
        return new BasicOperationSeparatorHandler();
    }
}