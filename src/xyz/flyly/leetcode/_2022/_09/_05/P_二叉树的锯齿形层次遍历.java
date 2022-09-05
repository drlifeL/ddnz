package xyz.flyly.leetcode._2022._09._05;

import xyz.flyly.leetcode.utils.ListNode;
import xyz.flyly.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author : luoyang
 * @since : 2022/9/5 17:22
 **/
public class P_二叉树的锯齿形层次遍历 {
	public static void main(String[] args) {
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(9);
//		root.right = new TreeNode(20);
//		root.right.left = new TreeNode(15);
//		root.right.right = new TreeNode(7);
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		List<List<Integer>> ans = new P_二叉树的锯齿形层次遍历().zigzagLevelOrder(root);

		ans.forEach(System.out::println);
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) return ans;
		int curNodeNum = 1;
		int nextNodeNum = 0;
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		boolean f = false;
		while (!s.isEmpty()) {
			List<Integer> nodes = new LinkedList<>();
			while (curNodeNum != 0) {
				TreeNode node = s.remove(0);
				if (node.left != null) {
					nextNodeNum++;
					s.push(node.left);
				}
				if (node.right != null) {
					nextNodeNum++;
					s.push(node.right);
				}
				curNodeNum--;
				if (!f) {
					nodes.add(node.val);
				} else {
					nodes.add(0, node.val);
				}
			}
			curNodeNum = nextNodeNum;
			nextNodeNum = 0;
			ans.add(nodes);
			f = !f;
		}
		return ans;
	}
}
