//https://leetcode.com/problems/keyboard-row/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow {
    public String[] findWords(String[] words) {

        String[] one = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
        String[] two = {"a", "s", "d", "f", "g", "h", "j", "k", "l"};
        String[] three = {"z", "x", "c", "v", "b", "n", "m"};
        String[] result = new String[words.length];
        String[] nullwords =new String[0];

        for (int i = 0; i < words.length; i++) {
            int flag = 0;
            String word = words[i];
            String item = word.toLowerCase();

            String[] itemArray = item.split("");


            if (useList(one, itemArray[0])) {
                for (int j = 1; j < itemArray.length; j++) {
                    if (!(useList(one, itemArray[j]))) {
                        {
                            flag = 1;
                            break;
                        }
                    }
                }
            } else if (useList(two, itemArray[0])) {
                for (int j = 1; j < itemArray.length; j++) {
                    if (!(useList(two, itemArray[j]))) {
                        {
                            flag = 1;
                            break;
                        }
                    }
                }
            } else if ((useList(three, itemArray[0]))) {
                for (int j = 1; j < itemArray.length; j++) {
                    if (!(useList(three, itemArray[j]))) {
                        {
                            flag = 1;
                            break;
                        }
                    }
                }
            }

            if (flag != 1) {
                result[i] = word;
            }


        }

        int nullNum=0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == null){
                nullNum+=1;
            }

        }

        if (nullNum == words.length){
            return nullwords;
        }

        return testB(result);

    }

    public static boolean useList(String[] arr, String targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }


    public static String[] testB(String [] str) {
        List<String> list = new ArrayList<String>();
        for (int i=0; i<str.length; i++) {
            if (str[i]!=null){
                list.add(str[i]);
            }
        }
        String[] newStr =  list.toArray(new String[1]);
        return newStr;
    }


    public static void main(String[] args) {

//        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
//        String[] words = {"rfv","edc"};
        String [] words = {""};
//        String[] words = {"asdfghjklASDFGHJKLasdfghjklASDFGHJKLzxcvbnmZXCVBNMaew",
//                "asdfghjklASDFGHJKLqwertyuiopQWERTYUIOP",
//                "zxcvbnmZXCVBNMaewzxcvbnmZXCVBNMaewzxcvbnmZXCVBNMaewzxcvbnmZXCVBNMaew"};

        KeyboardRow find = new KeyboardRow();

        String[] result = find.findWords(words);
        for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);

        }
    }

}
