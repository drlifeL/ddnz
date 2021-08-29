package xyz.flyly.bs._08_28_tw;

public class P_计算重复 {
    public static void main(String[] args) {

    }

    public static int test(String str, String word) {
        if (str == null || str.length() == 0) return 0;
        String[] arr = str.split(" ");
        word = word.toLowerCase();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toLowerCase().equals(word)) {
                res++;
            }
        }
        return res;
    }
}
