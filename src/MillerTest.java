import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MillerTest {

    public static void main(String[] args) {
        BigInteger x = new BigInteger(32,new Random());
//        System.out.println(millerTest(x));
        while (!millerTest(x)){
            x = new BigInteger(32,new Random());
            System.out.println(x);
            System.out.println(millerTest(x));
        }
    }
    static ArrayList<BigInteger> list = new ArrayList<BigInteger>();
    public static boolean millerTest(BigInteger n){
        if (n.equals(BigInteger.valueOf(0))  || n.equals(BigInteger.valueOf(1)) )
            return false;
        if (n.equals(BigInteger.valueOf(2)))
            return true;
        if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0)))
            return false;

        BigInteger s = n.subtract(BigInteger.valueOf(1));
        int k=0;
        while (s.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))){
            s = s.divide(BigInteger.valueOf(2)) ;
            k++;
        }

        long iteration = n.bitLength();
        for (int i = 0; i < iteration; i++)
        {
            if (!test(s, n , k))
                return false; // composite
        }
        return true; // in final is prime
    }
    private static boolean test(BigInteger s, BigInteger n , int k ) {
        Random rnd = new Random();
    BigInteger a = new BigInteger(n.bitLength(),rnd);
        BigInteger mod = a.modPow(s,n);
        if (mod.equals(BigInteger.valueOf(1))  || mod.equals(n.subtract(BigInteger.valueOf(1))))
            return true;
//        while (!s.equals(n.subtract(BigInteger.valueOf(1))))
        for (int i = 0; i < k; i++) {
        }
        { //s != n - 1 //one a =-1 => test another a (prime) || for all i => a^(2^i)*s != -1 n is composite
            mod = (mod.multiply(mod)).mod(n);
//            s = s.multiply(BigInteger.valueOf(2));
            if (mod.equals(BigInteger.valueOf(1))) // a^((2^k)*q) =1 => composite
                return false;
            if (mod .equals(n.subtract(BigInteger.valueOf(1)))) // a^((2^k)*q) =n-1 => prime
                return true;
        }
        return false; // is composite

    }

    static int power(int x, int y, int p) {

        int res = 1; // Initialize result

        //Update x if it is more than or
        // equal to p
        x = x % p;

        while (y > 0) {

            // If y is odd, multiply x with result
            if ((y & 1) == 1)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }

        return res;
    }

    private static ArrayList<BigInteger> randome3(BigInteger n) {
        ArrayList<BigInteger> list = new ArrayList<BigInteger>();
            BigInteger i= BigInteger.valueOf(2);
        while (!i.equals(n.subtract(BigInteger.valueOf(1)))){
                list.add(i);
                i=i.add(BigInteger.valueOf(1));
            }
        Collections.shuffle(list);
        return list;
    }


    private static BigInteger power(BigInteger a ,BigInteger b) {  // a^b
        BigInteger res= BigInteger.valueOf(1);
        while(!b.equals(BigInteger.valueOf(0))){
            b=b.subtract(BigInteger.valueOf(1));
            res=res.multiply(a);

        }
        return res;
    }

}
