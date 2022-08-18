package org.lacombe.kata;

public class Operand implements Comparable<Operand> {
    private final Integer value;

    public Operand(Integer value) {
        this.value = value;
    }

    public static Operand valueOf(String strValue) {
        Integer value = Integer.valueOf(strValue);
        return new Operand(value);
    }

    public Operand add(Operand b) {
        return new Operand(value + b.value);
    }

    public int intValue() {
        return this.value;
    }

    public boolean isPositif() {
        return this.value >= 0;
    }

    @Override
    public int compareTo(Operand o) {
        return value - o.value;
    }

    public String toString() {
        return String.valueOf(value);
    }

}
