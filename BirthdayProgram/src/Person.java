import java.util.Random;

/**
 * Represents a person with a randomly assigned birthday.
 * The birthday is represented as an integer between 1 and 365 (inclusive),
 * where 1 represents January 1st and 365 represents December 31st.
 */
class Person {

    private int birthday;

    /**
     * Constructs a Person object with a random birthday.
     * The birthday is generated using a random number generator and is between 1 and 365 (inclusive).
     */
    public Person() {
        Random temp = new Random();
        birthday = temp.nextInt(365) + 1; 
    }

    /**
     * Returns the person's birthday.
     *
     * @return The birthday as an integer between 1 and 365 (inclusive).
     */
    public int getBirthday() {
        return birthday;
    }
}
