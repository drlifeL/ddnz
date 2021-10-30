package xyz.flyly.bs._10_30_神策数据;

import java.util.Scanner;
/*
题目描述：
给出一对整数(x, y),再给出一个整数m,如果x或y中至少有一个数大于等于m,我们就称(x, y)对
m是一个很赞的整数对。例如(6, 6)对5是一个很赞的整数对，(3, 7)对7是一个很赞的整数对，而
(-1, 1)对2则不是。
老王在黑板上写了两个整数(x, y),并且允许你把其中一个数修改成之前两个数的和: x+y。比如最初
黑板上的数是(5, 2),两数和为5+2=7,经过一次修改可以变成(7, 2)或(5, 7)。
接下来老王给出一个整数m,问至少要做多少次上述修改操作，才能使得黑板上的两个数组成的数对是
对m很赞的整数对。
输入描述：
一行包含三个整数，分别是x,y,m
其中x, y是最初写到黑板上的两个整数，取值范围是 int32。
m是老王给出的整数，取值范围是，int32。
输出描述：
至少要做多少次上述修改操作，才能使得黑板上的两个数组成的数对是对 m 很赞的整数对。
如果做多少次操作都不行，那么输出-1
示例：
输入：
1 2 5
输出
2
 */
public class P1_很赞的整数对 {
    // 80%
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int m = sc.nextInt();

        //  x 或者 y 至少有一个数大于等于 m
        // 允许将一个数改变成之前两个数的和
        // 每次都替换小的那个数
        if (x <= 0 && y <= 0 && m > 0) {
            System.out.println(-1);
        } else if (x <= 0 && y <= 0 && m < 0 && x + y < m) {
            System.out.println(-1);
        } else {
            int s = 0;
            while (x < m && y < m) {
                if (x <= y) {
                    x = x + y;
                } else {
                    y = x + y;
                }
                s++;
            }
            System.out.println(s);
        }
    }
}
