package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._04_stack_recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        System.out.println("result =========== " + solution1("abc"));
    }

    /**
     * TODO 주어진 문자열의 가능한 치환을 모두 출력하라.
     */
    public static List<String> solution1(String str) {
        List<String> ans = new ArrayList<>();
        if (str.length() == 1) {
            ans.add(str);
            return ans;
        }

        char curr = str.charAt(0);
        str = str.substring(1);
        List<String> words = solution1(str);

        for (String sub : words) {
            for (int i = 0; i < sub.length()+1; i++) {
                ans.add(sub.substring(0, i) + curr + sub.substring(i));
            }
        }

        return ans;
    }
}
