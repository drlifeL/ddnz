package xyz.flyly.leetcode._2021._09._04;

import xyz.flyly.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层平均值
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class P_637 {
    public static void main(String[] args) {

    }

    /**
     * 求取每一层的平均值，算出每一层的和，然后除以该层的节点数量
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            double x = 0;
            double y = q.size();
            int y1 = q.size();
            while (y1 > 0) {
                TreeNode c = q.remove();
                x += c.val;
                if (c.left != null) {
                    q.add(c.left);
                }
                if (c.right != null) {
                    q.add(c.right);
                }
                y1--;
            }
            ans.add(x / y);
        }

        return ans;
    }
}
