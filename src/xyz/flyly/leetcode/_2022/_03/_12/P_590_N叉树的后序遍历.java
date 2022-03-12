package xyz.flyly.leetcode._2022._03._12;

import java.util.ArrayList;
import java.util.List;

public class P_590_N叉树的后序遍历 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public static void main(String[] args) {


    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        func(root, res);
        return res;
    }

    private void func(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            List<Node> children = root.children;
            for (int i = 0; i < children.size(); i++) {
                func(children.get(i), res);
            }
        }
        res.add(root.val);
    }
}
