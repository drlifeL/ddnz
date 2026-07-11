package xyz.flyly.leetcode._2026._07._10;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author luoyang
 * @since 2026/7/10
 */
public class P_128_最长连续序列 {
    public static void main(String[] args) {
        P_128_最长连续序列 p = new P_128_最长连续序列();
        int[] arr = {1, 2, 1, 0, 4};
        int r = p.longestConsecutive(arr);
        System.out.println(r);

    }


    /**
     * 此题的思路有点取巧，题目给定的是一个未排序的数组,且有连续数字,求最长连续序列
     * 我们可以把所有的数字都放在 Hash 表里面，然后遍历 Hash 表，但是因为顺序可能不一致，假设有序列 2 3 4 ，有可能 hash 表取的数字第一个是 3 ，这个时候我们只需要跳过这种情况就可以了
     * 也就是说，判断 3 - 1 包含在 hash 表中，则 continue . 否则的话就进行统计阶段
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (Integer num : set) {
            // 如果有更小的数字,则直接跳过
            if (set.contains(num - 1)) {
                continue;
            }
            int start = num + 1;
            int cur = 1;
            while (set.contains(start)) {
                cur++;
                start++;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
