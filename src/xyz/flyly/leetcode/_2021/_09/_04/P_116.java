package xyz.flyly.leetcode._2021._09._04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class P_116 {
    public static void main(String[] args) {

    }

    /**
     * 最后一个右侧的指针没有 next , 在判断的时候，x > 1 即可。但是最后要主要将最后一个节点的 left and right 加入到队列中
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            int x = q.size();
            while (x > 1) {
                Node node = q.remove();
                node.next = q.peek();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                x--;
            }
            Node node = q.remove();
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
