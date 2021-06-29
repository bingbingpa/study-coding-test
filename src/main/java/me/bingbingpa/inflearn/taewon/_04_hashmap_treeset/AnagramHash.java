package me.bingbingpa.inflearn.taewon._04_hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramHash {
//    public static void main(String[] args) {
//        AnagramHash T = new AnagramHash();
//        System.out.println(T.mySolution("abaCC", "Caaab"));
//    }

    public static void main(String[] args) {
        AnagramHash T = new AnagramHash();
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        System.out.println(T.mySolution(str1, str2));
    }

    /**
     * TODO 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.
     * 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
     * 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
     */
    public String mySolution(String str1, String str2) {
        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str2.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return "NO";
            }
            map.put(ch, map.get(ch) - 1);
        }

        return answer;
    }
}
