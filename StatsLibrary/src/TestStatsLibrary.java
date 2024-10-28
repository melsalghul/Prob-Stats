import java.util.ArrayList;

public class TestStatsLibrary {
	public static void main(String[] args) {
		ArrayList<Integer> numsList = new ArrayList<>();
		
		StatsLibrary tester = new StatsLibrary();
		for(int i = 1; i < 10; i++)
			numsList.add(i);
		
		numsList.add(9);
		
		System.out.println(numsList);
		System.out.println("Mean: " + tester.findMean(numsList));
		System.out.println("Median: " + tester.findMedian(numsList));
		
		if(tester.findMode(numsList) == -1)
			System.out.println("There is no mode");
		else
			System.out.println("Mode: " + tester.findMode(numsList));
		
		System.out.println("Standard Deviation: " + tester.standardDev(numsList));
	}
}