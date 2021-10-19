package xyz.flyly.bs._09_12_爱奇艺;

import java.util.*;
import java.util.stream.Collectors;

// AC
public class P2_统计最多数子组的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String s = i + "";
            char[] chars = s.toCharArray();
            int sum = 0;
            for (int j = 0; j < chars.length; j++) {
                sum += chars[j] - '0';
            }
            List<Integer> list = map.get(sum);
            if (list == null) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(sum, temp);
            } else {
                list.add(i);
            }
        }
        Map<Integer, List<List<Integer>>> collect = map.values()
                .stream()
                .collect(Collectors.groupingBy(List::size));

        Set<Integer> set = collect.keySet();
        int max = 0;
        int maxSize = 0;
        for (Integer i : set) {
            if (i * collect.get(i).size() > max) {
                max = i * collect.get(i).size();
                maxSize = collect.get(i).size();
            }

        }
        System.out.println(maxSize);

    }
}
