package xyz.flyly.leetcode._2021._12._12;

/**
 * https://leetcode-cn.com/problems/to-lower-case/
 */
public class P_709_转换成小写字母 {
    public static void main(String[] args) {
        System.out.println(new P_709_转换成小写字母().toLowerCase("Hello"));
    }

    public String toLowerCase(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 'a') {
                arr[i] += 32;
            }
        }
        return new String(arr);
    }
}
