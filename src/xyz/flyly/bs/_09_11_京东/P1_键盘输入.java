package xyz.flyly.bs._09_11_京东;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
题目描述:
你在使用一个特殊的键盘输入一个字符串。键盘是一个矩形网格的形状，有各种不同的排列，每个按键上的字符互不相同，最
多有94个按键(除空格外共有94个可见ASCII字符，ASCII 码为33~126)。你需要操作一个机械手来点击这个键盘，机械
手可以上下左右移动，每移动一格耗时x，移动过程中(不包括一开始或者点击前后)转向耗时y,每次点击键盘耗时z。-开
始，机械手位于左上角。请计算打完这个字符串最少需要多少时间。
输入描述
第一行五个空格隔开的整数n, m,x,y,z, 0<n*m<=94，1 <=x,y,Z <= 100000
后面n行，每行一个由m个字符组成的字符串，表示键盘的配列，保证m个字符都是ASCII可见字符，不是空格且互
不相同。
最后一行一个由上述配列中存在的字符组成的字符串，长度不超过100000。
输出描述
一个整数，表示最少需要的时间

样例输入
2 2 1 1 1
.E
:F
EE:F.:
样例输出
15
 */
public class P1_键盘输入 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        Map<Character, int[]> idxMap = new HashMap<>();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
            for (int j = 0; j < arr[i].length; j++) {
                idxMap.put(arr[i][j], new int[]{i, j});
            }
        }
        String str = sc.next();
        // 转向的时候 是 x + y     左右移动 x  点击 z
        int res = 0;
        int cx = 0;
        int cy = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int[] t = idxMap.get(c);
            if (cx == t[0] && cy == t[1]) {
                // 这个字符就在教下,直接 z
                res += z;
            } else {
                // 在同一行，只需要左右就可以了
                if (cx == t[0]) {
                    res += Math.abs(cy - t[1]) * x;
                    res += z;
                } else {
                    // 变更 y
                    res += Math.abs(cy - t[1]) * x;
                    // 变更 x
                    res += Math.abs(cx - t[0]) * x;
                    // 转向
                    res += y;

                    res += z;
                    cx = t[0];
                    cy = t[1];
                }

            }

        }
        System.out.println(res);
    }
}
