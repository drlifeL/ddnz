package xyz.flyly.leetcode._2021._11._01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class P_131_分割回文串 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        P_131_分割回文串 p = new P_131_分割回文串();
        p.back_tracking(0, "aab");
        System.out.println(p.res);

    }

    public List<List<String>> partition(String s) {
        back_tracking(0, s);
        return res;
    }

    public void back_tracking(int startIdx, String s) {
        if (startIdx >= s.length()) {
            List<String> temp = new ArrayList<>(path.size());
            temp.addAll(path);
            res.add(temp);
            return;
        }
        for (int i = startIdx; i < s.length(); i++) {
            if (isPalindrome(s, startIdx, i)) { // 是回文串
                // 获取字串,并加入到path中
                String str = s.substring(startIdx, i + 1);
                path.add(str);
            } else { // 不是字串则跳过
                continue;
            }
            back_tracking(i + 1, s);
            path.remove(path.size() - 1);
        }

    }

    private boolean isPalindrome(String s, int i, int j) {
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
