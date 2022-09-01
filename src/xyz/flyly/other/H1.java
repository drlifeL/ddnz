package xyz.flyly.other;


public class H1 {
    public static void main(String[] args) {

        create();
        getArcs(2);

    }

    // 不使用 0 号结点
    static VNode[] vNodes = {new VNode('n'), new VNode('a'), new VNode('b'), new VNode('c'), new VNode('d')};

    public static void create() {
        vNodes[1].firstArc = new EdgeNode(3);
        vNodes[1].firstArc.next = new EdgeNode(2);

        vNodes[3].firstArc = new EdgeNode(4);
        vNodes[4].firstArc = new EdgeNode(1);
    }

    public static void getArcs(int idx) {
        if (idx > vNodes.length || idx == 0) {
            System.out.println("结点编号有误!");
        }
        EdgeNode temp = vNodes[idx].firstArc;
        while (temp != null) {
            System.out.printf("< %s , %s >%n", idx, temp.vexIdx);
            temp = temp.next;
        }
    }


    static class VNode {
        char vexData;
        EdgeNode firstArc;

        public VNode(char vexData) {
            this.vexData = vexData;
        }
    }

    static class EdgeNode {
        int vexIdx;
        EdgeNode next;

        public EdgeNode(int vexIdx) {
            this.vexIdx = vexIdx;
        }
    }
}
