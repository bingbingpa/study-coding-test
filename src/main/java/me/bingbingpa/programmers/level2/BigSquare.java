package me.bingbingpa.programmers.level2;

public class BigSquare {

    public static void main(String[] args) {
        BigSquare T = new BigSquare();
        int[][] board = new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        System.out.println(T.solution(board));
    }

    /**
     * 가장 큰 정사각형 찾기
     * https://programmers.co.kr/learn/courses/30/lessons/12905
     */
    public int solution(int[][] board) {
        int[][] newBoard = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                newBoard[i + 1][j + 1] = board[i][j];
            }
        }

        int max = 0;

        for (int i = 1; i < newBoard.length; i++) {
            for (int j = 1; j < newBoard[i].length; j++) {
                if (newBoard[i][j] == 1) {
                    int left = newBoard[i - 1][j];
                    int up = newBoard[i][j - 1];
                    int leftUp = newBoard[i - 1][j - 1];
                    int min = Math.min(left, Math.min(up, leftUp));
                    newBoard[i][j] = min + 1;
                    max = Math.max(max, min + 1);
                }
            }
        }

        return max * max;
    }
}
