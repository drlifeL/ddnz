package xyz.flyly.bs._10_21_阅文集团;

/*
题目描述
给定两个字符串 s1 和 s2 , 写一个函数来判断 s2 是否包含 s1 的排列之一
说明：第一个字符串的排列（全部字符,顺序可换） 之一 是第二个字符串的字串

示例1
输入
"bc","abcd"
输出
true
 */
public class P1_字符串的排列 {
    public static void main(String[] args) {

        System.out.println(new P1_字符串的排列().checkInclusion("ab", "eidboaoo"));
    }


    public boolean checkInclusion(String s1, String s2) {
        // write code here
        for (int i = 0; i < s2.length(); ) {
            if (s2.charAt(i) == s1.charAt(0)) {
                int j = 0;
                while (j < s1.length() && s2.charAt(i) == s1.charAt(j)) {
                    i++;
                    j++;
                }
                if (j == s1.length()) {
                    return true;
                }

            } else {
                i++;
            }
        }

        for (int i = 0; i < s2.length(); ) {
            if (s2.charAt(i) == s1.charAt(s1.length() - 1)) {
                int j = s1.length() - 1;
                while (j >= 0 && s2.charAt(i) == s1.charAt(j)) {
                    i++;
                    j--;
                }
                if (j < 0) {
                    return true;
                }
            } else {
                i++;
            }
        }

        return false;
    }
}
