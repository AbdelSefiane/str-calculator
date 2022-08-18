package org.lacombe.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class ComplexCustomDelimiterExtracter extends CustomDelimiterExtracter implements DelimiterExtracter {
    public static final String CUSTOM_PREFIX_GROUP_CLOSING = "]";
    List<String> delimiters = new ArrayList<>();

    @Override
    public String extractFrom(String input) {
        String output = input.substring(input.indexOf("\n"))
                             .trim()
                             .replace("\n", delimiters.get(0));
        for (String delimiter : delimiters) {
            output = output.replace(delimiter, FINAL_DELIMITER);
        }
        return output;
    }

    @Override
    public void populateDelimiter(String input) {
        int configLineEndIndex = input.indexOf("\n");
        String customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX_LEN, configLineEndIndex);
        delimiters = Stream.of(customDelimiter.split(CUSTOM_PREFIX_GROUP_CLOSING))
                           .map(delimiter -> delimiter.substring(1))//opening
                           .toList();
    }

}
