package xyz.flyly.leetcode._2021._11._28;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class P_448_找到所有数组中消失的数字 {
    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new P_448_找到所有数组中消失的数字().findDisappearedNumbers(nums));
    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 桶排序
        int[] bucket = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
        // 还有一种解法，可以不使用额外空间 todo update
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i + 1) {
//                int temp = nums[i];
//                nums[i] = nums[temp - 1];
//                nums[temp - 1] = temp;
//            }
//        }
//        List<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i + 1) {
//                ans.add(i + 1);
//            }
//        }
//        return ans;
    }
}
