package me.bingbingpa.programmers.level1;

import java.util.Arrays;

public class SecretMap {

    public static void main(String[] args) {
        SecretMap T = new SecretMap();
        System.out.println(Arrays.toString(T.answer(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
    }

    /**
     * 비밀 지도
     * https://programmers.co.kr/learn/courses/30/lessons/17681
     */
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder arr1Str = new StringBuilder();
        StringBuilder arr2Str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            arr1Str.setLength(0);
            arr2Str.setLength(0);
            toBinary(arr1[i], arr1Str);
            toBinary(arr2[i], arr2Str);
            String map1 = " ".repeat(Math.max(0, n - arr1Str.length())) + arr1Str;
            String map2 = " ".repeat(Math.max(0, n - arr2Str.length())) + arr2Str;
            for (int j = 0; j < n; j++) {
                if (map1.charAt(j) == ' ' && map2.charAt(j) == ' ') {
                    temp.append(" ");
                } else {
                    temp.append("#");
                }
            }
            answer[i] = temp.toString();
        }

        return answer;
    }

    public void toBinary(int n, StringBuilder sb) {
        if (n == 1) {
            sb.append("#");
            return;
        }
        if (n == 0) {
            return;
        }
        char divide = n % 2 == 0 ? ' ' : '#';
        toBinary(n / 2, sb);
        sb.append(divide);
    }

    public String[] answer(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
}
