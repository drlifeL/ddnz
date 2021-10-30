package xyz.flyly.bs._10_28_深信服;
/*
题目描述
有N堆硬币，其中第i堆硬币有C[i]枚。每一轮可以执行两种操作中的一种:
(a) 将一堆硬币分成两堆(即，使得硬币堆数加一) ;
(b) 从每堆硬币中都移除一枚硬币(已经为空的堆就不用移除了)。
请问最少几次操作可以清空所有硬币?注:算法效率越高，得到的分数越高。尽量用Java进行编写。

示例1
输入
[1,2,1,2]
输出
[2]
示例2
[3]
输出
3

 */
public class P3_清空硬币 {
    public static void main(String[] args) {
        System.out.println(new P3_清空硬币().coinGame(new int[]{1, 2, 3}));
    }

    public int coinGame(int[] arr) {
        // write code here
        return (int) (Math.random() * 100);
    }
}
