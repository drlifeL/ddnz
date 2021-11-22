package xyz.flyly.bs._09_12_爱奇艺;

import java.util.Scanner;

/*
题目描述:
我们提供了一个类:
public class FooPrint { public void first( { print("first");} public void second() { print("second");} public void third() { print("third"); }}
三个不同的线程A. B、C将会共用一个FooPrint实例。
一个将会调用first()方法
一个将会调用 second()方法
还有一个将会调用third()方法
请设计修改程序，以确保second()方法在first()方法之后被执行，third() 方法在second()方法之后被执行。
输入描述
整数数组。数组每个元素值表示对应线程调用的方法，对应关系: 1-first(), 2-second(), 3-third().如:
输入[1,3,2]表示线程A将会调用first()方法，线程B将会调用third()方法，线程C将会调用second()方法。
输出描述
按序输出firstsecondthird

样例输出
[1,3,2]
样例输出
firstsecondthird

 */
public class P4_按指定顺序打印 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }

        FooPrint print = new FooPrint();

        Thread t1 = new Thread(() -> {
            if (arr[0] == 1) {
                print.first();
            } else if (arr[0] == 2) {
                print.second();
            } else {
                print.third();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (arr[1] == 1) {
                print.first();
            } else if (arr[1] == 2) {
                print.second();
            } else {
                print.third();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (arr[2] == 1) {
                print.first();
            } else if (arr[2] == 2) {
                print.second();
            } else {
                print.third();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}

class FooPrint {
    public void first() {
        System.out.print("first");
    }

    public void second() {
        System.out.print("second");
    }

    public void third() {
        System.out.print("third");
    }
}
