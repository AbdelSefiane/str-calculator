package org.lacombe.kata;

public class StringCalculator {
    public Integer sum(String s) {
        Integer accumulator = 0;
        if (s.isEmpty()) {
            return 0;
        }
        String[] operands = s.split(",");
        for (String operand : operands) {
            accumulator += Integer.valueOf(operand);
        }
        return accumulator;
    }
}
