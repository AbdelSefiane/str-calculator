package org.lacombe.kata;

public class DelimiterHandler {

    public static final String CUSTOM_COMPLEX_PREFIX = "//[";
    public static final String CUSTOM_SIMPLE_PREFIX = "//";

    public static DelimiterExtracter getInstance(String input) {
        if (input.startsWith(CUSTOM_COMPLEX_PREFIX)) {
            ComplexCustomDelimiterExtracter complexCustomDelimiterExtracter = new ComplexCustomDelimiterExtracter();
            complexCustomDelimiterExtracter.populateDelimiter(input);
            return complexCustomDelimiterExtracter;
        }
        if (input.startsWith(CUSTOM_SIMPLE_PREFIX)) {
            CustomDelimiterExtracter customDelimiterExtracter = new CustomDelimiterExtracter();
            customDelimiterExtracter.populateDelimiter(input);
            return customDelimiterExtracter;
        }
        return new BasicDelimiterExtracter();
    }
}