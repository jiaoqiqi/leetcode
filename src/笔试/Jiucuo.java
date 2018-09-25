package 笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jiucuo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> result = new ArrayList<>();

        String strs = in.nextLine();
        String[] splitStrs = strs.split(" ");
        String target = splitStrs[0];
        result.add(splitStrs[0]);
        int count0 = ins(target,splitStrs[0]) + change(target,splitStrs[0]);
        result.add(splitStrs[1]);
        int count1 = ins(target,splitStrs[1]) + change(target,splitStrs[1]);

        result.add(splitStrs[2]);
        int count2 = ins(target,splitStrs[2]) + change(target,splitStrs[2]);

        for (int i = 3; i < splitStrs.length; i++) {
            int counti = 0;
            int countChange = change(target,splitStrs[i]);
            if (target.length() == splitStrs[i].length()){
                counti += countChange;
            }else{
                int len = target.length()>splitStrs[i].length() ?  splitStrs[i].length() : target.length();
                counti+= ins(target,splitStrs[i])+ change(target.substring(0,len),splitStrs[i].substring(0,len));
            }
//            int counti= ins(target,splitStrs[i]) + change(target,splitStrs[i]);
            if (counti < count2 && !result.contains(splitStrs[i])){
                result.remove(result.get(2));
                result.add(splitStrs[i]);
            }else if(counti < count1 && !result.contains(splitStrs[i])){
                result.remove(result.get(1));
                result.add(splitStrs[i]);
            }else if(counti < count0 && !result.contains(splitStrs[i])){
                result.remove(result.get(0));
                result.add(splitStrs[i]);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)+" ");
        }

    }

    public  static  int ins(String a,String b){
        int lena = a.length();
        int lenb = b.length();
        return Math.abs(lena-lenb)*3;
    }

    public static int change(String a,String b){
        String[] arr1 = {"q","w","e","r","t","a","s","d","f","g","z","x","c","v"};
        String[] arr2 = {"y","u","i","o","p","h","j","k","l","b","n","m"};
        int result =0;
        if (a.length() == b.length()){
            for (int i = 0; i < a.length(); i++) {
                 if (a.charAt(i) != b.charAt(i)){
                     if ((isContain(arr1,a.substring(i,i+1)) && (isContain(arr1,b.substring(i,i+1)))) ||
                             ((isContain(arr2,a.substring(i,i+1)) && (isContain(arr2,b.substring(i,i+1)))))){
                         result++;
                     }else{
                         result+=2;
                     }
                 }
            }
        }
        return  result;
    }

    public static boolean isContain(String[] arr,String x){
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x){
                flag = true;
                break;
            }
        }
        return  flag;
    }
}


//    slep slap sleep step shoe shop snap slep
