package jingdong;

import java.util.Scanner;

public class ER {
    public static void main(String []args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        if (n == 1) {
            System.out.println(1);
        }
        boolean[] bool = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            bool[i] = false;
        }
        for (int i = 2; i <= n; i++) {
            if (bool[i]) {
                continue;
            } else {
                int j = i;
                while (j <= n) {
                    bool[j] = true;
                    j += i;
                }
                bool[j - i] = false;
            }
        }
        long res = 1;
        for (int i = 1; i <= n; i++) {
            if (!bool[i]) {
                res *= i;
            }
        }
//        return (int)(res % 987654321);
        System.out.println((int)(res % 987654321));
    }
}
