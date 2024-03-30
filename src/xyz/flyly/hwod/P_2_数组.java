package xyz.flyly.hwod;

/**
 * [ 第2题 ] 题目：给定一个数组，编写一个函数来计算它的最大N个数与最小N个数的和。你需要对数组进行去重。
 * <p>
 * 说明：
 * 数组中数字范围[0, 1000]
 * 最大N个数与最小N个数不能有重叠，如有重叠，输入非法返回-1
 * 输入非法返回-1
 * 题型：编程
 * 难度：1
 * 知识点：[数组, 排序]
 * 分值：100.0
 *
 * @author luoyang
 * @since 2024/3/30
 */
public class P_2_数组 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println(sum(arr));
    }

    public static int sum(int[] arr) {
        int[] temp = new int[1001];
        int maxIdx = -1;
        int minIdx = 1002;

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            if (n > maxIdx) {
                maxIdx = n;
            }
            if (n < minIdx) {
                minIdx = n;
            }
            temp[n]++;
        }
        if (maxIdx == minIdx) {
            return -1;
        }
        return maxIdx * temp[maxIdx] + minIdx * temp[minIdx];
    }


}
