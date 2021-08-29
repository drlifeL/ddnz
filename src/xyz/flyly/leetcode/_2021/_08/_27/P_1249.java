package xyz.flyly.leetcode._2021._08._27;

/**
 * 移除无效的括号
 * https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class P_1249 {
    public static void main(String[] args) {
        System.out.println(new P_1249().minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    /**
     * 思路可行，但效率比较低
     * 遍历字符串，找到左括号后,随即立刻开始找右括号, 找到对应的右括号后，将两边的括号标记为有效括号
     * 随后再次遍历字符串，将有效的括号和字符串返回
     *
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int j = i + 1;
                while (j < s.length()) {
                    if (s.charAt(j) == ')' && !used[j]) {
                        break;
                    }
                    j++;
                }
                if (j < s.length()) {
                    used[i] = true;
                    used[j] = true;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || used[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
