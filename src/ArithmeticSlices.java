import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int result = 0;
        for (int i = 0; i <= A.length-3; i++) {
            for (int j = i+2; j < A.length; j++) {
                if (isArithmetic(subArray(A,i,j))){
                    result++;
                }
            }

        }
        return result;
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
