package xyz.flyly.leetcode.utils;

/**
 *  x 序 主要是针对何时遍历根节点界定的
 *  例如：
 *        1
 *      2   3
 *  先序：  1 2 3
 *  中序：  2 1 3
 *  后续：  2 3 1
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
