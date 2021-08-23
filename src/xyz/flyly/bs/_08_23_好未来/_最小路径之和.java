package xyz.flyly.bs._08_23_好未来;

/**
 * 使用 dfs 会超时，该题可以转换为一个简单的 dp
 */
public class _最小路径之和 {
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 11
//        int[][] arr = new int[5][4];
//        int[] a1 = new int[]{3, 1, 0, 2};
//        int[] a2 = new int[]{4, 3, 2, 1};
//        int[] a3 = new int[]{5, 2, 1, 0};
//        int[] a4 = new int[]{1, 2, 3, 4};
//        int[] a5 = new int[]{0, 0, 0, 1};
//        arr[0] = a1;
//        arr[1] = a2;
//        arr[2] = a3;
//        arr[3] = a4;
//        arr[4] = a5;
//
//        System.out.println(mindDeep(arr));

//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        for(int i = 0; i < t; i++){
//            String str = scanner.next();
//            valid(str);
//        }
        valid("666");


    }

    public static void valid(String str) {
        if (!((str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') || (str.charAt(0) >= 'a' && str.charAt(0) <= 'z'))) {
            System.out.println("Wrong");
            return;
        }
        boolean hasNum = false;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                hasNum = true;
                continue;
            }
            if (!((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'))) {
                System.out.println("Wrong");
                return;
            }
        }
        if (!hasNum) {
            System.out.println("Wrong");
        } else {
            System.out.println("Accept");
        }
    }

    public static int mindDeep(int[][] arr) {
        res = Integer.MAX_VALUE;
        dfs(0, 0, arr, 0);
        return res;
    }

    public static void dfs(int i, int j, int[][] arr, int sum) {
        if (i == arr.length || j == arr[0].length) return;
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            res = Math.min(res, sum + arr[i][j]);
            return;
        }
        // 向右走
        dfs(i + 1, j, arr, sum + arr[i][j]);
        dfs(i, j + 1, arr, sum + arr[i][j]);
    }


}
