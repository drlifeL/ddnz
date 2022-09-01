package xyz.flyly.leetcode._2022._09._01;

import xyz.flyly.leetcode.utils.ListNode;

import java.util.LinkedList;
/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 *
 * @author : luoyang
 * @since : 2022/9/1 15:59
 **/
public class P_25_K个一组翻转链表 {
	public static void main(String[] args) {
		ListNode head = ListNode.createListNode(1, 5);
		int k = 3;

		ListNode result = new P_25_K个一组翻转链表().reverseKGroup(head, k);

		ListNode.printListNode(result);
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		LinkedList<ListNode> nodeList = new LinkedList<>();
		ListNode vNode = new ListNode(-1);
		ListNode tempNode = vNode;
		int i = 0;
		while (head != null) {
			nodeList.addLast(head);
			head = head.next;
			i++;
			if (i == k) {
				while (nodeList.size() != 0) {
					ListNode node = nodeList.removeLast();
					tempNode.next = node;
					node.next = null;
					tempNode = tempNode.next;
				}
				i = 0;
			}
		}
		if (nodeList.size() != 0) {
			tempNode.next = nodeList.removeFirst();
		}
		return vNode.next;
	}
}
