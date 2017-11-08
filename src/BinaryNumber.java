//https://leetcode.com/problems/binary-number-with-alternating-bits/descripti
//判断一个数字的二进制的1 0 是不是交替的，我是这么理解的
public class BinaryNumber {
    public boolean hasAlternatingBits(int n) {
        boolean flag = true;
        String a  = Integer.toBinaryString(n);

        String[] splitBinary = new String[a.length()];
        splitBinary=a.split("");
        if (a.length()==0){
            flag=true;
            return flag;
        }
        else if (a.length()>=2 &&splitBinary[0].equals(splitBinary[1])){
            flag = false;
            return flag;
        }

        for (int i = 1; i < splitBinary.length-1; i++) {
            if (splitBinary[i].equals(splitBinary[i-1]) || splitBinary[i].equals(splitBinary[i+1])){
                flag=false;
                break;
            }

        }
        return flag;

    }

    public static void main(String []args){
        BinaryNumber binaryNumber = new BinaryNumber();
        int n =1;
        System.out.println(binaryNumber.hasAlternatingBits(n));
    }
}
