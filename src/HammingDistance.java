//https://leetcode.com/problems/hamming-distance/description/

public class HammingDistance {
    private int hammingDistance(int x, int y) {
//        return Integer.bitCount(x ^ y);

//        int d = 0;
//        int bitxor = x ^ y;
//
//        while (bitxor > 0){
//            if (bitxor % 2 == 1){
//                d++;
//            }
//            bitxor = bitxor >> 1;
//        }
//
//        return d;
        String a  = Integer.toBinaryString(x);
        String b = Integer.toBinaryString(y);
        int m =a.length();
        int n = b.length();

        if (m < 32) {
            for (int i = 32; i > m; i--) {
                a="0".concat(a);
            }
        }

        if (n < 32) {
            for (int i = 32; i > n; i--) {
                b="0".concat(b);
            }
        }



        String[] arr1=a.split("");
        String[] arr2=b.split("");

        int c=0;

        for (int i=0 ; i<32 ; i++){
            if (!(arr1[i].equals(arr2[i]))){
                c++;
            }
        }



        return c;
    }

    public static  void main(String []args){
        int num1 = 1;
        int num2 = 3;
        HammingDistance res = new HammingDistance();
        System.out.println(res.hammingDistance(num1,num2));
    }
}
