package me.bingbingpa.inflearn.taewon._05_stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CurriculumDesign {

//    public static void main(String[] args) {
//        CurriculumDesign T = new CurriculumDesign();
//        System.out.println(T.mySolution("CBA", "CBDAGE"));
//    }

    public static void main(String[] args) {
        CurriculumDesign T = new CurriculumDesign();
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        String course = scanner.next();
        System.out.println(T.mySolution(target, course));
    }

    /**
     * TODO 필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하세요.
     */
    public String mySolution(String target, String course) {
        boolean testExecutable = false;
        if (testExecutable) {
            testIsValid();
        }

        return _mySolution(target, course);
    }

    public String _mySolution(String target, String course) {
        String answer = "YES";
        if (!isValid(course)) {
            throw new IllegalArgumentException("수업설계의 길이는 30이하여야 합니다.");
        }
        Deque<Character> deque = new ArrayDeque<>();

        for (Character ch : course.toCharArray()) {
            if (target.contains(String.valueOf(ch))) {
                deque.push(ch);
            }
        }

        int index = target.length() - 1;
        while (!deque.isEmpty()) {
            if (deque.pop() != target.charAt(index)) {
                return "NO";
            }
            index--;
        }

        return answer;
    }

    private boolean isValid(String course) {
        return course.length() <= 30;
    }

    private void testIsValid() {
        String testMethod = "testIsValid";
        assertThat(testMethod, "30", isValid("ADCDEADCDEADCDEADCDEADCDEADCDE"));
        assertThat(testMethod, "29", isValid("ADCDEADCDEADCDEADCDEADCDEADCD"));
        assertThat(testMethod, "31", !isValid("ADCDEADCDEADCDEADCDEADCDEADCDEF"));
    }

    private void assertThat(String testMethod, String input, boolean expected) {
        String testMessage = "testMethod: " + testMethod + ", input: " + input;
        if (expected) {
            System.out.println(testMessage);
        } else {
            System.err.println(testMessage);
        }
    }
}
