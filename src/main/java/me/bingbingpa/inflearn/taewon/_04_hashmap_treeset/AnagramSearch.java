package me.bingbingpa.inflearn.taewon._04_hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramSearch {

//    public static void main(String[] args) {
//        AnagramSearch T = new AnagramSearch();
//        System.out.println(T.mySolution("bacaAacba", "abc"));
//    }

    public static void main(String[] args) {
        AnagramSearch T = new AnagramSearch();
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        System.out.println(T.solution(str1, str2));
    }

    /**
     * TODO S 문자열에서 T 문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
     */
    public int mySolution(String str1, String str2) {
        int answer = 0;
        int target = 0;
        int strSum = 0;
        for (char ch : str2.toCharArray()) {
            target += ch - '0';
        }

        int len = str2.length();
        for (int i = 0; i < len; i++) {
            strSum += str1.charAt(i) - '0';
        }

        int lt = 1;
        for (int i = len; i < str1.length(); i++) {
            if (target == strSum) {
                answer++;
            }
            strSum += str1.charAt(i) - '0';
            strSum -= str1.charAt(lt++) - '0';
        }

        return answer;
    }

    public int solution(String a, String b) {
        int answer = 0;
        Map<Character, Integer> am = new HashMap<>();
        Map<Character, Integer> bm = new HashMap<>();
        for (char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }

        int L = b.length() - 1;
        for (int i = 0; i < L; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = L; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
            if (am.equals(bm)) {
                answer++;
            }
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if (am.get(a.charAt(lt)) == 0) {
                am.remove(a.charAt(lt));
            }
            lt++;
        }

        return answer;
    }
}
