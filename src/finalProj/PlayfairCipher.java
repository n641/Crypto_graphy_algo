package finalProj;

import java.awt.Point;
import java.util.Scanner;

public class PlayfairCipher
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Key");
        String Key = sc.next();

        System.out.print("Enter the plain text");
        String plainText = sc.next();

        System.out.print("the matrix");
        char[][] matrix = createMatrix(Key.toLowerCase()); //Monarchy


        String  encrypted = playfairEndcoded(Key , plainText.toLowerCase());
        System.out.print("\nencrpted string is " + encrypted);

        String decrypted = playfairDecoded(Key , encrypted);
        System.out.print("\ndecrypted string is " + decrypted);

    }

    static String playfairDecoded(String plainText,String Key) {
        char[][] matrix = createMatrix(Key.toLowerCase());
        String  decrypted = new String();
        int fchar_row=0, fchar_col=0 , schar_row=0 , schar_col=0 ;
        int fEnc_char_r=0, fEnc_char_c=0 , sEnc_char_r=0,sEnc_char_c=0;

        //repeat char (put x between) && text is odd put x
        for(int i=0;i<plainText.length();i+=2){ //ballon => ba lx lo nx
            if(i == plainText.length()-1){

                plainText+='x';

            } else if (plainText.charAt(i)==plainText.charAt(i+1)) {
                plainText=plainText.substring(0,i+1)+'x'+plainText.substring(i+1);
            }

            //replace i with j (because marteix has just j )
            if(plainText.charAt(i)=='i'){
                plainText=plainText.substring(0,i) +'j'+plainText.substring(i+1);
            } else if (plainText.charAt(i+1)=='i') {
                plainText=plainText.substring(0,i+1) +'j'+plainText.substring(i+2);
            }

            for (int r = 0; r <5 ; r++)
                for (int c = 0; c < 5; c++) {
                    if (plainText.charAt(i)==matrix[r][c]){
                        fchar_row=r;
                        fchar_col=c;
                    } else if (plainText.charAt(i+1)==matrix[r][c]) {
                        schar_row=r;
                        schar_col=c;
                    }
                }

            if(fchar_row == schar_row){ //same row
                fEnc_char_r=fchar_row;
                sEnc_char_r=schar_row;

                fEnc_char_c =(fchar_col-1+5)%5;
                sEnc_char_c =(schar_col-1+5)%5;

            } else if (fchar_col == schar_col) { //in same col
                fEnc_char_c =fchar_col;
                sEnc_char_c =schar_col;

                fEnc_char_r=(fchar_row-1+5)%5;
                sEnc_char_r=(schar_row-1+5)%5;

            }else {
                fEnc_char_r=fchar_row;
                fEnc_char_c =schar_col;

                sEnc_char_r=schar_row;
                sEnc_char_c=fchar_col;

            }
            decrypted += matrix[fEnc_char_r][fEnc_char_c];
            decrypted += matrix[sEnc_char_r][sEnc_char_c];


        }
        return decrypted;
    }

    static String playfairEndcoded( String plainText,String Key) {
        char[][] matrix = createMatrix(Key.toLowerCase());
        String  encrypted = new String();
        int fchar_row=0, fchar_col=0 , schar_row=0 , schar_col=0 ;
        int fEnc_char_r=0, fEnc_char_c=0 , sEnc_char_r=0,sEnc_char_c=0;

        //repeat char (put x between) && text is odd put x
        for(int i=0;i<plainText.length();i+=2){ //ballon => ba lx lo nx

               if(i == plainText.length()-1){

                   plainText+='x';

               } else if (plainText.charAt(i)==plainText.charAt(i+1)) {
                   plainText=plainText.substring(0,i+1)+'x'+plainText.substring(i+1);
               }

               //replace i with j (because marteix has just j )
                if(plainText.charAt(i)=='i'){
                   plainText=plainText.substring(0,i) +'j'+plainText.substring(i+1);
                } else if (plainText.charAt(i+1)=='i') {
                    plainText=plainText.substring(0,i+1) +'j'+plainText.substring(i+2);
                }

            for (int r = 0; r <5 ; r++)
                for (int c = 0; c < 5; c++) {

                    if (plainText.charAt(i)==matrix[r][c]){
                        fchar_row=r;
                        fchar_col=c;
                    } else if (plainText.charAt(i+1)==matrix[r][c]) {
                        schar_row=r;
                        schar_col=c;
                    }
                }

                if(fchar_row == schar_row){ //same row
                    fEnc_char_r=fchar_row;
                    sEnc_char_r=schar_row;

                    fEnc_char_c =(fchar_col+1)%5;
                    sEnc_char_c =(schar_col+1)%5;

                } else if (fchar_col == schar_col) { //in same col
                    fEnc_char_c =fchar_col;
                    sEnc_char_c =schar_col;

                    fEnc_char_r=(fchar_row+1)%5;
                    sEnc_char_r=(schar_row+1)%5;

                }else {
                    fEnc_char_r=fchar_row;
                    fEnc_char_c =schar_col;

                    sEnc_char_r=schar_row;
                    sEnc_char_c=fchar_col;

                }
                encrypted += matrix[fEnc_char_r][fEnc_char_c];
                encrypted += matrix[sEnc_char_r][sEnc_char_c];


        }
        return encrypted;
    }

    private static char[][] createMatrix(String key) {
        char[][] matrix = new char[5][5];
        StringBuilder alphabet = new StringBuilder();
        for(char i='a' , j=0 ; i<='z' ; i++,j++)
            alphabet.append(i);

            String text = key + alphabet;

            for (int i = 0; i <key.length() ; i++) {
                for (int j = i+1; j <text.length() ; j++) {
                        if(key.charAt(i) == text.charAt(j)){
                            text=text.substring(0,j)+text.substring(j+1);
                        }
                }
            }

        for (int i = 0; i < text.length(); i++) { //remove i
            if(text.charAt(i)=='i'){
                text = text.substring(0,i)+text.substring(i+1);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = text.charAt((i*5)+j);  // i=0 => 0 1 2 3 4 , i=1 => 5 6 7 8 9 .....
            }
        }

//        System.out.println();
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        return matrix;
    }
}