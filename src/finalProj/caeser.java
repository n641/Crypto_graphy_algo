package finalProj;

import java.math.BigInteger;
import java.util.Scanner;

//import static sun.util.calendar.CalendarUtils.mod;

public class caeser {
    public static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
//    final String Key;

//    public caeser(String Key){
//        this.Key = Key;
//    }

    public static String encrypt(String p, String Key) {
        String c = "";
        p = p.toLowerCase();
        for(int i = 0; i < p.length(); i++){
            if(!Character.isAlphabetic(p.charAt(i))){
                c += p.charAt(i);
                continue;
            }
            int index = ALPHABET.indexOf(p.charAt(i));
            int newIndex = (index + Integer.parseInt(Key)) % 26;
            char replaceVal = ALPHABET.charAt(newIndex);
            c += replaceVal;
        }
        return c;
    }

    public static String decrypt(String c, String Key) {

        String p = "";
        c = c.toLowerCase();
        for(int i = 0; i < c.length(); i++) {
            if (!Character.isAlphabetic(c.charAt(i))) {
                p += c.charAt(i);
                continue;
            }
            int index = ALPHABET.indexOf(c.charAt(i));
            int newIndex = (index - Integer.parseInt(Key)) % 26;
            if (newIndex < 0) {
                newIndex = newIndex + 26;
            }
            char replaceVal = ALPHABET.charAt(newIndex);
            p += replaceVal;
        }
        return p;
    }
}
