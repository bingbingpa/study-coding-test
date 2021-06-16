package me.bingbingpa.inflearn.taewon.section1;

import java.util.Scanner;

public class ShortestDistance {
//    public static void main(String[] args) {
//        ShortestDistance T = new ShortestDistance();
//        System.out.println(Arrays.toString(T.solution("teachermode", 'e')));
//    }

    public static void main(String[] args) {
        ShortestDistance T = new ShortestDistance();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);
        for (int x : T.solution(str, c)) {
            System.out.print(x + " ");
        }
    }

    /**
     * TODO 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
     * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
     * 문자열의 길이는 100을 넘지 않는다.
     */
    public int[] solution(String str, char target) {
        boolean testExecutable = false;
        if (testExecutable) {
            testIsValid();
            testFindByTarget();
        }
        return _mySolution(str, target);
    }

    private int[] _mySolution(String str, char target) {
        checkArgument(str, target);
        int[] answer = new int[str.length()];
        int p = 1000;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == target) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }
        p = 1000;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == target) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }

    private void checkArgument(String str, char target) {
        if (isValid(str)) {
            throw new IllegalArgumentException("문자열의 길이는 0 보다 크고 100보다 작아야 합니다.");
        }
        if (!findByTarget(str, target)) {
            throw new IllegalArgumentException("찾는 문자가 문자열에 존재하지 않습니다.");
        }
    }

    private boolean findByTarget(String str, char target) {
        return str.indexOf(target) != -1;
    }

    private boolean isValid(String str) {
        return str.length() == 0 || str.length() > 100;
    }

    private void testIsValid() {
        String maxInput = "tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt";
        System.out.println(" expected: true," + " result: " + isValid(maxInput) + " input: " + maxInput);
        System.out.println(" expected: true," + " result: " + isValid("") + " input: " + "");
    }

    private void testFindByTarget() {
        System.out.println(" expected: true," + " result: " + findByTarget("teachermode", 'e') + " input: " + "teachermode, e");
        System.out.println(" expected: false," + " result: " + findByTarget("teachermode", 'z') + " input: " + "teachermode, e");
    }
}
