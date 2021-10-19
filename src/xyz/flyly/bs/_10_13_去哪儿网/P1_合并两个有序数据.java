package xyz.flyly.bs._10_13_去哪儿网;

import java.util.Arrays;

public class P1_合并两个有序数据 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5};
        int m = 0;
        int[] b = new int[]{2, 4, 6};
        int n = 3;
        new P1_合并两个有序数据().mergeSortedArray(a, m, b, n);
        System.out.println(Arrays.toString(a));
    }

    public int[] mergeSortedArray(int[] a, int m, int[] b, int n) {
        // 从A 的末尾开始合并
        int idx = a.length - 1; // 尾巴的元素
        while (m > 0 && n > 0) {
            if (a[m - 1] > b[n - 1]) {
                a[idx] = a[m - 1];
                m--;
            } else {
                a[idx] = b[n - 1];
                n--;
            }
            idx--;
        }
        while (n > 0){
            a[idx--] = b[--n];
        }
        return a;
    }
}
