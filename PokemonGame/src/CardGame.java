import java.util.Scanner;

public class CardGame{
	
	private Player player1;
	private Player player2;
	
	private Scanner userInput;

    public CardGame(){
    	player1 = new Player("Player 1");
    	player2 = new Player("Player 2");
    	userInput = new Scanner(System.in);
    }
   
    public void initializeGame() {
    	player1.fillDeck();
    	player1.drawHand();
//    	player1.setActivePokemon();
    	
    	player2.fillDeck();
    	player2.drawHand();
//    	player1.setActivePokemon();
    	
    }
    
    public void playerTurn(Player player, Player opp) {
    	System.out.println("\n" + player.getName() + "'s turn:");
    	System.out.println("Your hand: " + player.getHand());
    	if(player.getActivePokemon() != null) {
    		System.out.println("Active Pokemon: " + player.getActivePokemon());
    		System.out.println("Energy: " + player.getActivePokemon().hasEnergy());
    	}
    	
    	System.out.println("1. Draw a card\n2. Play a Pokemon\n3. Attach Energy\n4. Attack\n5. End turn");
    	
    	int choice = userInput.nextInt();
    	userInput.nextLine();
    	
    	switch(choice) {
    	

    	}
    }
    
    
    public void playPokemon(Player player) {
    	if(player.getActivePokemon() == null && player.checkPokemon()) {
    		player.setActivePokemon();
    	}
    	else if(player.getActivePokemon() != null)
    		System.out.println("You have an active Pokemon " + player.getActivePokemon());
    	else
    		System.out.println("You have no Pokemon in hand.");
    }
    
    public boolean checkWin() {
    	return false;
    }

//Template, add methods here as you need to, to make your program run.
    public void run(){
        
//    	initializeGame();
    	player1 = new Player("Player 1");
    	player1.MonteCarlo();
//      fillDeck();
//      drawHand();
//      checkPokemon();
//      System.out.println(oddsOfPokemon());
      
      
  }
 
    
}