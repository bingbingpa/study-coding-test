package me.bingbingpa.programmers.codingtest;

public class StrSearch {
    public static void main(String[] args) {
        StrSearch T = new StrSearch();
        System.out.println(T.solution("aaaaabbbbb", "ab"));  //5
    }

    /**
     * 타겟 문자열 찾기
     */
    public int solution(String s, String t) {
        int count = 0;
        int targetLength = t.length();

        int index = 0;
        while (index <= s.length() - targetLength) {
            if (s.substring(index, targetLength + index).equals(t)) {
                s = s.substring(0, index) + s.substring(targetLength + index);
                count++;
                index = 0;
            } else {
                index++;
            }
        }

        return count;
    }
}
//    찾아 바꾸기