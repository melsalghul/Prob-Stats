import java.math.BigInteger;

class BiDistr{
    public static double solve(int n, int k, double p){
        if (n < 0 || k < 0 || k > n || p < 0 || p > 1){
            return 0; 
        }

        BigInteger combinations = Comb.solve(n, k); 
        
        return combinations.doubleValue() * Math.pow(p, k) * Math.pow(1 - p, n - k);
    }
}
