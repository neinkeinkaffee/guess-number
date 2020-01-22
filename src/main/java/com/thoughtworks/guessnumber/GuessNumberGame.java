package com.thoughtworks.guessnumber;

public class GuessNumberGame {
    private SolutionGenerator solutionGenerator;
    private Prompter prompter;
    private Rater rater;

    public GuessNumberGame(SolutionGenerator solutionGenerator, Prompter prompter, Rater rater) {
        this.solutionGenerator = solutionGenerator;
        this.prompter = prompter;
        this.rater = rater;
    }

    public void play() {
        NumberCombination numberCombination = solutionGenerator.generateSolution();
        for (int i = 0; i < 6; i++) {
            NumberCombination guess = prompter.prompt();
            Rating rating = rater.rateGuess(guess, numberCombination);
            if (rating.getInPlaceMatches() == 4) {
                break;
            }
        }
    }
}
