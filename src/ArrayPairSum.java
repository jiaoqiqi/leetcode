import java.lang.reflect.Array;
import java.util.*;

//https://leetcode.com/problems/array-partition-i/description/
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
        for (int i=0 ; i<=nums.length-1 ; i+=2){
            sum+=nums[i];
        }
        return sum;
    }

    public static void main(String []args){
        ArrayPairSum res = new ArrayPairSum();
        int[] arr = {1,4,3,2};
        System.out.println(res.arrayPairSum(arr));
    }
}
