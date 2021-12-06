package xyz.flyly.leetcode._2021._11._28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class P_438_找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        System.out.println(new P_438_找到字符串中所有字母异位词().findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            // 移除掉出去窗口掉
            --sCount[s.charAt(i) - 'a'];
            // 加上进来的
            ++sCount[s.charAt(i + pLen) - 'a'];
            // 判断一下是否相等
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
