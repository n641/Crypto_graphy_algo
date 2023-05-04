package RSAcipher;

import java.math.BigInteger;
import java.util.Random;

public class RSA {

    static BigInteger n , p , q , d , f ,e = BigInteger.valueOf(65537);
    public static void main(String[] args) {
          GenerateBasic();
          System.out.println(RSAEncrypt("noha"));

    }

    private static void GenerateBasic() {
        Random rand = new Random();
        int lengh = 32;
        p= BigInteger.probablePrime(lengh,rand);
        q= BigInteger.probablePrime(lengh,rand);
        n= p.multiply(q);
        f= (p.subtract(BigInteger.valueOf(1))).multiply((q.subtract(BigInteger.valueOf(1))));
        d= e.modInverse(f);

        System.out.println(e.gcd(f));

        while (!e.gcd(f).equals(BigInteger.valueOf(1))){
            e=e.add(BigInteger.valueOf(2));
        }
    }

    private static BigInteger RSAEncrypt(String M) {
        String editM = "";
        for (int i = 0; i < M.length(); i++) {
            String b = String.valueOf(M.charAt(i)-97);
            if(b.length() ==1){
                b="0"+"0"+b;
            } else if (b.length()==2) {
                b="0"+b;
            }
            editM += b;
//            System.out.println(editM);
        }
        BigInteger ed = new BigInteger("123456");
        BigInteger c = null;
        BigInteger m = null;
           System.out.println("message "+ed);

        if(n.compareTo(BigInteger.valueOf(editM.length())) < 0){
         System.out.println("divide");
        }else{
             c = ed.modPow(e,n);
           System.out.println("c1 "+c);
             m = c.modPow(d,n);
             c = m.modPow(e,n);
            System.out.println("m "+m);
            System.out.println("c2 "+c);
            m = c.modPow(d,n);
            c = m.modPow(e,n);
            System.out.println("m3 "+m);
            System.out.println("c3 "+c);

        }

    return c;
    }

}
