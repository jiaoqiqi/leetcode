package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class Zhong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = in.nextInt();
        }
        Arrays.sort(numbers);
        int len = n-1;
        if (n%2 == 1){
            System.out.println(numbers[n/2]);
        }else{
            int num1 = numbers[len/2];
            int num2 = numbers[(len/2) + 1];
            if (Math.round((num1+num2)/2.0) == ((num1+num2)/2)){
                System.out.println((num1+num2)/2);
            }else{
                System.out.println((num1+num2)/2.0);
            }

        }

    }

}
