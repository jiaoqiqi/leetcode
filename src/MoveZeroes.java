//https://leetcode.com/problems/move-zeroes/description/

import java.util.ArrayList;
import java.util.List;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        List<Integer> save = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!(num == 0)) {
                save.add(num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num==0){
                save.add(num);
            }
        }
//        System.out.println(save);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = save.get(i);
        }

        return;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
    }
}
