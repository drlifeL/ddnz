package xyz.flyly.leetcode._2021._08._27;

import java.util.Stack;

/**
 * 最多能完成排序的块
 * https://leetcode-cn.com/problems/max-chunks-to-make-sorted/
 */
public class P_769 {
    public static void main(String[] args) {
//        int[] arr = {0, 4, 5, 2, 1, 3};
//        int[] arr = {4, 2, 2, 5, 6, 7};
        int[] arr = {2, 6, 1, 3, 0, 5, 4};
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }

    static class MyAns {

        /**
         * 存在错误，没有认真的把题目下方的提示看完，能跑 50% 的数据
         *
         * @param arr
         * @return
         */
        public static int maxChunksToSorted(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            stack.add(arr[0]);
            int i = 1;
            while (i < arr.length) {

                if (arr[i] >= arr[i - 1]) {
                    stack.push(arr[i]);
                    i++;
                } else {
                    int j = i + 1;
                    int min = arr[i];
                    while (j < arr.length && arr[j] >= arr[i] && arr[j] <= arr[i - 1]) {
                        min = Math.min(min, arr[j]);
                        j++;

                    }
                    while (stack.size() > 0 && stack.peek() >= min) {
                        stack.pop();
                    }
                    stack.push(min);
                    i = j;
                }
            }
            return stack.size();
        }

    }


}
