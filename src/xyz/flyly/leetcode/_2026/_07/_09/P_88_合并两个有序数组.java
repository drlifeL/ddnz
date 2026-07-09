package xyz.flyly.leetcode._2026._07._09;

/**
 * 思路：nums1 是全部的长度,直接从后往前比较就可以了，不用新的数组空间
 * https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 *
 * @author luoyang
 * @since 2026/7/9
 */
public class P_88_合并两个有序数组 {
    public static void main(String[] args) {

    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;

        while (i >= 0) {
            if (m < 0 && n >= 0) {
                nums1[i] = nums2[n];
                n--;
            } else if (n < 0 && m >= 0) {
                nums1[i] = nums1[m];
                m--;
            } else if (nums2[n] >= nums1[m]) {
                nums1[i] = nums2[n];
                n--;
            } else {
                nums1[i] = nums1[m];
                m--;
            }
            i--;
        }
    }
}
