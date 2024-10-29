import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class provides static methods for performing set operations (union, intersection, and complement) on ArrayLists.
 */
public class SetOperations {

    /**
     * Demonstrates the usage of the set operation methods.
     *
     */
    public static void main(String[] args) {
        // Example usage with days of the week (String data type)
        ArrayList<String> allDays = new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
        ArrayList<String> weekdays = new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));
        ArrayList<String> weekend = new ArrayList<>(Arrays.asList("Saturday", "Sunday"));

        System.out.println("Union of weekdays and weekend: " + union(weekdays, weekend));
        System.out.println("Intersection of weekdays and weekend: " + intersection(weekdays, weekend));
        System.out.println("Complement of weekdays: " + complement(allDays, weekdays));

        // Example with Integer type
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(3, 4, 5, 6));

        System.out.println("Union of setA and setB: " + union(setA, setB));
        System.out.println("Intersection of setA and setB: " + intersection(setA, setB));
        ArrayList<Integer> allIntegers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)); // Example universal set
        System.out.println("Complement of setA: " + complement(allIntegers, setA));
    }


    /**
     * Calculates the union of two ArrayLists.
     *
     * @param arrayList1 The first ArrayList.
     * @param arrayList2 The second ArrayList.
     * @param <E>        The type of elements in the ArrayLists.
     * @return A new ArrayList containing all unique elements from both input ArrayLists.
     */
    public static <E> ArrayList<E> union(ArrayList<E> arrayList1, ArrayList<E> arrayList2) {
        ArrayList<E> result = new ArrayList<>(arrayList1);

        for (E element : arrayList2) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }


    /**
     * Calculates the intersection of two ArrayLists.
     *
     * @param arrayList1 The first ArrayList.
     * @param arrayList2 The second ArrayList.
     * @param <E>        The type of elements in the ArrayLists.
     * @return A new ArrayList containing the elements that are present in both input ArrayLists.
     */
    public static <E> ArrayList<E> intersection(ArrayList<E> arrayList1, ArrayList<E> arrayList2) {
        ArrayList<E> result = new ArrayList<>();

        for (E element : arrayList1) { 
            if (arrayList2.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Calculates the complement of a subset with respect to a universal set.
     *
     * @param universalSet The universal set.
     * @param subset       The subset.
     * @param <E>          The type of elements in the ArrayLists.
     * @return A new ArrayList containing elements present in the universal set but not in the subset.
     */
    public static <E> ArrayList<E> complement(ArrayList<E> universalSet, ArrayList<E> subset) {
        ArrayList<E> result = new ArrayList<>();

        for (E element : universalSet) {  // Use enhanced for loop.
            if (!subset.contains(element)) {  // Use contains() for efficiency.
                result.add(element);
            }
        }
        return result;
    }
}
