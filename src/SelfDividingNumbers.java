//https://leetcode.com/problems/self-dividing-numbers/description/

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            if (isSelfNumber(i)){
                res.add(i);
            }
        }

        return res;
    }

    public boolean isSelfNumber(int num){
        boolean flag = true;
        int a = num;
        int i=0;
        while(num>0)
        {
            i = num % 10;
            if ( i==0 || a%i != 0){
                flag=false;
                break;
            }else{

                num = num / 10;
            }

        }

        return flag;
    }

    public static void main(String[] args) {
        SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();

        System.out.println(selfDividingNumbers.selfDividingNumbers(1,22));
    }
}
