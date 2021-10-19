package xyz.flyly.leetcode._2021._09._04;

import xyz.flyly.leetcode.utils.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 二叉树的直径
 */
public class P_543 {
    int ans;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);

        System.out.println(new P_543().diameterOfBinaryTree(root));


    }

    /**
     * 由题意可知，二叉树的最大直径定义是 任意两个节点路径长度最大值，路径长度 = 节点的数量 - 1 ，其实就是边的数量
     * 解法如下：
     * 递归的计算左右节点 + 根节点 同 ans 比较最大值
     * 然后返回当前左右节点的最大值 + 根节点的边
     * 最后 return ans - 1 即为最大直径
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);
        return ans - 1;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = dfs(root.left);
        int R = dfs(root.right);
        ans = Math.max((L + R + 1), ans);
        return Math.max(L, R) + 1;
    }

}
