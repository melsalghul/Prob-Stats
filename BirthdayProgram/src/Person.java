import java.util.Random;

class Person {
    int birthday;

    public Person() {
        Random temp = new Random();
        birthday = temp.nextInt(365) + 1; 
    }

    public int getBirthday() {
        return birthday;
    }
}