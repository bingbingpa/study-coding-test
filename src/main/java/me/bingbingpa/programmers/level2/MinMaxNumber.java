package me.bingbingpa.programmers.level2;

public class MinMaxNumber {

    public static void main(String[] args) {
        MinMaxNumber T = new MinMaxNumber();
        System.out.println(T.solution("1 2 3 4"));
    }

    /**
     * 최댓값과 최솟값
     * https://programmers.co.kr/learn/courses/30/lessons/12939
     */
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] strs = s.split(" ");
        for (String str : strs) {
            int num = Integer.parseInt(str);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return min + " " + max;
    }
}
