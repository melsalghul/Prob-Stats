import java.math.BigInteger;

class Perm {
    public static BigInteger solve(int n, int r){
    	
        return Factorial.solve(n).divide(Factorial.solve(n - r));
    }
}