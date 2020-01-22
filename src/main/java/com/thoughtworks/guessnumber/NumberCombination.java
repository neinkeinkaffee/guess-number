package com.thoughtworks.guessnumber;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.stream.Collectors;

public class NumberCombination {
    private final int[] numbers;

    public NumberCombination(int i, int i1, int i2, int i3) {
        this.numbers = new int[]{i, i1, i2, i3};
    }

    public static NumberCombination from(String inputString) {
        int[] numbers = new int[4];
        String[] numberStrings = inputString.split(" ");
        for (int i = 0; i < 4; i++) {
            try {
                numbers[i] = Integer.valueOf(numberStrings[i]);
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < i; j++) {
                if (numbers[j] == numbers[i]) {
                    throw new IllegalArgumentException();
                }
            }
        }
        return new NumberCombination(numbers[0], numbers[1], numbers[2], numbers[3]);
    }

    public int[] getNumbers() {
        return numbers;
    }
}
