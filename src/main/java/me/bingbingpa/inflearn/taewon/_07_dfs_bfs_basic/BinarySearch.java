package me.bingbingpa.inflearn.taewon._07_dfs_bfs_basic;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch T = new BinarySearch();
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        T.mySolution(root);
    }

    /**
     * TODO 이진 트리 탐색 연습하기
     */
    public void mySolution(Node root) {
        // 전위순회: 부모 - 왼쪽 - 오른쪽 (1 2 4 5 3 6 7)
        // 중위순회: 왼쪽 - 부모 - 오른쪽 (4 2 5 1 6 3 7)
        // 후위순회: 왼쪽 - 오른쪽 - 부모 (4 5 2 6 7 3 1)
        if (root == null) {
            return;
        }
        mySolution(root.lt);
        mySolution(root.rt);
        System.out.print(root.data + " ");
    }

    private static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = null;
            rt = null;
        }
    }
}
