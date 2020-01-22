package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RaterTest {

    @Test
    public void should_report_one_correct_in_place() {
        Solution solution = new Solution(1, 2, 3, 4);
        Solution guess = new Solution(1, 5, 6, 7);
        Rater rater = new Rater();

        Rating rating = rater.rateGuess(guess, solution);

        assertEquals(rating.getInPlaceMatches(), 1);
        assertEquals(rating.getOutOfPlaceMatches(), 0);
    }

    @Test
    public void should_report_two_correct_out_of_place() {
        Solution solution = new Solution(1, 2, 3, 4);
        Solution guess = new Solution(2, 4, 7, 8);
        Rater rater = new Rater();

        Rating rating = rater.rateGuess(guess, solution);

        assertEquals(rating.getInPlaceMatches(), 0);
        assertEquals(rating.getOutOfPlaceMatches(), 2);
    }
}