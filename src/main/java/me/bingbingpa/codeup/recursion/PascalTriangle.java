package me.bingbingpa.codeup.recursion;

public class PascalTriangle {
    private static int[][] pascal = new int[51][51];

    public static void main(String[] args) {
        System.out.println("result ============ " + solution(44, 10)); // 3
    }

    /**
     * TODO 회전 변환된 파스칼의 삼각형에서 (r행, c열)의 값을 알 수 있는 프로그램을 작성하시오.
     * https://codeup.kr/problem.php?id=3702
     * 자연수 r과 c가 입력된다. (1 ≤ r, c ≤ 50)
     * (r, c)의 원소 값을 100,000,000으로 나눈 나머지를 출력한다.
     */
    public static int solution(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }
        if (pascal[row][col] != 0) {
            return pascal[row][col];
        }

        pascal[row][col] = (solution(row - 1, col) + solution(row, col - 1)) % 100000000;

        return pascal[row][col];
    }
}
