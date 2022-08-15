package org.lacombe.kata;

public class StringCalculator {
    public Integer sum(String s) {
        if ("".equals(s)) {
            return 0;
        }
        return Integer.valueOf(s);
    }
}
