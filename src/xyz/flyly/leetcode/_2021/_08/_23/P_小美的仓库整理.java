package xyz.flyly.leetcode._2021._08._23;

import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/TJZLyC/
 * // TODO 相关知识  前缀和
 */
public class P_小美的仓库整理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int idx = q[i] - 1;
            w[idx] = 0;
            System.out.println(Math.max(findMax(0, idx - 1, w), findMax(idx + 1, n - 1, w)));
        }

    }

    private static int findMax(int i, int j, int[] w) {
        int sum = 0;

        while (i <= j) {
            sum += w[i];
            i++;
        }

        return sum;
    }
}
