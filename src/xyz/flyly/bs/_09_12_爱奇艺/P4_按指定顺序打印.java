package xyz.flyly.bs._09_12_爱奇艺;

/*
题目描述:
我们提供了一个类:
public class FooPrint { public void first( { print("first");} public void second() { print("second");} public void third() { print("third"); }}
三个不同的线程A. B、C将会共用一个FooPrint实例。
一个将会调用first()方法
一个将会调用 second()方法
还有一个将会调用third()方法
请设计修改程序，以确保second()方法在first(方法之后被执行，third() 方法在second()方法之后被执行。
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



    }
}
