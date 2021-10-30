package xyz.flyly.bs._10_24_360;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
题目描述:
小A的英语考了个不及格，老师很生气，并且发现他英语的语法几乎全错!于是老师决定好好教教他英语语法。
老师想先从句子结构开始教他。个句子至少需要包含主谓结构， 即主语和谓语，并且主语在前，谓语在后。有些句子会在谓
语后面加上宾语。避免复杂，本题中句子的顺序严格按照主语-谓语宾语的顺序(即无宾语前置和倒装等情况)。
老师给了小A三张单词表，分别是主语单词表、谓语单词表和宾语单词表。老师要让小A用这些单词表中的单词来造句，并且
规定:谓语有且仅有一个单词，主语和宾语可以包含任意个单词(主语不可为空)。老师暂时不想让小A造出能保证意思通顺的
句子，他只想让小A能够学会基本的句子结构就行。
现在，小A根据这些单词造了m条句子，现在假设你是老师，你需要判断每条句子是否符合上述句子结构。

输入描述
第一行三个正整数n1.n2.n3.分别表示主语，谓语、宾语单词表的单词数:
第二行包含n1个单词，单词仅由小写英文字母组成，每两个单词之间有一个空格，单词长度不超过10;
第三行包含n2个单词，其他格式同上:
第四行包含n3个单词，其他格式同上;
第五行一个正整数m;
接下来m行，每行一个句子。句子由若干单词(至少一个)组成，并且保证出现的单词都在上面的单词表内。每两个单
词之间一个空格隔开。
数据保证一个单词最多只可做一种句子成分。即每个单词仅会出现在一个单词表 上。
1<= n1,n2,n3 <= 1000 , 1 <= m <= 2- , 1<= 句子单词数≤10
输出描述
对于每条句子，如果其符合句子结构，输出一行"YES”(不含引号) ，否则输出一-行"NO”(不含引号)。
样例输入
3 3 3
i you he
am is are
yours his hers
5
i am yours
you is his
he are heres yours
i am am yours
is his
样例输出
YES
YES
YES
NO
NO

提示：
第四个句子谓语含有两个单词，不合法;第五个句子，不含主语，不合法。
 */
public class P1_不及格的小A {
    // ac
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        Set<String> z = new HashSet<>();
        Set<String> w = new HashSet<>();
        Set<String> b = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            z.add(sc.next());
        }
        for (int i = 0; i < n2; i++) {
            w.add(sc.next());
        }
        for (int i = 0; i < n3; i++) {
            b.add(sc.next());
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] arr = sc.nextLine().split(" ");
            // 谓语只能有一个,结构要按照 主 谓 宾  主语和宾语可以多个
            System.out.println(func(arr, z, w, b));
        }

    }

    private static String func(String[] arr, Set<String> z, Set<String> w, Set<String> b) {
        // 第一次必须是主语, 主语出现后,后面可以出现主语和谓语，但谓语只能出现一次,出现谓语后,
        // 后面只能是宾语
        // 0 是只能包含主语   1 主语和谓语   2  宾语
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (s == 0) {
                if (!z.contains(arr[i])) {
                    return "NO";
                } else {
                    s = 1;
                }
            } else if (s == 1) {
                if (w.contains(arr[i])) {
                    s = 2;
                    continue;
                }
                if (!z.contains(arr[i])) {
                    return "NO";
                }
            } else {
                if (!b.contains(arr[i])) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
