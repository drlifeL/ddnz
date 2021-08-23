package xyz.flyly.leetcode._2021._08._23;

/**
 * 火柴拼正方形
 * https://leetcode-cn.com/problems/matchsticks-to-square/
 */
public class P_473 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 2, 2, 6};
        System.out.println(new P_473().makesquare(arr));
    }

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }
        if (sum == 0 || sum % 4 != 0) return false;
        int m = sum / 4;

        return dfs(0, m, matchsticks, new int[4]);
    }

    public boolean dfs(int sIdx, int target, int[] arr, int[] size) {
        if (sIdx == arr.length) {
            return true;
        }

        for (int i = 0; i < size.length; i++) {

            if (size[i] + arr[sIdx] > target) continue;

            size[i] += arr[sIdx];
            // 在继续放
            if (dfs(sIdx + 1, target, arr, size)) {
                return true;
            }
            size[i] -= arr[sIdx];
        }
        return false;
    }
}
