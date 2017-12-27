import java.util.Arrays;

public class LNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        int[] save = new int[nums.length];
        for (int i = 0; i < save.length; i++) {
            save[i] = nums[i];
        }

        Arrays.sort(save);
        int biggest = save[save.length-1];
        int flag=-1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == biggest) {
                flag=i;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0 && nums[i]!=biggest && biggest/nums[i] < 2){
                flag=-1;
            }

        }
        System.out.println(flag);
        return  flag;

    }

    public static void main(String[] args) {
        LNumberAtLeastTwiceofOthers lNumberAtLeastTwiceofOthers = new LNumberAtLeastTwiceofOthers();
        int [] nums = {1,2,6,3};
        lNumberAtLeastTwiceofOthers.dominantIndex(nums);
    }
}
