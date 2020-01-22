package com.thoughtworks.guessnumber;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Rater {
    public Rating rateGuess(Solution guess, Solution solution) {
        int inPlaceMatches = 0;
        int outOfPlaceMatches = 0;
        for (int i = 0; i < 4; i++) {
            int guessNumber = guess.getNumbers()[i];
            if (guessNumber == solution.getNumbers()[i]) {
                inPlaceMatches++;
            } else if (IntStream.of(solution.getNumbers()).anyMatch(x -> x == guessNumber)) {
                outOfPlaceMatches++;
            }
        }
        return new Rating(inPlaceMatches, outOfPlaceMatches);
    }
}
