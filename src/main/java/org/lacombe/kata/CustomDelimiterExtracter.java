package org.lacombe.kata;

class CustomDelimiterExtracter implements DelimiterExtracter {
    public static final int CUSTOM_DELIMITER_PREFIX_LEN = 2;
    String delimiter;

    public String extractFrom(String input) {
        int configLineEndIndex = input.indexOf("\n");
        return input.substring(configLineEndIndex)
                    .replace(delimiter, FINAL_DELIMITER)
                    .trim();
    }

    public void populateDelimiter(String input) {
        int configLineEndIndex = input.indexOf("\n");
        delimiter = input.substring(CUSTOM_DELIMITER_PREFIX_LEN, configLineEndIndex);
    }
}
