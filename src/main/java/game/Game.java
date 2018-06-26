package game;

import java.util.Optional;

public class Game {

    private Player player1;
    private Player player2;
    private PlayGenerator playGenerator;
    private GameRules rules;

    public String play() {
        Play randomPlay = playGenerator.random(player1);
        Play alwaysRockPlay = playGenerator.alwaysRock(player2);

        Optional<Play> winner = rules.check(alwaysRockPlay, randomPlay);

        if (winner.isPresent()){
            return String.format("%s <-> %s -> %s wins!",
                    randomPlay.command.name(), alwaysRockPlay.command.name(),
                    winner.get().command);
        } else {
            return String.format("%s <-> %s -> draw!",
                    randomPlay.command.name(), alwaysRockPlay.command.name());
        }
    }
}
