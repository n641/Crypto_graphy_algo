public class VigenèreCipher {
    public static void main(String[] args) {
        String c =encrypt("abc", "abcdefghijklmnopqrstuvwxyz");
        System.out.println(c);
        String d =decrypt("abc" ,c );
        System.out.println(d);
    }

    private static String encrypt(String Key, String plainText) {
        String c = "";
        Key=Key.toLowerCase();
        plainText=plainText.toLowerCase();
        for (int i = 0 , j=0; i < plainText.length(); i++) {

            if (plainText.charAt(i) < 'a' || plainText.charAt(i) > 'z') {
                c += plainText.charAt(i);
            } else {
                c += (char) ((char) (((plainText.charAt(i) - 'a') + (Key.charAt(j% Key.length())) - 'a') % 26) + 'a');
                j++;
            }

        }
        return c;
    }

    public static String decrypt(String Key, String cText) {
        String p ="";
        Key=Key.toLowerCase();
        cText=cText.toLowerCase();
        for (int i = 0 , j=0; i < cText.length(); i++) {

            if (cText.charAt(i) < 'a' || cText.charAt(i) > 'z') {
                p += cText.charAt(i);
            } else {
                int k = (cText.charAt(i)-'a') - (Key.charAt(j% Key.length())-'a');
                p += (char) ((char) mod(k) + 'a');
                j++;
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
