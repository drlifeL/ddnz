package xyz.flyly.leetcode._2026._07._09;

import java.util.Arrays;

/**
 * 一眼看过去是直接想到了双指针的解法，但是没解出来,看了一下以前的题解。
 * https://leetcode.cn/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * @author luoyang
 * @since 2026/7/9
 */
public class P_27_移除元素 {
    public static void main(String[] args) {
        P_27_移除元素 c = new P_27_移除元素();
        int[] nums = {3, 2, 2, 3};
        int k = c.removeElement(nums, 2);
        System.out.println("k:" + k + "::" + Arrays.toString(nums));

    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return i;
    }
}
