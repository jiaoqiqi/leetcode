package jingdong;

import java.util.Scanner;

public class Huiwen {
    public boolean isPalindromic(String a) {
        String reversed = new StringBuffer(a).reverse().toString();
        if (a.equals(reversed)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Huiwen huiwen  = new Huiwen();
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String[] Splited = input.split("");
        int count = 0 ;
        if (huiwen.isPalindromic(input)){
            count++;
        }
        for (int i = 0; i < Splited.length; i++) {
            for (int j = i+1; j < Splited.length+1; j++) {
//                System.out.println(input.substring(i,j));
                if (huiwen.isPalindromic(input.substring(i,j))){
                System.out.println(input.substring(i,j));
                    count++;
                }
            }

        }
        if (input.length()==1){
            count=1;
        }

        System.out.println(count);
    }
}
