package xyz.flyly.leetcode._2021._08._29;

public class P_560 {
    int ans;

    public static void main(String[] args) {
        int[] arr = {1, -1, 1};
        int k = 1;
        System.out.println(new P_560().subarraySum(arr, k));
    }

    /**
     * 双重 for 循环,不返回是因为 存在 正负可以相互抵消
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
