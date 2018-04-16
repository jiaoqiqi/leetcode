package jingdong;

import java.util.Scanner;

public class YingBi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String yingbi = in.next();
        int count = 0;
        int len = yingbi.length();
        if (yingbi.length() != 0) {
            String[] splitYingbi = yingbi.split("");
            if (!splitYingbi[0].equals(splitYingbi[1])) {
                count++;
            }
            if (!splitYingbi[len-1].equals(splitYingbi[len-2])){
                count++;
            }

            for (int i = 1; i < len - 1; i++) {
                if (!splitYingbi[i].equals(splitYingbi[i - 1]) || !splitYingbi[i].equals(splitYingbi[i + 1])) {
                    count++;
                }

            }
            System.out.println(count);
        }

    }

}
