import java.util.ArrayList;
import java.util.Arrays;

/**
 * A test class for the StatsLibrary, demonstrating its usage and verifying its functionality.
 */
public class TestStatsLibrary {

    /**
     * The main method creates a sample dataset, uses StatsLibrary to calculate statistics,
     * and prints the results.
     */
    public static void main(String[] args) {
        ArrayList<Integer> numsList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 9));

        StatsLibrary statsLibrary = new StatsLibrary();

        System.out.println("Dataset: " + numsList);
        System.out.println("Mean: " + statsLibrary.findMean(numsList));
        System.out.println("Median: " + statsLibrary.findMedian(numsList));

        double mode = statsLibrary.findMode(numsList);
        if (mode == -1) {
            System.out.println("There is no mode.");
        } else {
            System.out.println("Mode: " + mode);
        }

        System.out.println("Standard Deviation: " + statsLibrary.standardDev(numsList));
)
        testEmptyList(statsLibrary);

    }


    /**
     * Helper function to test the StatsLibrary class when dealing with an empty list.
     * @param statsLibrary An instance of the StatsLibrary class.
     */
    private static void testEmptyList(StatsLibrary statsLibrary)
    {
        ArrayList<Integer> emptyList = new ArrayList<>();
        System.out.println("\nTesting with an empty list:");
        System.out.println("Dataset: " + emptyList);
        System.out.println("Mean: " + statsLibrary.findMean(emptyList));
        System.out.println("Median: " + statsLibrary.findMedian(emptyList));

        double emptyMode = statsLibrary.findMode(emptyList);
        if (emptyMode == -1) {
            System.out.println("There is no mode.");

        System.out.println("Standard Deviation: " + statsLibrary.standardDev(emptyList));
    }
}
