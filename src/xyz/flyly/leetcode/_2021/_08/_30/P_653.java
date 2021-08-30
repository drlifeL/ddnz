package xyz.flyly.leetcode._2021._08._30;

import xyz.flyly.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P_653 {
    public static void main(String[] args) {


    }

    public boolean useHash(TreeNode root, int k, HashSet<Integer> container) {
        if (root == null) return false;
        if (container.contains(k - root.val)) return true;
        container.add(root.val);
        return useHash(root.left, k, container) || useHash(root.right, k, container);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int i = 0;
        int j = res.size() - 1;
        while (i != j) {
            int t = res.get(i) + res.get(j);
            if (t == k) {
                return true;
            } else if (t > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
