package xyz.flyly.leetcode._2022._09._09;

/**
 * https://leetcode.cn/problems/crawler-log-folder/
 *
 * @author : luoyang
 * @since : 2022/9/9 09:44
 **/
public class P_1598_文件夹操作日志收集器 {

	public static void main(String[] args) {
//		String[] logs = new String[]{"d1/", "d2/", "../", "d21/", "./"};
//		String[] logs = new String[]{"d1/","d2/","./","d3/","../","d31/"};
		String[] logs = new String[]{"d1/","../","../","../"};

		int result = new P_1598_文件夹操作日志收集器().minOperations(logs);

		System.out.println(result);
	}


	public int minOperations(String[] logs) {
		int result = 0;
		for (int i = 0; i < logs.length; i++) {
			if (logs[i].equals("./")) {
			} else if (logs[i].equals("../")) {
				if (result != 0) {
					result -= 1;
				}
			} else {
				result++;
			}
		}
		return result;
	}
}
