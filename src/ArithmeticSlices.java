//https://leetcode.com/problems/arithmetic-slices/description/

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }

    public boolean isArithmetic(int[] arr){
        boolean flag = true;
        int cha = arr[1] - arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] != cha){
                flag=false;
                break;
            }
        }
        return  flag;
    }

    public int[] subArray(int[] arr,int n, int m){
        int []res = new int[m-n+1];
        int length = res.length;
        for (int i = 0; i < length; i++) {
            res[i]=arr[n++];
        }
        return  res;
    }

    public static void main(String []args){
        int []arr = {1,2,3,4};
        ArithmeticSlices arithmeticSlices = new ArithmeticSlices();
//        System.out.println(arithmeticSlices.isArithmetic(arr));
//        System.out.println(Arrays.toString(arithmeticSlices.subArray(arr,0,1)));
        System.out.println(arithmeticSlices.numberOfArithmeticSlices(arr));
    }
}
