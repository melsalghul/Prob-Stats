import java.util.Random;

/**
 * This class simulates the Monty Hall problem.  It allows running the game multiple times
 * to demonstrate the probability of winning with and without switching doors.
 */
public class MontyHall {

    private final Random random;
    private final boolean isSwitched;

    /**
     * Constructs a MontyHall simulator.
     *
     * @param isSwitched Whether the contestant will switch doors after the host reveals a goat.
     */
    public MontyHall(boolean isSwitched) {
        this.random = new Random();
        this.isSwitched = isSwitched;
    }

    /**
     * Plays a single game of the Monty Hall problem.
     *
     * @return True if the contestant wins the prize, false otherwise.
     */
    public boolean playGame() {
        int winningDoor = random.nextInt(3); // Randomly assign the winning door (0, 1, or 2)
        int chosenDoor = random.nextInt(3); // Contestant randomly chooses a door

        int revealedDoor; // The door the host reveals (must not be the winning door or the chosen door)
        do {
            revealedDoor = random.nextInt(3);
        } while (revealedDoor == winningDoor || revealedDoor == chosenDoor);

        if (isSwitched) {
            int remainingDoor; // The door the contestant switches to
            do {
                remainingDoor = random.nextInt(3);
            } while (remainingDoor == chosenDoor || remainingDoor == revealedDoor);
            chosenDoor = remainingDoor;
        }

        return chosenDoor == winningDoor;
    }

    /**
     * Runs multiple trials of the Monty Hall game and calculates the win ratio.
     *
     * @param trials    The number of trials to run.
     * @param isSwitched Whether the contestant switches doors in each trial.
     * @return The win ratio (number of wins / number of trials).
     */
    public static double run(int trials, boolean isSwitched) {
        int wins = 0;
        MontyHall game = new MontyHall(isSwitched);

        for (int i = 0; i < trials; i++) {
            if (game.playGame()) {
                wins++;
            }
        }

        return (double) wins / trials;
    }
}
