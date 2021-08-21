package xyz.flyly.leetcode._2021._08._22;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class P_78 {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtracking(0, i, nums, res, path);
        }
        return res;
    }

    public static void backtracking(int sIdx, int tIdx, int[] nums, List<List<Integer>> res, List<Integer> path) {
        if (tIdx == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = sIdx; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(i + 1, tIdx, nums, res, path);
            // 回溯
            path.remove(path.size() - 1);
        }
    }


}
