package xyz.flyly.leetcode.utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createListNode(int ...values){
        ListNode vNode = new ListNode();
        ListNode temp = vNode;
	    for (int value : values) {
			temp.next = new ListNode(value);
			temp = temp.next;
	    }
		return vNode.next;
    }

    public static ListNode createListNode(int min, int max) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i = min; i <= max; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head.next;
    }

    public static void printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        ListNode temp = head;
        while (temp != null) {
            sb.append(temp.val);
            sb.append(" , ");
            temp = temp.next;
        }
        sb.append("]");

        System.out.println(sb.toString());
    }

}
