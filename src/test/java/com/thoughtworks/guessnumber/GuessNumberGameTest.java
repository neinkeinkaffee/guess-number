package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class GuessNumberGameTest {

    @Test
    public void should_grant_player_six_guesses_maximum() {
        SolutionGenerator solutionGenerator = mock(SolutionGenerator.class);
        Prompter prompter = mock(Prompter.class);
        Rater rater = mock(Rater.class);
        when(solutionGenerator.generateSolution()).thenReturn(mock(NumberCombination.class));
        when(rater.rateGuess(any(NumberCombination.class), any(NumberCombination.class))).thenReturn(mock(Rating.class));
        GuessNumberGame guessNumberGame = new GuessNumberGame(solutionGenerator, prompter, rater);

        guessNumberGame.play();

        verify(solutionGenerator, times(1)).generateSolution();
        verify(rater, times(6)).rateGuess(any(NumberCombination.class), any(NumberCombination.class));
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
        verify(rater, times(3)).rateGuess(any(NumberCombination.class), any(NumberCombination.class));
    }
}