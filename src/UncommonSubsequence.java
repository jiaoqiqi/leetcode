public class UncommonSubsequence {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());

    }

    public static void main(String[] args) {
        UncommonSubsequence uncommonSubsequence = new UncommonSubsequence();
        String a = "aba";
        String b = "cdc";
        System.out.println(uncommonSubsequence.findLUSlength(a,b));
    }
}
