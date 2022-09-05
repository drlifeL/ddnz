package xyz.flyly.leetcode._2022._09._02;

import xyz.flyly.leetcode.utils.AnswerPrinter;
import xyz.flyly.leetcode.utils.ListNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/next-greater-node-in-linked-list/
 *
 * @author : luoyang
 * @since : 2022/9/2 17:17
 **/
public class P_1019_链表中的下一个更大节点 {

	public static void main(String[] args) {

//		ListNode head = ListNode.createListNode(2, 1, 5);
		ListNode head = ListNode.createListNode(2, 7, 4, 3, 5);

		int[] res = new P_1019_链表中的下一个更大节点().nextLargerNodes(head);

		AnswerPrinter.printIntTypeArray(res);
	}


	public int[] nextLargerNodes(ListNode head) {
		Stack<ListNode> nodes = new Stack<>();
		while (head != null) {
			nodes.push(head);
			head = head.next;
		}
		int idx = nodes.size() - 1;
		int[] res = new int[nodes.size()];
		Stack<Integer> s = new Stack<>();
		while (!nodes.empty()) {
			Integer val = nodes.pop().val;
			while (!s.empty() && s.peek() <= val) {
				s.pop();
			}
			res[idx--] = s.empty() ? 0 : s.peek();

			s.push(val);
		}
		return res;
	}
}
