package xyz.flyly.leetcode._2021._11._01;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class P_70_爬楼梯 {


    public static void main(String[] args) {
        P_70_爬楼梯 p = new P_70_爬楼梯();
        System.out.println(p.climbStairs(5));
    }


    // p[i] = p[i-1] + p[i-2];
    public int climbStairs(int n) {
        if (n <= 2) return n;
        // 滚动数组
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];

    }
}
