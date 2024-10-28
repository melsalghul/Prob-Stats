import java.util.Random;

public class MontyHall {

    private final Random random;
    private final boolean isSwitched;

    public MontyHall(boolean isSwitched) {
        this.random = new Random();
        this.isSwitched = isSwitched;
    }

    public boolean playGame() {
        int G = random.nextInt(3);
        int pickDoor = random.nextInt(3);

        int revealedDoor;
        do {
            revealedDoor = random.nextInt(3);
        } while (revealedDoor == G || revealedDoor == pickDoor);

        if (isSwitched) {
            int remainingDoor;
            do {
                remainingDoor = random.nextInt(3);
            } while (remainingDoor == pickDoor || remainingDoor == revealedDoor);
            pickDoor = remainingDoor;
        }

        return pickDoor == G;
    }

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
}