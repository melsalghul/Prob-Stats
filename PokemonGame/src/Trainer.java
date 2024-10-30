public class Trainer extends Card{
	
	private String name;
	
	public Trainer() {
		name = "Basic";
	}
	
	public Trainer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void ability(Player player1, Player player2) {
		
	}
}