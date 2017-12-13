//https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

public class SmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        char result = letters[0];
        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            if (letter > target) {
                result = letter;
                break;
            }

        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        SmallestLetterGreaterThanTarget smallestLetterGreaterThanTarget = new SmallestLetterGreaterThanTarget();
        char[] leters = {'c', 'f', 'j'};
        char target = 'z';
        smallestLetterGreaterThanTarget.nextGreatestLetter(leters,target);

    }
}


