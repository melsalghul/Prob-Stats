import java.util.ArrayList;
import java.util.Arrays;

public class SetOperations {

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

    public static <E> ArrayList<E> intersection(ArrayList<E> arrayList1, ArrayList<E> arrayList2) {
        ArrayList<E> result = new ArrayList<>();

        for (int i = 0; i < arrayList1.size(); i++) {
            for (int j = 0; j < arrayList2.size(); j++) {
                if (arrayList1.get(i).equals(arrayList2.get(j))) {
                    result.add(arrayList1.get(i));
                    break; // Move to next element in arrayList1 once a match is found
                }
            }
        }
        return result;
    }

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
}
