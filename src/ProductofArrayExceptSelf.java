//https://leetcode.com/problems/product-of-array-except-self/description/

public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//        res[0] = 1;
//        for (int i = 1; i < n; i++) {
//            res[i] = res[i - 1] * nums[i - 1];
//        }
//
//        int right = 1;
//        for (int i = n - 1; i >= 0; i--) {
//            res[i] *= right;
//            right *= nums[i];
//        }
//        return res;
        int[] result = new int[nums.length];
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] ==0){
                count++;
            }
        }
        System.out.println(count);
        if (count>=2){
            for (int i = 0; i < result.length; i++) {
                result[i]=0;
            }
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
            return  result;
        }

        int mul = 1;
        int mul0=1;

        for (int i = 0; i < nums.length; i++) {
            mul0*=nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                mul *= nums[i];
            }
        }

        if (mul==mul0){
            for (int i = 0; i < result.length; i++) {
                result[i] = mul / nums[i];
            }
        }
        if(mul!=mul0){
            for (int i = 0; i < result.length; i++) {
                if (nums[i] ==0){
                    result[i] = mul;
                }else{
                    result[i] = 0;
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            int i1 = result[i];
            System.out.println(i1);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductofArrayExceptSelf productofArrayExceptSelf = new ProductofArrayExceptSelf();
        productofArrayExceptSelf.productExceptSelf(nums);
    }
}
