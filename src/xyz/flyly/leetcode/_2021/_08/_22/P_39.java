package xyz.flyly.leetcode._2021._08._22;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总数
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class P_39 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        System.out.println(combinationSum(nums, 2));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(0, candidates, target, path, res);
        return res;
    }

    public static void backtracking(int idx, int[] nums, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                path.add(nums[i]);
                backtracking(i, nums, target - nums[i], path, res);
                // 移除
                path.remove(path.size() - 1);
            }
        }
    }
}
