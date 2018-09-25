package 笔试;

import java.util.*;
public class San {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = in.nextInt();
            nums[i][1] = in.nextInt();
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0]>arr2[0])
                    return arr2[0]-arr1[0];
                else if(arr1[0]==arr2[0]){
                    if(arr1[1]>arr2[1])
                        return arr2[1]-arr1[1];
                    else
                        return arr1[1]-arr2[1];
                }
                else
                    return arr1[0]-arr2[0];
            }
        });
        int m=0;
        int count=1;
        int temp1 = nums[m][0],temp2 = nums[m][1];
        while(m!=n-1){
            m++;
            if(nums[m][0]<= temp1 && nums[m][1]<= temp2){
                count++;
                temp1=nums[m][0];
                temp2=nums[m][1];
            }
        }
        System.out.println(count);
    }
}
