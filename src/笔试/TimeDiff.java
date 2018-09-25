package 笔试;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeDiff {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        String fromData = in.nextLine();
        String toData = in.nextLine();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date fd = df.parse(fromData);
        Date td = df.parse(toData);
        long diff = Math.abs(td.getTime() - fd.getTime());
        long day = diff / 86400000;
        long hour= diff % 86400000 / 3600000;
        long min = diff % 86400000 % 3600000 / 60000;
        double tag = 0.5;
        if (min <=29){
            tag = 0;
        }
        if (tag == 0.5){
            System.out.println(day*24 + hour + tag);
        }else{
            System.out.println(day*24 + hour);
        }



    }
}
//
//2018-06-23 11:10
//        2018-06-22 15:30
