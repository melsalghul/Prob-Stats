import java.util.ArrayList;
import java.util.Random;
public class CardGame{

    private ArrayList<Card> deck;
    private ArrayList<Card> hand;

    public CardGame(){
        deck = new ArrayList<Card>();
        hand = new ArrayList<Card>();
    }
    public void fillDeck(){
/* 
 * 			Random rng = new Random();
            int temp = temp.nextInt(2);
            if(temp == 0)
                deck.add(new Charmander());
            if(temp == 1)
                deck.add(new Energy());
            else
                deck.add(new Trainer());
*/
    	deck.add(new Charmander());
    	for(int x = 0; x < 10; x++) {
    		deck.add(new Energy());
    	}
    }

    public void drawHand(){
        Random rng = new Random();
        for(int i = 0; i < 7; i++){
            int cardToTakeIndex = rng.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
    }

    public boolean checkPokemon(){
        for(Card singleCard : hand){
            if(singleCard instanceof Pokemon)
                return true;
        }
        return false;
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
//Tenplate, add methods here as you need to, to make your program run.
    public void run(){
        fillDeck();
        drawHand();
        checkPokemon();
        System.out.println(oddsOfPokemon());
    }
}