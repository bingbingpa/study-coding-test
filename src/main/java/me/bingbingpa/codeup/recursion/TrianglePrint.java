package me.bingbingpa.codeup.recursion;

public class TrianglePrint {
    public static void main(String[] args) {
        solution(5);
    }

    /**
     * TODO n 이 입력되면 다음과 같은 삼각형을 출력하시오.
     * n 이 5 이면
     * *
     * **
     * ***
     * ****
     * *****
     */
    public static void solution(int num) {
        StringBuilder sb = new StringBuilder();
        recursion(1, num, sb);
    }

    private static void recursion(int start, int end, StringBuilder sb) {
        if (start > end) {
            return;
        }
        sb.append('*');
        System.out.println(sb);
        recursion(start + 1, end, sb);
    }
}
