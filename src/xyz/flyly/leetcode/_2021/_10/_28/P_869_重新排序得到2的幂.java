package xyz.flyly.leetcode._2021._10._28;

/**
 * https://leetcode-cn.com/problems/reordered-power-of-2/
 */
public class P_869_重新排序得到2的幂 {
    public static void main(String[] args) {
        System.out.println(new P_869_重新排序得到2的幂().reorderedPowerOf2(61));

    }

    public boolean reorderedPowerOf2(int n) {
        if (isOK(n)) {
            return true;
        }
        return dfs(0, (n + "").toCharArray());
    }

    public boolean dfs(int i, char[] arr) {
        if (i == arr.length) {
            if (arr[0] == '0') return false;
            return isOK(Integer.parseInt(new String(arr)));
        }
        for (int j = i; j < arr.length; j++) {
            swap(i, j, arr);
            if (dfs(i + 1, arr)) {
                return true;
            }
            swap(i, j, arr);
        }
        return false;
    }

    private void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean isOK(int i) {
        return (i & (i - 1)) == 0;
    }


}
