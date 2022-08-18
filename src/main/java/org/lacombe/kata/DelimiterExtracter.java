package org.lacombe.kata;

public interface DelimiterExtracter {

    String FINAL_DELIMITER = ",";

    String extractFrom(String input);

}
