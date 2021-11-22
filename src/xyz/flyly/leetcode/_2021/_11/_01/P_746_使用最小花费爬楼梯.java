package xyz.flyly.leetcode._2021._11._01;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class P_746_使用最小花费爬楼梯 {


    public static void main(String[] args) {
//        int[] cost = new int[]{10, 15, 20};
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] cost = new int[50];
//        for (int i = 0; i < 50; i++) {
//            cost[i] = (int) (Math.random() * 100);
//        }
        P_746_使用最小花费爬楼梯 p = new P_746_使用最小花费爬楼梯();
        System.out.println(p.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        // dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    /*
    回溯法
        int ans;
    public int minCostClimbingStairs(int[] cost) {
        ans = Integer.MAX_VALUE;
        back_tracking(0, 0, cost);
        back_tracking(1, 0, cost);
        return ans;
    }

    private void back_tracking(int i, int sum, int[] cost) {
        if(sum > ans)return;
        if (i >= cost.length) {
            ans = Math.min(sum, ans);
            return;
        }
        sum += cost[i];
        if (i == cost.length - 1) {
            ans = Math.min(sum, ans);
            return;
        }
        back_tracking(i + 1, sum, cost);
        back_tracking(i + 2, sum, cost);
    }
     */
}
