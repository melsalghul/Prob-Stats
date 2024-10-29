import java.util.ArrayList;

/**
 * This class simulates the Birthday Paradox, which calculates the probability of two people in a group sharing the same birthday.
 * It runs multiple simulations with a given group size and calculates the probability based on the number of successful runs (where a shared birthday was found).
 */
public class BirthdayProgram {

    private int size;
    private int runs;

    /**
     * Constructs a BirthdayProgram object.
     *
     * @param size The number of people in each group for the simulation.
     * @param runs The number of times to run the simulation.
     */
    public BirthdayProgram(int size, int runs) {
        this.size = size;
        this.runs = runs;
    }


    /**
     * Runs the birthday paradox simulation.
     * For each run, it creates a group of `size` people and checks if any two share a birthday.
     *
     * @return The probability of two people sharing the same birthday in a group of the given size, calculated as the number of successful runs divided by the total number of runs.
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
     * Checks if any two people in the given list share the same birthday.
     *
     * @param temp The list of Person objects to check.
     * @return True if any two people in the list share a birthday, false otherwise.
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
        
}
