package xyz.flyly.leetcode._2022._09._12;

import xyz.flyly.leetcode.utils.TreeNode;

/**
 * https://leetcode.cn/problems/sum-of-left-leaves/
 *
 * @author : luoyang
 * @since : 2022/9/12 18:15
 **/
public class P_404_左叶子之和 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		int result = new P_404_左叶子之和().sumOfLeftLeaves(root);

		System.out.println(result);
	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int res = 0;
		if (root.left != null && root.left.left == null && root.left.right == null) {
			res += root.left.val;
		}
		return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + res;
	}

}
