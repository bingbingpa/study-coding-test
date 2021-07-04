package me.bingbingpa.programmers.codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxStrSplit {
    public static void main(String[] args) {
        MaxStrSplit T = new MaxStrSplit();
        System.out.println(Arrays.toString(T.solution("abcxyqwertyxyabc")));  //["abc","xy","asdf","asdf","xy","abc"]
    }

    /**
     * 문자열 최대 자르기(못품...)
     */
    public String[] solution(String s) {
        String[] answer = {};
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            int lastIndex = s.lastIndexOf(s.charAt(index));
            if (lastIndex != -1) {
                int splitRange = s.length() - lastIndex;
                System.out.println(s.substring(index, splitRange));
                s = s.substring(splitRange, lastIndex);
                index = 0;
            } else {
                index++;
            }
        }
        return answer;
    }
}


//    s	result
//"abcxyasdfasdfxyabc"	["abc","xy","asdf","asdf","xy","abc"]
//        "abcxyqwertyxyabc"	["abc","xy","qwerty","xy","abc"]
//        "abcabcabcabc"	["abc","abc","abc","abc"]
//        "llttaattll"	["l","l","t","t","a","a","t","t","l","l"]
//        "zzzzzz"	["z","z","z","z","z","z"]
//        "abcdef"	["abcdef"]