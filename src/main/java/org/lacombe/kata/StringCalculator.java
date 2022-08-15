package org.lacombe.kata;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static final int UPPER_BOUND = 1000;
    public static final int LOWER_BOUND = 0;

    public Integer add(String input) {
        List<Integer> operands = SeparatorHandler.getInstance(input)
                                                 .parseLine(input);
        return add(operands);
    }

    public Integer add(List<Integer> operands) {
        Integer accumulator = LOWER_BOUND;
        List<Integer> negatifs = new ArrayList<>();
        for (Integer operand : operands) {
            if (operand < LOWER_BOUND) {
                negatifs.add(operand);
            }
            if (accumulator > LOWER_BOUND && operand >= UPPER_BOUND) {
                operand = LOWER_BOUND;
            }
            accumulator += operand;
        }
        if (negatifs.size() > LOWER_BOUND) {
            throw new RuntimeException("negatives not allowed: " + negatifs);
        }
        return accumulator;
    }
}
