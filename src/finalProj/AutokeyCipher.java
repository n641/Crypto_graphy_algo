package finalProj;

public class AutokeyCipher {
    public static void main(String[] args) {
        String c =encrypt("abcabcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz ");
        System.out.println(c);
       String p =decrypt("abcabcdefghijklmnopqrstuvwxyz" , c);
       System.out.println(p);


    }

    static String pk="";
    public static String encrypt(String Key, String plainText) {
        String c = "";
        Key=Key.toLowerCase();
        plainText=plainText.toLowerCase();

        for (int i = 0; i < plainText.length(); i++) {
            if (plainText.charAt(i) >= 'a' && plainText.charAt(i) <= 'z') {
                pk += plainText.charAt(i);
            }
        }

        for (int i = 0 , j=0 , k=0; i < plainText.length(); i++) {

            if (plainText.charAt(i) < 'a' || plainText.charAt(i) > 'z') {

                c += plainText.charAt(i);

            } else if (Key.length()-1<k) {

//                char q = pk.charAt(j%pk.length());
//                System.out.print("=>at index " +j+"  :");
//                System.out.print("=>at char " + plainText.charAt(i)+"  :");
//                System.out.println("USE KEY = PLAIN char at " +q );
                c += (char) ((char) (((plainText.charAt(i) - 'a') + (pk.charAt(j)) - 'a') % 26) + 'a');
                j++;
            }else{
//                System.out.println("USE KEY = KEY");
                c += (char) ((char) (((plainText.charAt(i) - 'a') + (Key.charAt(k)) - 'a') % 26) + 'a');
//                char q = Key.charAt(k);
//                System.out.print("=>at index " +k+"  :");
//                System.out.print("=>at char " + plainText.charAt(i)+"  :");
//                System.out.println("USE KEY = key char at " +q );
//                System.out.println();

                k++;
            }

        }
        return c;
    }

    public static String decrypt(String Key, String cText) {
        String p = "";
        Key=Key.toLowerCase();
        cText=cText.toLowerCase();


        for (int i = 0 , j=0 , k=0; i < cText.length(); i++) {

            if (cText.charAt(i) < 'a' || cText.charAt(i) > 'z') {

                p += cText.charAt(i);

            } else if (Key.length()-1<k) {

                int d = (cText.charAt(i) - 'a') - (pk.charAt(j) - 'a') ;
                p += (char) ((char) mod(d) + 'a');
                j++;
            }else{
                int d = (cText.charAt(i) - 'a') - (Key.charAt(k) - 'a') ;
                p += (char) ((char) mod(d) + 'a');
                k++;
            }

        }
        return p;
    }

    public static int mod(int n) {
        if(n<0){
            return n+26;
        }else{
            return n%26;
        }
    }
}
