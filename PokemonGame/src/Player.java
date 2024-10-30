import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 * Represents a player in the Pokemon card game.
 */
public class Player {
    private String name;
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private Pokemon activePokemon;

    /**
     * Creates a default player with name "Player", an empty deck and hand, and no active Pokemon.
     */
    public Player(){
    	name = "Player";
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        activePokemon = null;
    }

    /**
     * Creates a player with the given name, an empty deck and hand, and no active Pokemon.
     * @param name The name of the player.
     */
    public Player(String name){
        this.name = name;
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        activePokemon = null;
    }

    /**
     * Creates a player with the given name, deck, and hand.
     * @param name The name of the player.
     * @param deck The player's deck.
     * @param hand The player's hand.
     */
    public Player(String name, ArrayList<Card> deck, ArrayList<Card> hand){
        this.name = name;
        this.deck = deck;
        this.hand = hand;
        activePokemon = null;
    }

    /**
     * Returns the name of the player.
     * @return The name of the player.
     */
    public String getName(){
        return name;
    }

    /**
     * Sets the name of the player.
     * @param name The new name of the player.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Fills the player's deck with a predetermined set of cards.
     */
    public void fillDeck(){
    	for(int x = 0; x < 2; x++) {
    		deck.add(new Charmander());
        	deck.add(new Bulbasaur());
        	deck.add(new Squirtle());
    	}
    	
    	for(int x = 0; x < 45; x++)
    		deck.add(new Energy());
    	
    	for(int x = 0; x < 4; x++)
    		deck.add(new RareCandy());
    	
    	for(int x = 0; x < 5; x++)
    		deck.add(new ProfResearch());
    }

    /**
     * Draws a hand of 7 cards from the deck.
     */
    public void drawHand(){
        Random rng = new Random();
        for(int i = 0; i < 7; i++){
            int cardToTakeIndex = rng.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
        
        System.out.println(name + " drew a hand.");
    }

    /**
     * Discards the player's hand.
     */
    public void discardHand() {
    	while(hand.size() > 0)
    		hand.remove(0);
    	
    	System.out.println(name + " discarded hand.");
    }

    /**
     * Returns the player's hand.
     * @return The player's hand as an ArrayList of Cards.
     */
    public ArrayList<Card> getHand(){
    	return hand;
    }

    /**
     * Draws a single card from the deck and adds it to the hand.
     */
    public void drawCard() {
    	Random rng = new Random();
    	int temp = rng.nextInt(deck.size());
    	hand.add(deck.get(temp));
    	deck.remove(temp);
    	
    	System.out.println(name + " drew a card.");
    }

    /**
     * Checks if the player's hand contains any Pokemon cards.
     * @return True if the hand contains a Pokemon, false otherwise.
     */
    public boolean checkPokemon(){
        for(Card singleCard : hand){
            if(singleCard instanceof Pokemon)
                return true;
        }
        return false;
    }

    /**
     * Shuffles the player's deck.
     */
    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    /**
     * Checks if the first card in the player's hand is a Pokemon.
     * @return True if the first card is a Pokemon, false otherwise.
     */
    public boolean firstTurnPokemon(){
        if (hand.get(0) instanceof Pokemon) {
            return true;
        }
        return false;
    }

    /**
     * Sets the active Pokemon from the player's hand. The first Pokemon card found in the hand is set as the active Pokemon, and it is removed from the hand.
     */
    public void setActivePokemon() {
    	for(Card card: hand) {
    		if(card instanceof Pokemon) {
    			activePokemon = (Pokemon)card;
    			hand.remove(card);
                        return; // Exit after finding the first Pokemon
    		}
    	}
    }

    /**
     * Returns the player's active Pokemon.
     * @return The active Pokemon.
     */
    public Pokemon getActivePokemon() {
    	return activePokemon;
    }

    /**
     * Calculates the odds of drawing a Pokemon from the deck.
     * @return The odds of drawing a Pokemon.
     */
    public double oddsOfPokemon(){
        double count = 0;
        
        for(int x = 0; x < deck.size(); x++) {
        	if(deck.get(x) instanceof Pokemon)
        		count ++;
        	System.out.println(deck.get(x)); //debugging
        }
        return count/(double)deck.size();
    }

    /**
     * Checks if the player's hand contains a Rare Candy card.
     * @return True if the hand contains a Rare Candy, false otherwise.
     */
    public boolean checkCandy(){
        for(Card card : hand){
            if (card instanceof RareCandy) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Runs a Monte Carlo simulation to estimate probabilities related to the starting hand.
     * Prints the probabilities of:
     * The first card being a Pokemon.
     * Having a Rare Candy in hand.
     * Having any Pokemon in hand.
     */
    public void MonteCarlo() {
        int trial1 = 0;
        int trial2 = 0;
        int trial3 = 0;
        int loop = 10000;
        
        for(int i = 0; i < loop; i++){
            fillDeck();
            shuffleDeck();
            drawHand();
            if(firstTurnPokemon()){
                trial1++;
            }
            if(checkCandy()){
                trial2++;
            }
            if(checkPokemon()){
                trial3++;
            }
            discardHand(); // Discard hand after each trial
            deck.clear(); // Clear the deck after each trial
        }
 
        double prob1 = (double)trial1/loop;
        System.out.println("Probability 1st card in hand is Pokemon: "+prob1);
        double prob2 = (double)trial2/loop;
        System.out.println("Probability of Rare Candy in hand: "+prob2);
        double prob3 = (double)trial3/loop;
        System.out.println("Probability of Pokemon in hand: "+prob3);
    }
}