package me.bingbingpa.test;

public class RockPaperScissors {

    public static void main(String[] args) {
        RockPaperScissors T = new RockPaperScissors();
        int n = 5;
        int[][] array = new int[][]{
                {2, 3, 3, 1, 3},
                {1, 1, 2, 2, 3}
        };

        T.mySolution(n, array);
    }

//    public static void main(String[] args) {
//        RockPaperScissors T = new RockPaperScissors();
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] a = new int[n];
//        int[] b = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            b[i] = scanner.nextInt();
//        }
//        for(char x : T.solution(n, a, b).toCharArray()) {
//            System.out.println(x);
//        }
//    }

    /**
     * TODO 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
     * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보
     * 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
     * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
     * 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
     */
    public void mySolution(int n, int[][] array) {
        boolean testExecutable = true;
        if (testExecutable) {
            testIsValid();
            testIsWinner();
        }

        _mySolution(n, array);
    }

    public void _mySolution(int n, int[][] array) {
        if (!isValid(n)) {
            throw new IllegalArgumentException("입력값 n 은 1보다 크고 100보다 작아야 합니다.");
        }

        for (int i = 0; i < n; i++) {
            System.out.println(isWinner(array[0][i], array[1][i]));
        }
    }

    public String solution(int n, int[] a, int[] b) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                answer.append("D");
            } else if (a[i] == 1 && b[i] == 3) {
                answer.append("A");
            } else if (a[i] == 2 && b[i] == 1) {
                answer.append("A");
            } else if (a[i] == 3 && b[i] == 2) {
                answer.append("A");
            } else {
                answer.append("B");
            }
        }

        return answer.toString();
    }

    private String isWinner(int p1, int p2) {
        String result;
        if (p1 == p2) {
            result = "D";
        } else if (p1 == 1 && p2 == 3) {
            result = "A";
        } else if (p1 == 2 && p2 == 1) {
            result = "A";
        } else if (p1 == 3 && p2 == 2) {
            result = "A";
        } else {
            result = "B";
        }

        return result;
    }

    private boolean isValid(int n) {
        return n > 1 && n < 100;
    }

    private void testIsWinner() {
        String testName = "testIsWinner";
        assertThat(testName, "1,1", isWinner(1, 1).equals("D"));
        assertThat(testName, "1,2", isWinner(1, 2).equals("B"));
        assertThat(testName, "1,3", isWinner(1, 3).equals("A"));
        assertThat(testName, "2,1", isWinner(2, 1).equals("A"));
        assertThat(testName, "2,2", isWinner(2, 2).equals("D"));
        assertThat(testName, "2,3", isWinner(2, 3).equals("B"));
        assertThat(testName, "3,1", isWinner(3, 1).equals("B"));
        assertThat(testName, "3,2", isWinner(3, 2).equals("A"));
        assertThat(testName, "3,3", isWinner(3, 3).equals("D"));
    }

    private void testIsValid() {
        String testName = "testIsValid";
        assertThat(testName, "20", isValid(20));
        assertThat(testName, "-1", !isValid(-1));
        assertThat(testName, "1", !isValid(1));
        assertThat(testName, "0", !isValid(0));
        assertThat(testName, "100", !isValid(100));
        assertThat(testName, "1000", !isValid(1000));
    }

    private void assertThat(String testName, String input, boolean result) {
        String testMessage = "testName: " + testName + ", input: " + input;
        if (result) {
            System.out.println(testMessage);
        } else {
            System.err.println(testMessage);
        }
    }
}
