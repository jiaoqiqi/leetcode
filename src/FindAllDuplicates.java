//https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
//找一个数组里出现了两次的数
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List result = new ArrayList();
        for (int i = 0; i < nums.length-1; i++) {
           if (nums[i] == nums[i+1]){
               result.add(nums[i]);
           }

        }
        return result;
    }

//    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; ++i) {
//            int index = Math.abs(nums[i])-1;
//            if (nums[index] < 0)
//                res.add(Math.abs(index+1));
//            nums[index] = -nums[index];
//        }
//        return res;
//    }



    public static void main(String []args){
        int [] nums = {4,3,2,7,8,2,3,1};
        FindAllDuplicates findAllDuplicates  = new FindAllDuplicates();
        List result = findAllDuplicates.findDuplicates(nums);
        System.out.println(result);
    }
}
