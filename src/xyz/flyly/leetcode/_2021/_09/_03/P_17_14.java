package xyz.flyly.leetcode._2021._09._03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的 k 个数
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class P_17_14 {
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;

        System.out.println(Arrays.toString(new P_17_14().smallestK(arr, k)));


    }

    /**
     *  大顶堆
     *  遍历数组，往堆中添加元素
     *  当元素的 个数 达到 k 时，移除堆顶的元素。最后堆中的 k 个元素就是 最小的 k 个数
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove();
        }

        return res;
    }
}
