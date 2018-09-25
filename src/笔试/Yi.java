package 笔试;

import java.util.Scanner;

public class Yi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int duishu = scanner.nextInt();
        int[] everyApple = new int[duishu];
        for (int i = 0; i < everyApple.length; i++) {
            everyApple[i] = scanner.nextInt();
        }
        int ask = scanner.nextInt();
        int[] everyAsk = new int[ask];
        for (int i = 0; i < everyAsk.length; i++) {
            everyAsk[i] = scanner.nextInt();
        }

        int[] result = new int[ask];
        for (int i = 0; i < everyAsk.length; i++) {
            int add = 0;
            for (int j = 0; j < everyApple.length; j++) {
               add+=everyApple[j];
               if (add>=everyAsk[i]){
                   result[i] = j+1;
                   break;
               }
            }

        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
