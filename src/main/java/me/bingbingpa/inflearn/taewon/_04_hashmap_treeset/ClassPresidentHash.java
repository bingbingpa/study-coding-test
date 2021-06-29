package me.bingbingpa.inflearn.taewon._04_hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassPresidentHash {
//    public static void main(String[] args) {
//        ClassPresidentHash T = new ClassPresidentHash();
//        System.out.println(T.mySolution("BACBACCACCBDEDE"));
//    }

    public static void main(String[] args) {
        ClassPresidentHash T = new ClassPresidentHash();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str= scanner.next();
        System.out.println(T.mySolution(str));
    }

    /**
     * TODO 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 있을때 누가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
     */
    public char mySolution(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Map.Entry<Character, Integer> entry = map.entrySet().stream()
                .max(Map.Entry.comparingByValue(Integer::compareTo)).orElseThrow(RuntimeException::new);

        return entry.getKey();
    }
}
