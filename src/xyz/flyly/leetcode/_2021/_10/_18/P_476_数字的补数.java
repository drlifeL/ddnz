package xyz.flyly.leetcode._2021._10._18;

public class P_476_数字的补数 {

    public static void main(String[] args) {
        System.out.println(new P_476_数字的补数().
                findComplement(5));
    }

    public int findComplement(int num) {
        // 先找到最高位的1所在的位置，然后取反
        int hidx = -1;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) != 0) {
                hidx = i;
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < hidx; i++) {
            if (((num >> i) & 1) == 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
