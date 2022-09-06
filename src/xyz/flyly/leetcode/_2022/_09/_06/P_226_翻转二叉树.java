package xyz.flyly.leetcode._2022._09._06;

import xyz.flyly.leetcode.utils.TreeNode;

/**
 * https://leetcode.cn/problems/invert-binary-tree/?favorite=2cktkvj
 *
 * @author : luoyang
 * @since : 2022/9/6 10:36
 **/
public class P_226_翻转二叉树 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);

		TreeNode ans = new P_226_翻转二叉树().invertTree(root);

		System.out.println(ans);

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
