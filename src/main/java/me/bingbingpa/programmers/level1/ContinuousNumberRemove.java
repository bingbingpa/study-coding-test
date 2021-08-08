package me.bingbingpa.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class ContinuousNumberRemove {

    public static void main(String[] args) {
        ContinuousNumberRemove T = new ContinuousNumberRemove();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 3, 3, 0, 1, 1})));

    }

    public int[] solution(int []arr) {
        ArrayList<Integer> tempList = new ArrayList<>();
        int preNum = 10;
        for(int num : arr) {
            if(preNum != num) {
                tempList.add(num);
            }
            preNum = num;
        }
        int[] answer = new int[tempList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = tempList.get(i);
        }
        return answer;
    }
}
