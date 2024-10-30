import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program calculates the probability that at least two people in a group share the same birthday.
 */
public class BirthdayProgram {

    private int size; // The size of group.
    private int runs; //Number of runs.

    /**
     * Constructor for the BirthdayProgram.
     * @param size The size of the group of people.
     * @param runs The number of times to run the simulation.
     */
    public BirthdayProgram(int size, int runs) {
        this.size = size;
        this.runs = runs;
    }

    /**
     * Runs the simulation and calculates the probability of a shared birthday.
     * @return The probability of at least two people sharing a birthday.
     */
    public double run() {
        int count = 0;

        for (int i = 0; i < runs; i++) {
            ArrayList<Person> temp = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                temp.add(new Person());
            }

            if (hasSharedBirthday(temp)) {
                count++;
            }
        }

        return (double) count / runs;
    }

    /**
     * Checks if any two people in a group share the same birthday.
     * @param group The group of people.
     * @return True if at least two people share a birthday, false otherwise.
     */
    private boolean hasSharedBirthday(ArrayList<Person> temp) {
        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                if (temp.get(i).getBirthday() == temp.get(j).getBirthday())
                    return true;
            }
        }
        return false;
    }
    
    /**
     * Main method to run program.
     */
    public static void main(String[] args) {
        int size = 23; 
        int runs = 10000;


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of people: ");
        size = scanner.nextInt();
        scanner.close();

        BirthdayProgram tester = new BirthdayProgram(size, runs);
        double probability = tester.run();

        System.out.println("Probability of at least 2 people sharing a birthday in a size of " + size + ": " + probability);

    }
}