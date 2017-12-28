package niuke;

import java.util.Scanner;

public class CustomersHobby {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] hobbies = new int[n];
        for (int i = 0; i < hobbies.length; i++) {
            hobbies[i] = in.nextInt();

        }

        int arrayNum = in.nextInt();
        int[][] arrays = new int[arrayNum][3];
        for (int i = 0; i < arrayNum; i++) {
            for (int j = 0; j < 3; j++) {
                arrays[i][j] = in.nextInt();

            }
        }

        int[] reasult = new int[arrayNum];
        for (int i = 0; i < reasult.length; i++) {
            reasult[i] = 0;
        }

        for (int i = 0; i < arrayNum; i++) {
            for (int j = 0; j < 3; j++) {
                int l = arrays[i][0];
                int r = arrays[i][1];
                int k = arrays[i][2];

                for (int m = l; m <= r; m++) {
                    if (hobbies[m - 1] == k) {
                        reasult[i] ++;
                    }
                }

            }
        }

        for (int i = 0; i < reasult.length; i++) {
            System.out.println(reasult[i]/arrayNum);

        }
    }
}

