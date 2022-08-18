package org.lacombe.kata;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Optional.ofNullable;

public class StringCalculator {
    private static final Operand UPPER_BOUND = new Operand(1000);
    private static final Operand ZERO = new Operand(0);
    private final OperationParser operationParser;

    public StringCalculator() {
        this.operationParser = new OperationParser();
    }

    public Integer add(String input) {
        return this.compute(input, this::add);
    }

    private Integer compute(String input, BinaryOperator<Operand> operation) {
        Map<Boolean, List<Operand>> operandsBySign = operationParser
                .parseLine(input)
                .stream()
                .collect(Collectors.groupingBy(Operand::isPositif));
        if (operandsBySign.isEmpty()) {
            return 0;
        }
        checkNegatif(ofNullable(operandsBySign.get(FALSE)));
        return operandsBySign.get(TRUE)
                             .stream()
                             .reduce(operation)
                             .orElse(new Operand(0))
                             .intValue();
    }

    private void checkNegatif(Optional<List<Operand>> operands) {
        if (containsNegatif(operands)) {
            throw new CalculationException("negatives not allowed: " + operands.get());
        }
    }

    private static Boolean containsNegatif(Optional<List<Operand>> operands) {
        return operands.map(a -> a.size() > 0)
                       .orElse(FALSE);
    }

    private Operand add(Operand a, Operand b) {
        if (!inBounds(a, b)) {
            return a;
        }
        return a.add(b);
    }

    private boolean inBounds(Operand a, Operand b) {
        return a.compareTo(ZERO) > 0 && b.compareTo(UPPER_BOUND) < 0;
    }

}
