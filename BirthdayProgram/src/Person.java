import java.util.Random;

/**
 * Represents a Person with a random birthday.
 */
class Person {
    int birthday;
    /**
     * Constructor for the Person class. Assigns a random birthday between 1 and 365 (inclusive).
     */
    public Person() {
        Random temp = new Random();
        birthday = temp.nextInt(365) + 1; 
    }

    /**
     * Returns the person's birthday.
     * @return The birthday as an integer between 1 and 365 (inclusive).
     */
    public int getBirthday() {
        return birthday;
    }
}