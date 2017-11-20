import java.util.Arrays;

public class MinMoves2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int site = nums.length/2;
        for (int i = 0; i < nums.length; i++) {
            count+= Math.abs(nums[i] - nums[site]);

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        MinMoves2 minMoves2 = new MinMoves2();
        System.out.println(minMoves2.minMoves2(nums));

    }
}
