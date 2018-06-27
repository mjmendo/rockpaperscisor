package game;

import game.logic.PlayGenerator;
import game.model.Command;
import game.model.Player;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

public class PlayGeneratorTest {

    private PlayGenerator playGenerator = new PlayGenerator();

    @Test
    public void generateAlwaysRock(){
        boolean allMatch = IntStream.range(0, 10)
                .mapToObj(i -> playGenerator.alwaysRock(new Player("somename")))
                .allMatch(alwaysRock2 -> Command.Rock == alwaysRock2.getCommand());

        assertTrue("Play should be always rock", allMatch);
    }

    @Test
    public void generateRandom(){
        long count = IntStream.range(0, 10)
                .mapToObj(i -> playGenerator.random(new Player("somename")).getCommand())
                .distinct()
                .count();

        assertTrue("Should have generated more than 1 distinct command type", count > 1);

    }
}