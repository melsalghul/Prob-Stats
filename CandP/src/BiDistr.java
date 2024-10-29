import java.math.BigInteger;

/**
 * This class provides a method for calculating the probability mass function (PMF)
 * of a binomial distribution.
 */
class BiDistr {

    /**
     * Calculates the probability mass function (PMF) of a binomial distribution.
     *
     * The binomial distribution models the probability of getting exactly k successes in n independent trials,
     * where each trial has a probability p of success.
     *
     * @param n The number of trials. Must be non-negative.
     * @param k The number of successes. Must be non-negative and not greater than n.
     * @param p The probability of success in a single trial. Must be between 0 and 1 (inclusive).
     * @return The probability of getting exactly k successes in n trials, or 0 if the input parameters are invalid.
     */
    public static double solve(int n, int k, double p) {
        if (n < 0 || k < 0 || k > n || p < 0 || p > 1) {
            return 0;
        }

        BigInteger combinations = Comb.solve(n, k); // Calculate combinations (nCk)

        return combinations.doubleValue() * Math.pow(p, k) * Math.pow(1 - p, n - k);
    }
}
