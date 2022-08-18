package org.lacombe.kata;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class OperationParser {
    public static final Predicate<String> BLANK_STRING = str -> !str.isBlank();
    DelimiterExtracter delimiterHandler;

    public List<Operand> parseLine(String input) {
        this.delimiterHandler = DelimiterHandler.getInstance(input);
        return Stream.of(delimiterHandler.extractFrom(input))
                     .flatMap(OperationSpliter::splitOperands)
                     .filter(BLANK_STRING)
                     .map(Operand::valueOf)
                     .toList();
    }

}
