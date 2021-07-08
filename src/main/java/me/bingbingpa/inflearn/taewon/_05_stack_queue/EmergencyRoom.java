package me.bingbingpa.inflearn.taewon._05_stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EmergencyRoom {

//    public static void main(String[] args) {
//        EmergencyRoom T = new EmergencyRoom();
//        System.out.println(T.solution(2, new int[]{60, 50, 70, 80, 90}));
//    }

    public static void main(String[] args) {
        EmergencyRoom T = new EmergencyRoom();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(m, arr));
    }

    /**
     * TODO N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램을 작성하세요.
     */
    public int solution(int target, int[] arr) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(new Person(i, arr[i]));
        }

        while (!queue.isEmpty()) {
            Person tmp = queue.poll();
            for (Person x : queue) {
                if (x.priority > tmp.priority) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == target) {
                    return answer;
                }
            }
        }
        return answer;
    }

    static class Person {
        private final int id;
        private final int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
}
