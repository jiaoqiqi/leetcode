package 笔试;

import java.util.Scanner;

public class Yuenanbi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nums[] = new int[2 * n + 1];
        int i = 0;
        int k = 0;
        while (k < n) {
            nums[i++] = 0;
            nums[i++] = in.nextInt();
            k++;
        }
        nums[i++] = 0;

        long low = 0, high = 0;
        int left = 0, right = nums.length - 1;
        long result = 0;
        while (left <= right) {
            if (low < high) {
                left++;
                low += nums[left - 1];
            } else if (low > high) {
                right -= 2;
                high += nums[right + 1];
            } else {
                result = low;
                left += 2;
                low += nums[left - 1];
            }
        }
        System.out.println(result);
    }
}
