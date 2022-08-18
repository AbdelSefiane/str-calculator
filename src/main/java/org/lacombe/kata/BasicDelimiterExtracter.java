package org.lacombe.kata;

class BasicDelimiterExtracter implements DelimiterExtracter {
    final String FINAL_DELIMITER = ",";

    public String extractFrom(String input) {
        return input.replace("\n", FINAL_DELIMITER);
    }

}
