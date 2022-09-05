package xyz.flyly.leetcode._2022._09._05;

import xyz.flyly.leetcode.utils.AnswerPrinter;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhhkv/
 *
 * @author : luoyang
 * @since : 2022/9/5 14:42
 **/
public class P_旋转图像 {
	public static void main(String[] args) {
//		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] matrix = {
				{5, 1, 9, 11},
				{2, 4, 8, 10},
				{13, 3, 6, 7},
				{15, 14, 12, 16}
		};

		new P_旋转图像().rotate(matrix);

		AnswerPrinter.print2dMatrix(matrix);


	}

	public void rotate(int[][] matrix) {
		int n = matrix.length;

		// 上下交换
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - i][j];
				matrix[n - 1 - i][j] = temp;
			}
		}
		// 在按照对角线交换
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
