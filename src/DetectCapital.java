public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        String wordUp = word.toUpperCase();
        String wordDown = word.toLowerCase();
        String[] splitWord = word.split("");
        if (word.equals(wordUp) || word.equals(wordDown)) {
            return true;
        } else if (splitWord.length > 1) {
            if (splitWord[0].equals(splitWord[0].toUpperCase())) {
                String res = word.substring(1, word.length());
                System.out.println(res);
                if (res.equals(res.toLowerCase())) {
                    return true;
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        DetectCapital detectCapital = new DetectCapital();
        System.out.println(detectCapital.detectCapitalUse("Flag"));
    }
}
