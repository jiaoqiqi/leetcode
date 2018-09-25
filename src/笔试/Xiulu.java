package 笔试;

import java.util.Scanner;

public class Xiulu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] daolu = new int[n-1][2];
        for (int i = 0; i < daolu.length; i++) {
            for (int j = 0; j < 2; j++) {
                daolu[i][j] = in.nextInt();
            }
        }
        int count = 1;
        for (int i = 0; i < daolu.length-1; i++) {
            int qian = daolu[i][1];
            int hou = daolu[i+1][0];
            if (qian != hou){
                count=i+1;
                break;
            }
        }
        if (count == 1){
            System.out.println(1);
        }else{
            int halfont = count;
            int halfsec = n-count-2;
            System.out.println(halfont*halfsec);
        }
    }
}
