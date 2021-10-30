package xyz.flyly.leetcode._2021._10._30;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/single-number-iii/
 */
public class P_260_只出现一次的数字 {
    public static void main(String[] args) {
        int[] ints = new P_260_只出现一次的数字().singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        System.out.println(Arrays.toString(ints));
    }

    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        Iterator<Integer> iter = set.iterator();
        int[] res = new int[2];
        res[0] = iter.next();
        res[1] = iter.next();
        return res;
    }
}
