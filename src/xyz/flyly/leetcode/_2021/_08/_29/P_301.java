package xyz.flyly.leetcode._2021._08._29;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删除无效的括号
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/
 */
public class P_301 {
    private char[] arr;
    private Set<String> res = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(new P_301().removeInvalidParentheses("(a)())()"));
    }

    public List<String> removeInvalidParentheses(String s) {
        this.arr = s.toCharArray();

        // 第一步：遍历一次，计算多余的括号
        int leftRemove = 0;
        int rightRemove = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                leftRemove++;
            } else if (arr[i] == ')') {
                // 当前是右括号，但是却没有左括号，当前的这个括号是无效括号
                if (leftRemove == 0) {
                    rightRemove++;
                }
                if (leftRemove > 0) {
                    // 如果存在左括号，左括号是可以被抵消的
                    leftRemove--;
                }
            }
        }

        // 第二步,回溯算法，测试每一个可能
        StringBuilder path = new StringBuilder();
        dfs(0, 0, 0, leftRemove, rightRemove, path);
        return new ArrayList<>(res);
    }

    /**
     * 总共两种可能，
     * 1.存在无效括号，移除
     * 2.添加字符或者括号
     *
     * @param idx         当前idx
     * @param leftCount   左括号的数量
     * @param rightCount  右括号的数量
     * @param leftRemove  无效左括号的数量
     * @param rightRemove 无效右括号的数量
     * @param path        当前字符串
     */
    private void dfs(int idx, int leftCount, int rightCount, int leftRemove, int rightRemove, StringBuilder path) {
        if (idx == arr.length) {
            if (leftRemove == 0 && rightRemove == 0) {
                res.add(path.toString());
            }
            return;
        }
        char c = arr[idx];
        // 可能的操作1 ，删除当前的字符
        if (c == '(' && leftRemove > 0) {
            dfs(idx + 1, leftCount, rightCount, leftRemove - 1, rightRemove, path);
        }
        if (c == ')' && rightRemove > 0) {
            dfs(idx + 1, leftCount, rightCount, leftRemove, rightRemove - 1, path);
        }

        // 可能的操作2 ，保留当前的字符
        path.append(c);
        if (c != '(' && c != ')') {
            // 当前是字母
            dfs(idx + 1, leftCount, rightCount, leftRemove, rightRemove, path);
        } else if (c == '(') { // 左括号
            dfs(idx + 1, leftCount + 1, rightCount, leftRemove, rightRemove, path);
        } else if (rightCount < leftCount) { // 右括号
            dfs(idx + 1, leftCount, rightCount + 1, leftRemove, rightRemove, path);
        }
        path.deleteCharAt(path.length() - 1);
    }

}
