package xyz.flyly.leetcode._2021._08._27;

/**
 * 有效的括号字符串
 * https://leetcode-cn.com/problems/valid-parenthesis-string/
 */
public class P_678 {
    public static void main(String[] args) {

    }

    public boolean checkValidString(String s) {
        int b = 0;
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                b++;
            }
        }
        return true;
    }
}
