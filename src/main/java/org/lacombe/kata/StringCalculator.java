package org.lacombe.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<Integer> operands = Stream.of(harmonizedOutput.split(separator))
                                       .filter(str -> !str.isBlank())
                                       .map(Integer::valueOf)
                                       .collect(Collectors.toList());
        return sum(operands, harmonizedOutput);
    }

    public Integer sum(List<Integer> operands, String s) {
        Integer accumulator = 0;
        List<Integer> negatifs = new ArrayList<>();
        if (s.isBlank()) {
            return 0;
        }
        for (Integer operand : operands) {
            if (operand < 0) {
                negatifs.add(operand);
            }
            accumulator += operand;
        }
        if (negatifs.size() > 0) {
            throw new RuntimeException("negatives not allowed: " + negatifs);
        }
        return accumulator;
    }
}
