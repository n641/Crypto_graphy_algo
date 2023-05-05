package AlgoOfDES;

import java.util.Objects;

import static AlgoOfDES.KeyGenrator.KeyGenerator;


public class DES_Massage_Encryption {

    static String[] Keys =new String[16];
    static int[][] IP   =   {{58 ,50 ,42 ,34 ,26 ,18 ,10 ,2},
            {60 ,52 ,44 ,36 ,28 ,20, 12, 4}
            ,{62 ,54 ,46 ,38 ,30 ,22 ,14, 6}
            ,{64 ,56 ,48 ,40 ,32 ,24 ,16 ,8}
            ,{57 ,49 ,41 ,33 ,25 ,17 ,9 ,1}
            ,{59 ,51 ,43 ,35, 27 ,19 ,11 ,3}
            ,{61 ,53 ,45 ,37 ,29 ,21 ,13 ,5}
            ,{63 ,55 ,47 ,39 ,31 ,23 ,15 ,7}};

    static int[][] Epansion   =   {{32 ,1 ,2 ,3 ,4 ,5},
                                 {4 ,5 ,6 ,7 ,8 ,9}
                                ,{8 ,9 ,10 ,11 ,12 ,13}
                                ,{12 ,13 ,14 ,15 ,16 ,17}
                                ,{16 ,17 ,18 ,19 ,20 ,21}
                                ,{20 ,21 ,22 ,23 ,24 ,25}
                                ,{24 ,25 ,26 ,27 ,28 ,29}
                                ,{28 ,29 ,30 ,31 ,32 ,1}};

    static int[][] S1   =   {
            {14 ,4 ,13 ,1,2,15,11,8,3,10,6,12,5,9,0,7}
            ,{0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},
            {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
            {15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}
    };

    static int[][] S2   =   {
            {15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},
            {3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
            {0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},
            {13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}
    };

    static int[][] S3   =   {
            {10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},
            {13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},
            {13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},
            {1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}
    };

    static int[][] S4   =   {
            {7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},
            {13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},
            {10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},
            {3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}
    };

    static int[][] S5   =   {
            {2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},
            {14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},
            {4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},
            {11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}
    };

    static int[][] S6   =   {
            {12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},
            {10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},
            {9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},
            {4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}
    };

    static int[][] S7   =   {
            {4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},
            {13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},
            {1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},
            {6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}
    };

    static int[][] S8   =   {
            {13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},
            {1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2},
            {7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8},
            {2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}
    };

    static int[][] Permutation   =
            {{16, 7, 20, 21, 29, 12, 28, 17}
            , {1, 15, 23, 26, 5, 18, 31, 10}
            , {2, 8, 24, 14, 32, 27, 3, 9}
            , {19, 13, 30, 6, 22, 11, 4, 25}};

    static int[][]  INVERSE_IP   =   {
            {40 ,8 ,48 ,16 ,56 ,24 ,64 ,32},
            {39 ,7 ,47 ,15 ,55 ,23 ,63 ,31}
            ,{38 ,6 ,46 ,14 ,54 ,22 ,62 ,30}
            ,{37 ,5 ,45 ,13 ,53 ,21 ,61 ,29}
            ,{36 ,4 ,44 ,12 ,52 ,20 ,60 ,28}
            ,{35 ,3 ,43 ,11 ,51 ,19 ,59 ,27}
            ,{34 ,2 ,42 ,10 ,50 ,18 ,58 ,26}
            ,{33 ,1 ,41 ,9 ,49 ,17 ,57 ,25}};


    public static void main(String[] args) {

        String M ="0000000100100011010001010110011110001001101010111100110111101111";
        String k = "133457799BBCDFF1";
//        Keys =KeyGenerator(k);

        String c=Encrption(M, "EN" , k);
        System.out.println(Encrption(c,"DE", k));

    }
    public static String Encrption(String plaintext, String moda ,String key2){
        Keys =KeyGenerator(key2);
        String IP =intialPer(plaintext);
        String Left = IP.substring(0,32);
        String Right = IP.substring(32,64);

        String Left1="";
        String Right1="";

        if(Objects.equals(moda, "EN")){
            for (int i = 0; i < 16; i++) {
                Left1 = Right;
                Right1 = GetXOR(Left , F(Right,Keys[i]));
                Left = Left1;
                Right=Right1;
            }

        } else if (Objects.equals(moda, "DE")) {

            for (int i =15 ; i >= 0 ; i--) {
                Left1 = Right;
                Right1 = GetXOR(Left , F(Right,Keys[i]));
                Left = Left1;
                Right=Right1;
//                System.out.println("string in left  "+(i+1) +" " + Left1);
//                System.out.println("string in right  "+(i+1) +" " + Right1);
            }

        }

        String lastRount = Right1 + Left1;

//        System.out.println();
//        System.out.println("lastRount = R16L16 :- "+" " + lastRount);

        String inverse_Ip = inversePer(lastRount);

        String text ="";
        if(Objects.equals(moda, "EN")){
            text="Cipher";
        } else if (Objects.equals(moda, "DE")) {
            text="Plain text";
        }

        System.out.println("text "+text+" " + inverse_Ip);


        return inverse_Ip;
    }

    private static String inversePer(String lastRount) {
        String text="";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                text+=lastRount.charAt(INVERSE_IP[i][j]-1);
            }
        }

        return text;
    }

