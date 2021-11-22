package xyz.flyly.leetcode._2021._11._01;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class P_62_不同路径 {
    public static void main(String[] args) {
        P_62_不同路径 p = new P_62_不同路径();
        System.out.println(p.uniquePaths(3, 7));

    }

    /*
    输入：m = 3, n = 7
    输出：28
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // dp[i][j] = dp[i - 1][j] + dp[i][j-1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
