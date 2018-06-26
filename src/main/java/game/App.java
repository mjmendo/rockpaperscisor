package game;


public class App {

    private static final int MAX_ITERATIONS = 100;

    public static void main(String[] args) {

        int iterations = 0;
        Game game = new Game();

        try {

            while (iterations < MAX_ITERATIONS) {
                print(game.play());
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

