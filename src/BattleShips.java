//https://leetcode.com/problems/battleships-in-a-board/description/

public class BattleShips {
    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return 0;
        }
        int n=board[0].length;

        int count=0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                count++;
            }
        }

        return count;
    }

    public static void main(String []args){
        char[][] board ={{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
//        for (int i = 0; i < board.length; i++) {
//            char[] chars = board[i];
//            for (int j = 0; j < chars.length; j++) {
//                System.out.println(chars[j]);
//            }
//        }     itar
        BattleShips battleShips = new BattleShips();
        System.out.println(battleShips.countBattleships(board));
    }
}
