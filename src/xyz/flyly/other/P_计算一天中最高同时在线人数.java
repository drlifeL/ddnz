package xyz.flyly.other;

/**
 * 现在有某个网站的登录和登出记录，求该天中同时在线人数最高的时间点，精确到秒
 * 解法：
 * 一天共有 60 * 60 * 24 = 86400 秒
 * 我们先定义一个 86400 长度的数组，依次读入数据，将该天的时间转换到每个数组中
 * 例如： 10点01分01 秒有人登录 则 数组下标 10 * 60 * 60 + 60 + 1 处 值加 1 , 若该时间点有登出数据，则下标处值 -1
 * 读取完所有的数据后，然后在次遍历数组，统计最高值 例如在 8点1分1秒有一个人 登录， 2 秒有一个登录 3 秒有一个人退出 ，则最高时间点在 8点1分02秒 登录人数为 2 人 ，1秒和 3 秒都只有一个人
 */
public class P_计算一天中最高同时在线人数 {
    public static void main(String[] args) {
        int time[] = new int[60 * 60 * 24];
        // 格式 时 分 秒
        int u1Login = (10 * 60 * 60) + (60 * 0) + 0; // 10点整
        int u1Logout = (10 * 60 * 60) + (60 * 1) + 1; // 10点零一分一秒
        time[u1Login]++;
        time[u1Logout]--;

        int u2Login = (10 * 60 * 60) + (60 * 0) + 0; // 10点整
        int u2Logout = (10 * 60 * 60) + (60 * 2) + 10; // 10点零二分十秒
        time[u2Login]++;
        time[u2Logout]--;

        int u3Login = (10 * 60 * 60) + (60 * 1) + 0; // 10点零一分
        int u3Logout = (10 * 60 * 60) + (60 * 2) + 10; // 10点零二分十秒
        time[u3Login]++;
        time[u3Logout]--;

        int max = 0;
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            res += time[i];
            if (res > max) {
                max = res;
                System.out.println(i);
            }
        }
        System.out.println(max);

    }
}
