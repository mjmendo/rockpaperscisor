package game;

import java.util.Random;

public class PlayGenerator {

    public Play random(Player random) {
        return new Play(random, Command.values()[getRandomNumberInRange(0,2)]);
    }

    public Play alwaysRock(Player player2) {
        return new Play(player2, Command.Rock);
    }

    private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }
}
