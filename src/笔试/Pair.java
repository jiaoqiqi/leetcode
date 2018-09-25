package 笔试;

import java.util.Scanner;

public class Pair {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int count = 0;

        if (n<=0 || m<=0){
            System.out.println(count);
            return;
        }
        int bigger = n > m ? n : m;
        int smaller = n < m ? n : m;
        while (smaller >0 && bigger>0 && smaller<bigger){
            count++;
            smaller-=1;
            bigger-=2;
        }
        System.out.println(count);
    }
}
