public class ProfResearch extends Trainer{
	
	public ProfResearch() {
		setName("Professor's Research");
	}
	
	public void ability(Player curPlayer) {
		curPlayer.discardHand();
		curPlayer.drawHand();
		
		System.out.println(curPlayer.getName() + " used Professor's Research.");
	}
}
