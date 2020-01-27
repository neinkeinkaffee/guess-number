package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GuessNumberGameTest {

    @Test
    public void should_grant_player_six_guesses_maximum() {
        SolutionGenerator solutionGenerator = mock(SolutionGenerator.class);
        NumberCombination solution = mock(NumberCombination.class);
        when(solutionGenerator.generateSolution()).thenReturn(solution);
        Terminal terminal = mock(Terminal.class);
        String incorrectGuess = "5 6 7 8";
        when(terminal.prompt("Please take a guess")).thenReturn(incorrectGuess);
        NumberCombination incorrectGuessParsed = NumberCombination.from(incorrectGuess);
        Rater rater = mock(Rater.class);
        Rating allWrongRating = new Rating(0, 0);
        when(rater.rateGuess(incorrectGuessParsed, solution)).thenReturn(allWrongRating);
        GuessNumberGame guessNumberGame = new GuessNumberGame(solutionGenerator, terminal, rater);

        guessNumberGame.play();

        verify(terminal, times(6)).prompt("Please take a guess");
        verify(terminal, times(1)).alert("You lose.");
    }

    @Test
    public void should_stop_after_player_guesses_correct() {
        SolutionGenerator solutionGenerator = mock(SolutionGenerator.class);
        NumberCombination solution = mock(NumberCombination.class);
        when(solutionGenerator.generateSolution()).thenReturn(solution);
        Terminal terminal = mock(Terminal.class);
        String incorrectGuess = "5 6 7 8";
        String correctGuess = "1 2 3 4";
        when(terminal.prompt("Please take a guess"))
                .thenReturn(incorrectGuess)
                .thenReturn(incorrectGuess)
                .thenReturn(correctGuess);
        NumberCombination incorrectGuessParsed = NumberCombination.from(incorrectGuess);
        NumberCombination correctGuessParsed = NumberCombination.from(correctGuess);
        Rater rater = mock(Rater.class);
        when(rater.rateGuess(incorrectGuessParsed, solution)).thenReturn(new Rating(0, 0));
        when(rater.rateGuess(correctGuessParsed, solution)).thenReturn(new Rating(4, 0));
        GuessNumberGame guessNumberGame = new GuessNumberGame(solutionGenerator, terminal, rater);

        guessNumberGame.play();

        verify(terminal, times(3)).prompt("Please take a guess");
        verify(terminal, times(1)).alert("You win.");
    }
}