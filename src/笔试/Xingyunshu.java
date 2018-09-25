package 笔试;

import java.util.Scanner;

public class Xingyunshu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ID = in.next();
        if (ID.length() < 6){
            return;
        }
        String[] idList = ID.split("");
        int pre = Integer.parseInt(idList[0]) + Integer.parseInt(idList[1]) + Integer.parseInt(idList[2]);
        int last = Integer.parseInt(idList[3]) + Integer.parseInt(idList[4]) + Integer.parseInt(idList[5]);
        if (pre == last){
            System.out.println(0);
        }else if(Math.abs(pre-last) < 10){
            System.out.println(1);
        }else if( Math.abs(pre-last) <= 18){
            System.out.println(2);
        }else if (Math.abs(pre-last) <= 27){
            System.out.println(3);
        }else{
            return;
        }
    }
}
