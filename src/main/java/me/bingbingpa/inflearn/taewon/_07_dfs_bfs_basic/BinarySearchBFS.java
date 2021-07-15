package me.bingbingpa.inflearn.taewon._07_dfs_bfs_basic;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchBFS {

    public static void main(String[] args) {
        BinarySearchBFS T = new BinarySearchBFS();
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
     * TODO 이진 트리 순회(넓이우선탐색: 레벨탐색)
     */
    public void mySolution(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.printf(node.data + " ");
            if (node.lt != null) {
                queue.add(node.lt);
            }
            if (node.rt != null) {
                queue.add(node.rt);
            }
        }
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
