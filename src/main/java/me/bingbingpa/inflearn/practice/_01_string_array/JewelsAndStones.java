package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        System.out.println("result ================ " + jewelsAndStones.solution("aA", "aAAbbbb"));

    }

    /**
     * TODO input 으로 주어진 J 각각의 문자열이 S 문자열에 포함된 수를 구하라.
     * 예) input: J = "aA", S = "aAAbbbb", output: 3
     */
    public int solution(String jew, String stones) {
        Set<Character> set = new HashSet<>();
        for (char jewel : jew.toCharArray()) {
            set.add(jewel);
        }

        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (set.contains(stone)) {
                count++;
            }
        }

        return count;
    }
}
