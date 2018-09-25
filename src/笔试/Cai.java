package 笔试;

import java.util.Scanner;

public class Cai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] cai = new int[n];
        for (int i = 0; i < cai.length; i++) {
            cai[i] = in.nextInt();
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            result += MaxSubSum3(cai);
//            for (int j = 0; j < cai.length; j++) {
//                System.out.print(cai[j] + " ");
//            }
//            System.out.println();
        }
        System.out.println(result);
    }


    public static int MaxSubSum3(int[] arr) {
        int i;
        int len = arr.length;
        int MaxSum = 0;
        int CurSum = 0;
        for (i = 0; i < len; i++) {
            CurSum += arr[i];
            if (CurSum > MaxSum){

                MaxSum = CurSum;
                 arr[i] = 0;
            }
            if (CurSum < 0)
                CurSum = 0;
        }
        return MaxSum;
    }
}


//7 2
//        1 2 3 -2 3 -10 3