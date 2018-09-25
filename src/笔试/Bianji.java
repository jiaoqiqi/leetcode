package 笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bianji {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int actorsNumber = in.nextInt();
        String[] problems = new String[actorsNumber];
        for (int i = 0; i < problems.length; i++) {
            problems[i] = in.next();
        }
        ArrayList<String[]> splitProblems = new ArrayList();
        for (int i = 0; i < problems.length; i++) {
            splitProblems.add(problems[i].split(";"));
        }

        int num = 0;
        for (int i = 0; i < splitProblems.size(); i++) {
            for (int j = 0; j < splitProblems.get(i).length; j++) {
                num++;
            }
        }


        String[] allProblems = new String[num];
        int k =0;
        for (int i = 0; i < splitProblems.size(); i++) {
            for (int j = 0; j < splitProblems.get(i).length; j++) {
                allProblems[k++] = splitProblems.get(i)[j];
            }
        }


        List<String> result = new ArrayList<>();
        for (int i = 0; i < allProblems.length; i++) {
            for (int j = 0; j < allProblems.length; j++) {
                result.add(change(allProblems[i],allProblems[j]));
//                allProblems[i] = change(allProblems[i],allProblems[j]);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }



    }
    public static String change(String fir, String sec){
        String[] splitFir = fir.split(",");
        String[] splitSec = sec.split(",");
        if (isBetween(splitFir[0],splitFir[1],splitSec[0])){
            if (Integer.parseInt(splitFir[1]) < Integer.parseInt(splitSec[1])){
                splitFir[1] = splitSec[1];
            }
        }
        return splitFir.toString();
    }

    public static boolean isBetween(String a,String b,String c){
        return Integer.parseInt(c)>Integer.parseInt(a) && Integer.parseInt(c) <Integer.parseInt(b);
    }
}

//
//1,10;32,45
//        78,94;5,16
//        80,100;