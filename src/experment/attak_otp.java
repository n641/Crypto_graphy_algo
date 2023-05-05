package experment;

import java.util.Arrays;

public class attak_otp {
    static String[] MSGS =
                    {"993D854E2BAEBE370A6DFE2BE44E0BDD2F972F87520522510020AEE220B05D24FF830B02A0EF0C31CFFD12D1BEBDD1D9AA71652B6CA532E7F3D3FFE0665F90084FE51B7EF6EB38E87D6910EBB5E7792B58F9A61987471655E0567A4AABFEC670390270FA580F7FEE2E575968331AF500527D62F3D5D08B107EFA3D45D15BA824CF984C05C88C8E9E809D70AD890E3BB6C28A13AE",
                    "813A9E5866FAB8281538E46AFE1D48DB22937B8F59563414002EB6FC2AFE0A27B086074CBBEC4833FAEE19D0BAB99FCAED27314365BD25B1F9D4ADAD7E4897084AEE0C37FCEA39A37D4E1DE1ABAB6B6E19F8AB56830E141EA4526747ECE48F76334631B55D4363F8294D",
                    "F501980B31E6AE670A70FC7EE159458E33D2788F1D1C2302176FA0E03FA75032F1821247EFE80C60E1E110D8B0F4CCDBE62B200D60B777F0F8C5FFEA6C59D5490EE91331F8EF6AE23B3901E1BDFF3C3419C3A24F910E141EAC587B45ABEBDB22280E35B5584066F1284E572620",
                    "8237D74A2AE2F72C1777E42BF9554E8932817A8B51563C1E082AB0AF2EBC1237E4D1124AAAA90B40AFAF1EDAF5F3F6D1DC78651077B339F5FFCFB8AD6F42870809D81A3DEEF623F9243E5BA48CFF3B7819E3A24B90420C1EA117674BE8F8CA767C1238F44A0F79F8244C4C21330BB0494F3C6AFB97C68E196BF27804CB5AF03E8A834D0FC8C78A94C4D97AAD851F7EA4858209E0544B60CC824C0F54360F8CAB385B5E83315276701E350EA73A2D455844337B5D",
                    "F5139B4766CFB5280C6CB348E44F48DC2E867CCA54057601162DAFE63CB6142CF7D10702BCEC5E7AEDFC57DBB3F4DECCFC36260F66A177FEF881BAE06B48914C4BEF5F2DFEE73FFF346D0CA4B2E2686319EAE34A805C1A50A7177241E8FFDC22330870FB5B5B7DF235521E3B2211E552486876",
                    "9421845E2BEBF7331179E72BE41D43C831972F8E58103F1F062BE3E12AA95D10F19F024DA2A11821A1AF1EDAF5B7D3DFFB2C65026DB677F8F881BEE366599D4D5CAB1C32FAF739AD343914E3A4E2722B5DE4E3579159556CA1597041E6A2862233083CEC1E4E64F967501E2F2806B044487A69F387C684092EE43D16D052A47EC1D953139AD8879596D83FBA82053BA3C08812AE5C567989D65708152D4991EE351A51832E567124413909AD2034000B55376C164AC55ED4886B5BA5CC3BAD1041BEFDFC61542BC0F59A4119A7148205220A1B04007405DF9E6AFFD59BFC7D358B0D5129B5B903F7167FB24E926761790F8126E2E78203FCFF1ACF6F8F3C9E5AE4B1E0B0C856BB47843E098595F42F7D4ED7D2D05CC6F1020F5E22A4B0456C523887455869A59FC93933799420DA1CA630F3EB65A25B0C3BB7C1F12BAEB60902C6A3",
                    "F521980B28EBAF333D77E669E1580BDE2887638E1D173A060236B0AF3DBB0937E29F4656A7EC0C75E1FD04C0F5B0D0CBEA3320436ABC77E5FEC4FFFF6843914743AB0C3BEAF12FE33E7C",
                    "813A965F61FDF733117DB37BFF5445CA2E82638F1D193051026F93FC2AAB192DBDA32865E1A9787BEDAF19C1B8B6DACCFB7F241166F239FEE281ADE8684199510EF91E30FFEB27",
                    "813A925266EFA522597FF665E84F4ADD22962F9F4E1F3816432EE3EB2AAA1830FD98084BBCFD4570A8EE1BD3BAA6D6CAE032",
                    "A626965F23AEB821596CFB6EAD4F4AC7239D62CA53033B13063DE3E82AB01830F1850950EFEE4967FBAF05D1A6B1CB9EE931214377BA32B1F0C8ADFE7D0D874940EF1033BBEA3FE03F7C07A4BCE4692B5EEEAD5C864F015BE0407D42E7AACD677C1238F01E4963EF344D1E3A261CF44F4C3C61E398C18F0F2EF73E11C04CF02487921A09D4C59B9985D13FA8981D6FB2",
                    "813A920B35EBB4351C6CB366E84E58C820972F834E4C76260B2AADAF3AAD142CF7D10702BCFD5E76E9E257D7BCA4D7DBFA7F2B0675B725B1E3D2BAAD7D45900845EE067EF6EB38E87D6D1DE5ABAB73655AEEE311C5174709F2022707"};

