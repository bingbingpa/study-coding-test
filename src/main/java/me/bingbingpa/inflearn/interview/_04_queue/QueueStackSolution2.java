package me.bingbingpa.inflearn.interview._04_queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStackSolution2 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) {
        QueueStackSolution2 stack = new QueueStackSolution2();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop() == 3);
        System.out.println(stack.pop() == 2);
        System.out.println(stack.pop() == 1);

    }

    private Integer pop() {
        if (q1.isEmpty()) {
            return null;
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        Integer result = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return result;
    }

    private void push(int number) {
        q1.offer(number);
    }
}
