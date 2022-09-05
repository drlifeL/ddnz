package xyz.flyly.leetcode._2022._09._05;

import xyz.flyly.leetcode.utils.AnswerPrinter;

import java.util.*;

/**
 * @author : luoyang
 * @since : 2022/9/5 14:06
 **/
public class P_两个数组的交集II {
	public static void main(String[] args) {
//		int[] nums1 = {1, 2, 2, 1};
//		int[] nums2 = {2, 2};

		int[] nums1 = {4, 9, 5};
		int[] nums2 = {9, 4, 9, 8, 4};

		int[] ans = new P_两个数组的交集II().intersect(nums1, nums2);

		AnswerPrinter.printIntTypeArray(ans);

	}

	public int[] intersect(int[] nums1, int[] nums2) {
		return f2(nums1, nums2);
	}

	private int[] f2(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums1) {
			Integer v = map.getOrDefault(num, 0);
			map.put(num, ++v);
		}

		int[] ans = new int[Math.min(nums1.length, nums2.length)];
		int idx = 0;
		for (int num : nums2) {
			Integer v = map.getOrDefault(num, 0);
			if (v != 0) {
				ans[idx++] = num;
				map.put(num, --v);
			}
		}

		return Arrays.copyOfRange(ans, 0, idx);
	}


	/**
	 * 思路：
	 * 先对数组1和数组2进行排序，然后逐步开始做比较，如果该结果在数组 1 存在也在数组 2 存在，那么就将其加入到结果集中
	 * 最后在对结果集进行裁剪即可
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	private int[] f1(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int[] ans = new int[Math.min(nums1.length, nums2.length)];

		int idx = 0;
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] > nums2[j]) {
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				ans[idx++] = nums1[i];
				i++;
				j++;
			}
		}
		return Arrays.copyOfRange(ans, 0, idx);
	}
}
