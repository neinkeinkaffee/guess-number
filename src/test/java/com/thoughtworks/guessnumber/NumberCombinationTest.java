package com.thoughtworks.guessnumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberCombinationTest {
    @Test
    void should_throw_IllegalArgumentException_when_passing_input_string_with_less_than_four_numbers() {
        assertThrows(IllegalArgumentException.class, () -> { NumberCombination.from("1 2"); });
    }

    @Test
    void should_throw_IllegalArgumentException_when_passing_input_string_with_duplicate_numbers() {
        assertThrows(IllegalArgumentException.class, () -> { NumberCombination.from("1 1 2 3"); });
    }
}