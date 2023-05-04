package AlgoOfDES;


import java.util.Arrays;
import java.util.Scanner;



public class KeyGenrator {
    static int[][] pc1   =   {{57 ,49 ,41 ,33, 25, 17, 9},
                      {1 ,58, 50, 42, 34, 26, 18}
                     ,{10 ,2 ,59 ,51 ,43 ,35 ,27}
                     ,{19 ,11 ,3 ,60 ,52 ,44 ,36}
                     ,{63 ,55 ,47 ,39 ,31 ,23 ,15}
                     ,{7 ,62, 54, 46, 38, 30, 22}
                     ,{14 ,6 ,61 ,53 ,45 ,37 ,29}
                     ,{21 ,13 ,5 ,28 ,20 ,12 ,4}};

    static int[][] pc2   =   {{14 ,17 ,11 ,24 ,1 ,5},
            {3 ,28 ,15, 6 ,21 ,10}
            ,{23 ,19 ,12 ,4 ,26 ,8}
            ,{16 ,7 ,27 ,20 ,13 ,2}
            ,{41 ,52 ,31 ,37 ,47 ,55}
            ,{30 ,40 ,51 ,45 ,33 ,48}
            ,{44 ,49 ,39 ,56 ,34 ,53}
            ,{46 ,42 ,50 ,36, 29, 32
    }};

    static int[] Shift ={1 ,1 ,2 ,2 ,2 ,2 ,2 ,2 ,1 ,2 ,2 ,2 ,2 ,2 ,2 ,1};

    static String[] Keys =new String[16];


    public static void main(String[] args) {
        System.out.println(Arrays.toString(KeyGenerator("133457799BBCDFF1")));
    }

    public static String[] KeyGenerator(String Key){

        String BinaryKey =convert(Key);
        String BinaryKey56=EnterTOPc1(BinaryKey);
        String Left = BinaryKey56.substring(0,28);
        String Right = BinaryKey56.substring(28,56);

//        System.out.println(Left.length());
//        System.out.println(Right.length());
//        System.out.println();

        for (int i = 0; i < 16; i++) {
            if(Shift[i]==1){
                Left =Left.substring(1)+Left.charAt(0);
                Right =Right.substring(1)+Right.charAt(0);
                String ResultKey = Left+Right;
                String k = ConvertTo48(ResultKey);
//                System.out.println("K"+(i+1)+"= "+ k);
                Keys[i]=k;
            }else{
                Left =Left.substring(2)+Left.charAt(0)+Left.charAt(1);
                Right =Right.substring(2)+Right.charAt(0)+Right.charAt(1);
                String ResultKey = Left+Right;
                String k = ConvertTo48(ResultKey);
//                System.out.println("K"+(i+1)+"= "+ k);
                Keys[i]=k;
            }

        }
        return Keys;
    }

    private static String ConvertTo48(String resultKey) {
        String Key56="";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                Key56+=resultKey.charAt(pc2[i][j]-1);
            }
        }

        return Key56;
    }

    private static String EnterTOPc1(String key) {
        String Key56="";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                Key56+=key.charAt(pc1[i][j]-1);
            }

        }

        return Key56;
    }

    static String convert(String hex)
    {
        String bin = "";
        String binFragment = "";

        int iHex;
        hex = hex.trim();
        hex = hex.replaceFirst("0x", "");

        for(int i = 0; i < hex.length(); i++){
            iHex = Integer.parseInt(""+hex.charAt(i),16);
            binFragment = Integer.toBinaryString(iHex);

            while(binFragment.length() < 4){
                binFragment = "0" + binFragment;
            }
            bin += binFragment;
        }
        return bin;
    }
}
//1111000 0110011 0010101 0101111 0101010 0101010 1001111 0001111
//1111000 0110011 0010101 0101111 0101010 1011001 1001111 0001111