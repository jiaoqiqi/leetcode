package 笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChuFa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (Math.round((n)/m) == ((n)/(m*1.0))){
            System.out.println(n/m);
        }else if(isLoop(n,m)){
            f(n,m);
        }else{
            System.out.println(n/(m*1.0));
        }
    }

    public static boolean isLoop(long a, long b) {
        long commonDivisor = greatestCommonDivisor(a, b);
        b = b / commonDivisor;
        while (b % 2 == 0) {
            b /= 2;
        }
        while (b % 5 == 0) {
            b /= 5;
        }
        if (b == 1) {
            return false;
        } else {
            return true;
        }
    }

    public static long greatestCommonDivisor(long a, long b) {
        long c = 0;
        while (true) {
            c = a % b;
            a = b;
            b = c;
            if (b == 0) {
                return a;
            }
        }
    }

    static void f(int a, int b){
        List t1 = new ArrayList();
        List t2 = new ArrayList();

        int p = - 1;
        while(true){

            t1.add(a/b);
            int x = a % b;
            if(x == 0) break;

            p = t2.indexOf(x);

            if(p >= 0) break;
            else
                t2.add(x);

            a = x*10;
        }
        System.out.print(t1.get(0)+".");

        for(int i = 1; i < t1.size();i++){

            if(i == p + 1)System.out.print("(");
            System.out.print(t1.get(i));
        }
        if(p >= 0)
            System.out.println(")");

    }

}
