package xyz.flyly.leetcode._2021._08._21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_46 {
    static Set<List<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        dfs(0, nums);
        List<List<Integer>> res = new ArrayList(set);
        return res;
    }

    public static void dfs(int s, int[] nums) {
        if (s == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            set.add(temp);
            return;
        }
        for (int i = s; i < nums.length; i++) {
            swap(s, i, nums);
            dfs(s + 1, nums);
            swap(i, s, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