    static int[][] c = new int[MSGS.length][];
    static char[][] p = new char[MSGS.length][];

    public static void main(String[] args) {

        for (int i = 0; i < MSGS.length; i++) {

            int[] carr = new int[MSGS[i].length()/2];
            for (int j = 0; j < carr.length; j++) {
                carr[j] = Integer.valueOf(MSGS[i].substring(j * 2, (j + 1) * 2), 16);
            }
            c[i]=carr;
            p[i] = new char[c[i].length];
            Arrays.fill(p[i], '_');
        }
//        for (int i = 0; i < p.length; i++) {
//            for (int j = 0; j < p[0].length; j++) {
//                System.out.print(p[0][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < MSGS.length; i++) {
            for (int j = 0; j < MSGS.length; j++) {
                if (j == i)
                    continue;
                int minLength = Math.min(c[i].length, c[j].length);
                for (int k = 0; k < minLength; k++) {
                    int x = (c[i][k] ^ c[j][k]);
//                  System.out.println((char) x);
                    if ((x >= 'A' && x <= 'Z') || (x >= 'a' && x <= 'z')) {
                        if (valChar(i, c[i][k], k)){
                            setPlainTexts(k,i,x);
                        }
                    }
                }
            }
        }


        for (int i = 0; i < p.length; i++) {
            for (int k = 0; k < p[i].length; k++)
                System.out.print(p[i][k]);
            System.out.println();
        }

//        int[] key = new int[p[0].length];
//        for (int i = 0; i < key.length; i++) key[i] = (p[0][i] ^ c[0][i]);
//        for (int i = 0; i < key.length; i++) {
//            System.out.print(key[i]);
//        }

    }

    static void setPlainTexts(int k , int i , int x) {
        for (int l = 0; l < p.length; l++) {
            if (k >= p[l].length || p[l][k] != '_')
                continue;
            x = (char) (c[i][k] ^ c[l][k] ^ ' ');
            if (x == 0) { //space
                p[l][k] = ' ';
            }
            else {
                p[l][k] = (char) x;
            }
        }
    }

     static boolean valChar(int cindex, int ch, int charindex) {
        int count = 0;
        for (int j = 0; j < MSGS.length; j++) {

            if (j == cindex || c[j].length <= charindex) {
                continue;
            }

            int x = (ch ^ c[j][charindex]);
//            System.out.println(x);
            if (x == 0) { //equal char space
                continue;
            }
            if (!((x >= 'A' && x <= 'Z')||(x >= 'a' && x <= 'z'))) {
                count++;

                if (count > 2) {
                    return false;
                }

            }
        }
        return true;
    }

}
