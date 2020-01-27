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

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if ((o instanceof NumberCombination)
                && (((NumberCombination) o).getNumbers()[0] == this.getNumbers()[0])
                && (((NumberCombination) o).getNumbers()[1] == this.getNumbers()[1])
                && (((NumberCombination) o).getNumbers()[2] == this.getNumbers()[2])
                && (((NumberCombination) o).getNumbers()[3] == this.getNumbers()[3])) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (int i = 0; i < numbers.length; i++)
        result += (int) (numbers[i] / 11);
        return result;
    }
}
