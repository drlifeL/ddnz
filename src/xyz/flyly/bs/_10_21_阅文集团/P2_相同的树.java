package xyz.flyly.bs._10_21_阅文集团;

import xyz.flyly.leetcode.utils.TreeNode;

public class P2_相同的树 {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // write code here
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
