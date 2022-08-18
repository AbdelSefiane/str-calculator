package org.lacombe.kata;

import java.util.Arrays;
import java.util.stream.Stream;

public interface OperationSpliter {
    String FINAL_DELIMITER = ",";

    static Stream<String> splitOperands(String operandArray) {
        return Arrays.stream(
                operandArray.split(FINAL_DELIMITER));
    }
}
