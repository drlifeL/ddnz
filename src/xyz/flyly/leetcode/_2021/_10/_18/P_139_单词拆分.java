package xyz.flyly.leetcode._2021._10._18;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_139_单词拆分 {
    boolean isOk = false;

    public static void main(String[] args) {
        // 动态规划做法
        System.out.println(new P_139_单词拆分().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        isOk = false;
        Set<String> set = new HashSet<>();
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String w : wordDict) {
            maxLen = Math.max(maxLen, w.length());
            minLen = Math.min(minLen, w.length());
            set.add(w);
        }
        if (minLen == Integer.MAX_VALUE) {
            return false;
        }
        dfs(s, set, minLen, maxLen, 0);
        return isOk;

    }

    public void dfs(String s, Set<String> set, int min, int max, int idx) {
        if (isOk) {
            return;
        }
        if (idx >= s.length()) {
            isOk = true;
            return;
        }
        if (idx + min > s.length()) {
            return;
        }
        String str = s.substring(idx, idx + min);
        if (set.contains(str)) {
            dfs(s, set, min, max, idx + min);
        }
        for (int i = idx + min; i < s.length() && idx - i <= max; i++) {
            str += s.charAt(i);
            if (set.contains(str)) {
                dfs(s, set, min, max, i + 1);
            }
        }

    }
}
