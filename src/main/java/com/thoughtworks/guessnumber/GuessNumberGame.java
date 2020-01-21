package com.thoughtworks.guessnumber;

public class GuessNumberGame {
    private SolutionGenerator solutionGenerator;
    private GuessPrompter guessPrompter;
    private GuessRater guessRater;

    public GuessNumberGame(SolutionGenerator solutionGenerator, GuessPrompter guessPrompter, GuessRater guessRater) {
        this.solutionGenerator = solutionGenerator;
        this.guessPrompter = guessPrompter;
        this.guessRater = guessRater;
    }

    public void play() {
        Solution solution = solutionGenerator.generateSolution();
        for (int i = 0; i < 6; i++) {
            Solution guess = guessPrompter.prompt();
            Rating rating = guessRater.rateSolution(guess);
            if (rating.getInPlaceMatches() == 4) {
                break;
            }
        }
    }
}
