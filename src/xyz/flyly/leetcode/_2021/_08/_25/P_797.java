package xyz.flyly.leetcode._2021._08._25;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有可能的路径
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 */
public class P_797 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        P_797 m = new P_797();
        m.allPathsSourceTarget(graph);
        System.out.println(m.ans);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        backtracking(0, graph);
        return ans;
    }

    public void backtracking(int sIdx, int[][] graph) {
        // 这里注意了，不能判断以当前数组的长度为空判断为最后一个节点
        if (sIdx == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[sIdx].length; i++) {
            path.add(graph[sIdx][i]);
            backtracking(graph[sIdx][i], graph);
            path.remove(path.size() - 1);
        }
    }


}
