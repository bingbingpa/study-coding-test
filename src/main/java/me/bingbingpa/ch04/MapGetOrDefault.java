package me.bingbingpa.ch04;

import java.util.HashMap;
import java.util.Map;

public class MapGetOrDefault {
    /**
     * ===================Problem===================
     * - 주어진 문자열에서 반복되지 않는 첫 번째 문자를 찾아서 Index 를 return 합니다
     * - 존재하지 않으면 -1을 반환합니다.
     * ===================Example===================
     * String s = "inflearninlove"
     * ===================Note===================
     * 문자열에 영문 소문자 만 포함.
     * 1. 생각=문자열을 for 각 문자다 개수를 파악
     * 2. i=2, n=2, f=1, l=2
     * 3. 첫번째 나오는 값이 1인 map.put(ch, map.getOrDefault(ch,0)+1));
     * Ch 라는 키
     * Ch가 존재하면 ch의 기존값을 가져온다,
     * Ch가 존재 안하면 0 을 가져온다
     * Default value +1
     */
    public static void main(String[] args) {
        String s = "inflearninlove";
        System.out.println("result ============== " + solve(s));
    }

    public static int solve(String s) {
        // 1. error check
        if (s == null || s.length() == 0) {
            return -1;
        }
        // 2. 담을 그릇 Data structure
        Map<Character, Integer> map = new HashMap<>();

        // 3. for, while
        for (char ch : s.toCharArray()) {
//            if (!map.containsKey(ch)) {
//                map.put(ch, 1);
//            } else {
//                map.put(ch, map.get(ch) + 1);
//            }
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
