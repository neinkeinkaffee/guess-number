package com.thoughtworks.guessnumber;

public class Rating {
    private final int inPlaceMatches;
    private final int outOfPlaceMatches;

    public Rating(int inPlaceMatches, int outOfPlaceMatches) {
        this.inPlaceMatches = inPlaceMatches;
        this.outOfPlaceMatches = outOfPlaceMatches;
    }

    public int getInPlaceMatches() {
        return inPlaceMatches;
    }

    public int getOutOfPlaceMatches() {
        return outOfPlaceMatches;
    }

    @Override
    public String toString() {
        return String.format("%dA%dB", this.inPlaceMatches, this.outOfPlaceMatches);
    }
}
