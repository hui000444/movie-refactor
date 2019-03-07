package guessnumbertests;

import guessnumber.Answer;
import guessnumber.Game;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameTest {
    @Test
    public void should_return_0A0B_when_no_number_incorrectly(){
        Answer actualAnswer = Answer.createAnswer("1 2 3 4");
        Game game = new Game(actualAnswer);
        Answer inputAnswer = Answer.createAnswer("5 6 7 8");

        String result = game.guess(inputAnswer);
        assertThat(result, is("0A0B"));
    }
}
