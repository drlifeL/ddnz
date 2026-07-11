package xyz.flyly.leetcode._2026._07._10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author luoyang
 * @since 2026/7/10
 */
public class P_49_字母异位词分组 {
    public static void main(String[] args) {
        System.out.println(97 - 'a');

    }

    /**
     * 思路： Hash 对应, strs 只会有小写字母,考察字母的差异位置，只要对字母先进行排序，然后再放入到 Map 中就可以了。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = Arrays.toString(charArr);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> arr = new ArrayList<>();
                arr.add(str);
                map.put(key, arr);
            }
        }


        return new ArrayList<>(map.values());
    }
}
