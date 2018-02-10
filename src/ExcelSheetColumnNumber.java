//https://leetcode.com/problems/excel-sheet-column-number/description/

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        for(int i = 0 ; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        int a = excelSheetColumnNumber.titleToNumber("A");
        System.out.println(a);
    }
}
