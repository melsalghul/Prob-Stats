import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A library for calculating basic statistical measures on a list of integers.
 */
public class StatsLibrary {

    /**
     * Calculates the mean (average) of a list of integers.
     *
     * @param numsList The list of integers.
     * @return The mean of the numbers in the list. Returns 0 if the list is empty.
     * @throws NullPointerException if the input list is null.
     */
    public double findMean(ArrayList<Integer> numsList) {
        if (numsList == null) {
            throw new NullPointerException("Input list cannot be null.");
        }
        if (numsList.isEmpty()) {
            return 0; //avoid division by zero
        }

        int sum = 0;
        for (int singleNumber : numsList) {
            sum += singleNumber;
        }
        return (double) sum / numsList.size();
    }

    /**
     * Calculates the median (middle value) of a list of integers.
     *
     * @param numsList The list of integers.
     * @return The median of the numbers in the list.  Returns 0 if the list is empty.
     * @throws NullPointerException if the input list is null.
     */
    public double findMedian(ArrayList<Integer> numsList) {
        if (numsList == null) {
            throw new NullPointerException("Input list cannot be null.");
        }
        if (numsList.isEmpty()) {
            return 0;
        }

        Collections.sort(numsList);

        int size = numsList.size();
        if (size % 2 == 0) {
            double num1 = numsList.get(size / 2 - 1);
            double num2 = numsList.get(size / 2);
            return (num1 + num2) / 2;
        } else {
            return numsList.get(size / 2);
        }
    }

    /**
     * Calculates the mode (most frequent value) of a list of integers.
     *
     * @param numsList The list of integers.
     * @return The mode of the numbers in the list. Returns -1 if the list is empty or if no mode exists.
     * @throws NullPointerException if the input list is null.
     */
    public double findMode(ArrayList<Integer> numsList) {
        if (numsList == null) {
            throw new NullPointerException("Input list cannot be null.");
        }
        if (numsList.isEmpty()) {
            return -1;
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : numsList) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0;
        int mode = -1;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }


        //Check to see if there is only one mode.
        int modeCount = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if(entry.getValue() == maxCount)
                modeCount++;
        }

        if(modeCount > 1)
            return -1;

        return mode;
    }


    /**
     * Calculates the population standard deviation of a list of integers.
     *
     * @param numsList The list of integers.
     * @return The population standard deviation of the numbers in the list. Returns 0 if the list is empty.
     * @throws NullPointerException if the input list is null.
     */
    public double standardDev(ArrayList<Integer> numsList) {
        if (numsList == null) {
            throw new NullPointerException("Input list cannot be null.");
        }
       if (numsList.isEmpty()) {
           return 0;
       }

        double mean = findMean(numsList);
        double sumOfSquares = 0;
        for (int num : numsList) {
            sumOfSquares += Math.pow(num - mean, 2);
        }

        return Math.sqrt(sumOfSquares / numsList.size());

    }
}
