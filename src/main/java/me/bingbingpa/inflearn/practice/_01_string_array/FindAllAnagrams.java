package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static void main(String[] args) {
        FindAllAnagrams findAllAnagrams = new FindAllAnagrams();
        String text = "BACDGABCDA";
        String pattern = "ABCD";
        System.out.println("result ================ " + findAllAnagrams.solution2(text, pattern));
    }

    /**
     * TODO input text 배열에서 패턴 배열이 시작되는 인덱스를 찾아라.
     * 패턴 배열의 순서는 상관없다.
     * 예) input: txt ="BACDGABCDA", pattern="ABCD", output:[0,5,6]
     */
//    public List<Integer> solution1(String txt, String pat) {
//        List<Integer> result = new ArrayList<>();
//        int patSum = 0;
//        for (int i = 0; i < pat.length(); i++) {
//            patSum += pat.charAt(i);
//        }
//
//        int txtSum = 0;
//        for (int i = 0; i < txt.length() - pat.length(); i++) {
//            for()
//            txtSum += txt.charAt(i);
//            if (patSum == txtSum) {
//                result.add(i+1- pat.length());
//                txtSum = 0;
//            }
//        }
//
//        return result;
//    }


    public List<Integer> solution2(String txt, String pat) {
        List<Integer> result = new ArrayList<>();
        if (txt == null || txt.length() == 0 || pat == null || pat.length() == 0 || txt.length() < pat.length()) {
            return result;
        }

        int[] patArr = new int[256];
        for (int i = 0; i < pat.length(); i++) {
            patArr[pat.charAt(i)] = 1;
        }

        for (int i = 0; i < txt.length()- pat.length()+1; i++) {
            int[] txtArr = new int[256];
            for (int j = 0; j < pat.length(); j++) {
                txtArr[txt.charAt(i + j)] = 1;
            }

            if (check(patArr, txtArr)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean check(int[] patArr, int[] txtArr) {
        for (int i = 0; i < patArr.length; i++) {
            if (patArr[i] != txtArr[i]) {
                return false;
            }
        }
        return true;
    }
}
