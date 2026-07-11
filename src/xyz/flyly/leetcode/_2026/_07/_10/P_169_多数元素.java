package xyz.flyly.leetcode._2026._07._10;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
 *
 * @author luoyang
 * @since 2026/7/10
 */
public class P_169_多数元素 {
    public static void main(String[] args) {
        P_169_多数元素 c = new P_169_多数元素();
        int[] arr = {3, 2, 3};
        int i = c.majorityElement(arr);
        System.out.println(i);

    }

    /**
     * 我的思路,Map 完成数的统计, 两个变量做 max 统计
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        int maxNum = -1;
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer curCount = map.getOrDefault(num, 0);
            curCount++;
            map.put(num, curCount);
            if (maxCount < curCount) {
                maxNum = num;
                maxCount = curCount;
            }
            if (maxCount > n) {
                break;
            }
        }
        return maxNum;
    }
}
