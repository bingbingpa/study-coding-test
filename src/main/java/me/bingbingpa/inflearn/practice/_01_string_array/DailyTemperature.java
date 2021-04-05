package me.bingbingpa.inflearn.practice._01_string_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("result ================== " + Arrays.toString(dailyTemperature.solution2(temperatures)));
    }

    /**
     * TODO 주어진 온도 배열에서 더 따뜻한 날까지의 인덱스를 배열로 리턴하라.
     *  더 따뜻한 날이 없다면 0 을 넣는다.
     *  참고: 온도 배열의 길이는 1 ~ 30000, 각 온도의 범위는 30 ~ 100
     * 예) input: [73, 74, 75, 71, 69, 72, 76, 73], output: [1, 1, 4, 2, 1, 1, 0, 0]
     */
    public int[] solution1(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int length = temperatures.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    result[i] = j - i;
                    break;
                } else {
                    result[i] = 0;
                }
            }
        }

        return result;
    }

    public int[] solution2(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        int length = temperatures.length;

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

            return result;
    }
}
