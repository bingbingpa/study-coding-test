package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping {
    public static void main(String[] args) {
        FindAnagramsMapping findAnagramsMapping = new FindAnagramsMapping();
        int[] input = new int[]{11, 27, 45, 31, 50};
        int[] find = new int[]{50, 11, 31, 45, 27};
        System.out.println("result ==================== " + Arrays.toString(findAnagramsMapping.solution2(input, find)));
    }

    /**
     * TODO input 으로 주어진 A 배열의 값이 B 배열에 위치하는 인덱스를 배열로 리턴하라.
     * B 배열에 값이 없을 경우는 0
     * 예) input A:[11,27,45,31,50], B:[50,11,31,45,27], output: [1,4,3,2,0]
     *
     */
    public int[] solution(int[] input, int[] find) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[input.length];

        for (int i = 0; i < find.length; i++) {
            map.put(find[i], i);
        }

        for (int i = 0; i < input.length; i++) {
            int key = input[i];
            result[i] = 0;
            if (map.containsKey(key)) {
                result[i] = map.get(key);
            }
        }

        return result;
    }

    public int[] solution2(int[] input, int[] find) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            map.put(find[i], i);
        }

        for (int i = 0; i < input.length; i++) {
            result[i] = map.get(input[i]);
        }

        return result;
    }
}
