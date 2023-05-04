
import java.security.Key;
import java.util.Random;

public class OneTimePadCipher {
    public static void main(String[] args) {

        String c =encrypt("15", "nohanoha");
        System.out.println("the cipher text "+c); //A  A  B  Q  R  O  Q  U  O  K
        String d =decrypt("15" ,c );
        System.out.println("the plain text "+d);
//          System.out.println((('e'-'a')^ ('z'-'a'))%26);
    }

//    meet me after the toga party
private static String encrypt(String Key, String plainText) {
    String c = "";
    int K=Integer.parseInt(Key);
    String Key2 =GenerateKey(K , plainText.length());

    System.out.println("the key is : "+Key2);

    plainText=plainText.toLowerCase();
    for (int i = 0 , j=0; i < plainText.length(); i++) {

        if (plainText.charAt(i) < 'a' || plainText.charAt(i) > 'z') {
            c += plainText.charAt(i);
        } else {
            c += (char) ((char) (((plainText.charAt(i) - 'a') ^ ((Key2.charAt(j% Key2.length())) - 'a'))  %32) + 'a');
            j++;
        }
    }
    return c;
}

    public static String decrypt(String Key, String cText) {
        String p ="";
        int K=Integer.parseInt(Key);
        String Key2 =GenerateKey(K , cText.length());
        System.out.println("the key is : "+Key2);

        cText=cText.toLowerCase();
        for (int i = 0 , j=0; i < cText.length(); i++) {

//            if (cText.charAt(i) < 'a' || cText.charAt(i) > 'z') {
//                p += cText.charAt(i);
//            } else {
                int k = ((cText.charAt(i)-'a') ^ (Key2.charAt(j% Key2.length())-'a'))%32 ;
//                System.out.println(((cText.charAt(i)-'a') ^ (Key2.charAt(j% Key2.length())-'a')) %26);
//                System.out.println((cText.charAt(i)-'a') + " xor " +(Key2.charAt(j% Key2.length())-'a') );
                p += (char) ((char) mod(k) + 'a');
                j++;
//            }

        }
        return p;
    }

    public static String GenerateKey(int seed , int x) {
        String key ="";
        for (int i = 0; i < x; i++) {
             key += (char) (mod(new Random(seed+i).nextInt()%26)+'a');
//            System.out.println(key);
        }
        return key;
    }
    public static int mod(int n) {
        if(n<0){
            return n+32;
        }else{
            return n%32;
        }
    }

}
