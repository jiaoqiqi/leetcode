package 网易;

import org.junit.Test;

import java.util.Scanner;

public class W2 {
    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        BigInteger N = in.nextBigInteger();
//        BigInteger K = in.nextBigInteger();
//        BigInteger x = new BigInteger("0");
//        BigInteger y = new BigInteger("1");
//        int res = 0;
//        for (BigInteger i = new BigInteger("1"); N.subtract(i).compareTo(x) >=1; i.add(y)) {
//            for (BigInteger j = new BigInteger("1"); i.subtract(j).compareTo(x) >= 1 ; i.add(y)) {
//               if (x.divide(y).compareTo(K) == 1){
//                   res++;
//               }
//
//            }
//
//        }
//        System.out.println(res);
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
//    int res = 0;
//    for (int i = 1; i <= N; i++) {
//        for (int j = 1; j <= N; j++) {
//            if ((i%j) >= K){
//                res++;
//            }
//
//        }
//
//    }
//    System.out.println(res);
        System.out.println(Math.pow(2, (N - K)) - 1);
        System.out.println(Math.pow(2, 2));

    }

    @Test
    public void testW2() {

    }
}
