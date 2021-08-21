package xyz.flyly.leetcode._2021._08._22;

import java.util.ArrayList;
import java.util.List;

/**
 * 标准回溯问题
 * https://leetcode-cn.com/problems/combinations/
 */
public class P_77 {
    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] temp = new int[k];
        backtracking(n, 0, 1, temp, res);
        return res;
    }

    public static void backtracking(int n, int c, int s, int[] temp, List<List<Integer>> res) {
        if (c == temp.length) {
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < temp.length; i++) {
                t.add(temp[i]);
            }
            res.add(t);
            return;
        }

        for (int i = s; i <= n; i++) {
            temp[c++] = i;
            backtracking(n, c, i + 1, temp, res);
            // 回溯状态
            c--;
        }
    }

}
