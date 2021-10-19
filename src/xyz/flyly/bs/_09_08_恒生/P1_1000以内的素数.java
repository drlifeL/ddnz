package xyz.flyly.bs._09_08_恒生;

/**
 * 输出 1000 以内的素数,每 8 个换一行
 */
public class P1_1000以内的素数 {
    public static void main(String[] args) {
        int c = 1;
        for (int i = 2; i <= 1000; i++) {
            boolean f = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    f = false;
                    break;
                }
            }
            if (f) {
                if (c % 8 == 0) {
                    System.out.println(i);
                } else {
                    System.out.print(i + " ");
                }
                c++;
            }
        }
    }
}
