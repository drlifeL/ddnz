package xyz.flyly.leetcode._2022._09._09;

import xyz.flyly.leetcode.utils.AnswerPrinter;

/**
 * https://leetcode.cn/problems/running-sum-of-1d-array/?envType=study-plan&id=leetcode_75_level_1
 *
 * @author : luoyang
 * @since : 2022/9/9 10:23
 **/
public class P_1480_一维数组的动态和 {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 4};

		int[] result = new P_1480_一维数组的动态和().runningSum(nums);

		AnswerPrinter.printIntTypeArray(result);
	}


	public int[] runningSum(int[] nums) {
		int[] ans = new int[nums.length];
		ans[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			ans[i] = nums[i] + ans[i - 1];
		}
		return ans;
	}


}
