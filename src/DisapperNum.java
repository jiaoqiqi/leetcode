//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisapperNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
////        List<Integer> disapper = new ArrayList();
////        List<Integer> result = new ArrayList<>();
////        if (nums.length==0){
////            return result;
////        }
////        for (int i = 0; i < nums.length; i++) {
////            int num = nums[i];
////            disapper.add(num);
////        }
////        for (int i = 1; i <=nums.length; i++) {
////            if (!disapper.contains(i)){
////                result.add(i);
////            }
////
////        }
////        System.out.println(result);
////        return result;
//
//
//
//        List<Integer> ret = new ArrayList<Integer>();
//
//        for(int i = 0; i < nums.length; i++) {
//            int val = Math.abs(nums[i]) - 1;
//            if(nums[val] > 0) {
//                nums[val] = -nums[val];
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
//            System.out.println(num);
//
//        }
//
//        for(int i = 0; i < nums.length; i++) {
//            if(nums[i] > 0) {
//                ret.add(i+1);
//            }
//        }
////        System.out.println(ret);
//        return ret;

        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i ++) nums[(nums[i]-1) % n] += n;
        for (int i = 0; i < nums.length; i ++) if (nums[i] <= n) res.add(i+1);
        return res;

    }

    public static void main(String[] args) {
        DisapperNum disapperNum = new DisapperNum();
        int[] nums = {4,3,2,7,8,2,3,1};
        disapperNum.findDisappearedNumbers(nums);
    }
}
