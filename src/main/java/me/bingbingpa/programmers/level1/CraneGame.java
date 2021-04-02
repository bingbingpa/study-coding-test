package me.bingbingpa.programmers.level1;

import java.util.Stack;

public class CraneGame {
    public static void main(String[] args) {
        CraneGame craneGame = new CraneGame();
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println("result ================ " + craneGame.solution(board, moves));
    }

    /**
     * TODO 크레인을 작동하면 해당 라인의 가장 상위에 있는 인형이 무조건 뽑히고, (만약 해당 라인에 인형이 하나도 없으면 아무것도 뽑지 않는다)
     *  인형은 바구니에 담는다. 이 때 인형이 연속으로 2개 있으면 터져서 사라진다.
     *  뽑기판 board 이 주어지고 뽑는 라인의 순서인 moves 이 주어질 때, 터져서 사라진 인형의 갯수를 구해야한다.
     */
    private int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int num = board[i][move - 1];
                if (num != 0) {
                    if (stack.peek() == num) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(num);
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
