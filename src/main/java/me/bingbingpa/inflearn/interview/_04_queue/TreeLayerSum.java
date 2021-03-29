package me.bingbingpa.inflearn.interview._04_queue;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLayerSum {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        TreeLayerSum treeLayerSum = new TreeLayerSum();
        System.out.println(treeLayerSum.maxSum(root) == 15);
    }

    /**
     * TODO 바이너리 트리의 계층별 합계 중에 최대 값을 구하라.
     * 9  -> 9
     * 2 3  -> 5
     * 1 5 4  -> 10
     * ==========> 10
     */
    private int maxSum(Node root) {
        if (root == null) {
            return 0;
        }

        int result = root.value;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int count = q.size();
            int sum = 0;
            while (count > 0) {
                count--;
                Node node = q.poll();
                sum += node.value;
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            result = Math.max(result, sum);
        }

        return result;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
