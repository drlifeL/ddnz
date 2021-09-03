package xyz.flyly.bs._09_01_小米;

import java.util.Scanner;

// so easy 麻烦只麻烦输入的处理上
public class P1_两个有序数组合并 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        String[] arr = in.split(",");
        int m = Integer.parseInt(arr[0].split("=")[1]);
        int n = Integer.parseInt(arr[1].split("=")[1]);
        String[] mStr = sc.next().split(",");
        String[] nStr = sc.next().split(",");
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            int m1 = Integer.parseInt(mStr[i]);
            int n1 = Integer.parseInt(nStr[j]);
            if (m1 <= n1) {
                System.out.print(m1 + " ");
                i++;
            } else {
                System.out.print(n1 + " ");
                j++;
            }
        }

        while (j < nStr.length) {
            System.out.print(nStr[j++] + " ");
        }

        while (i < mStr.length) {
            System.out.println(mStr[i++] + " ");
        }
    }
}
