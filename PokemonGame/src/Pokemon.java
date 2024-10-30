import java.util.ArrayList;

/**
 * Represents a Pokemon card in a card game.
 */
public class Pokemon extends Card {
    private String name;
    private int hp;
    protected boolean hasEnergy;
    private int attackDamage;

    /**
     * Creates a default Pokemon with name "Normal", 50 HP, 10 attack damage, and no energy.
     */
    public Pokemon(){
    	name = "Normal";
    	hp = 50;
    	attackDamage = 10;
    	hasEnergy = false;
    }

    /**
     * Returns the name of the Pokemon.
     * @return The name of the Pokemon.
     */
    public String getName(){
        return name;
    }

    /**
     * Sets the name of the Pokemon.
     * @param name The new name of the Pokemon.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Returns the HP of the Pokemon.
     * @return The HP of the Pokemon.
     */
    public int getHp(){
        return hp;
    }

    /**
     * Sets the HP of the Pokemon.
     * @param hp The new HP of the Pokemon.
     */
    public void setHp(int hp){
        this.hp = hp;
    }

    /**
     * Resets the energy status of the Pokemon to false.
     */
    public void resetEnergy(){
        hasEnergy = false;
    }
    
    /**
     * Checks if the Pokemon has energy attached.
     * @return True if the Pokemon has energy, false otherwise.
     */
    public boolean hasEnergy() {
    	return hasEnergy;
    }
    
    /**
     * Attaches energy to the Pokemon if an Energy card is present in the given hand.
     * @param hand The ArrayList of cards representing the player's hand.
     */
    public void attachEnergy(ArrayList<Card> hand) {
    	for(Card card: hand) {
    		if(card instanceof Energy) {
    			hasEnergy = true;
    		}
    	}
    }
    
    /**
     * Returns the attack damage of the Pokemon.
     * @return The attack damage of the Pokemon.
     */
    public int getAttackDamage() {
    	return attackDamage;
    }
    
    /**
     * Sets the attack damage of the Pokemon.
     * @param attackDamage The new attack damage of the Pokemon.
     */
    public void setAttackDamage(int attackDamage) {
    	this.attackDamage = attackDamage;
    }
    
    /**
     * Represents the attack action of the Pokemon.  
     */
    public void attack() {
    	
    }
    
}