package com.thoughtworks.guessnumber;

public class GuessNumberGame {
    private SolutionGenerator solutionGenerator;
    private SolutionRater solutionRater;

    public GuessNumberGame(SolutionGenerator solutionGenerator, SolutionRater solutionRater) {
        this.solutionGenerator = solutionGenerator;
        this.solutionRater = solutionRater;
    }

    public void play() {
        Solution solution = solutionGenerator.generateSolution();
        for (int i = 0; i < 6; i++) {
            Solution guess = new Solution(5, 6, 7, 8);
            solutionRater.rateSolution(guess);
        }
    }
}
