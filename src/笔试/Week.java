package 笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Week {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < days.length; i++) {
            days[i] = in.nextInt();
        }
//        System.out.println(days.length);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < days.length; i++) {
            List<Integer> join = new ArrayList<>();

            for (int j = i; j < days.length; j++) {
                if (days[j] - days[i] == j-i){
                    join.add(days[j]);
                }else{
                    break;
                }
            }

            if (join.size() >=3){
                i+=join.size()-1;
                result.add(join.get(0)+ "-" + join.get(join.size()-1));
            }else{
                result.add(days[i] + "");
            }
        }
        for (int i = 0; i < result.size()-1; i++) {
            System.out.print(result.get(i) + ",");
        }
        System.out.print(result.get(result.size()-1));
    }
}


//6
//1 2 3 4 6 7
