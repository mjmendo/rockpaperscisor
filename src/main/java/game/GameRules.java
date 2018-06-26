package game;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class GameRules {

    private Map<Command, Command> keyWisOverValue = new EnumMap<Command, Command>(Command.class){{
        put(Command.Paper, Command.Rock);
        put(Command.Rock, Command.Scissor);
        put(Command.Scissor, Command.Paper);
    }};

    public Optional<Play> check(Play play1, Play play2) {

        if (keyWisOverValue.get(play1.command) == play2.command){
            return Optional.of(play1);

        } else if(keyWisOverValue.get(play2.command) == play1.command){
            return Optional.of(play2);

        } else {
            return Optional.empty();
        }
    }
}
