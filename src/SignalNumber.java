import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignalNumber {
    public  int[] singleNumber(int[] nums) {
        List result = new ArrayList();
        Arrays.sort(nums);
        if (nums[0]!= nums[1]){
            result.add(nums[0]);
        }
        if(nums[nums.length-1] != nums[nums.length-2]){
            result.add(nums[nums.length-1]);
        }
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i]!= nums[i-1] && nums[i]!=nums[i+1] ){
                result.add(nums[i]);
            }

        }
        System.out.println(result);
        int[] signal = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
           signal[i] = (int) result.get(i);

        }
        return signal;
    }

    public static void main(String[] args) {
        SignalNumber signalNum = new SignalNumber();
        int[] nums = {1,2};
        signalNum.singleNumber(nums);
    }
}
