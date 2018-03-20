import java.util.Arrays;
//全排列
public class Permutation {
    public static int total = 0;

    public static void swap(String[] str, int i, int j) {
        String temp = new String();
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void arrange(String[] str, int st, int len) {
        if (st == len - 1) {
            for (int i = 0; i < len; i++) {
                System.out.print(str[i] + "  ");
            }
            System.out.println();
            total++;
        } else {
            for (int i = st; i < len; i++) {
                swap(str, st, i);
                arrange(str, st + 1, len);
                swap(str, st, i);
            }
        }

    }

    public static void main(String[] args) {
        String str[] = {"a", "b", "c"};
        arrange(str, 0, str.length);
        System.out.println(total);
    }
}
