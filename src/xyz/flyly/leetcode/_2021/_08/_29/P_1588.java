package xyz.flyly.leetcode._2021._08._29;

/**
 * 所有奇数长度子数组的和
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 */
public class P_1588 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};

        System.out.println(new P_1588().sumOddLengthSubarrays(arr));
    }

    /**
     * 直接暴力,
     * 1.先确定每次取的元素的个数
     * 2.确定元素的开始和结束点
     * 3.遍历取值
     *
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int temp = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            for (int j = 0; j < arr.length; j++) {
                if (arr.length - j < i) {
                    break;
                }
                for (int k = j; k < j + i; k++) {
                    temp += arr[k];
                }
            }
        }
        return temp;
    }



}
