package game;

import game.logic.GameRules;
import game.model.Command;
import game.model.Play;
import game.model.Player;
import org.junit.Test;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameRulesTest {

    private Map<Command, Command> rules = new EnumMap<Command, Command>(Command.class){{
        put(Command.Paper, Command.Rock);
        put(Command.Rock, Command.Scissor);
        put(Command.Scissor, Command.Paper);
    }};
    private GameRules gameRules = new GameRules(rules);
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