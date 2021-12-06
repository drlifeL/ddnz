package xyz.flyly.leetcode._2021._12._06;

public class P_1816_截断句子 {
    public static void main(String[] args) {
//        String str = "Hello how are you Contestant";
//        int k = 4;
        String str = "chopper is not a tanuki";
        int k = 5;

        System.out.println(new P_1816_截断句子().truncateSentence(str, k));

    }

    public String truncateSentence(String s, int k) {
        // s = "Hello how are you Contestant", k = 4
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == ' ') k--;
            if (k == 0) {
                break;
            }
        }
        return s.substring(0, i);
    }
}
