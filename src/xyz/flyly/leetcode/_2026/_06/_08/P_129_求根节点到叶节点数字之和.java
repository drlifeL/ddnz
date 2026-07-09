package xyz.flyly.leetcode._2026._06._08;

import xyz.flyly.leetcode.utils.TreeNode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * @author luoyang
 * @since 2026/6/8
 */
public class P_129_求根节点到叶节点数字之和 {
    public static void main(String[] args) {
        int arr[] = new int[24];
        arr[0] = 2;
        arr[1] = 2;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println(Arrays.toString(arr));

    }


    /**
     * dfs 统计,节点 1 2 3
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int curVal = preSum * 10 + root.val;

        if (root.left != null || root.right != null) {
            return dfs(root.left, curVal) + dfs(root.right, curVal);
        }

        return curVal;
    }
}
