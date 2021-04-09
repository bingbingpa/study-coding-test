package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class LongestSubMostTwoDist {
    public static void main(String[] args) {
        LongestSubMostTwoDist main = new LongestSubMostTwoDist();
        System.out.println("result ================ " + main.solution1("ccaabbb"));

    }

    /**
     * TODO 최대 2 개의 가장 긴 부분 문자열의 길이를 리턴하라.
     * 예) input: "ccaabbb", output: 5
     */
    public int solution1(String str) {
        if (str.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        int result = 0;
            for (Character ch : map.keySet()) {
                if (count == 2) {
                    break;
                }
                result += map.get(ch);
                count++;
            }

        return result;
    }

    public int solution2(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int length = 0;
        int counter = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (end < str.length()) {
            char endChar = str.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            if (map.get(endChar) == 1) {
                counter++;
            }
            end++;
            while (counter > 2) {
                char startChar = str.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    counter--;
                }
                start++;
            }
            length = Math.max(length, end - start);
        }

        return length;
    }
}