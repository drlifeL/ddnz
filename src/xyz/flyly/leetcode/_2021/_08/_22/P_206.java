package xyz.flyly.leetcode._2021._08._22;


import xyz.flyly.leetcode.utils.ListNode;

/**
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class P_206 {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(1, 10);
        ListNode res = reverseList(head);
        ListNode.printListNode(res);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode res = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return res;
    }
}
