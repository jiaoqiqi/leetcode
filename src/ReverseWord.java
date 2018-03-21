//https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

public class ReverseWord {
    public String reverseWords(String s) {
        String result="";
        String [] splitString = s.split(" ");
        for (int i = 0; i < splitString.length-1; i++) {
            String s1 = splitString[i];
            result = result + new StringBuffer(s1).reverse().toString() + " ";

        }
        result+=new StringBuffer(splitString[splitString.length-1]).reverse().toString();
        return result;

    }


    public String reverseString1(String s) {
        byte[] bytes = s.getBytes();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            bytes[i] = (byte) (bytes[i] ^ bytes[j]);
            bytes[j] = (byte) (bytes[i] ^ bytes[j]);
            bytes[i] = (byte) (bytes[i] ^ bytes[j]);
            i++;
            j--;
        }
        return new String(bytes);
    }

    public String reverseString(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
    public static void main(String []args){
        String s = "Let's take LeetCode contest";
        ReverseWord reverseWord = new ReverseWord();
        System.out.println(reverseWord.reverseWords(s));
        System.out.println(reverseWord.reverseString(s));
    }
}
