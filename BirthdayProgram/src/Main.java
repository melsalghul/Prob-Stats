import java.util.Scanner;

/**
 * The main class for running the Birthday simulation.
 * This program takes user input for the number of people in the group and then calculates the probability 
 * of at least two people sharing the same birthday within that group.
 */
public class Main {

    /**
     * The main method that runs the Birthday simulation.
     * 
     */
    public static void main(String[] args) {
        int size = 23; // Default group size (size of class)
        int runs = 10000; // Number of simulation runs

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        size = scanner.nextInt(); // user input for the group size
        scanner.close(); // Close scanner

        BirthdayProgram tester = new BirthdayProgram(size, runs); // Creates a BirthdayProgram object
        double probability = tester.run(); // Runs tester simulation and getsprobability

        System.out.println("Probability of at least 2 people sharing a birthday in a size of " + size + ": " + probability); // Prints the result

    }
}
