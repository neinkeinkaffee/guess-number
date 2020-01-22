package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RaterTest {

    @Test
    public void should_report_one_correct_in_place() {
        NumberCombination numberCombination = new NumberCombination(1, 2, 3, 4);
        NumberCombination guess = new NumberCombination(1, 5, 6, 7);
        Rater rater = new Rater();

        Rating rating = rater.rateGuess(guess, numberCombination);

        assertEquals(rating.getInPlaceMatches(), 1);
        assertEquals(rating.getOutOfPlaceMatches(), 0);
    }

    @Test
    public void should_report_two_correct_out_of_place() {
        NumberCombination numberCombination = new NumberCombination(1, 2, 3, 4);
        NumberCombination guess = new NumberCombination(2, 4, 7, 8);
        Rater rater = new Rater();

        Rating rating = rater.rateGuess(guess, numberCombination);

        assertEquals(rating.getInPlaceMatches(), 0);
        assertEquals(rating.getOutOfPlaceMatches(), 2);
    }

    @Test
    public void should_report_one_correct_in_place_two_correct_out_of_place() {
        NumberCombination numberCombination = new NumberCombination(1, 2, 3, 4);
        NumberCombination guess = new NumberCombination(0, 3, 2, 4);
        Rater rater = new Rater();

        Rating rating = rater.rateGuess(guess, numberCombination);

        assertEquals(rating.getInPlaceMatches(), 1);
        assertEquals(rating.getOutOfPlaceMatches(), 2);
    }

    @Test
    public void should_report_all_wrong() {
        NumberCombination numberCombination = new NumberCombination(1, 2, 3, 4);
        NumberCombination guess = new NumberCombination(5, 6, 7, 8);
        Rater rater = new Rater();

        Rating rating = rater.rateGuess(guess, numberCombination);

        assertEquals(rating.getInPlaceMatches(), 0);
        assertEquals(rating.getOutOfPlaceMatches(), 0);
    }

    @Test
    public void should_report_four_correct_in_place() {
        NumberCombination numberCombination = new NumberCombination(1, 2, 3, 4);
        NumberCombination guess = new NumberCombination(1, 2, 3, 4);
        Rater rater = new Rater();

        Rating rating = rater.rateGuess(guess, numberCombination);

        assertEquals(rating.getInPlaceMatches(), 4);
        assertEquals(rating.getOutOfPlaceMatches(), 0);
    }
}