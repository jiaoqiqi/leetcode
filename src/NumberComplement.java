//https://leetcode.com/problems/number-complement/description/

import javax.lang.model.element.NestingKind;

public class NumberComplement {
    public int findComplement(int num) {
        String a = Integer.toBinaryString(num);
        String[] arrayA = a.split("");
        int[] arrayANumber = new int[a.length()];
        for (int i = 0; i < arrayA.length; i++) {
            arrayANumber[i] = Integer.valueOf(arrayA[i]) ^ 1;
        }

        String resultSting = "";
        for (int i = 0; i < arrayANumber.length; i++) {
            resultSting += arrayANumber[i];

        }
        int result = Integer.valueOf(resultSting, 2);
        return result;
    }

    public static void main(String[] args) {
        int num = 1;
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(numberComplement.findComplement(num));
    }
}
