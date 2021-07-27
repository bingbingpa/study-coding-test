package me.bingbingpa.programmers.level1;

import java.util.Arrays;

public class NotCompletePlayer {

    public static void main(String[] args) {
        NotCompletePlayer T = new NotCompletePlayer();
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};

        System.out.println(T.solution(participant, completion));
    }

    /**
     * TODO participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
     * https://programmers.co.kr/learn/courses/30/lessons/42576
     */
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length-1];
    }
}
