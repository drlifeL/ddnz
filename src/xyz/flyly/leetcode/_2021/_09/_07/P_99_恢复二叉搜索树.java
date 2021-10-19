package xyz.flyly.leetcode._2021._09._07;

import xyz.flyly.leetcode.utils.TreeNode;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class P_99_恢复二叉搜索树 {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树，使用中序遍历就是有序序列
     * 思路：
     * 先中序遍历二叉搜索树，而后寻找到不同的节点，将其值进行交换
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        midOrder(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void midOrder(TreeNode root) {
        if (root == null) return;
        midOrder(root.left);
        if (firstNode == null && preNode.val > root.val) firstNode = preNode;
        if (firstNode != null && preNode.val > root.val) secondNode = root;
        preNode = root;
        midOrder(root.right);
    }

}
