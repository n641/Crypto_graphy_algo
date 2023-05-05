package finalProj;

public class RowTranspositionCiphers {
    public static void main(String[] args) {
        String text = "attack postponed until two am";
        String Key = "431256";

        String c = encrypt("4312567",text);
        System.out.println(c);

        System.out.println(5^8);
    }

//    char [] alpha = {'x','y','z'};
     static String encrypt(String Key, String plainText) {
        String c="";
        String plainText2 = plainText.toLowerCase();
        String p="";

        for (int i = 0 ; i < plainText2.length(); i++) {

            if (plainText2.charAt(i) >= 'a' && plainText2.charAt(i) <= 'z') {
                p += plainText2.charAt(i);
            }
        }
        int row ;
        if(p.length() % Key.length() !=0){
            row =(p.length()/Key.length())+1;
        }else{
            row =(p.length()/Key.length());

        }
        System.out.println(row);

        char [][] text = new char[row][Key.length()];

        int r=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < Key.length(); j++) {
                if(p.length()-1<r){
                    text[i][j]='x';
                }else {
                    text[i][j]=p.charAt(r);
                    r++;
                }

            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < Key.length(); j++) {
                System.out.print(text[i][j]+" ");
            }
            System.out.println();

        }

        String[] arr = new String[Key.length()];

        for (int i = 0; i < Key.length(); i++) {
            int colIndex = Integer.parseInt(String.valueOf(Key.charAt(i)))-1;

            String temp ="";
            for(int j=0;j<row;j++){
               temp += text[j][i];
           }
           arr[colIndex]=temp;
        }

        for (int i = 0; i < arr.length; i++) {
//            int colIndex = Integer.parseInt(String.valueOf(Key.charAt(i)))-1;
//            System.out.println(arr[i]+" ");
            c+= arr[i];
        }


        return c;
    }

    public static String decrypt(String Key, String cText) {
        String p ="";
        int row =cText.length()/Key.length();
        char[][] text = new char[row][Key.length()];

        String[] arr = new String[Key.length()];
        for (int i = 0 , r=0 ; i < cText.length(); i+=row) {
            String temp ="";
            for (int j = i; j < row+i; j++) {
                temp += cText.charAt(j);

            }
            arr[r]=temp;
            r++;
        }
        for (int i = 0; i < arr.length; i++) {
            int index = search(Integer.parseInt(String.valueOf(Key.charAt(i)))-1 , Key);
//            int colIndex = Integer.parseInt(String.valueOf(Key.charAt(i)))-1;
            System.out.println(arr[i]+" ");
//            c+= arr[i];
        }



        return p;
    }

    private static int search(int num , String Key) {
        int index=0;
        for(int i=0;i<Key.length();i++){
            if(num ==Integer.parseInt(String.valueOf(Key.charAt(i)))-1 ){
                index = i;
            }
        }
        return index;
    }
}
