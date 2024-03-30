package xyz.flyly.leetcode._2022._09._07;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/remove-duplicate-letters/
 *
 * @author : luoyang
 * @since : 2022/9/7 17:48
 **/
public class P_316_去除重复字母 {
	public static void main(String[] args) {


	}

	/**
	 * 两个要求：
	 * 1.要求返回的字母的字典序最小
	 * 2.返回字母的相对顺序不能发生改变
	 *
	 * @param s
	 * @return
	 */
	public String removeDuplicateLetters(String s) {
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < chars.length; i++) {
			if (set.add(chars[i])) {
				sb.append(chars[i]);
			}
		}
		return sb.toString();
	}
}
