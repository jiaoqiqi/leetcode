package 网络编程;

import java.util.Scanner;

public class AAA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().trim().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        int[] nums = new int[n];
        String[] sencondLine = scanner.nextLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(sencondLine[i]);
        }
        int[] wake = new int[n];
        String[] tirdLine = scanner.nextLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            wake[i] = Integer.parseInt(tirdLine[i]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (wake[i] == 1) {
                sum += nums[i];
            }
        }
        int max =0;
        for (int i = 0; i < n; i++) {
            if (wake[i] == 0 ) {
                int num =sum;
                for (int j = i; j < Math.min(i+k,n); j++) {
                    if(wake[j]==0) num+=nums[j];
                }
                max = Math.max(max, num);

            }
        }
        System.out.println(max);
    }
}