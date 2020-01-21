package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class GuessNumberGameTest {

    @Test
    public void should_grant_player_six_guesses_maximum() {
        SolutionGenerator solutionGenerator = mock(SolutionGenerator.class);
        SolutionRater solutionRater = mock(SolutionRater.class);
        when(solutionGenerator.generateSolution()).thenReturn(mock(Solution.class));
        when(solutionRater.rateSolution(any(Solution.class))).thenReturn(mock(Rating.class));
        GuessNumberGame guessNumberGame = new GuessNumberGame(solutionGenerator, solutionRater);

        guessNumberGame.play();

        verify(solutionGenerator, times(1)).generateSolution();
        verify(solutionRater, times(6)).rateSolution(any(Solution.class));
    }
}