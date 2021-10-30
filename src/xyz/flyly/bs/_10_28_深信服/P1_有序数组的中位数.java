package xyz.flyly.bs._10_28_深信服;
/*
题目描述：
当前有两个有序(增序)的int型数组A和B，请给出算法求出两个有序数组的中位数。
算法效率越高，得到的分数越高。尽量用Java进行编写。

示例1
输入
[1,2,3,4],[5,6,7,8,9]
输出
5
示例2
输入
[1,3,5,7,9],[2,4,6]
输出
4

 */
public class P1_有序数组的中位数 {
    // AC
    public static void main(String[] args) {
//        int[] arr1 = new int[]{1, 2, 3, 4};
//        int[] arr2 = new int[]{5, 6, 7, 8, 9};
        int[] arr1 = new int[]{1, 3, 5, 7, 9};
        int[] arr2 = new int[]{2, 4, 6};
        System.out.println(new P1_有序数组的中位数().getMedia(arr1, arr2));

    }

    public int getMedia(int[] arr1, int[] arr2) {
        // write code here
        int len = arr1.length + arr2.length;
        int mid;
        if (len % 2 == 0) {
            mid = len / 2 - 1;
        } else {
            mid = len / 2;
        }
        int i = 0;
        int j = 0;
        int idx = 0;
        int t = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                t = arr1[i];
                i++;
            } else {
                t = arr2[j];
                j++;
            }
            if (idx == mid) return t;
            idx++;

        }

        if (i == arr1.length) {
            arr1 = arr2;
            i = j;
        }
        for (; i < arr1.length && idx <= mid; i++, idx++) {
            t = arr1[i];
        }
        return t;
    }
}
