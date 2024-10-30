import java.util.ArrayList;
import java.util.Arrays;

/**
 * Methods for performing set operations and calculating probabilities.
 */
public class SetOperations {

    /**
     * Calculates the union of two ArrayLists.
     * @param arrayList1 The first ArrayList.
     * @param arrayList2 The second ArrayList.
     * @param <E> The type of elements in the ArrayLists.
     * @return An ArrayList containing all unique elements from both input ArrayLists.
     */
    public static <E> ArrayList<E> union(ArrayList<E> arrayList1, ArrayList<E> arrayList2) {
        ArrayList<E> result = new ArrayList<>(arrayList1);

        for (int i = 0; i < arrayList2.size(); i++) {
            boolean found = false;
            for (int j = 0; j < result.size(); j++) {
                if (arrayList2.get(i).equals(result.get(j))) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result.add(arrayList2.get(i));
            }
        }
        return result;
    }

    /**
     * Calculates the intersection of two ArrayLists.
     * @param arrayList1 The first ArrayList.
     * @param arrayList2 The second ArrayList.
     * @param <E> The type of elements in the ArrayLists.
     * @return An ArrayList containing the elements that are present in both input ArrayLists.
     */
    public static <E> ArrayList<E> intersection(ArrayList<E> arrayList1, ArrayList<E> arrayList2) {
        ArrayList<E> result = new ArrayList<>();

        for (int i = 0; i < arrayList1.size(); i++) {
            for (int j = 0; j < arrayList2.size(); j++) {
                if (arrayList1.get(i).equals(arrayList2.get(j))) {
                    result.add(arrayList1.get(i));
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Calculates the complement of a subset with respect to a universal set.
     * @param universalSet The universal set.
     * @param subset The subset.
     * @param <E> The type of elements in the ArrayLists.
     * @return An ArrayList containing elements present in the universal set but not in the subset.
     */
    
    public static <E> ArrayList<E> complement(ArrayList<E> universalSet, ArrayList<E> subset) {
        ArrayList<E> result = new ArrayList<>();

        for (int i = 0; i < universalSet.size(); i++) {
            boolean found = false;
            for (int j = 0; j < subset.size(); j++) {
                if (universalSet.get(i).equals(subset.get(j))) {
                    found = true;
                    break; 
                }
            }
            if (!found) {
                result.add(universalSet.get(i));
            }
        }
        return result;
    }
    
    /**
     * Calculates the probability of set A occurring within sample space S.
     * @param setA The event set.
     * @param setS The sample space.
     * @param <E> The type of elements in the ArrayLists.
     * @return The probability of set A. Returns 0 if the sample space is empty.
     */
    public static <E> double probability(ArrayList<E> setA, ArrayList<E> setS) {
    	if(setS.isEmpty())
    		return 0;
    	
    	double size = intersection(setA, setS).size();
    	return size/setS.size();
    }
    
    /**
     * Calculates the conditional probability of set A given set B within universal set S.
     *  P(A|B) = P(A∩B) / P(B)
     * @param setA The first set.
     * @param setB The second set (condition).
     * @param setS The universal set.
     * @param <E> The type of elements in the ArrayLists.
     * @return The conditional probability. Returns 0 if the intersection of B and S is empty.
     */
    public static <E> double condProb(ArrayList<E> setA, ArrayList<E> setB, ArrayList<E> setS) {
    	if(intersection(setB, setS).isEmpty())
    		return 0;
    	
    	double ABsize = intersection(intersection(setA, setB), setS).size();
    	double Bsize = intersection(setB, setS).size();
    	
    	return ABsize/Bsize;
    }
    
    /**
     * Checks if two sets A and B are independent within universal set S.
     * Two sets A and B are independent if P(A|B) = P(A) or P(B|A) = P(B).
     * @param setA The first set.
     * @param setB The second set.
     * @param setS The universal set.
     * @param <E> The type of elements in the ArrayLists.
     * @return True if the sets are independent, false otherwise.
     */
    public static <E> boolean isIndependent(ArrayList<E> setA, ArrayList<E> setB, ArrayList<E> setS) {
        double probA = probability(setA, setS);
        double probB = probability(setB, setS);
        
        double probAB = condProb(setA, setB, setS);
        double probBA = condProb(setB, setA, setS);
        double probIntersectAB = probability(intersection(setA, setB), setS);

        double fixRounding = 1e-9;

        return (Math.abs(probAB - probA) < fixRounding) ||
               (Math.abs(probBA - probB) < fixRounding) ||
               (Math.abs(probIntersectAB - probA * probB) < fixRounding);
    }
    
    /**
     * Main method for testing the set operations.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        ArrayList<String> allDays = new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
        ArrayList<String> weekdays = new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));
        ArrayList<String> weekend = new ArrayList<>(Arrays.asList("Saturday", "Sunday"));

        System.out.println("Union of weekdays and weekend: " + union(weekdays, weekend));
        System.out.println("Intersection of weekdays and weekend: " + intersection(weekdays, weekend));
        System.out.println("Complement of weekdays: " + complement(allDays, weekdays));

        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(3, 4, 5, 6));
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        System.out.println("Union of setA and setB: " + union(setA, setB));
        System.out.println("Intersection of setA and setB: " + intersection(setA, setB));
        
        System.out.println("Complement of setA: " + complement(integers, setA));
        
        System.out.println("Probability of weekdays: " + probability(weekdays, allDays));
        System.out.println("Conditional probability of weekend given weekdays: " + condProb(weekend, weekdays, allDays)); // 0
        System.out.println("Are weekdays and weekend independent? " + isIndependent(weekdays, weekend, allDays)); // false, mutually exclusive



        setA = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        setB = new ArrayList<>(Arrays.asList(3, 4, 5, 6));

        System.out.println("Probability of setA : " + probability(setA, integers));
        System.out.println("Conditional probability of setB given setA : " + condProb(setB, setA, integers));
        System.out.println("Are setA and setB independent? " + isIndependent(setA,setB, integers));
    }
}
