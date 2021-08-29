package xyz.flyly.bs._08_28_tw;

import java.util.Arrays;
import java.util.List;

public class P_整除配对 {
    public static void main(String[] args) {
        System.out.println(test(Arrays.asList(1, 2, 3, 4, 5, 6), 5));
    }

    public static int test(List<Integer> arr, int k) {
        int res = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if ((arr.get(i) + arr.get(j)) % k == 0) {
                    res++;
                }
            }
        }
        return res;

    }
}
