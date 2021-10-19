package xyz.flyly.leetcode._2021._09._07;

/**
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class P_331_验证二叉树的前序序列化 {
    public static void main(String[] args) {
        String in = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String error = "9,#,92,#,#";
        System.out.println(new P_331_验证二叉树的前序序列化().isValidSerialization(error));
    }


    /**
     * 运用的思想是
     * 默认的槽为1
     * 如果当前是一个空节点，则消耗一个槽
     * 如果当前是非空节点，则消耗一个槽的同时还要补上两个槽，（两个子节点）
     * 期间，如果没遍历完就出现了槽 == 0 ，则该树不是一颗合法的树
     *
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        int slot = 1;
        int i = 0;
        while (i < preorder.length()) {
            if (slot == 0) return false;
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                i++;
                slot--;
            } else {
                while (i < preorder.length() && preorder.charAt(i) != ',') {
                    i++;
                }
                slot++;
            }
        }
        return slot == 0;

    }
}