    private static String GetXOR(String left, String text) {
        String R="";
        for (int i = 0; i < left.length(); i++) {
            R += left.charAt(i)^ text.charAt(i) ;
        }
        return R;
    }

    private static String F(String right, String key) {

        // expantion right text from 32 to 48
        String M48 =ConverTexttTo48(right);
        String result0fXOR="";

        // get key xor with key
        for (int i = 0; i < M48.length(); i++) {
            result0fXOR += M48.charAt(i)^ key.charAt(i) ;
        }
        // make 8 substitutions
        String subText ="";
        for (int i = 1 , j=6; i <=8 ; i++, j+=6) {
            String text = result0fXOR.substring(j-6,j) ; // 0->6 , 6->12 , 12->18 , 18->24 , 24->30 , 30->36 , 36 -> 42 , 42->48
            subText +=S(text,i);
        }

        String permutationText=permutation(subText);

        return permutationText;
    }

    private static String permutation(String subText) {

        String Right="";

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                Right+=subText.charAt(Permutation[i][j]-1);
            }
        }

        return Right;

    }

    private static String S(String text, int i) {
        String bit4 ="";
        // get number of row
        String row = String.valueOf(text.charAt(0))+String.valueOf(text.charAt(text.length()-1));
        // convert number of row to int
        int numberrow = Integer.parseInt(row, 2);

        // get number of col
        String col = String.valueOf(text.charAt(1))+String.valueOf(text.charAt(2))+String.valueOf(text.charAt(3))+String.valueOf(text.charAt(4));
        // convert number of col to int
        int numbercol = Integer.parseInt(col, 2);

        switch (i){
            case 1:
                bit4= String.valueOf(S1[numberrow][numbercol]);
                break;
            case 2:
                //get number of s1 of row and col
                bit4= String.valueOf(S2[numberrow][numbercol]);
                break;
            case 3:
                //get number of s1 of row and col
                bit4= String.valueOf(S3[numberrow][numbercol]);
                break;
            case 4:
                //get number of s1 of row and col
                bit4= String.valueOf(S4[numberrow][numbercol]);
                break;
            case 5:
                //get number of s1 of row and col
                bit4= String.valueOf(S5[numberrow][numbercol]);
                break;
            case 6:
                //get number of s1 of row and col
                bit4= String.valueOf(S6[numberrow][numbercol]);
                break;
            case 7:
                //get number of s1 of row and col
                bit4= String.valueOf(S7[numberrow][numbercol]);
                break;
            case 8:
                //get number of s1 of row and col
                bit4= String.valueOf(S8[numberrow][numbercol]);
                break;
        }

        // convert int to binary of 6 bit
        String bit42 = Integer.toBinaryString(Integer.parseInt(bit4));
        if(bit42.length()==3){
            bit42 ="0"+bit42;
        } else if (bit42.length()==2) {
            bit42 ="0"+"0"+bit42;
        } else if (bit42.length()==1) {
            bit42 ="0"+"0"+"0"+bit42;
        }


        return bit42;
    }

    private static String ConverTexttTo48(String key) {
        String Right="";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                Right+=key.charAt(Epansion[i][j]-1);
            }
        }

        return Right;
    }

    private static String intialPer(String resultKey) {
        String text="";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                text+=resultKey.charAt(IP[i][j]-1);
            }
        }

        return text;
    }

    static int binaryToDecimal(long binary)
    {


        int decimalNumber = 0, i = 0;
        while (binary > 0) {

            decimalNumber
                    += Math.pow(2, i++) * (binary % 10);
            binary /= 10;
        }
        return decimalNumber;
    }

    static String decimalToHex(long binary)
    {
        int decimalNumber = binaryToDecimal(binary);

        String hexNumber
                = Integer.toHexString(decimalNumber);

        hexNumber = hexNumber.toUpperCase();

        return hexNumber;
    }

}
