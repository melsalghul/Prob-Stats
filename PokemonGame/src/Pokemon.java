import java.util.ArrayList;

public class Pokemon extends Card {
    private String name;
    private int hp;
    protected boolean hasEnergy;
    private int attackDamage;

    public Pokemon(){
    	name = "Normal";
    	hp = 50;
    	attackDamage = 10;
    	hasEnergy = false;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public void ressetEnergy(){
        hasEnergy = false;
    }
    
    public boolean hasEnergy() {
    	return hasEnergy;
    }
    
    public void attachEnergy(ArrayList<Card> hand) {
    	for(Card card: hand) {
    		if(card instanceof Energy) {
    			hasEnergy = true;
    		}
    	}
    }
    
    public int getAttackDamage() {
    	return attackDamage;
    }
    
    public void setAttackDamage(int attackDamage) {
    	this.attackDamage = attackDamage;
    }
    
    public void attack() {
    	
    }
    
}