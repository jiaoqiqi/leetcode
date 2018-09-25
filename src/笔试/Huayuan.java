package 笔试;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Huayuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int tan1x = in.nextInt();
        int tan1y = in.nextInt();
        int tan2x = in.nextInt();
        int tan2y = in.nextInt();

        int tandistance = distance(tan1x,tan1y,tan2x,tan2y);


        int[][] flowers = new int[n][2];
        for (int i = 0; i < flowers.length; i++) {
            for (int j = 0; j<2; j++) {
                flowers[i][j] = in.nextInt();
            }
        }

        int[] distance1 = new int[n];
        int[] distance2 = new int[n];
        for (int i = 0; i < distance1.length; i++) {
            distance1[i] = distance(tan1x,tan1y,flowers[i][0],flowers[i][1]);
            distance2[i] = distance(tan2x,tan2y,flowers[i][0],flowers[i][1]);
            if (distance1[i] > distance2[i]){
                distance1[i] =0;
            }else {
                distance2[i] =0;
            }
        }
        for (int i = 0; i < distance2.length; i++) {
            System.out.print(distance1[i] + " ");
        }

        int min1 = getMix(distance1);
        int max1 = getMax(distance1);
        int min2 = getMix(distance2);
        int max2 = getMax(distance2);

//        int fir = min1+max2;
//        int sec = min2+max1;


//        System.out.println(Math.min(fir,sec));
        System.out.println(max1+max2);

    }

    public static int distance(int a,int b,int c,int d){
        int x = Math.abs(a-c);
        int y = Math.abs(b-d);
        int m = x*x + y*y;
        return m;
    }

    public static int getMix(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        return  min;
    }

    public static int getMax(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        return  max;
    }
}
//
//2 -1 0  5 3
//        0 2
//        5 2
