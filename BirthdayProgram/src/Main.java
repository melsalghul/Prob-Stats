import java.util.Scanner;

public class Main {
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