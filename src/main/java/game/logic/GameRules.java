package game.logic;

import game.model.Command;
import game.model.Play;

import java.util.Map;
import java.util.Optional;

public class GameRules {
    private final Map<Command, Command> keyWinsOverValue;

    public GameRules(Map rules) {
        this.keyWinsOverValue = rules;
    }

    public Optional<Play> check(Play play1, Play play2) {

        if (keyWinsOverValue.get(play1.getCommand()) == play2.getCommand()){
            return Optional.of(play1);

        } else if(keyWinsOverValue.get(play2.getCommand()) == play1.getCommand()){
            return Optional.of(play2);

        } else {
            return Optional.empty();
        }
    }
}
