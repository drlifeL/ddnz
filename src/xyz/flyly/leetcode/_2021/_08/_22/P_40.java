package xyz.flyly.leetcode._2021._08._22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总数 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class P_40 {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(nums, target));
    }

    /**
     * used 默认全部为 false
     * 排序后，若要对判断同一层是否有其他的组合使用过该数： (i > 0 && nums[i] == nums[i-1] && !used[i-1])
     * 同一枝                        (i > 0 && nums[i] == nums[i-1] && used[i-1])
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // 去重前先排序
        Arrays.sort(candidates);
        boolean[] vis = new boolean[candidates.length];
        backtracking(0, target, candidates, vis, path, res);
        return res;
    }

    public static void backtracking(int sIdx, int target, int[] nums, boolean[] vis, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = sIdx; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) continue;

            if (target - nums[i] >= 0) {
                vis[i] = true;
                path.add(nums[i]);
                backtracking(i + 1, target - nums[i], nums, vis, path, res);
                path.remove(path.size() - 1);
                vis[i] = false;
            }
        }
    }


}
