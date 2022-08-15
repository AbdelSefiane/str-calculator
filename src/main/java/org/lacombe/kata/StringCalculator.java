package org.lacombe.kata;

public class StringCalculator {
    public Integer sum(String s) {
        Integer accumulator = 0;
        if (s.isBlank()) {
            return 0;
        }
        String[] operands = s.replace("\n", ",")
                             .split(",");
        for (String operand : operands) {
            accumulator += Integer.valueOf(operand);
        }
        return accumulator;
    }
}
