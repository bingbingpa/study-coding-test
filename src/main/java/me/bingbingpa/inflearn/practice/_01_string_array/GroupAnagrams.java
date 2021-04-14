package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("result =============== " + groupAnagrams.solution2(list));
    }

    /**
     * 입력으로 주어진 문자열 배열을 같은 문자열로 이루어진 그룹으로 만들어라.
     * 예) input: ["eat", "tea", "tan", "ate", "nat", "bat"], output: ["ate","eat","tea"], ["nat","tan"], ["bat"]
     */
    public List<List<String>> solution(String[] strs) {
        Arrays.sort(strs);
        List<List<String>> result = new ArrayList<>();
        Map<Integer, List<String >> map = new HashMap<>();
        for (String str : strs) {
            int sum = stringSum(str);
            if (!map.containsKey(sum)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sum, list);
                result.add(list);
            } else {
                map.get(sum).add(str);
            }
        }
        return result;
    }

    public List<List<String>> solution2(String[] strs) {
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

    private int stringSum(String str) {
        int result = 0;
        for (char ch : str.toCharArray()) {
            result += ch;
        }

        return result;
    }
}
