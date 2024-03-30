package xyz.flyly.leetcode._2022._09._06;

/**
 * https://leetcode.cn/problems/decode-string/
 *
 * @author : luoyang
 * @since : 2022/9/6 14:43
 **/
public class P_394_字符串解码 {
	public static void main(String[] args) {
//		String s = "3[a]2[bc]";
//		String s = "abc3[cd]xyz";
//		String s = "2[abc]3[cd]ef";
		String s = "3[a2[c]]";

		String ans = new P_394_字符串解码().decodeString(s);

		System.out.println(ans);
	}


	public String decodeString(String s) {

		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		int i = 0;
		while (i < chars.length) {
			if (chars[i] >= 'a' && chars[i] <= 'z') {
				// 纯粹的字母，直接加到结果集里面去就可以了
				sb.append(chars[i]);
				i++;
			} else if (chars[i] >= '1' && chars[i] <= '9') {
				// 需要解码的情况
				int num = 0;
				int m = 1;
				while (chars[i] != '[') {
					num += (chars[i] - '0') * m;
					i++;
				}
				// 取括号里面的内容
				i++;
				String temp = "";
				while (chars[i] != ']') {
					if (chars[i] >= '1' && chars[i] <= '9') {
						temp += decodeString(s.substring(i));
					} else {
						temp += chars[i++];
					}

				}
				i++;
				for (int j = 0; j < num; j++) {
					sb.append(temp);
				}
			}

		}


		return sb.toString();
	}
}
