//https://leetcode.com/problems/number-complement/description/

//求一个数的补码对应的数
public class NumberComplement {
//    public int findComplement(int num)
//    {
//        int i = 0;
//        int j = 0;
//
//        while (i < num)
//        {
//            i += Math.pow(2, j);
//            j++;
//        }
//
//        return i - num;
//    }
//

//    public int findComplement(int num) {
//        int n = 0;
//        while (n < num) {
//            n = (n << 1) | 1;
//        }
//        return n - num;
//    }
    public int findComplement(int num) {
        String a = Integer.toBinaryString(num);
        String[] arrayA = a.split("");
        int[] arrayANumber = new int[a.length()];
        for (int i = 0; i < arrayA.length; i++) {
            arrayANumber[i] = Integer.valueOf(arrayA[i]) ^ 1;
        }

        String resultSting = "";
        for (int i = 0; i < arrayANumber.length; i++) {
            resultSting += arrayANumber[i];

        }
        int result = Integer.valueOf(resultSting, 2);
        return result;
    }

    public static void main(String[] args) {
        int num = 1;
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(numberComplement.findComplement(num));
    }
}
