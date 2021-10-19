package xyz.flyly.bs._09_11_京东;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 键盘输入
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
