package xyz.flyly.leetcode._2022._09._09;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-pivot-index/?plan=leetcode_75&plan_progress=z6f7mw5
 *
 * @author : luoyang
 * @since : 2022/9/9 10:28
 **/
public class P_724_寻找数组的中心下标 {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 7, 3, 6, 5, 6};

		int index = new P_724_寻找数组的中心下标().pivotIndex(nums);

		System.out.println(index);

	}

	public int pivotIndex(int[] nums) {
		int total = Arrays.stream(nums).sum();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (2 * sum + nums[i] == total) {
				return i;
			}
			sum += nums[i];

		}
		return -1;
	}
}
