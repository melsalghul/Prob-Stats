import java.math.BigInteger;

/**
 * This class provides a method for calculating permutations (nPr).
 * Permutations represent the number of ways to arrange r items from a set of n distinct items, where order matters.
 */
class Perm {

    /**
     * Calculates the number of permutations of n items taken r at a time (nPr).
     * This is calculated using the formula n! / (n-r)!.
     *
     * @param n The total number of items. Must be non-negative.
     * @param r The number of items to arrange. Must be non-negative and not greater than n.
     * @return The number of permutations (nPr) as a BigInteger.
     * @throws IllegalArgumentException if n or r are negative, or if r is greater than n.
     */
    public static BigInteger solve(int n, int r) {
        if (n < 0 || r < 0 || r > n) {
            throw new IllegalArgumentException("Invalid input: n and r must be non-negative, and r must be less than or equal to n.");
        }

        return Factorial.solve(n).divide(Factorial.solve(n - r));
    }
}
