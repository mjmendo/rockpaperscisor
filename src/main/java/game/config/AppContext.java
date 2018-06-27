package game.config;

import game.RockPaperScissorGame;
import game.logic.GameRules;
import game.logic.PlayGenerator;
import game.model.Command;
import game.model.Player;

import java.util.EnumMap;
import java.util.Map;

public class AppContext {

    public RockPaperScissorGame game(){
        return new RockPaperScissorGame(
                new Player("Player 1"),
                new Player("Player 2"),
                new PlayGenerator(),
                new GameRules(rules()));
    }

    public Map<Command, Command> rules(){
        return new EnumMap<Command, Command>(Command.class){{
            put(Command.Paper, Command.Rock);
            put(Command.Rock, Command.Scissor);
            put(Command.Scissor, Command.Paper);
        }};
    }
}
