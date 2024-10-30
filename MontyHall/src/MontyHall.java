import java.util.Random;

public class MontyHall {

    private final Random random;
    private final boolean isSwitched;

    /**
     * Constructor for the MontyHall class.
     * @param isSwitched Whether the player switches doors after the prize door is revealed.
     */
    public MontyHall(boolean isSwitched) {
        this.random = new Random();
        this.isSwitched = isSwitched;
    }

    public boolean playGame() {
        int G = random.nextInt(3);
        int pickDoor = random.nextInt(3);

        int revealDoor;
        do {
            revealDoor = random.nextInt(3);
        } while (revealDoor == G || revealDoor == pickDoor);

        if (isSwitched) {
            int remainingDoor;
            do {
                remainingDoor = random.nextInt(3);
            } while (remainingDoor == pickDoor || remainingDoor == revealDoor);
            pickDoor = remainingDoor;
        }

        return pickDoor == G;
    }

    /**
     * Plays a single game of the Monty Hall problem.
     * @return True if the player wins the car, false otherwise.
     */
    public static double run(int trials, boolean isSwitched){
        int wins = 0;
        MontyHall tester = new MontyHall(isSwitched);

        for (int i = 0; i < trials; i++) {
            if (tester.playGame()) {
                wins++;
            }
        }

        double winRatio = (double) wins / trials;
        
        return winRatio;
    }
    
    /**
     * Runs multiple trials of the Monty Hall problem and calculates the win ratio.
     * @param trials The number of trials to run.
     * @param isSwitched Whether the player switches doors.
     * @return The win ratio (wins / trials).
     */
    public static void main(String[] args) {
        int trials = 10000;
        System.out.println("Without switching: " + MontyHall.run(trials, false));
        System.out.println("With switching: " + MontyHall.run(trials, false));
    }
}
