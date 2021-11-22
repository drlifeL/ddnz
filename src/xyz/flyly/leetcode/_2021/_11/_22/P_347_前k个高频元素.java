package xyz.flyly.leetcode._2021._11._22;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class P_347_前k个高频元素 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = new P_347_前k个高频元素().topKFrequent(nums, k);

        System.out.println(Arrays.toString(res));
    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        // 不能使用 map 会出现 频率次数一样的，所以使用优先队列，里面存放数组，然后使用 数组里面的元素进行比较
        PriorityQueue<int[]> sortedQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sortedQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }

        // 是 前 k 个元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int[] ints = sortedQueue.remove();
            res[i] = ints[0];
        }
        return res;
    }


}
