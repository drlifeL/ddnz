package xyz.flyly.bs._10_13_去哪儿网;

import java.util.*;

public class P2_字符重排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // bbbAa
        String str = sc.next();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        // 统计出现频率，随后降序输出，
        // 对于频率相同，按照先大写后小写的顺序
        // 对于频率和大小都相同的字符串，则按照字母的顺序排序
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        TreeMap<Integer, List<Character>> pMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Map.Entry<Character, Integer> c : map.entrySet()) {
            Integer v = c.getValue();
            Character k = c.getKey();
            if (!pMap.containsKey(v)) {
                ArrayList<Character> charArr = new ArrayList<>();
                charArr.add(k);
                pMap.put(v, charArr);
            } else {
                pMap.get(v).add(k);
            }
        }

        for (Map.Entry<Integer, List<Character>> entry : pMap.entrySet()) {
            List<Character> value = entry.getValue();
            Integer key = entry.getKey();
            for (Character character : value) {
                for (int i = 0; i < key; i++) {
                    System.out.print(character);
                }
            }
        }
    }

}
