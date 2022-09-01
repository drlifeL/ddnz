package xyz.flyly.leetcode._2022._08._30;

import java.util.*;

/**
 * https://leetcode.cn/problems/parallel-courses-ii/
 *
 * @author : luoyang
 * @since : 2022/8/30 16:37
 **/
public class P_1494_并行课程II {

	public static void main(String[] args) {
//		int n = 4;
//		int[][] dependencies = {{2, 1}, {3, 1}, {1, 4}};
//		int k = 2;

//		int n = 5;
//		int[][] dependencies = {{2, 1}, {3, 1}, {4, 1}, {1, 5}};
//		int k = 2;
//
//		int n = 11;
//		int[][] dependencies = {};
//		int k = 2;

		int n = 13;
		int[][] dependencies = {{12, 8}, {2, 4}, {3, 7}, {6, 8}, {11, 8}, {9, 4}, {9, 7}, {12, 4}, {11, 4}, {6, 4}, {1, 4}, {10, 7}, {10, 4}, {1, 7}, {1, 8}, {2, 7}, {8, 4}
				, {10, 8}, {12, 7}, {5, 4}, {3, 4}, {11, 7}, {7, 4}, {13, 4}, {9, 8}, {13, 8}
		};
		int k = 9;

		int result = new P_1494_并行课程II().minNumberOfSemesters(n, dependencies, k);


		System.out.printf("result is %d %n", result);

	}

	/**
	 * @param n         课程数目
	 * @param relations 依赖关系 [x1,y1] -> 表示 x1 必须在 y1 之前上
	 * @param k         1 学期最多上 k 门课
	 * @return 几学期可以上完课
	 */
	public int minNumberOfSemesters(int n, int[][] relations, int k) {
		Map<Integer, Set<Integer>> relationMap = new HashMap<>();

		// 初始化节点
		for (int i = 1; i <= n; i++) {
			Set<Integer> set = new HashSet<>();
			relationMap.put(i, set);
		}

		// 建立关联关系
		for (int[] relation : relations) {
			Set<Integer> set = relationMap.get(relation[1]);
			set.add(relation[0]);
		}

		int result = 0;

		int i = 0;

		// 解决顺序
		while (n != 0) {
			for (Integer key : relationMap.keySet()) {
				if (relationMap.get(key).size() == 0) {
					// remove Node
					n--;
					System.out.println(key);
					// remove 依赖
					Collection<Set<Integer>> sets = relationMap.values();
					for (Set<Integer> set : sets) {
						set.remove(key);
					}
					relationMap.remove(key);
					i++;
					if (i % k == 0) {
						result ++;
					}
					break;
				}
			}
		}
		return result;
	}

}
