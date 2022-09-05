package xyz.flyly.leetcode.utils;

import java.util.Arrays;

/**
 * @author : luoyang
 * @since : 2022/9/2 12:25
 **/
public class AnswerPrinter {

	public static void printIntTypeArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 打印二维数组
	 *
	 * @param arr
	 */
	public static void print2dMatrix(int[][] arr) {
		for (int[] ints : arr) {
			System.out.println(Arrays.toString(ints));
		}
	}

}
