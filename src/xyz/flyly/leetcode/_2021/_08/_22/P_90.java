package xyz.flyly.leetcode._2021._08._22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 ii
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class P_90 {
    List<List<Integer>> res = new ArrayList();
    List<Integer> path = new ArrayList();

    public static void main(String[] args) {

        int[] nums = new int[]{4, 4, 4, 1, 4};
        System.out.println(new P_90().subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            backtracking(0, i, used, nums);
        }
        return res;
    }

    public void backtracking(int sIdx, int tIdx, boolean[] used, int[] nums) {
        if (tIdx == 0) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = sIdx; i < nums.length && tIdx >= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(i + 1, tIdx - 1, used, nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
