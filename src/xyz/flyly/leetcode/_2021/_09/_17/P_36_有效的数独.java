package xyz.flyly.leetcode._2021._09._17;

import java.util.HashSet;
import java.util.Set;

public class P_36_有效的数独 {
    public static void main(String[] args) {

    }

    /**
     * 该种解法无法解决 3x3 格子的重复
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // H  L
        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(i + "H" + board[i][j])) {
                        return false;
                    }
                    if (!set.add(j + "L" + board[i][j])) {
                        return false;
                    }
                }

            }
        }
        return true;

    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[][] rows = new int[9][9];
            int[][] columns = new int[9][9];
            int[][][] subboxes = new int[3][3][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c != '.') {
                        int index = c - '0' - 1;
                        rows[i][index]++;
                        columns[j][index]++;
                        subboxes[i / 3][j / 3][index]++;
                        if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
