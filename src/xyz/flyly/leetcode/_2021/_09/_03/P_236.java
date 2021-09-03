package xyz.flyly.leetcode._2021._09._03;

import xyz.flyly.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class P_236 {
    public static void main(String[] args) {

    }


    /**
     * 解法：
     * 先记录每一个节点的父节点
     * 然后将 p 节点进行回退，并将其存入到 Hash 表中
     * 最后在回退 q 节点，如果当前节点在 Hash 表中已经回退，那么该节点就是最近的公共祖先，返回该节点即可
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);
        Set<Integer> set = new HashSet<>();
        while (p != null) {
            set.add(p.val);
            p = parentMap.get(p);
        }
        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q);
        }

        return null;
    }

    public void buildParentMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) {
            return;
        }
        parentMap.put(root, parent);
        buildParentMap(root.left, root, parentMap);
        buildParentMap(root.right, root, parentMap);
    }

}
