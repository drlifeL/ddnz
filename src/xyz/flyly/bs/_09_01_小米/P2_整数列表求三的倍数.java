package xyz.flyly.bs._09_01_小米;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 约瑟夫环问题,不同的是，每次计算完后,会回到起点开始重新计算，直接模拟
public class P2_整数列表求三的倍数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        int i = 0;
        while (arr.size() > 1) {
            i = (i + 2) % arr.size();
            arr.remove(i);
        }
        System.out.println(arr.get(0));

    }

}
