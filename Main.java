import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Player pop;
        Scanner sc = new Scanner(System.in);

        // Asks the user to input thier name for the player
        System.out.println("What is player1's name?: ");
        String name1 = sc.nextLine();
        Player p1 = new Player(name1);
        // TO DO: Create Player 1

        // Asks the user to input their name for the player.
        System.out.println("What is player2's name?: ");
        // TO DO: Create Player 2
        String name2 = sc.nextLine();
        Player p2 = new Player(name2);

        String again = "Literally any string";
        Player currentPlayer;

        // Runs the game
        while (!again.equals("q")) {
            // Generates the game
            // TO DO: Create "game"
            Game game = new Game(p1, p2);

            game.takePiece();
            // TO DO: Set the a random player as the current player
            if ((Math.random() * 2) >= 1) {
                currentPlayer = p1;
            } else {
                currentPlayer = p2;
            }
            game.setFirstPlayer(currentPlayer);
            // This is the loop in which the game will be played
            while (!game.isComplete()) {
                game.takePiece();
                currentPlayer = game.getNextPlayer();
            }
            System.out.println(currentPlayer.getName() + " Won!!");
            System.out.println(p1.getName() + " had removed " + p1.getScore() + " pieces!");
            System.out.println(p2.getName() + " had removed " + p2.getScore() + " pieces!");
            System.out.println("------------------------------------------");
            System.out.println("Enter q to quit, enter anything else to play again.");
            again = sc.nextLine();
        }
        System.out.println("Thank you for playing!");
    }
}
