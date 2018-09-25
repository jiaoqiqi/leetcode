package 笔试;

import java.util.Scanner;

public class Jimu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int BAbs = Math.abs(B);
        int count = A > BAbs ? (A / BAbs) + 1 : BAbs / A;
        int[] arr = new int[17];

        if (A < BAbs) {
            for (int i = 0; i < 17; i++) {
                if ((i+1)%(count+1) == 0){
                    arr[i] = B;
                }else{
                    arr[i] = A;
                }
            }


        }else{
            arr[0] = A;
            for (int i = 1; i < 17; i++) {
                if (i%(count+1) == 0){
                    arr[i] = A;
                }else {
                    arr[i] = B;
                }
            }

        }



        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            System.out.println();
            sum = sum + arr[i];
        }
        System.out.println(sum);

    }


}
