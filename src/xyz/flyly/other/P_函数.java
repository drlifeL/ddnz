package xyz.flyly.other;

import java.util.Scanner;

/**
 * 对于一个十进制正整数 x ,如果 x 的每一位数字只可能是 1,2,3 中的其中一个 ,则称 x 是完美数
 * 如： 123， 1,3321,都是完美数，而 5,1234 则不是
 * 牛牛想写一个函数 f(n),使得其返回最大的不大于 n 的完美数，请你帮助牛牛实现这个函数。
 * 输入描述：
 * 第一行一个正整数 T 表示单组测试数据的组数
 * 接下来 T 行每行一个正整数 n
 * 输入：
 * 4
 * 213
 * 3244
 * 22
 * 100
 * 输出：
 * 213
 * 3233
 * 22
 * 33
 */
public class P_函数 {
    public static long max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(f(sc.nextInt()));
        }
        // 646201396803243732

    }

    public static long f(long n) {
        max = 0;
        dfs(n, 0, 1);
        return max;
    }

    public static void dfs(long t, long n, long b) {
        if (n > t) return;
        max = Math.max(n, max);
        for (int i = 1; i <= 3; i++) {
            dfs(t, n + (b * i), b * 10);
        }
    }
}
