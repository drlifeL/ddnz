package xyz.flyly.bs._10_24_360;

import java.util.Scanner;

/*
题目描述:
一日，小A走在路上时看到路边摆着面大镜子。他对着这面镜子注视了半天，突然发现自己穿越到了另一个世界!
这个世界很奇怪:他所在的地方可视为一个n行m列的矩阵，每一个位置上都有一个非负整数或者-1.这时，他的耳边响起了
一个很空灵的声音:“如果您想要回到原来的世界， 你需要解决下面的问题:你需要在整个矩阵上选择一个正方形区域， 使得
该区域不包含任何负数，并且该区域内的数字之和最大。
然而这个问题对于小A来说还是太难了，所以他请了你来帮忙解决这个问题。

输入描述
第一行一个正整数T，表示一共有T组数据。
对于每组数据，第一行两个正整数n,m,含义见题面;
接下来一个n行m列的整数矩阵a[i][j]。
1 <= n , m <= 500 , 1 <= T <= 5 a[i][j] ∈ {-1,[0,100]}
输出描述
对于每组数据，输出一行-一个正整数，表示满足条件的最大值。如果该矩阵全为-1，则输出0.
样例输入
1
4 4
3 0 5 6
0 9 -1 4
-1 8 1 1
4 -1 5 -1
样例输出
12
提示
选择左上角的 2 * 2 正方形 ,和为 3 + 0 + 0 + 9 = 12
 */
public class P2_幻想正方形 {
    // %20
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            System.out.println(func(arr));
        }
    }

    private static int func(int[][] arr) {
        int max = 0;
        int rows = arr.length;
        int cols = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] != -1) {
                    int t = arr[i][j];
                    int r = i;
                    int c = j;
                    while (r + 1 < rows && c + 1 < cols && arr[r + 1][c] != -1 && arr[r][c + 1] != -1 && arr[r + 1][c + 1] != -1) {
                        t += arr[r + 1][c + 1];
                        t += arr[r + 1][c];
                        t += arr[r][c + 1];
                        r++;
                        c++;

                    }
                    max = Math.max(max, t);
                }
            }
        }
        return max;
    }
}
