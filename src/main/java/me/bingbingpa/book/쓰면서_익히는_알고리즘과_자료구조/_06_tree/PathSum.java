package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._06_tree;

import java.util.Deque;
import java.util.LinkedList;

public class PathSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(-3);
        root.right.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.left.right.right = new Node(1);
        System.out.println("result ============ " + solution2(root, 8)); // result: 3
    }

    /**
     * TODO 트리 경로의 합이 주어진 수가 되는 횟수를 구하라.
     */
    public static int solution1(Node root, int sum) {
        // 시간 복잡도: O(NlogN)
        // 공간 복잡도: O(logN)
        int cnt = 0;
        if (root == null) {
            return cnt;
        }

        Deque<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Node node = queue.pollFirst();
                cnt += recursion(node, sum);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return cnt;
    }

    public static int solution2(Node root, int sum) {
        // 시간 복잡도: O(NlogN)
        // 공간 복잡도: O(logN)
        if (root == null) {
            return 0;
        }

        return solution2(root.left, sum) + solution2(root.right, sum) + recursion(root, sum);
    }

    private static int recursion(Node node, int target) {
        if (node == null) {
            return 0;
        }
        return target - node.data == 0 ? 1 : recursion(node.left, target - node.data) + recursion(node.right, target - node.data);
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
}
