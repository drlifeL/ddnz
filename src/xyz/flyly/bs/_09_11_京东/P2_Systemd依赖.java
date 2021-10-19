package xyz.flyly.bs._09_11_京东;

import java.util.Scanner;

public class P2_Systemd依赖 {
    static int[][] arr;
    static int s;
    static boolean[] flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        arr = new int[n + 1][];

        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            if (c == 0) {
                arr[i + 1] = new int[0];
            } else {
                int[] temp = new int[c];
                for (int j = 0; j < c; j++) {
                    temp[j] = sc.nextInt();
                }
                arr[i + 1] = temp;
            }
        }

        // 服务状态
        flag = new boolean[n + 1];
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 1) {
                // 启动服务
                startServer(y);
            } else {
                // 停止服务
                stopServer(y);
            }
            System.out.println(s);
        }

    }

    private static void stopServer(int y) {
        if (flag[y]) {
            flag[y] = false;
            s--;
        }
        int[] temp = arr[y];
        for (int i = 0; i < temp.length; i++) {
            stopServer(temp[i]);
        }

    }

    private static void startServer(int y) {
        // 启动服务
        if (!flag[y]) {// 当前服务是未启动状态，在启动
            flag[y] = true;
            s++;
            int[] temp = arr[y];
            for (int j = 0; j < temp.length; j++) {
                startServer(temp[j]);
            }
        }
    }
}
