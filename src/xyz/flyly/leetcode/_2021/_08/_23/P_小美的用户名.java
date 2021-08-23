package xyz.flyly.leetcode._2021._08._23;

import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/BaR9fy/
 */
public class P_小美的用户名 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String str = scanner.next();
            valid(str);
        }
    }

    public static void valid(String str) {
        if (!((str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') || (str.charAt(0) >= 'a' && str.charAt(0) <= 'z'))) {
            System.out.println("Wrong");
            return;
        }
        boolean hasNum = false;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                hasNum = true;
                continue;
            }
            if (!((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'))) {
                System.out.println("Wrong");
                return;
            }
        }
        if (!hasNum) {
            System.out.println("Wrong");
        } else {
            System.out.println("Accept");
        }
    }
}
