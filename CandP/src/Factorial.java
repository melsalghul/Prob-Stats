import java.math.BigInteger;

/**
 * This class is for calculating the factorial of a non-negative integer.
 */
class Factorial {

    /**
     * Calculates the factorial of a non-negative integer n (n!).
     *
     * @param n The non-negative integer for which to calculate the factorial.
     * @return The factorial of n (n!) as a BigInteger.
     * @throws IllegalArgumentException if n is negative.
     */
    public static BigInteger solve(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative.");
        }

        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
