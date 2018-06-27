package game;


import game.logic.GameRules;
import game.logic.PlayGenerator;
import game.model.Command;
import game.model.Player;

import java.util.EnumMap;
import java.util.Map;

public class App {

    private static final int MAX_ITERATIONS = 100;

    public static void main(String[] args) {

        Map<Command, Command> rules = new EnumMap<Command, Command>(Command.class){{
            put(Command.Paper, Command.Rock);
            put(Command.Rock, Command.Scissor);
            put(Command.Scissor, Command.Paper);
        }};

        Game game = new RockPaperScissorGame(
                new Player("Player 1"),
                new Player("Player 2"),
                new PlayGenerator(),
                new GameRules(rules));

        int iterations = 0;
        try {
            while (iterations < MAX_ITERATIONS) {
                print(game.play());
                iterations++;
            }

        } catch (Throwable e) {
            print("Error has occurred. Reason: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void print(String line) {
        System.out.println(line + "\r");
    }
}

