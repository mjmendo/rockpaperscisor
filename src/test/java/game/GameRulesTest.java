package game;

import game.config.AppContext;
import game.logic.GameRules;
import game.model.Command;
import game.model.Play;
import game.model.Player;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class GameRulesTest {

    private GameRules gameRules = new GameRules(new AppContext().rules());
    private Player player1 = new Player("player1");
    private Player player2 = new Player("player2");

    @Test
    public void rockBeatsScissor(){
        Play rock = buildWith(player1, Command.Rock);
        Play scissor = buildWith(player2, Command.Scissor);

        Optional<Play> winner = gameRules.check(rock, scissor);

        assertTrue("Result play should be present", winner.isPresent());
        assertEquals("Winner player is not correct", player1, winner.get().getPlayer());
    }

    @Test
    public void scissorBeatsPaper(){
        Play paper = buildWith(player1, Command.Paper);
        Play scissor = buildWith(player2, Command.Scissor);

        Optional<Play> winner = gameRules.check(paper, scissor);

        assertTrue("Result play should be present", winner.isPresent());
        assertEquals("Winner player is not correct", player2, winner.get().getPlayer());
    }

    @Test
    public void paperBeatsRock(){
        Play paper = buildWith(player1, Command.Paper);
        Play rock = buildWith(player2, Command.Rock);

        Optional<Play> winner = gameRules.check(paper, rock);

        assertTrue("Result play should be present", winner.isPresent());
        assertEquals("Winner player is not correct", player1, winner.get().getPlayer());
    }

    @Test
    public void sameMeansNoWinner(){
        Play rock = buildWith(player1, Command.Paper);
        Play scissor = buildWith(player2, Command.Paper);

        Optional<Play> winner = gameRules.check(rock, scissor);

        assertFalse("Result play should NOT be present", winner.isPresent());
    }

    private Play buildWith(Player player, Command command){
        return new Play(player, command);
    }

}