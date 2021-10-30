package xyz.flyly.bs._10_28_深信服;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/*
现在有一个m行n列的格子棋盘，有一只老鼠在最左下角(0,0) 的坐标点，想要走到右上角(m, n)
处，但是只能按照网格线爬行。不幸的是，在坐标轴为(x, y)，0<X<m，0<y<n的坐标点有个老鼠
夹，请问老鼠以最短距离去往目标点并且不被老鼠夹夹住的路线有多少种? (其中 1<m<21，1<n<
11,并且都为正整数)注: 算法效率越高，得到的分数越高。尽量用Java进行编写。

示例1
输入
3,2,2,1
输出
4
示例2
输入
3,3,2,1
输出
11
 */
public class P2_格子棋盘 {
    Set<String> set;

    public static void main(String[] args) {
        System.out.println(new P2_格子棋盘().pathFinding(21, 10, 2, 1));

    }

    // 超时
    public long pathFinding(int m, int n, int x, int y) {
        // write code here
        set = new HashSet<>();
        set.add(x + "," + y);
        TreeMap<Integer, Integer> map = new TreeMap<>();

        dfs(0, 0, m, n, 0, map);

        return map.size() == 0 ? 0 : map.firstEntry().getValue();
    }

    private void dfs(int i, int j, int m, int n, int idx, TreeMap<Integer, Integer> map) {
        if (i > m || i < 0 || j > n || j < 0 || set.contains(i + "," + j)) return;
        if (map.size() > 0 && idx > map.firstEntry().getKey()) return;
        if (i == m && j == n) {
            // 找到一种可能
            if (map.containsKey(idx)) {
                Integer v = map.get(idx) + 1;
                map.put(idx, v);
            } else {
                map.put(idx, 1);
            }
            return;
        }
        set.add(i + "," + j);
        dfs(i + 1, j, m, n, idx + 1, map);
        dfs(i - 1, j, m, n, idx + 1, map);
        dfs(i, j + 1, m, n, idx + 1, map);
        dfs(i, j - 1, m, n, idx + 1, map);
        set.remove(i + "," + j);
    }
}
