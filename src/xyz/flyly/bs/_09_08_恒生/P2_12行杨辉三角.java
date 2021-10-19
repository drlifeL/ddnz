package xyz.flyly.bs._09_08_恒生;

import java.util.Arrays;

public class P2_12行杨辉三角 {
    public static void main(String[] args) {
        // 构建数组
        int[][] arr = new int[12][12];

        for (int i = 0; i < 12; i++) {
            arr[i][0] = arr[i][i] = 1;
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }

        // 打印结果
        for (int i = 0; i < arr.length; i++) {
            //输出杨辉三角数字前的空格
            for (int j = 0; j < arr.length - 1 - i; j++) {
                System.out.print("   ");
            }
            for (int j = 0; j <= i; j++) {
                //打印空格填补空位
                System.out.print("###");
                System.out.printf("%-3d", arr[i][j]);

            }
            System.out.println();
        }

        new P2_12行杨辉三角().print();
    }

    public void print() {
        int[][] arr = new int[12][12];
        for (int i = 0; i < 12; i++) {
            arr[i][0] = arr[i][i] = 1;
        }

        for (int i = 2; i < 12; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }

        // 打印数组
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                System.out.print("   ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("   ");
                System.out.printf("%-3d", arr[i][j]);
            }
            System.out.println();
        }

    }

}
