package xyz.flyly.leetcode._2021._08._30;

import xyz.flyly.leetcode.utils.TreeNode;

import java.util.Arrays;

/**
 * 从前序和中序构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
 */
public class P_105 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode treeNode = new P_105().buildTree(preorder, inorder);

    }

    /**
     * 思路:
     * 1.首先看前序数组，找到根节点
     * 2.然后在中序数组中,查找根节点的位置
     * 3.以根节点的位置为界，划分出新的前序和中序数组
     * 4.递归的寻找的左右节点
     *
     * @param preorder 前序序列
     * @param inorder  中序序列
     * @return 根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length == 0) return null;
        // 先序的第一个必然是根节点
        TreeNode root = new TreeNode(preorder[0]);
        // 分别求左右节点
        int i = 0;
        while (i < inorder.length && inorder[i] != root.val) {
            i++;
        }
        int[] newPreorder = Arrays.copyOfRange(preorder, 1, i + 1);
        int[] newInorder = Arrays.copyOfRange(inorder, 0, i);
        root.left = buildTree(newPreorder, newInorder);

        newPreorder = Arrays.copyOfRange(preorder, i + 1, preorder.length);
        newInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        root.right = buildTree(newPreorder, newInorder);


        return root;
    }
}
