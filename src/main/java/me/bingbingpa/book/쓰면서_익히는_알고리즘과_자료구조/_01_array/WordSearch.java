package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._01_array;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        String word = "ABFE"; // output: true
//        String word = "BFEE"; // output: true
//        String word = "BFSE"; // output: false
        String word = "BFST"; // output: false
        System.out.println("result ============ " + solution(board, word));
    }

    /**
     * TODO 2차원 문자 배열과 단어 문자열이 주어지는데 문자 배열에 인접한 문자의 조합 입력으로 주어진 단어를 만들 수 있는지 확인하라.
     * TDD
     * 2차원 그리드를 탐색하기
     * 상하좌우 탐색하기
     */
    public static boolean solution(char[][] board, String word) {
        if (!isValid(board, word)) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean bfs(char[][] board, String word, int x, int y, int index) {
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = board.length;
        int n = board[0].length;
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }

        char temp = board[x][y];
        board[x][y] = '.';
        for (int[] ints : direction) {
            if (bfs(board, word, x + ints[0], y + ints[1], index + 1)) {
                return true;
            }
        }

        board[x][y] = temp;

        return false;
    }

    private static boolean isValid(char[][] board, String word) {
        return board == null || board.length > 0 || word.length() > 0;
    }
}
