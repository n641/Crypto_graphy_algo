public class railFenceCipher {
    public static void main(String[] args) {
        String c = encrypt("2","meetmeafterthetogaparty");
        System.out.println(c);
        String p = decrypt("2" , c);
        System.out.println(p);

    }

    private static String encrypt(String Key, String plainText) {
        String c ="";
        String p="";
        int key2 =Integer.parseInt(Key);

        for (int i = 0 ; i < plainText.length(); i++) {

            if (plainText.charAt(i) >= 'a' && plainText.charAt(i) <= 'z') {
                p += plainText.charAt(i);
            }
        }
        char[][] text = new char[key2][Math.round((p.length()/key2)+1)];

        int r=0;
        for (int i = 0 ; i < (p.length()/key2)+1 ; i++) {
            for (int j = 0; j < key2; j++) {
                if(p.length()-1<r){
                    text[j][i]='_';
                }else {
                    text[j][i] = p.charAt(r);
                    r++;
                }
            }

        }

        for (int i = 0; i < key2 ; i++) {
            for (int j = 0; j < (p.length()/key2)+1; j++) {
                if(text[i][j]!='_'){
                    System.out.print(text[i][j] +" ");
                    c+= text[i][j];
                }
            }
            System.out.println();

        }
        System.out.println();
        System.out.println();


//        for (int i = 0; i < key2 ; i++) {
//            for (int j = 0; j < (p.length()/key2)+1; j++) {
//                System.out.print(text[i][j] +" ");
//
//            }
//            System.out.println();
//        }
//        System.out.println();
        return c;
    }

    public static String decrypt(String Key, String cText) {
        String p="";
        int key2 =Integer.parseInt(Key);
        char[][] text = new char[key2][Math.round((cText.length()/key2)+1)];

        int r=0;
        for (int i = 0 ; i < key2; i++) {
            for (int j = 0; j < (cText.length()/key2)+1; j++) {

                if(cText.length()-1<r){
                    text[i][j]='_';
                }else {
                    text[i][j]=cText.charAt(r);
                    r++;
                }
            }
        }


        for (int i = 0; i < (cText.length()/key2)+1 ; i++) {
            for (int j = 0; j < key2; j++) {
//                System.out.print(text[j][i] +" ");
                if(text[j][i]!='_'){
                    p+=text[j][i];
                }
            }
        }
                System.out.println();

        return p;
    }
}
