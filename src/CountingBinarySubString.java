public class CountingBinarySubString {
//    public int countBinarySubstrings(String s) {
//        int prevRunLength = 0, curRunLength = 1, res = 0;
//        for (int i=1;i<s.length();i++) {
//            if (s.charAt(i) == s.charAt(i-1)) curRunLength++;
//            else {
//                prevRunLength = curRunLength;
//                curRunLength = 1;
//            }
//            if (prevRunLength >= curRunLength) res++;
//        }
//        return res;
//    }

    public int countBinarySubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j += 2) {
                String sub = s.substring(i, j+1);
//                System.out.println(sub);
                int len = sub.length();
                String one = sub.substring(0, len / 2);
                String two = sub.substring(len / 2, len);
                if (countEqual(sub) && isBinary(one) && isBinary(two)) {
                    count++;
                }
            }
        }

//        System.out.println(count);
        return count;


    }

    public boolean countEqual(String s) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else if (s.charAt(i) == '1') {
                count1++;
            }
        }
        return (count0 == count1) ? true : false;
    }

    public boolean isBinary(String s) {
        boolean flag = true;
        String onepart = String.valueOf(s.charAt(0));
        if (onepart.equals("0")) {
            if (s.contains("1")) {
                flag = false;
            }
        } else if (onepart.equals("1")) {
            if (s.contains("0")) {
                flag = false;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        CountingBinarySubString countingBinarySubString = new CountingBinarySubString();
        String s = "00110011";
//        countingBinarySubString.isBinary(s);
//        System.out.println(countingBinarySubString.isBinary("00"));
        countingBinarySubString.countBinarySubstrings(s);
    }
}
