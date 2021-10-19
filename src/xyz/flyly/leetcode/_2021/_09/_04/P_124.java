package xyz.flyly.leetcode._2021._09._04;

import xyz.flyly.leetcode.utils.TreeNode;

/**
 * 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class P_124 {
    int ans;

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(-10);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(-3);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-1);

        System.out.println(new P_124().maxPathSum(root));


    }

    public int maxPathSum(TreeNode root) {
        ans = root.val;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        // 以贡献度来进行计算，如果左边
        int L = Math.max(dfs(root.left), 0);
        int R = Math.max(dfs(root.right), 0);

        ans = Math.max(L + R + root.val, ans);

        return Math.max(L, R) + root.val;
    }
}
