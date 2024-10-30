import java.util.Scanner;

/**
 * Represents the Pokemon card game.
 */
public class CardGame {

    private Player player1;
    private Player player2;
    private Scanner userInput;

    /**
     * Creates a new CardGame with two default players.
     */
    public CardGame() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        userInput = new Scanner(System.in);
    }

    /**
     * Initializes the game by filling the decks and drawing starting hands for both players.
     */
    public void initializeGame() {
        player1.fillDeck();
        player1.shuffleDeck();
        player1.drawHand();
//        player1.setActivePokemon();

        player2.fillDeck();
        player2.shuffleDeck();
        player2.drawHand();
//        player2.setActivePokemon();
    }

    /**
     * Executes a single player's turn.
     * @param player The current player.
     * @param opp The opponent.
     */
    public void playerTurn(Player player, Player opp) {
        System.out.println("\n" + player.getName() + "'s turn:");
        System.out.println("Your hand: " + player.getHand());
        if (player.getActivePokemon() != null) {
            System.out.println("Active Pokemon: " + player.getActivePokemon().getName());
            System.out.println("Energy: " + player.getActivePokemon().hasEnergy());
        }

        System.out.println("1. Draw a card\n2. Play a Pokemon\n3. Attach Energy\n4. Attack\n5. End turn");

        int choice = userInput.nextInt();
        userInput.nextLine();

        switch (choice) {
            case 1:
                player.drawCard();
                break;
            case 2:
                playPokemon(player);
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    /**
     * Allows the player to play a Pokemon from their hand.
     * @param player The player playing the Pokemon.
     */
    public void playPokemon(Player player) {
        if (player.getActivePokemon() == null && player.checkPokemon()) {
            player.setActivePokemon();
            System.out.println(player.getName() + " played " + player.getActivePokemon().getName()); // Indicate which Pokemon was played

        } else if (player.getActivePokemon() != null) {
            System.out.println("You already have an active Pokemon: " + player.getActivePokemon().getName()); // Show active Pokemon name
        } else {
            System.out.println("You have no Pokemon in hand.");
        }
    }

    /**
     * Checks if any player has won the game.
     * @return True if a player has won, false otherwise.
     */
    public boolean checkWin() {
    	
        return false;
    }

    /**
     * Runs the main game loop.
     */
  //Template, add methods here as you need to, to make your program run.
    public void run(){
        
//    	initializeGame();
    	player1 = new Player("Player 1");
    	player1.MonteCarlo();
//    	player1.fillDeck();
//    	player1.drawHand();
//    	player1.checkPokemon();
//    	System.out.println(player1.oddsOfPokemon());
      
      
    }
}