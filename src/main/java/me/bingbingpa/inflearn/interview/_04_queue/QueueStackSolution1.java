package me.bingbingpa.inflearn.interview._04_queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStackSolution1 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) {
        QueueStackSolution1 stack = new QueueStackSolution1();
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

        return q1.poll();
    }

    private void push(int number) {
        q2.offer(number);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}
