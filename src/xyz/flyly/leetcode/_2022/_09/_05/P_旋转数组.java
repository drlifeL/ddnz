package xyz.flyly.leetcode._2022._09._05;

import xyz.flyly.leetcode.utils.AnswerPrinter;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2skh7/
 *
 * @author : luoyang
 * @since : 2022/9/5 13:40
 **/
public class P_旋转数组 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		int k = 3;

//		int[] nums = {-1, -100, 3, 99};
//		int k = 2;

		new P_旋转数组().rotate(nums, k);
		AnswerPrinter.printIntTypeArray(nums);
	}

	public void rotate(int[] nums, int k) {
		int len = nums.length;
		int sIdx = k % len;
		int[] ans = new int[len];
		for (int i = 0; i < len; i++) {
			ans[(sIdx + i) % len] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = ans[i];
		}
	}

}
