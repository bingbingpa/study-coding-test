package me.bingbingpa.inflearn.practice._03_queue_stack;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        String[] strs = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println("result ================== " + baseballGame.solution(strs));
    }

    /**
     * TODO 주어진 오퍼레이션을 이용한 연산 결과를 리턴하라.
     * 1: The sum is: 5.
     * 2: -2 points. The sum is: 3.
     * 3: 4 points. The sum is: 7.
     * C: 3번 데이터 삭제. The sum is: 3.
     * 4: 2번의 -2 값 더블 -4을 얻는다 -4+3=-1. The sum is: -1.
     * 5: 9 points. The sum is: 8.
     * 6: -4 + 9 = 5 points. The sum is 13.
     * 7: 9 + 5 = 14 points. The sum is 27.
     */
    public int solution(String[] strs) {
        Stack<Integer> stack = new Stack<>();

        for (String op : strs) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y);
                    stack.push(x);
                    stack.push(x + y);
                    break;
                default:
                    stack.push(Integer.valueOf(op));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
