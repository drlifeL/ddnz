package xyz.flyly.leetcode._2022._09._05;

/**
 * @author : luoyang
 * @since : 2022/9/5 17:05
 **/
public class P_汉明距离 {
	public static void main(String[] args) {
		int x = 3;
		int y = 1;

		int ans = new P_汉明距离().hammingDistance(x, y);

		System.out.println(ans);


	}

	public int hammingDistance(int x, int y) {
		int z = x ^ y;
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			if (((z >> i) & 1) > 0) {
				ans++;
			}
		}
		return ans;
	}
}
