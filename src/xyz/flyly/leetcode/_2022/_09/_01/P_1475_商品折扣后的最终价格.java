package xyz.flyly.leetcode._2022._09._01;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * @author : luoyang
 * @since : 2022/9/1 15:41
 **/
public class P_1475_商品折扣后的最终价格 {
	public static void main(String[] args) {
		int[] prices = {8, 4, 6, 2, 3};

		int[] result = new P_1475_商品折扣后的最终价格().finalPrices(prices);

		System.out.println(Arrays.toString(result));
	}


	public int[] finalPrices(int[] prices) {
		int n = prices.length;
		int result[] = new int[n];
		for (int i = 0; i < n; i++) {
			int discount = 0;
			for (int j = i + 1; j < n; j++) {
				if (prices[j] <= prices[i]) {
					discount = prices[j];
					break;
				}
			}
			result[i] = prices[i] - discount;
		}

		return result;
	}
}
