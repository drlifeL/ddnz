package xyz.flyly.leetcode._2022._09._05;

/**
 * @author : luoyang
 * @since : 2022/9/5 16:56
 **/
public class P_位1的个数 {
	public static void main(String[] args) {

		int ans = new P_位1的个数().hammingWeight(12);

		System.out.println(ans);
	}

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			if (((n >> i) & 1) > 0) {
				ans++;
			}
		}
		return ans;
	}
}
