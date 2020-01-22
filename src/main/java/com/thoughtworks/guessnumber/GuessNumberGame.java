package com.thoughtworks.guessnumber;

public class GuessNumberGame {
    private SolutionGenerator solutionGenerator;
    private Prompter prompter;
    private Parser parser;
    private Rater rater;

    public GuessNumberGame(SolutionGenerator solutionGenerator, Prompter prompter, Parser parser, Rater rater) {
        this.solutionGenerator = solutionGenerator;
        this.prompter = prompter;
        this.parser = parser;
        this.rater = rater;
    }

    public void play() {
        NumberCombination numberCombination = solutionGenerator.generateSolution();
        for (int i = 0; i < 6; i++) {
            String guess = prompter.prompt();
            NumberCombination parsedGuess = parser.parse(guess);
            Rating rating = rater.rateGuess(parsedGuess, numberCombination);
            if (rating.getInPlaceMatches() == 4) {
                break;
            }
        }
    }
}
