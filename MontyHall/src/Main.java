public class Main{
	
    public static void main(String[] args) {
        int trials = 10000;
        System.out.println("Without switching: " + MontyHall.run(trials, false));
        System.out.println("With switching: " + MontyHall.run(trials, false));
    }
}