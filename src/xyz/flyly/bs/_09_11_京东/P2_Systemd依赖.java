package xyz.flyly.bs._09_11_京东;

import java.util.Scanner;

/*
题目描述:
你可能不喜欢systemd,但很可能每天都要面对它 --- Linux 下广泛使用的init程序。
在一个systemd units中，可以使用Requires=...的语法来引入依赖，当服务a引入了服务b作为依赖之后，服务a启
动时b会随之启动，b停止时a会随之停止。本题会给你n个服务和它们之间的依赖关系，一开始所有服务都处于停止状态，
然后进行若干次启动和停止操作，你需要在每一次操作后输出当前正在运行的服务数量。假设所有服务都能稳定运行、正常启
动和退出。为了简化输入，所有服务名使用序号(1~n) 代替。可以启动正在运行的程序，也可以停止已经停止的程序，这样
的操作将不会造成任何变化。
输入描述
第一行两个空格隔开的整数n, q,表示服务的数量和询问的数量，1 <= n,q <= 500。
下面n行，其中的第i行第一个整数 c表示第i个服务所依赖的服务数量，后面c个整数表示它所依赖的各个服务，保
证这c个整数在1~n范围内，互不相等且都不等于i。
下面q行，每行两个空格隔开的整数x,y。x为1或0，1表示启动服务，0表示停止服务。y表示启动或停止的服务的
序号。
输出描述
q行，每行一个整数，表示每次操作后这n个服务中正在运行的服务数量。
样例输入：
3 2
1 2
1 3
0
1 1
0 2
输出：
3
1
 */
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
