import java.math.BigInteger;

/**
 * This class is for calculating combinations (nCr).
 * Uses the formula n! / (r! * (n-r)!).
 */
class Comb {

    /**
     * Calculates the number of combinations of n items taken r at a time (nCr).
     *
     * @param n The total number of items.  Must be non-negative.
     * @param r The number of items to choose. Must be non-negative and not greater than n.
     * @return The number of combinations (nCr) as a BigInteger.
     * @throws IllegalArgumentException if n or r are negative, or if r is greater than n.
     */
    public static BigInteger solve(int n, int r) {
        if (n < 0 || r < 0 || r > n) {
            throw new IllegalArgumentException("Invalid input: n and r must be non-negative, and r must be less than or equal to n.");
        }
        return Factorial.solve(n).divide(Factorial.solve(r).multiply(Factorial.solve(n - r)));
    }
}
