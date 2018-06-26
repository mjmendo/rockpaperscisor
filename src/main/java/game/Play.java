package game;

public class Play {

    Player player;
    Command command;

    public Play(Player player, Command command) {
        this.player = player;
        this.command = command;
    }

    public Player getPlayer() {
        return player;
    }

    public Command getCommand() {
        return command;
    }

}
