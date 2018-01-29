//https://leetcode.com/problems/minesweeper/description/
//
//'M' represents an unrevealed mine,  M代表还没揭露的雷
//'E' represents an unrevealed empty square,  E代表还没显示的空格
//'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines,
//B代表一个显露的空白方格，它没有相邻的（上面，下面，左边，右边和所有4对角线）地雷，
//X代表踩到雷了

//If a mine ('M') is revealed, then the game is over - change it to 'X'.
//If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
//If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
//Return the board when no more squares will be revealed.

public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') board[x][y] = 'X';
        else if (countmines(board, x, y) > 0) board[x][y] = (char) (countmines(board, x, y) + '0');
        else update(board, x, y);
        return board;
    }

    private void update(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == 'E') {
            if (countmines(board, i, j) == 0) {
                board[i][j] = 'B';
                update(board, i, j - 1);
                update(board, i - 1, j);
                update(board, i, j + 1);
                update(board, i + 1, j);
                update(board, i - 1, j - 1);
                update(board, i + 1, j + 1);
                update(board, i + 1, j - 1);
                update(board, i - 1, j + 1);
            } else {
                board[i][j] = (char) (countmines(board, i, j) + '0');
            }
        }
    }

    private int countmines(char[][] board, int i, int j) { // just count mines in the neighborhood.
        int count = 0;
        if (i - 1 >= 0 && board[i - 1][j] == 'M') count++;
        if (i + 1 < board.length && board[i + 1][j] == 'M') count++;
        if (j - 1 >= 0 && board[i][j - 1] == 'M') count++;
        if (j + 1 < board[0].length && board[i][j + 1] == 'M') count++;
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 'M') count++;
        if (i + 1 < board.length && j + 1 < board[0].length && board[i + 1][j + 1] == 'M') count++;
        if (i - 1 >= 0 && j + 1 < board[0].length && board[i - 1][j + 1] == 'M') count++;
        if (i + 1 < board.length && j - 1 >= 0 && board[i + 1][j - 1] == 'M') count++;
        return count;
    }

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        Minesweeper minesweeper = new Minesweeper();
        minesweeper.updateBoard(board, click);

    }
}
