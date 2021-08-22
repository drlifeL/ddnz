package xyz.flyly.leetcode._2021._08._22;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class P_22 {
    List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        List<String> res = new P_22().generateParenthesis(4);
        System.out.println(res);
    }

    public List<String> generateParenthesis(int n) {
        backtracking("", n, n);
        return path;
    }

    public void backtracking(String str, int l, int r) {
        if (l == 0 && r == 0) {
            path.add(str);
            return;
        }
        // 剪枝  l 一定不能小于  r
        if (l > r) return;

        if (l > 0) {
            backtracking(str + "(", l - 1, r);
        }
        if (r > 0) {
            backtracking(str + ")", l, r - 1);
        }

    }
}
