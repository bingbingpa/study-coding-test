package me.bingbingpa.inflearn.taewon._07_dfs_bfs_basic;

public class TreeDFS {

    public static void main(String[] args) {
        TreeDFS T = new TreeDFS();
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(T.mySolution(0, root));
    }

    /**
     * TODO 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.
     */
    public int mySolution(int level, Node node) {
        if (node.lt == null && node.rt == null) {
            return level;
        } else {
            return Math.min(mySolution(level + 1, node.lt), mySolution(level + 1, node.rt));
        }
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
