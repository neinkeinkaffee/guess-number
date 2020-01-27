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

    public String play() {
        NumberCombination numberCombination = solutionGenerator.generateSolution();
        for (int i = 0; i < 6; i++) {
            String guess = prompter.prompt();
            NumberCombination parsedGuess = NumberCombination.from(guess);
            Rating rating = rater.rateGuess(parsedGuess, numberCombination);
            if (rating.getInPlaceMatches() == 4) {
                return "You win.";
            }
        }
        return "You lose.";
    }
}
