package com.thoughtworks.guessnumber;

import java.util.stream.IntStream;

public class Rater {
    public Rating rateGuess(NumberCombination guess, NumberCombination numberCombination) {
        int inPlaceMatches = 0;
        int outOfPlaceMatches = 0;
        for (int i = 0; i < 4; i++) {
            int guessNumber = guess.getNumbers()[i];
            if (guessNumber == numberCombination.getNumbers()[i]) {
                inPlaceMatches++;
            } else if (IntStream.of(numberCombination.getNumbers()).anyMatch(x -> x == guessNumber)) {
                outOfPlaceMatches++;
            }
        }
        return new Rating(inPlaceMatches, outOfPlaceMatches);
    }
}
