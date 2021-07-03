package me.bingbingpa.inflearn.taewon._05_stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ClawCraneGame {
    //    public static void main(String[] args) {
//        ClawCraneGame T = new ClawCraneGame();
//        int[][] board = {
//                {0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 3},
//                {0, 2, 5, 0, 1},
//                {4, 2, 4, 4, 2},
//                {3, 5, 1, 3, 1}
//        };
//        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
//
//        System.out.println(T.mySolution(board, moves));
//    }
    public static void main(String[] args) {
        ClawCraneGame T = new ClawCraneGame();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        int m = scanner.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = scanner.nextInt();
        }
        System.out.println(T.solution(board, moves));
    }

    /**
     * TODO 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
     * 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.
     */
    public int mySolution(int[][] board, int[] moves) {
        boolean testExecutable = false;
        if (testExecutable) {
            testGetDoll();
        }

        return _mySolution(board, moves);
    }

    public int _mySolution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(getDoll(board, 0, moves[0] - 1));

        for (int i = 1; i < moves.length; i++) {
            int num = moves[i];
            int target = getDoll(board, 0, num - 1);
            if (target == 0) {
                continue;
            }
            if (!deque.isEmpty() && target == deque.peek()) {
                answer += 2;
                deque.pop();
            } else {
                deque.push(target);
            }
        }

        return answer;
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][pos - 1] != 0) {
                    int temp = board[i][pos - 1];
                    board[i][pos - 1] = 0;
                    if (!stack.isEmpty() && temp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(temp);
                    }
                    break;
                }
            }
        }

        return answer;
    }

    private int getDoll(int[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return 0;
        }
        if (board[row][col] != 0) {
            int result = board[row][col];
            board[row][col] = 0;

            return result;
        }


        return getDoll(board, row + 1, col);
    }

    private void testGetDoll() {
        String testMethod = "testGetDoll";
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        assertThat(testMethod, "0", getDoll(board, 0, 0) == 4);
        assertThat(testMethod, "1", getDoll(board, 0, 1) == 2);
        assertThat(testMethod, "2", getDoll(board, 0, 2) == 1);
        assertThat(testMethod, "3", getDoll(board, 0, 3) == 4);
        assertThat(testMethod, "4", getDoll(board, 0, 4) == 3);

        print(board);

    }

    private void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" [" + i + "]" + "[" + j + "]===" + board[i][j]);
            }
            System.out.println();
        }
    }

    private void assertThat(String testMethod, String input, boolean expected) {
        String testMessage = "testMethod: " + testMethod + "input : " + input;
        if (expected) {
            System.out.println(testMessage);
        } else {
            System.err.println(testMessage);
        }
    }
}
