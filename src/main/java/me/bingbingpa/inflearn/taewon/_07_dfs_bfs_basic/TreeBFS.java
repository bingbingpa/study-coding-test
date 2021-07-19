package me.bingbingpa.inflearn.taewon._07_dfs_bfs_basic;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {

    public static void main(String[] args) {
        TreeBFS T = new TreeBFS();
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(T.mySolution(root));
    }

    /**
     * TODO 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.
     */
    public int mySolution(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if (cur.lt == null && cur.rt == null) {
                    return level;
                }
                if (cur.lt != null) {
                    queue.offer(cur.lt);
                }
                if (cur.rt != null) {
                    queue.offer(cur.rt);
                }
            }
            level++;
        }

        return level;
    }

    static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
            lt = null;
            rt = null;
        }
    }
}
