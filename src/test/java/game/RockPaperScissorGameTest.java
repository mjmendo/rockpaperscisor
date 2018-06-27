package game;

import game.logic.GameRules;
import game.logic.PlayGenerator;
import game.model.Command;
import game.model.Play;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RockPaperScissorGameTest {

    private RockPaperScissorGame game;
    private PlayGenerator playGenerator;
    private GameRules rules;
    private Play play1;
    private Play play2;


    @Before
    public void before(){
        play1 = mock(Play.class);
        play2 = mock(Play.class);

        playGenerator = mock(PlayGenerator.class);
        when(playGenerator.random(any())).thenReturn(play1);
        when(playGenerator.alwaysRock(any())).thenReturn(play2);

        rules = mock(GameRules.class);

        game = new RockPaperScissorGame(null, null, playGenerator, rules);

    }

    @Test
    public void whenThereIsWinnerShouldInformIt(){
        when(play1.getCommand()).thenReturn(Command.Scissor);
        when(play2.getCommand()).thenReturn(Command.Paper);

        when(rules.check(any(), any())).thenReturn(Optional.of(play1));

        String play = game.play();
        assertTrue("Should contain player 1's command", play.contains(play1.getCommand().name()));
        assertTrue("Should contain player 2's command", play.contains(play2.getCommand().name()));
        assertTrue("Winner should be informed", play.contains("Scissor wins!"));
    }

    @Test
    public void whenThereIsDrawShouldInformIt(){
        when(play1.getCommand()).thenReturn(Command.Scissor);
        when(play2.getCommand()).thenReturn(Command.Scissor);

        when(rules.check(any(), any())).thenReturn(Optional.empty());

        String play = game.play();
        String temp = play.replace(Command.Scissor.name(), "");
        int commandOccurrences = (play.length() - temp.length()) / Command.Scissor.name().length();

        assertTrue("Same command is informed twice", commandOccurrences == 2);
        assertTrue("Draw should be informed", play.toLowerCase().contains("draw!"));
    }


}