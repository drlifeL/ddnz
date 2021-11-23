package xyz.flyly.leetcode._2021._11._23;

/**
 * https://leetcode-cn.com/problems/buddy-strings/
 */
public class _859_亲密的字符串 {

    public static void main(String[] args) {
        String s = "aa";
        String g = "aa";
        System.out.println(new _859_亲密的字符串().buddyStrings(s, g));
    }

    public boolean buddyStrings(String s, String goal) {
        int n = s.length(), m = goal.length();
        // 如果两者的字符串长度不一直，那么一定不相等
        if (n != m) return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - 'a', b = goal.charAt(i) - 'a';
            cnt1[a]++;
            cnt2[b]++;
            // 统计位置不正确的字符
            if (a != b) sum++;
        }
        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            // 找到了第一个位置不同的字符
            if (cnt1[i] != cnt2[i]) return false;
            // 有可能某一个字符出现了两次 比如 s = aa ，g = aa 这种情况下结果也应该是 True
            if (cnt1[i] > 1) ok = true;
        }
        // 如果说正好只有两个字符的位置不同,或者说是重叠字符串,返回 true 否则 false
        return sum == 2 || (sum == 0 && ok);
    }

}
