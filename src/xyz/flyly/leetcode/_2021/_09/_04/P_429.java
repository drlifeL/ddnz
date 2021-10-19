package xyz.flyly.leetcode._2021._09._04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_429 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            int x = q.size();
            List<Integer> res = new ArrayList<>();
            while (x > 0) {
                Node node = q.remove();
                res.add(node.val);
                if (node.children != null) {
                    q.addAll(node.children);
                }
                x--;
            }
            ans.add(res);
        }
        return ans;
    }


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

}
