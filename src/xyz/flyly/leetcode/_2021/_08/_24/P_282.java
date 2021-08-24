package xyz.flyly.leetcode._2021._08._24;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P_282 {


    public static void main(String[] args) {

        System.out.println(new P_282().addOperators("105", 5));

//        new MySolution().addOperators()
    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        addOperatorsHelper(num, target, result, new StringBuilder(), 0, 0, 0);
        return result;
    }

    private void addOperatorsHelper(String num, int target, List<String> result, StringBuilder path, int sIdx, long eval, long pre) {
        if (sIdx == num.length()) {
            if (target == eval) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = sIdx; i < num.length(); i++) {
            if (num.charAt(sIdx) == '0' && i > sIdx) {
                break;
            }
            // 获取当前值 --> 这样就实现了递增的取值
            long cur = Long.parseLong(num.substring(sIdx, i + 1));
            int len = path.length();
            if (sIdx == 0) {
                // 第一次只加数字
                addOperatorsHelper(num, target, result, path.append(cur), i + 1, eval + cur, cur);
                path.setLength(len);
            } else {
                // 加法
                addOperatorsHelper(num, target, result, path.append('+').append(cur) , i + 1, eval + cur, cur);
                path.setLength(len);
                // 减法
                addOperatorsHelper(num, target, result, path.append('-').append(cur), i + 1, eval - cur, -cur);
                path.setLength(len);
                // 乘法 有两点不同

                // 当前的值就是先减去 之前的值，然后在加上当前的值和前面的值相乘的结果 1 + 2 * 3   ==> e=3 c=2  (3 - 2) + (2 * 3)

                //另外 addOperatorsHelper 函数传进 pre 参数需要是 pre * cur
                //比如前边讲的 2+ 3 * 4 * 5 这种连乘的情况
                addOperatorsHelper(num, target, result, path.append('*').append(cur), i + 1, eval - pre + pre * cur, pre * cur);
                path.setLength(len);
            }
        }

    }

    /**
     * P_282 main = new P_282();
     * // 该种解法存在错误，其余大部分正确，但是效率太低，因为是最后才去计算表达式的值，这里就降低了效率
     * main.addOperators("123456789", 45);
     * System.out.println(main.ans);
     */
    static class MySolution {
        List<String> ans = new ArrayList<>();

        public List<String> addOperators(String num, int target) {
            if (num == null || num.length() == 0) {
                return ans;
            }
            char[] opt = {'+', '-', '*'};
            dfs(1, num, num.charAt(0) + "", opt, target);
            return ans;
        }

        public boolean hasFrontZero(String str) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if ((c == '+' || c == '-' || c == '*') && i < str.length() - 1 && str.charAt(i + 1) == '0') {
                    return true;
                }

            }
            return false;
        }


        public int js2(String str) {
            Stack<Integer> nums = new Stack<>();
            Stack<Character> opt = new Stack<>();

            int i = 0;
            while (i < str.length()) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    int x = 0;
                    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                        x = x * 10 + (str.charAt(i) - '0');
                        i++;
                    }
                    nums.push(x);
                } else {
                    if (str.charAt(i) == '*') {
                        i++;
                        int x = 0;
                        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                            x = x * 10 + (str.charAt(i) - '0');
                            i++;
                        }
                        nums.push(nums.pop() * x);
                    } else {
                        opt.push(str.charAt(i));
                        i++;
                    }
                }
            }
            while (opt.size() > 0) {
                Character c = opt.pop();
                if (c == '+') {
                    nums.push(nums.pop() + nums.pop());
                } else {
                    int x = nums.pop();
                    int y = nums.pop();
                    nums.push(y - x);
                }
            }

            return nums.pop();

        }

        public void dfs(int sIdx, String str, String res, char[] opt, int target) {
            if (sIdx == str.length()) {
                if (res.contains("+") || res.contains("-") || res.contains("*")) {
                    if (js2(res) == target) {
                        ans.add(res);
                    }
                }
                return;
            }
            for (int i = 0; i < opt.length; i++) {
                dfs(sIdx + 1, str, (res + opt[i] + str.charAt(sIdx)), opt, target);
            }
            // 不能有前导 0
            if (hasFrontZero(res)) {
                return;
            }

            dfs(sIdx + 1, str, (res + str.charAt(sIdx)), opt, target);
        }


    }
}
