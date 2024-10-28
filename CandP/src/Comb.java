import java.math.BigInteger;

class Comb {
    public static BigInteger solve(int n, int r) {
        return Factorial.solve(n).divide(Factorial.solve(r).multiply(Factorial.solve(n - r)));
    }
}