package finalProj;

public class VernamCipher {

    public static void main(String[] args) {
//        String c =encrypt("zzzzzzzz", "abcdefjh");
//        System.out.println("the cipher text "+c); //A  A  B  Q  R  O  Q  U  O  K
//        String d =decrypt("zzzzzzzz" ,c );
//        System.out.println("the plain text "+d);
    }
    static String encrypt(String Key, String plainText) {
        String c = "";
        Key=Key.toLowerCase();
        String Key2 ="";
        for (int i = 0 ; i < Key.length(); i++) {

            if (Key.charAt(i) >= 'a' && Key.charAt(i) <= 'z') {
                Key2 += Key.charAt(i);
            }
        }

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
        Key=Key.toLowerCase();
        cText=cText.toLowerCase();
        System.out.println("the key is : "+Key);
        for (int i = 0 , j=0; i < cText.length(); i++) {

//            if (cText.charAt(i) < 'a' || cText.charAt(i) > 'z') {
//                p += cText.charAt(i);
//            } else {
                int k = ((cText.charAt(i)-'a') ^ (Key.charAt(j% Key.length())-'a'))%32 ;
//                System.out.println(((cText.charAt(i)-'a') ^ (Key.charAt(j% Key.length())-'a')) %26);
//                System.out.println((cText.charAt(i)-'a') + " xor " +(Key.charAt(j% Key.length())-'a') );
                p += (char) ((char) mod(k) + 'a');
                j++;
//            }

        }
        return p;
    }

    public static int mod(int n) {
        if(n<0){
            return n+32;
        }else{
            return n%32;
        }
    }

}
