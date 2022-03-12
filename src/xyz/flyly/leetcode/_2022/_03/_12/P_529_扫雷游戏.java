package xyz.flyly.leetcode._2022._03._12;


public class P_529_扫雷游戏 {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        char[][] board = new char[m][n];
        int[] click = new int[]{3, 0};
        board[0] = new char[]{'E', 'E', 'E', 'E', 'E'};
        board[1] = new char[]{'E', 'E', 'M', 'E', 'E'};
        board[2] = new char[]{'E', 'E', 'E', 'E', 'E'};
        board[3] = new char[]{'E', 'E', 'E', 'E', 'E'};

        char[][] updateBoard = new P_529_扫雷游戏().updateBoard(board, click);
        for (int i = 0; i < updateBoard.length; i++) {
            System.out.println(updateBoard[i]);
        }

    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        char x = board[i][j];
        // 1
        if (x == 'M') {
            board[i][j] = 'X';
            return board;
        }
        resolve(board, i, j);
        return board;
    }


    public static int[] idx_i = {1, -1, -1, -1, 0, 0, 1, 1};
    public static int[] idx_j = {0, 0, -1, 1, -1, 1, -1, 1};

    private void resolve(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'E') {
            return;
        }
        char n = '0';
        for (int k = 0; k < idx_i.length; k++) {
            int i1 = i + idx_i[k];
            int j1 = j + idx_j[k];
            if (i1 < 0 || j1 < 0 || i1 >= board.length || j1 >= board[0].length) {
                continue;
            }
            if (board[i1][j1] == 'M') {
                n++;
            }
        }
        if (n > '0') {
            board[i][j] = n;
        } else {
            board[i][j] = 'B';
            for (int k = 0; k < idx_i.length; k++) {
                int i1 = i + idx_i[k];
                int j1 = j + idx_j[k];
                resolve(board, i1, j1);
            }
        }
    }

}
