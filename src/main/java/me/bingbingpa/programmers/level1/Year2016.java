package me.bingbingpa.programmers.level1;

import java.time.LocalDate;

public class Year2016 {

    public static void main(String[] args) {
        Year2016 T = new Year2016();
        System.out.println((T.answer(5, 24))); // "TUE"
    }

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/12901
     */
    public String solution(int a, int b) {
        LocalDate date = LocalDate.of(2016, a, b);
        return date.getDayOfWeek().toString().substring(0, 3);
    }

    public String answer(int a, int b) {
        String answer = "";
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int allDate = 0;
        for (int i = 0; i < a - 1; i++) {
            allDate+= date[i];
        }
        allDate += (b - 1);
        answer = day[allDate % 7];

        return answer;
    }
}
