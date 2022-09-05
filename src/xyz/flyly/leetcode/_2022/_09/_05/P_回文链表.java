package xyz.flyly.leetcode._2022._09._05;

import xyz.flyly.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : luoyang
 * @since : 2022/9/5 16:05
 **/
public class P_回文链表 {
	public static void main(String[] args) {
		ListNode head = ListNode.createListNode(1, 2, 2, 1);

		boolean ans = new P_回文链表().isPalindrome(head);

		System.out.println(ans);
	}

	public boolean isPalindrome(ListNode head) {
		List<ListNode> list = new ArrayList<>();
		while (head != null) {
			list.add(head);
			head = head.next;
		}
		int i = 0;
		int j = list.size() - 1;
		while (i <= j) {
			if (list.get(i).val != list.get(j).val) {
				return false;
			}
			i++;
			j--;
		}


		return true;
	}
}
