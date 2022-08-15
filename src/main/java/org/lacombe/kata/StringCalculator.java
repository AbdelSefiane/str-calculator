package org.lacombe.kata;

public class StringCalculator {
    public Integer sum(String s) {
        String separator = ",";
        Integer accumulator = 0;
        if (s.isBlank()) {
            return 0;
        }
        if (s.startsWith("//")) {
            int i = s.indexOf("\n");
            String customDelimiter = s.substring(2, i);
            separator = customDelimiter;
            s = s.substring(i)
                 .trim();
        }
        String harmonizedOutput = s.replace("\n", separator);
        String[] operands = harmonizedOutput.split(separator);
        for (String operand : operands) {
            accumulator += Integer.valueOf(operand);
        }
        return accumulator;
    }
}
