package xyz.flyly.leetcode._2021._11._01;

public class P_63_不同路径2 {
    public static void main(String[] args) {
        P_63_不同路径2 p = new P_63_不同路径2();
//        int[][] arr = new int[3][3];
//        arr[0] = new int[]{0, 0, 0};
//        arr[1] = new int[]{0, 1, 0};
//        arr[2] = new int[]{0, 0, 0};

        int[][] arr = new int[1][2];
        arr[0] = new int[]{1, 0};
        System.out.println(p.uniquePathsWithObstacles(arr));

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
