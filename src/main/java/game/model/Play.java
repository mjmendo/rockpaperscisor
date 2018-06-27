package game.model;

public class Play {

    private Player player;
    private Command command;

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
