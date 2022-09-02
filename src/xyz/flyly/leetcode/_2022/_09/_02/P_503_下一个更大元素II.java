package xyz.flyly.leetcode._2022._09._02;

import xyz.flyly.leetcode.utils.AnswerPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/next-greater-element-ii/
 *
 * @author : luoyang
 * @since : 2022/9/2 12:16
 **/
public class P_503_下一个更大元素II {
	public static void main(String[] args) {
//		int[] nums = {1, 2, 1};
		int[] nums = {1, 2, 3, 4, 3};

		int[] ans = new P_503_下一个更大元素II().nextGreaterElements(nums);

		AnswerPrinter.printIntTypeArray(ans);
	}


	public int[] nextGreaterElements(int[] nums) {
		int ans[] = new int[nums.length];
		Stack<Integer> s = new Stack<>();
		int max = nums[0];
		List<Integer> list = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!s.empty() && nums[i] >= s.peek()) {
				s.pop();
			}
			if (s.empty()) {
				ans[i] = -1;
				list.add(i);
			} else {
				ans[i] = s.peek();
			}
			s.push(nums[i]);
			max = Math.max(max, nums[i]);
		}
		for (Integer idx : list) {
			if (nums[idx] != max) {
				for (int i = 0; i < idx; i++) {
					if (nums[i] > nums[idx]) {
						ans[idx] = nums[i];
						break;
					}
				}
			}
		}
		return ans;
	}
}
