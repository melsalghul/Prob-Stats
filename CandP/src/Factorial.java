import java.math.BigInteger;

class Factorial{
    public static BigInteger solve(int n){
    	BigInteger result = BigInteger.ONE;
    	
        for (int i = 1; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));

        return result;
    }
}