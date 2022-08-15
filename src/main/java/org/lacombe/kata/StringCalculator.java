package org.lacombe.kata;

public class StringCalculator {
    public Integer sum(String s) {
        String separator = ",";
        if (s.startsWith("//")) {
            int i = s.indexOf("\n");
            String customDelimiter = s.substring(2, i);
            separator = customDelimiter;
            s = s.substring(i)
                 .trim();
        }
        String harmonizedOutput = s.replace("\n", separator);
        return sum(separator, harmonizedOutput);
    }

    public Integer sum(String separator, String s) {
        if (s.isBlank()) {
            return 0;
        }
        Integer accumulator = 0;
        String[] operands = s.split(separator);
        for (String operand : operands) {
            accumulator += Integer.valueOf(operand);
        }
        return accumulator;
    }
}
