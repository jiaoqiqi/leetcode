//https://leetcode.com/problems/counting-bits/description/

public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i < num; i++) {
            result[i] = result[i / 2] + i % 2;

        }
        return result;
    }

    public static void main(String[] args) {
        CountingBits count = new CountingBits();
        int num = 2;
        int[] res= count.countBits(num);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);

        }

    }
}


