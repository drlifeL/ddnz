package xyz.flyly.leetcode._2021._08._29;

import java.util.Stack;

/**
 * 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/submissions/
 */
public class P_20 {
    public static void main(String[] args) {

        System.out.println(new P_20().isValid("([)]"));

    }

    public boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || !isMatch(stack.pop(), c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char l, char r) {
        if (r == ')') {
            return l == '(';
        } else if (r == '}') {
            return l == '{';
        }
        return l == '[';
    }

}
