package xyz.flyly.leetcode._2021._09._20;

/**
 * https://leetcode-cn.com/problems/2-keys-keyboard/
 */
public class P650_只有两个键的键盘 {
    int min = Integer.MAX_VALUE;
    int INF = 1000;

    public static void main(String[] args) {
        System.out.println(new P650_只有两个键的键盘().minSteps(765));
    }

    public int minSteps(int n) {
        return dfs(n, 1, 0);
    }

    private int dfs(int n, int curr, int clipboard) {
        if (curr > n) {
            return 1001;
        }
        if (curr == n) {
            return 0;
        }
        int ans = 1001;
        if (clipboard > 0) {
            ans = Math.min(ans, dfs(n, curr + clipboard, clipboard));
        }
        if (curr != clipboard) {
            ans = Math.min(ans, dfs(n, curr, curr));
        }

        return ans + 1;
    }


}
