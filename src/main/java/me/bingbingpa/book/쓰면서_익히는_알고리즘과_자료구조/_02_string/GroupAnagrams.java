package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._02_string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println("result ================ " + solution(new String[]{"eat", "repaid", "paired", "tea", "bat"}));
    }

    /**
     * TODO 주어진 문자열을 검사해 서로 같은 애너그램을 가지는 문자열을 그룹으로 묶어 리턴하라.
     * 예) input: ['eat','repaid','paired','tea','bat'], output: [['eat','tea'],['repaid','paired'],['bat']]
     */
    public static List<List<String>> solution(String[] strs) {
        // 시간 복잡도: O(N*LlogL) n 은 문자열 총개수, L 은 문자열 중 가장 긴 문자열 길이
        // 공간 복잡도: O(N*L)
        List<List<String>> result = new ArrayList<>();
        if (strs == null | strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        result.addAll(map.values());

        return result;
    }
}
