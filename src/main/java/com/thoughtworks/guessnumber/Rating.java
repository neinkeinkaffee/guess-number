package com.thoughtworks.guessnumber;

public class Rating {
    private final int inPlaceMatches;
    private final int outOfPlaceMatches;

    public Rating(int inPlaceMatches, int outOfPlaceMatches) {
        this.inPlaceMatches = inPlaceMatches;
        this.outOfPlaceMatches = outOfPlaceMatches;
    }
}
