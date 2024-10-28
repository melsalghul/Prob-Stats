public class Pokemon extends Card {
    private String name;
    private int hp;
    private int attachedEnergy = 0;

    public Pokemon(){

    }

    public Pokemon(String name) {
        this.name = name;
    }

    public Pokemon(String name, int hp){
        this.name = name;
        this.hp = hp;
    }

    public Pokemon(Pokemon pokemon) {
        this.name = pokemon.name;
        this.hp = pokemon.hp;
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

    public int getEnergy(){
        return attachedEnergy;
    }

    public void setEnergy(int energy){
        this.attachedEnergy = energy;
    }
    
}