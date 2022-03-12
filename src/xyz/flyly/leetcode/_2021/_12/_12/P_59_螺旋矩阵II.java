package xyz.flyly.leetcode._2021._12._12;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class P_59_螺旋矩阵II {
    public static void main(String[] args) {
        int[][] matrix = new P_59_螺旋矩阵II().generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startX = 0, startY = 0;
        int loop = n / 2;
        int mid = n / 2;
        int count = 1;
        int offset = 1;
        int i, j;
        while (loop-- > 0) {
            i = startX;
            j = startY;

            // 模拟转圈 左闭右开  ,最上面的从左到右
            for (j = startY; j < startY + n - offset; j++) {
                res[startX][j] = count++;
            }
            // 模拟右列的从上到下
            for (i = startX; i < startX + n - offset; i++) {
                res[i][j] = count++;
            }

            // 模拟从右到左
            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            //模拟左列从下到上
            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            // 开始的位置要加1
            startX++;
            startY++;

            // offset 用于控制每一圈中每一条边遍历的长度
            offset += 2;
        }
        if (n % 2 != 0) {
            res[mid][mid] = count;
        }
        return res;
    }
}
