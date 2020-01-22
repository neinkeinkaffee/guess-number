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
        when(solutionGenerator.generateSolution()).thenReturn(mock(Solution.class));
        when(rater.rateSolution(any(Solution.class))).thenReturn(mock(Rating.class));
        GuessNumberGame guessNumberGame = new GuessNumberGame(solutionGenerator, prompter, rater);

        guessNumberGame.play();

        verify(solutionGenerator, times(1)).generateSolution();
        verify(rater, times(6)).rateSolution(any(Solution.class));
    }

    @Test
    public void should_stop_after_player_guesses_correct() {
        SolutionGenerator solutionGenerator = mock(SolutionGenerator.class);
        Prompter prompter = mock(Prompter.class);
        Solution incorrectGuess = mock(Solution.class);
        Solution correctGuess = mock(Solution.class);
        when(solutionGenerator.generateSolution()).thenReturn(mock(Solution.class));
        when(prompter.prompt())
                .thenReturn(incorrectGuess)
                .thenReturn(incorrectGuess)
                .thenReturn(correctGuess);
        Rater rater = mock(Rater.class);
        when(rater.rateSolution(incorrectGuess)).thenReturn(new Rating(0, 0));
        when(rater.rateSolution(correctGuess)).thenReturn(new Rating(4, 0));
        GuessNumberGame guessNumberGame = new GuessNumberGame(solutionGenerator, prompter, rater);

        guessNumberGame.play();

        verify(solutionGenerator, times(1)).generateSolution();
        verify(rater, times(3)).rateSolution(any(Solution.class));
    }
}