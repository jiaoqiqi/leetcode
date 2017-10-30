//https://leetcode.com/problems/single-element-in-a-sorted-array/description/

public class SingleElement {
    public int singleNonDuplicate(int[] nums) {
        int result=0;
        if (nums[0]!= nums[1]){
            result = nums[0];
        }
        if(nums[nums.length-1] != nums[nums.length-2]){
            result=nums[nums.length-1];
        }
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i]!= nums[i-1] && nums[i]!=nums[i+1] ){
                result = nums[i];
            }

        }

        return result;
    }
    public static void main(String []args){
        int[] nums = {1,1,2,3,3,4,4,8,8};
        SingleElement singleElement = new SingleElement();
        System.out.println(singleElement.singleNonDuplicate(nums));
    }

}
