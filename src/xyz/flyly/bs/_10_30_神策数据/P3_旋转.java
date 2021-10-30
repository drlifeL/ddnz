package xyz.flyly.bs._10_30_神策数据;

import java.util.Scanner;
/*
题目描述
给定一个N* N的2D矩阵表示一张图片，将图片顺时针旋转90度。
注意:请使尽量用原地转换(in-place)实现，测试CASE包含大数据量的情况，使用额外空间可能部分
CASE内存超限。
输入描述：
第一行是矩阵大小N,后续每N行输入，是矩阵的一行。
例如:3 * 3的矩阵:
1 2 3
4 5 6
7 8 9
输入为：
3
1
2
3
4
5
6
7
8
9
输出描述:
旋转后的矩阵，把矩阵的行逐个输出，输出每行一个数，例如输出如下矩阵
7
4
1
8
5
2
9
6
3
 */
public class P3_旋转 {
    // 50% 超时
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                System.out.println(arr[j][i]);
            }
        }
    }
}
