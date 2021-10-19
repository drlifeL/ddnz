package xyz.flyly.leetcode._2021._09._29;

public class P_79_单词搜索 {
    boolean find = false;

    public static void main(String[] args) {
//        char[][] arr = {{'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};
        char[][] arr = {{'A'}};
        String word = "A";
        System.out.println(new P_79_单词搜索().exist(arr, word));

    }

    public boolean exist(char[][] board, String word) {

        char[] arr = word.toCharArray();
        boolean[][] path = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == arr[0]) { // 首字符相同，继续搜索
                    dfs(board, arr, path, i, j, 0);
                    if (find) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void dfs(char[][] board, char[] arr, boolean[][] path, int i, int j, int idx) {
        if (find) return;
        if (idx == arr.length) {
            find = true;
            return;
        }
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || path[i][j]) return;

        if (board[i][j] == arr[idx]) {
            path[i][j] = true;
            // 相同元素
            dfs(board, arr, path, i + 1, j, idx + 1);
            dfs(board, arr, path, i - 1, j, idx + 1);
            dfs(board, arr, path, i, j + 1, idx + 1);
            dfs(board, arr, path, i, j - 1, idx + 1);
            path[i][j] = false;
        }
    }
}
