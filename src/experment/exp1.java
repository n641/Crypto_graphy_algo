package experment;

public class exp1 {
    public static void main(String[] args) {
//        int k1=3;
//        int p1=4;
//        int p2=6;
        int[] arr = {
                20 ^ 33,
                40 ^ 33,
                32 ^ 33,
                41 ^ 33,
                52 ^ 33,
                66 ^ 33,
                73 ^ 33,
                82 ^ 33,
                91 ^ 33,
                10 ^ 33,

        };
        int c1 = 20 ^ 33;
        int c2 = 40 ^ 33;
        int c3 = 32 ^ 33;
        int c4 = 41 ^ 33;
        int c5 = 52 ^ 33;
        int c6 = 66 ^ 33;
        int c7 = 73 ^ 33;
        int c8 = 82 ^ 33;
        int c9 = 91 ^ 33;
        int c10 = 10 ^ 33;

        int t = c1 ^ c2;
        int t2 = c1 ^ c3;
        int t3= c1 ^ c4;
        int t4= c1 ^ c5;
        int t5= c1 ^ c6;
        int t6= c1 ^ c7;
        int t7= c1 ^ c8;
        int t8= c1 ^ c9;
        int t9= c1 ^ c10;
        System.out.println((char) (32^32^' '));
//        System.out.println((char) (32^0));

        for (int i = 0; i < 100; i++) {
            if((32^i)==0){
//                System.out.println(i);
            }
        }

    }
}

