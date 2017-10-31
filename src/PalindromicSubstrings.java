//https://leetcode.com/problems/palindromic-substrings/description/  回文数


public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindromic(sub)) {
                    count++;
                }

            }
        }
        return count;

    }

    public boolean isPalindromic(String a) {
        String reversed = new StringBuffer(a).reverse().toString();
        if (a.equals(reversed)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String a = "aaa";
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings(a));
    }

}
