package xyz.flyly.leetcode.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * x 序 主要是针对何时遍历根节点界定的
 * 例如：
 * 1
 * 2   3
 * 先序：  1 2 3
 * 中序：  2 1 3
 * 后续：  2 3 1
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	/**
	 * 1.层次遍历后，已经知道了二叉树的层级，由此我们限定
	 *
	 * @param root
	 */
	public static void printTreeNode(TreeNode root) {
		if (root == null) {
			System.out.println("Empty Tree!");
		}
		List<List<Integer>> result = new ArrayList<>();

		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		int curNodeNum = 1;
		int nextNodeNum = 0;
		while (!s.empty()) {
			List<Integer> ans = new ArrayList<>();
			while (curNodeNum != 0) {
				curNodeNum--;
				TreeNode node = s.remove(0);
				ans.add(node.val);
				if (node.left != null) {
					s.push(node.left);
					nextNodeNum++;
				}
				if (node.right != null) {
					s.push(node.right);
					nextNodeNum++;
				}
			}
			result.add(ans);
			curNodeNum = nextNodeNum;
			nextNodeNum = 0;
		}
		result.forEach(System.out::println);


		for (int i = 0; i < result.size(); i++) {
			StringBuilder sb = new StringBuilder();
			StringBuilder prefix = new StringBuilder();
			for (int j = 0; j < result.size() - i; j++) {
				prefix.append(MARK);
			}
			sb.append(prefix);
			for (int j = 0; j < result.get(i).size(); j++) {
				sb.append(result.get(i).get(j)).append(prefix);
			}
			System.out.println(sb);
		}

	}

	/**
	 * 默认的符号为两个空格
	 */
	private static final String MARK = "  ";

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(11);

		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(13);
		root.right.right.left = new TreeNode(14);
		root.right.right.right = new TreeNode(15);


		TreeNode.printTreeNode(root);
	}
}
