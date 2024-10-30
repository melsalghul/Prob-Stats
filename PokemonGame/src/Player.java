import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Player {
    private String name;
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private Pokemon activePokemon;

    public Player(){
    	name = "Player";
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        activePokemon = null;
    }

    public Player(String name){
        this.name = name;
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        activePokemon = null;
    }

    public Player(String name, ArrayList<Card> deck, ArrayList<Card> hand){
        this.name = name;
        this.deck = deck;
        this.hand = hand;
        activePokemon = null;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
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

    
    public void drawHand(){
        Random rng = new Random();
        for(int i = 0; i < 7; i++){
            int cardToTakeIndex = rng.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
        
        System.out.println(name + " drew a hand.");
    }
    
    public void discardHand() {
    	hand = new ArrayList<Card>();
    	
    	System.out.println(name + " discarded hand.");
    }
    
    public ArrayList<Card> getHand(){
    	return hand;
    }
    
    public void drawCard() {
    	Random rng = new Random();
    	int temp = rng.nextInt(deck.size());
    	hand.add(deck.get(temp));
    	deck.remove(temp);
    	
    	System.out.println(name + " drew a card.");
    }

    public boolean checkPokemon(){
        for(Card singleCard : hand){
            if(singleCard instanceof Pokemon)
                return true;
        }
        return false;
    }
    
    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
    public boolean firstTurnPokemon(){
        // loop through hand, if the first card is a Pokemon, return true, else return false

        if (hand.get(0) instanceof Pokemon) {
            return true;
        }
        return false;
    }
    
    public void setActivePokemon() {
    	for(Card card: hand) {
    		if(card instanceof Pokemon) {
    			activePokemon = (Pokemon)card;
    			hand.remove(card);
    		}
    	}
    }
    
    public Pokemon getActivePokemon() {
    	return activePokemon;
    }

    public double oddsOfPokemon(){
        double count = 0;
        
        for(int x = 0; x < deck.size(); x++) {
        	if(deck.get(x) instanceof Pokemon)
        		count ++;
        	System.out.println(deck.get(x));
        }
        return count/(double)deck.size();
    }
    
    public void attachEnergy() {
    	for(Card card: hand) {
    		if(card instanceof Energy) {
    			
    		}
    	}
    }
    
    public boolean checkCandy(){
        // loop through hand, if one card is a candy, return true, else return false
        for(Card card : hand){
            if (card instanceof RareCandy) {
                return true;
            }
        }
        return false;
    }
    
    public void MonteCarlo() {
        int success1 = 0;
        int success2 = 0;
        int success3 = 0;
        int loop = 10000;
        
        for(int i = 0; i < loop; i++){
            fillDeck();
            shuffleDeck();
            drawHand();
            if(firstTurnPokemon()){
                success1++;
            }
            if(checkCandy()){
                success2++;
            }
            if(checkPokemon()){
                success3++;
            }
        }
 
        double probability1 = (double)success1/loop;
        System.out.println("The probability that the first card in a hand is a pokemon is "+probability1);
        double probability2 = (double)success2/loop;
        System.out.println("The probability that there is a prize candy in the hand is  "+probability2);
        double probability3 = (double)success3/loop;
        System.out.println("The probability that there is a pokemon in the hand is  "+probability3);
    }
 
}