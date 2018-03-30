package 网易;

import java.lang.reflect.Array;
import java.util.Scanner;

public class North {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String dir = in.next();
        String[] NESW = {"N","E","S","W"};
        int res = 0;
        String[] dirs = dir.split("");
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i] == "L"){
                if(i==3){res = 0;}
                else{res+=1;}
            }else if(dirs[i] == "R"){
                if(i==0){
                    res = 3;
                }else{res -= 1;}
            }

        }
        System.out.println(NESW[(res+1)%4]);

    }
}
