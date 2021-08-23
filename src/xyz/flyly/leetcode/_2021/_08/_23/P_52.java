package xyz.flyly.leetcode._2021._08._23;

/**
 * N皇后 II
 * https://leetcode-cn.com/problems/n-queens-ii/
 */
public class P_52 {
    int res;

    public static void main(String[] args) {
        System.out.println(new P_52().totalNQueens(9));
    }

    public int totalNQueens(int n) {
        boolean[][] arr = new boolean[n][n];
        backtracking(0, n, arr);
        return res;
    }

    public void backtracking(int i, int n, boolean[][] arr) {
        if (n == 0) {
            res++;
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (canFill(i, j, arr)) {
                arr[i][j] = true;
                backtracking(i + 1, n - 1, arr);
                arr[i][j] = false;
            }
        }
    }

    private boolean canFill(int i, int j, boolean[][] arr) {
        // 检查同一列
        for (int k = 0; k < arr.length; k++) {
            if (arr[k][j]) return false;
        }
        // 左上 -> 右下 初始化 ->  j = 0  i++, j++

        // 右上 -> 左下 初始化 ->  i = 0

        // 左上
        int t = i;
        int k = j;
        while (t >= 0 && k >= 0) {
            if (arr[t][k]) return false;
            t--;
            k--;
        }
        t = i;
        k = j;
        while (t < arr.length && k < arr.length) {
            if (arr[t][k]) return false;
            t++;
            k++;
        }

        // 右上
        t = i;
        k = j;
        while (t >= 0 && k < arr.length) {
            if (arr[t][k]) return false;
            t--;
            k++;
        }

        t = i;
        k = j;
        while (t < arr.length && k >= 0) {
            if (arr[t][k]) return false;
            t++;
            k--;
        }
        return true;
    }
}
