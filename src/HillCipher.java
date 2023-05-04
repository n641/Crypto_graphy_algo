import java.security.Key;
import java.util.Arrays;
import java.util.Scanner;

public class HillCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Key"); //dcif
        String Key = sc.next();
        while(Key.length() !=4){
            System.out.print("Enter the Key");
            Key = sc.next();
        }
        System.out.print("Enter the plain text");
        String plainText = sc.next();
        String c =encrypt("dcif" ,plainText);
        System.out.println(c);
        System.out.println(decrypt("dcif",c));

    }

    private static String encrypt(String Key , String plainText){
        String p="";
        int[][] keyMatrix = createKeyMatrix(Key);
        for (int i = 0; i < plainText.length(); i+=2) {
            if(i == plainText.length()-1){
                plainText+='x';
            }
            int[][] plain= {{plainText.charAt(i)-'a',plainText.charAt(i+1)-'a'}};
            String c = multiMatrix(plain ,keyMatrix);
            for (int j = 0; j < 2; j++) {
                p+=c.charAt(j);
            }
        }
        return p;
    }

    private static String decrypt(String Key , String c){
        String p="";
        int[][] keyMatrix = createKeyMatrix(Key);
        int[][] keyMatrixinv = createKeyMatrixinverse(keyMatrix);
        for (int i = 0; i < c.length(); i+=2) {
            int[][] q= {{c.charAt(i)-'a',c.charAt(i+1)-'a'}};
            String r = multiMatrix(q,keyMatrixinv);
            for (int j = 0; j < 2; j++) {
                p+=r.charAt(j);
            }
        }
        return p;
    }

    private static int[][] createKeyMatrixinverse(int[][] keyMatrix) {
        int det = calculateDet(keyMatrix);
        int [][] m = new int[2][2];
        if(det!=0){
            for(int i=0 ;i<2 ;i++ ){
                for (int j = 0; j <2 ; j++) {
                    m[i][j]=keyMatrix[i][j];
                }
            }

            int inv =0;
            for (int t = 0; t < 26; t++) {
                int r=(det*t)%26;
                if(r==1){
                    inv=t;
                }
            }

            int temp = m[0][0];
            m[0][0] = m[1][1];
            m[1][1] = temp;

            for(int i=0 ;i<2 ;i++ ){
                for (int j = 0; j <2 ; j++) {
                    m[i][j] = (int) Math.pow(-1, ((i)+(j)))*(m[i][j]);
                    m[i][j] = mod(m[i][j]);
                    m[i][j]= m[i][j]*inv;
                    m[i][j]= m[i][j]%26;
                }
            }
        }
        return m;
    }

    private static int calculateDet(int[][] keyMatrix) {

        int det= (keyMatrix[0][0] * keyMatrix[1][1]) - (keyMatrix[0][1] * keyMatrix[1][0]);
        while(det<0){
            det+=26;
        }
        return det;
    }
    public static int mod(int n) {
        if(n<0){
            return n+26;
        }else{
            return n%26;
        }
    }


    private static String multiMatrix(int[][] plain, int[][] keyMatrix) {
        String p ="";
        int c[][]=new int[1][2];
        for(int i=0;i<1;i++){
            for(int j=0;j<2;j++){
                c[i][j]=0;
                for(int k=0;k<2;k++)
                {
                    c[i][j]+=plain[i][k]*keyMatrix[k][j];

                }
            }
        }
        for(int i=0 ;i<1 ;i++ ){
            for (int j = 0; j <2 ; j++) {
                p+= (char)((c[i][j] %26)+'a')  ;

            }
        }
        return p;
    }

    private static int[][] createKeyMatrix(String key) {
        int[][] matrix = new int[2][2];
        for(int i=0 ;i<2 ;i++ ){
            for (int j = 0; j <2 ; j++) {
                matrix[i][j]= key.charAt((i*2)+j)-'a';
            }
        }
        return matrix;
    }


}
