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
    public static void main(String []args){
        String s = "Let's take LeetCode contest";
        ReverseWord reverseWord = new ReverseWord();
        System.out.println(reverseWord.reverseWords(s));
    }
}
