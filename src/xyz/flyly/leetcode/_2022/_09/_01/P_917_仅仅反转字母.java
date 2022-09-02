package xyz.flyly.leetcode._2022._09._01;

/**
 * https://leetcode.cn/problems/reverse-only-letters/
 *
 * @author : luoyang
 * @since : 2022/9/1 16:28
 **/
public class P_917_仅仅反转字母 {
	public static void main(String[] args) {
		String s = "ab-cd";
		s = "a-bC-dEf-ghIj";
//		s = "Test1ng-Leet=code-Q!";

		String result = new P_917_仅仅反转字母().reverseOnlyLetters(s);

		System.out.println(result);
	}

	public String reverseOnlyLetters(String s) {
		char[] chars = s.toCharArray();
		int i = 0;
		int j = chars.length - 1;

		while (i < j) {
			while (i < j && !isLetter(chars[i])) {
				i++;
			}
			while (i < j && !isLetter(chars[j])) {
				j--;
			}
			if (i >= j) {
				break;
			}
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			i++;
			j--;

		}
		return new String(chars);
	}

	private boolean isLetter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A') && (c <= 'Z');
	}


}
