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
        Solution solution = solutionGenerator.generateSolution();
        for (int i = 0; i < 6; i++) {
            Solution guess = prompter.prompt();
            Rating rating = rater.rateSolution(guess);
            if (rating.getInPlaceMatches() == 4) {
                break;
            }
        }
    }
}
