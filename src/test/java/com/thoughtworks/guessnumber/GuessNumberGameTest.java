package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class GuessNumberGameTest {

    @Test
    public void should_grant_player_six_guesses_maximum() {
        SolutionGenerator solutionGenerator = mock(SolutionGenerator.class);
        NumberCombination solution = mock(NumberCombination.class);
        when(solutionGenerator.generateSolution()).thenReturn(solution);
        Prompter prompter = mock(Prompter.class);
        String incorrectGuess = "5 6 7 8";
        when(prompter.prompt()).thenReturn(incorrectGuess);
        Parser parser = mock(Parser.class);
        NumberCombination incorrectGuessParsed = mock(NumberCombination.class);
        when(parser.parse(incorrectGuess)).thenReturn(incorrectGuessParsed);
        Rater rater = mock(Rater.class);
        Rating allWrongRating = new Rating(0, 0);
        when(rater.rateGuess(incorrectGuessParsed, solution)).thenReturn(allWrongRating);
        GuessNumberGame guessNumberGame = new GuessNumberGame(solutionGenerator, prompter, parser, rater);

        guessNumberGame.play();

        verify(prompter, times(6)).prompt();
    }

    @Test
    public void should_stop_after_player_guesses_correct() {
        SolutionGenerator solutionGenerator = mock(SolutionGenerator.class);
        NumberCombination solution = mock(NumberCombination.class);
        when(solutionGenerator.generateSolution()).thenReturn(solution);
        Prompter prompter = mock(Prompter.class);
        String incorrectGuess = "5 6 7 8";
        String correctGuess = "1 2 3 4";
        when(prompter.prompt())
                .thenReturn(incorrectGuess)
                .thenReturn(incorrectGuess)
                .thenReturn(correctGuess);
        Parser parser = mock(Parser.class);
        NumberCombination incorrectGuessParsed = mock(NumberCombination.class);
        NumberCombination correctGuessParsed = mock(NumberCombination.class);
        when(parser.parse(incorrectGuess)).thenReturn(incorrectGuessParsed);
        when(parser.parse(correctGuess)).thenReturn(correctGuessParsed);
        Rater rater = mock(Rater.class);
        when(rater.rateGuess(incorrectGuessParsed, solution)).thenReturn(new Rating(0, 0));
        when(rater.rateGuess(correctGuessParsed, solution)).thenReturn(new Rating(4, 0));
        GuessNumberGame guessNumberGame = new GuessNumberGame(solutionGenerator, prompter, parser, rater);

        guessNumberGame.play();

        verify(prompter, times(3)).prompt();
    }
}