//https://leetcode.com/problems/sliding-puzzle/description/
//A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
//只能用0和周围四个交换

import java.util.*;

public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        Set<String> seen = new HashSet<>(); // used to avoid duplicates
        String target = "123450";
        // convert board to string - initial state.
        String s = Arrays.deepToString(board).replaceAll("\\[|\\]|,|\\s", "");
        Queue<String> q = new LinkedList<>(Arrays.asList(s));
//        System.out.println(q);
        seen.add(s);
        int ans = 0; // record the # of rounds of Breadth Search
        while (!q.isEmpty()) { // Not traverse all states yet?
            // loop used to control search breadth.
            for (int sz = q.size(); sz > 0; --sz) {
                String str = q.poll();
                if (str.equals(target)) {
                    return ans;
                } // found target.
                int i = str.indexOf('0'); // locate '0'
                int[] d = {1, -1, 3, -3}; // potential swap distances.
                for (int k = 0; k < 4; ++k) { // traverse all options.
                    int j = i + d[k]; // potential swap index.
                    // conditional used to avoid invalid swaps.
                    if (j < 0 || j > 5 || i == 2 && j == 3 || i == 3 && j == 2) {
                        continue;
                    }
                    char[] ch = str.toCharArray();
                    // swap ch[i] and ch[j].
                    char tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                    s = String.valueOf(ch); // a new candidate state.
                    if (seen.add(s)) {
                        q.offer(s);
                    } //Avoid duplicate.
                }
            }
            ++ans; // finished a round of Breadth Search, plus 1.
        }
        return -1;

    }


    public void swap(int a, int b) {
        int c = a + b;
        a = c - a;
        b = c - a;
    }

    public static void main(String[] args) {
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        int[][] board = {{1, 2, 3}, {4, 0, 5}};
        slidingPuzzle.slidingPuzzle(board);
    }
}
