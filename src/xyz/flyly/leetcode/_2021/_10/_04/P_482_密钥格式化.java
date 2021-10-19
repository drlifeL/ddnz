package xyz.flyly.leetcode._2021._10._04;

public class P_482_密钥格式化 {
    public static void main(String[] args) {
        String str = "absdaw-asdaw-as123nas-213nfa";
        System.out.println(new P_482_密钥格式化().licenseKeyFormatting_改("--a-a-a-a--", 2));
        System.out.println(new P_482_密钥格式化().licenseKeyFormatting(str, 2));

        System.out.println((char) ('A' + 'b' - 'a'));
    }

    public String licenseKeyFormatting(String s, int k) {

        char[] arr = s.replace("-", "").toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        int x = arr.length / k;
        int y = arr.length % k;
        if (x == 0) {
            return new String(arr);
        }
        if (y != 0) {
            sb.append(arr, 0, y);
            sb.append('-');
        }

        for (int i = 0; i < x - 1; i++, y += k) {
            sb.append(arr, y, k);
            sb.append("-");
        }
        sb.append(arr, y, k);
        return sb.toString();
    }

    public String licenseKeyFormatting_改(String s, int k) {
        // 从后往前,一次遍历,随后直接转为大写
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, n = 0; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') continue;
            if (c >= 'a' && c <= 'z') {
                c = (char) (c - 'a' + 'A');
            }
            if (n == k && (n = 0) >= 0) sb.append("-");
            sb.append(c);
            n++;

        }
        return sb.reverse().toString();
    }
}
