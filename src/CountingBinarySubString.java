public class CountingBinarySubString {
    public int countBinarySubstrings(String s) {
        int prevRunLength = 0, curRunLength = 1, res = 0;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i) == s.charAt(i-1)) curRunLength++;
            else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength) res++;
        }
        return res;
    }


    public static void main(String[] args) {
        CountingBinarySubString countingBinarySubString = new CountingBinarySubString();
        String s = "00110011";
        System.out.println(countingBinarySubString.countBinarySubstrings(s));
    }
}
