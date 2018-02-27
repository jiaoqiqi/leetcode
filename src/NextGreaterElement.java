import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    //    public int[] nextGreaterElements(int[] nums) {
//        int[] result = new int[nums.length];
//        boolean[] change = new boolean[nums.length];
//        Arrays.fill(result, -1);
//        Arrays.fill(change,false);
//        for (int i = 0; i < nums.length-1; i++) {
//            for (int j = i+1; j < result.length; j++) {
//                if (nums[j] > nums[i]){
//                    result[i] = nums[j];
//                    change[i] = true;
//                    break;
//                }
//            }
//
//            for (int j = 0; j < i; j++) {
//                if (nums[j] > nums[i]  && change[i]==false){
//                    result[i] = nums[j];
//                    change[i] = true;
//                    break;
//                }
//            }
//        }
//
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i] > nums[nums.length-1]){
//                result[nums.length-1] = nums[i];
//                break;
//            }
//
//        }
//
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
//
//        return result;
//
//    }
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }
        return next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        nextGreaterElement.nextGreaterElements(nums);
    }
}
