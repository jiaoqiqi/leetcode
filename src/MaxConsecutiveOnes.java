public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                result = Math.max(count, result);
            }
            else{
                count=0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int []nums = {1,1,0,0,1,1,1};
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
    }
}
