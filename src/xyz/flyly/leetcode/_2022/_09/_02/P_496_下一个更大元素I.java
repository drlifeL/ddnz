package xyz.flyly.leetcode._2022._09._02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 单调栈的作用：
 * 可以 O（1）的时间复杂度得知某个位置左右两侧比他大（或小）的数的位置，当你需要高效率获取某个位置左右两侧比他大（或小）的数的位置的时候就可以用到单调栈
 *
 * 求解数组中右边第一个比它小的元素的下标，从前往后，构造单调递增栈
 * 求解数组中右边第一个比它大的元素的下标，从前往后，构造单调递减栈
 *
 * 求解数组中左边第一个比它小的元素的下标，从后往前，构造单调递减栈
 * 求解数组中左边第一个比它大的元素的下标，从前往后，构建单调递增栈
 *
 * https://leetcode.cn/problems/next-greater-element-i/
 * @author : luoyang
 * @since : 2022/9/2 10:54
 **/
public class P_496_下一个更大元素I {
	public static void main(String[] args) {
//		int[] nums1 = {4, 1, 2};
//		int[] nums2 = {1, 3, 4, 2};

//		int[] nums1 = {2, 4};
//		int[] nums2 = {1, 2, 3, 4};

		int[] nums2 = {30,40,50,60};


//		int[] result = new P_496_下一个更大元素I().nextGreaterElement(nums1, nums2);

		int[] result = new P_496_下一个更大元素I().nextGreaterElement(nums2);

		System.out.println(Arrays.toString(result));
	}

	/**
	 * 单调栈模版
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		HashMap<Integer, Integer> map = new HashMap<>();
		Stack<Integer> s = new Stack<>();
		for (int i = nums2.length - 1; i >= 0; i--) {
			while (!s.empty() && s.peek() <= nums2[i]) {
				s.pop();
			}
			map.put(nums2[i], s.empty() ? -1 : s.peek());

			s.push(nums2[i]);
		}
		for (int i = 0; i < nums1.length; i++) {
			result[i] = map.get(nums1[i]);
		}
		return result;
	}


	public int[] nextGreaterElement(int[] nums) {
		int[] result = new int[nums.length];

		Stack<Integer> s = new Stack<>();

		for (int i = nums.length - 1; i >= 0; i--) {
			// 倒着往栈里放
			while (!s.empty() && s.peek() <= nums[i]) { // 判定个子高矮
				s.pop(); //  矮个出栈
			}
			result[i] = s.empty() ? -1 : s.peek();
			s.push(nums[i]); // 入栈，之后还需要判定
		}


		return result;

	}
}
