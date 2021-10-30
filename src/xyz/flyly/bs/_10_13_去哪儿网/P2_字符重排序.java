package xyz.flyly.bs._10_13_去哪儿网;

import java.util.*;
/*
题目描述:
给定一个只包含大小写英文字母的字符串，需要将字符串中出现的字符按照一定的规则重新排序后输出。
排序规则如下:
1.首先按照字符串里字符出现的频率降序排列
2.对于频率相同的字符，则按照先大写后小写的顺序排列
3.对于频率相同且大小写相同的字符，则按照字母的顺序排序，即a/A排在最前，z/Z 排在最后，中间的字母以此类推。
输入描述
baAbb
输出描述
bbbAa

样例输出
baAbb
样例输出
bbbAa
 */
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
