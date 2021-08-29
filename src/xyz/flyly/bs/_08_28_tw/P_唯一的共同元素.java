package xyz.flyly.bs._08_28_tw;

import java.util.*;

public class P_唯一的共同元素 {
    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(1, 1,2);
        List<Integer> arr2 = Arrays.asList(1,1,2);

        System.out.println(test2(arr1, arr2));
    }

    public static List<Integer> test2(List<Integer> arr1, List<Integer> arr2) {
        Set<Integer> set = new HashSet<>();
        for (Integer e : arr1) {
            set.add(e);
        }
        Set<Integer> res = new HashSet<>();
        for (Integer i : arr2) {
            if (set.contains(i)) {
                res.add(i);
            }
        }
        return new ArrayList<>(res);
    }
}
