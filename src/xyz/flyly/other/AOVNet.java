package xyz.flyly.other;

import java.util.Stack;

public class AOVNet {


    public static void main(String[] args) {
        AOVNet net = new AOVNet();

        System.out.println(net.Sort());
    }



    TNode[] g; // g[0]不用

    public AOVNet() {
        TNode g0 = new TNode(Integer.MIN_VALUE, 0);

        TNode g1 = new TNode(0, 1);
        g1.link = new Node(4);
        g1.link.next = new Node(3);
        g1.link.next.next = new Node(2);

        TNode g2 = new TNode(2, 2);

        TNode g3 = new TNode(1, 3);
        g3.link = new Node(5);
        g3.link.next = new Node(2);

        TNode g4 = new TNode(2, 4);
        g4.link = new Node(5);

        TNode g5 = new TNode(3, 5);

        TNode g6 = new TNode(0, 6);
        g6.link = new Node(5);
        g6.link.next = new Node(4);

        g = new TNode[]{g0, g1, g2, g3, g4, g5, g6};
    }

    public String Sort() { // 以字符串形式返回逗号分隔的结点编号表示的拓扑排序

        Stack<TNode> stack = new Stack<>();

        // 遍历顶点，将所有入度为 0 的顶点入栈
        for (int i = 1; i < g.length; i++) {
            if (g[i].in == 0) {
                stack.push(g[i]);
            }
        }
        StringBuffer sb = new StringBuffer();
        // 栈非空
        while (!stack.empty()) {
            TNode node = stack.pop();
            // 得到邻接表
            Node temp = node.link;
            while (temp != null) {
                // 减入度
                if (--g[temp.vex].in == 0) {
                    // 入度为 0 入栈
                    stack.push(g[temp.vex]);
                }
                temp = temp.next;
            }
            sb.append(node.num);

            sb.append(",");
        }


        return sb.toString();
    }
}

class Node {
    public Node(int vex) {
        this.vex = vex;
    }

    int vex; // 顶点域
    Node next; // 连接域
}

class TNode {
    public TNode(int in, int num) {
        this.in = in;
        this.num = num;
    }

    int num; // 结点编号
    int in; // 入度域
    Node link; // 链域
}
