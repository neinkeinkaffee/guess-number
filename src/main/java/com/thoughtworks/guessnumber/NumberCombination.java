package com.thoughtworks.guessnumber;

public class NumberCombination {
    private final int[] numbers;

    public NumberCombination(int i, int i1, int i2, int i3) {
        this.numbers = new int[]{i, i1, i2, i3};
    }

    public int[] getNumbers() {
        return numbers;
    }
}
