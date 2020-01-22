package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class GuessNumberGameTest {

    @Test
    public void should_grant_player_six_guesses_maximum() {
        SolutionGenerator solutionGenerator = mock(SolutionGenerator.class);
        NumberCombination solution = mock(NumberCombination.class);
        when(solutionGenerator.generateSolution()).thenReturn(solution);
        Prompter prompter = mock(Prompter.class);
        NumberCombination someIncorrectGuess = mock(NumberCombination.class);
        when(prompter.prompt()).thenReturn(someIncorrectGuess);
        Rater rater = mock(Rater.class);
        Rating allWrongRating = new Rating(0, 0);
        when(rater.rateGuess(someIncorrectGuess, solution)).thenReturn(allWrongRating);
        GuessNumberGame guessNumberGame = new GuessNumberGame(solutionGenerator, prompter, rater);

        guessNumberGame.play();

        verify(solutionGenerator, times(1)).generateSolution();
        verify(prompter, times(6)).prompt();
    }

    @Test
    public void should_stop_after_player_guesses_correct() {
        SolutionGenerator solutionGenerator = mock(SolutionGenerator.class);
        Prompter prompter = mock(Prompter.class);
        NumberCombination numberCombination = mock(NumberCombination.class);
        NumberCombination incorrectGuess = mock(NumberCombination.class);
        NumberCombination correctGuess = mock(NumberCombination.class);
        when(solutionGenerator.generateSolution()).thenReturn(numberCombination);
        when(prompter.prompt())
                .thenReturn(incorrectGuess)
                .thenReturn(incorrectGuess)
                .thenReturn(correctGuess);
        Rater rater = mock(Rater.class);
        when(rater.rateGuess(incorrectGuess, numberCombination)).thenReturn(new Rating(0, 0));
        when(rater.rateGuess(correctGuess, numberCombination)).thenReturn(new Rating(4, 0));
        GuessNumberGame guessNumberGame = new GuessNumberGame(solutionGenerator, prompter, rater);

        guessNumberGame.play();

        verify(solutionGenerator, times(1)).generateSolution();
        verify(prompter, times(3)).prompt();
    }
}