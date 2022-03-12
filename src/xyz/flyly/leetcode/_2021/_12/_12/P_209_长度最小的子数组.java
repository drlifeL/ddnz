package xyz.flyly.leetcode._2021._12._12;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class P_209_长度最小的子数组 {
    public static void main(String[] args) {
//        int [] nums = {2,3,1,2,4,3};
        int[] nums = {1, 4, 4};
        System.out.println(new P_209_长度最小的子数组().minSubArrayLen(4, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int subLength = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                subLength = j - i + 1;
                result = Math.min(result, subLength);
                sum -= nums[i++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
