/**
 * This class runs a simulation of the Monty Hall problem.
 * The Monty Hall problem is a probability puzzle based on a game show scenario.  A contestant chooses one of three doors,
 * behind one of which is a prize. The host then opens one of the other doors to reveal a goat (not the prize).
 * The contestant is then given the option to stick with their original choice or switch to the remaining closed door.
 * This simulation demonstrates the probabilities of winning with and without switching doors.
 */
public class Main {

    /**
     * The main method runs the Monty Hall simulation.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        int trials = 10000; // Number of trials for the simulation

        System.out.println("Without switching: " + MontyHall.run(trials, false));
        System.out.println("With switching: " + MontyHall.run(trials, true));
    }
}
