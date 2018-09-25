package 笔试;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JuZhang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int NfoodType = in.nextInt();
        int Mdays = in.nextInt();
        int Pid = in.nextInt();
        int[] foodCount = new int[NfoodType];
        for (int i = 0; i < foodCount.length; i++) {
            foodCount[i]  = in.nextInt();
        }


        String[][] plan = new String[Mdays][2];
        for (int i = 0; i < plan.length; i++) {
            plan[i][0] = in.next();
            plan[i][1] = in.next();
        }

        for (int i = 0; i < plan.length; i++) {
           if (plan[i][0].equals("A")){
               int id = Integer.parseInt(plan[i][1]) -1;
               foodCount[id] +=1;
           }else{
               int id = Integer.parseInt(plan[i][1]) -1;
               foodCount[id] -=1;
           }

        }

        int target = foodCount[Pid-1];

        Arrays.sort(foodCount);

        for (int i = foodCount.length-1; i >=0; i--) {
//            System.out.println(foodCount[i]);
            if (foodCount[i] == target){
                System.out.println(foodCount.length-i);
                break;
            }
        }
    }
}

//
//3 4 2
//        5 3 1
//        B 1
//        A 2
//        A 2
//        A 3