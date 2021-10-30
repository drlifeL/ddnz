package xyz.flyly.bs._10_30_神策数据;

import java.util.Scanner;
/*
题目描述
人民币1元以上包含1元，2元，5元，10元，20元，50元，100元7种。给出一个钱包里面的每种纸币的
个数 + 一个价格，计算出这个价格的所有出钱方案。
输入描述：
第一行是7个数字分别代表钱包里面1元，2元，5元，10元，20元，50元，100元的张数，用空格分开
第二行是1个数字，表示需要出的价钱
输出描述：
输出每行是一个出钱方案，每行是7个数字，分别代表出价时1元，2元，5元，10元，20元，50元，
100元的张数，用空格分开
多个出钱方案需要排序后输出，排序方法是依次比较七个数字的大小，按照升序排列。
示例：
输入：
2 1 3 2 0 0 0
24
输出：
2 1 0 2 0 0 0
2 1 2 1 0 0 0
 */
public class P2_出钱方案 {
    static int[] m = new int[]{1, 2, 5, 10, 20, 50, 100};
    static int[] ans = new int[7];
    static int count;
    static int[] arr = new int[7];
    static int cur = 0;

    // %40
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }
        count = sc.nextInt();

        dfs(6);
    }

    private static void dfs(int i) {
        if (cur == count) {
            for (int j = 0; j < ans.length - 1; j++) {
                System.out.print(ans[j] + " ");
            }
            System.out.println(ans[6]);
            return;
        }
        if (i < 0 || cur > count) return;
        if (arr[i] > 0 && (cur + m[i]) <= count) {
            cur += m[i];
            arr[i] -= 1;
            ans[i] += 1;
            dfs(i);// 取一张
            cur -= m[i];
            arr[i] += 1;
            ans[i] -= 1;
        }
        dfs(i - 1);
    }
}
