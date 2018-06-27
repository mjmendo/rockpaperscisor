package game;

import game.logic.GameRules;
import game.logic.PlayGenerator;
import game.model.Play;
import game.model.Player;

import java.util.Optional;

public class RockPaperScissorGame implements Game {

    public static final String WINNING_TEMPLATE = "%s <-> %s -> %s wins!";
    public static final String DRAW_TEMPLATE = "%s <-> %s -> draw!";

    private Player player1;
    private Player player2;
    private PlayGenerator playGenerator;
    private GameRules rules;

    public RockPaperScissorGame(Player player1, Player player2, PlayGenerator playGenerator, GameRules rules) {
        this.player1 = player1;
        this.player2 = player2;
        this.playGenerator = playGenerator;
        this.rules = rules;
    }

    @Override
    public String play() {
        Play randomPlay = playGenerator.random(player1);
        Play alwaysRockPlay = playGenerator.alwaysRock(player2);

        Optional<Play> winner = rules.check(alwaysRockPlay, randomPlay);

        return getPrintableVeredict(randomPlay, alwaysRockPlay, winner);
    }

    private String getPrintableVeredict(Play randomPlay, Play alwaysRockPlay, Optional<Play> winner) {
        if (winner.isPresent()){
            return String.format(WINNING_TEMPLATE,
                    randomPlay.getCommand().name(),
                    alwaysRockPlay.getCommand().name(),
                    winner.get().getCommand()
            );
        }

        return String.format(DRAW_TEMPLATE,
                    randomPlay.getCommand().name(),
                    alwaysRockPlay.getCommand().name()
        );

    }
}
