public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        int count=0;
        for(int i=0;i<S.length();i++){
            String item=Character.toString(S.charAt(i));
            if(J.contains(item)){
                count++;
            }
        }
        return count;
    }
}
