import java.util.Arrays;

//https://leetcode.com/problems/next-greater-element-i/description/
public class NextGreater {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int tag = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == tag){
//                    System.out.println(nums2[j]);
                    for (int k = j; k < nums2.length; k++) {
                        if (nums2[k] > tag){
                            result[i] = nums2[k];
                            break;
                        }
                        else{
                            result[i] = -1;
                        }

                    }
                }

            }
        }
        return result;
    }

   public static void main(String []args){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int [] nums3 = {2,4};
        int[] nums4 = {1,2,3,4};
        NextGreater nextGreater = new NextGreater();
        int[] result = nextGreater.nextGreaterElement(nums3,nums4);
       for (int i = 0; i <result.length ; i++) {
           System.out.println(result[i]);
       }
   }
}
