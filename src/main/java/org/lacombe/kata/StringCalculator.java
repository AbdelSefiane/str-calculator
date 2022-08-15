package org.lacombe.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
    public Integer sum(String input) {
        String separator = ",";
        if (input.startsWith("//[")) {
            int configLineEndIndex = input.indexOf("\n");
            String customDelimiter = input.substring(2, configLineEndIndex);
            List<String> separatorList = Stream.of(customDelimiter.split("]"))
                                               .map(sep -> sep.substring(1))
                                               .collect(Collectors.toList());
            input = input.substring(configLineEndIndex)
                         .trim();
            for (String delimiter : separatorList) {
                input = input.replace(delimiter, separator);
            }
        }
        if (input.startsWith("//")) {
            int configLineEndIndex = input.indexOf("\n");
            String customDelimiter = input.substring(2, configLineEndIndex);
            separator = customDelimiter;
            input = input.substring(configLineEndIndex)
                         .trim();
        }
        String harmonizedOutput = input.replace("\n", separator);
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
            if (accumulator > 0 && operand >= 1000) {
                operand = 0;
            }
            accumulator += operand;
        }
        if (negatifs.size() > 0) {
            throw new RuntimeException("negatives not allowed: " + negatifs);
        }
        return accumulator;
    }
}
