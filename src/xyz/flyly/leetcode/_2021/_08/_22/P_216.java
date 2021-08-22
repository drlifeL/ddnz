package xyz.flyly.leetcode._2021._08._22;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为 N 的 K 个数
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
public class P_216 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(new P_216().combinationSum3(k, n));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(1, k, n);
        return res;
    }

    public void backtracking(int sIdx, int k, int n) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = sIdx; i <= 9 && k > 0 && n - i >= 0; i++) {
            path.add(i);
            backtracking(i + 1, k - 1, n - i);
            path.remove(path.size() - 1);
        }
    }

}
