package xyz.flyly.leetcode._2022._09._02;

import xyz.flyly.leetcode.utils.AnswerPrinter;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/daily-temperatures/
 *
 * @author : luoyang
 * @since : 2022/9/1 17:22
 **/
public class P_739_每日温度 {
	public static void main(String[] args) {

		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
//		int[] temperatures = {30,40,50,60};
//		int[] temperatures = {30, 60, 90};
//		int[] temperatures = {7, 3, 8, 5, 6};


		int[] result = new P_739_每日温度().dailyTemperatures(temperatures);

		AnswerPrinter.printIntTypeArray(result);
	}

	/**
	 * 从右往左维护一个单调递增栈，保存数组的索引下标，然后根据单调栈的特征，即可解题
	 *
	 * @param temperatures
	 * @return
	 */
	public int[] dailyTemperatures(int[] temperatures) {
		int[] result = new int[temperatures.length];
		Stack<Integer> idxStack = new Stack<>();
		for (int i = temperatures.length - 1; i >= 0; i--) {
			while (!idxStack.empty() && temperatures[idxStack.peek()] <= temperatures[i]) {
				idxStack.pop();
			}
			result[i] = idxStack.empty() ? 0 : idxStack.peek() - i;
			idxStack.push(i);
		}
		return result;
	}
}
