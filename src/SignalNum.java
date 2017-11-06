import java.lang.reflect.Array;
import java.util.Arrays;

public class SignalNum {
    public int singleNumber(int[] nums) {
        int result=0;
        Arrays.sort(nums);
        if(nums.length == 1){
            result = nums[0];
        }
        else if (nums[0]!=nums[1] && nums.length>2){
            result=nums[0];
        }
        else if(nums[nums.length-1] != nums[nums.length-2]){
            result=nums[nums.length-1];
        }
        for (int i = 1; i <= nums.length-2; i++) {
            if (nums[i] !=nums[i-1] && nums[i]!=nums[i+1]){
                result = nums[i];
            }

        }
        return result;
    }

    public static void main(String []args){
        int[] nums = {2,2,3,3,4,4,7};
        SignalNum signalNum = new SignalNum();
        System.out.println(signalNum.singleNumber(nums));
    }
}

