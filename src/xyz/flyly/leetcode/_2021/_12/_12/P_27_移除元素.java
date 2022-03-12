package xyz.flyly.leetcode._2021._12._12;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-element/
 */
public class P_27_移除元素 {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] nums = {3, 2, 2, 3};
        System.out.println(new P_27_移除元素().removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    /**
     *  不需要考虑数组后面的元素，直接快慢指针覆盖即可。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

}
