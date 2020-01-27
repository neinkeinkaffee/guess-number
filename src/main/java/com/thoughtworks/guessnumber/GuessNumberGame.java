package com.thoughtworks.guessnumber;

public class GuessNumberGame {
    private SolutionGenerator solutionGenerator;
    private Terminal terminal;
    private Rater rater;

    public GuessNumberGame(SolutionGenerator solutionGenerator, Terminal terminal, Rater rater) {
        this.solutionGenerator = solutionGenerator;
        this.terminal = terminal;
        this.rater = rater;
    }

    public void play() {
        NumberCombination numberCombination = solutionGenerator.generateSolution();
        for (int i = 0; i < 6; i++) {
            String guess = terminal.prompt();
            NumberCombination parsedGuess = NumberCombination.from(guess);
            Rating rating = rater.rateGuess(parsedGuess, numberCombination);
            if (rating.getInPlaceMatches() == 4) {
                terminal.alert("You win.");
                break;
            }
        }
        terminal.alert("You lose.");
    }
}
