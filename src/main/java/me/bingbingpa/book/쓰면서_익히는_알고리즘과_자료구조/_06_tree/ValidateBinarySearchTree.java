package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._06_tree;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinarySearchTree {
    static int low = 0;
    static int hight = 0;

    public static void main(String[] args) {
        Node bt = new Node(8);
        bt.left = new Node(6);
        bt.right = new Node(15);
        bt.left.left = new Node(3);
        bt.left.right = new Node(7);
        bt.right.left = new Node(12);
        bt.right.right = new Node(21);

        Node nbt = new Node(8);
        nbt.left = new Node(6);
        nbt.right = new Node(15);
        nbt.left.left = new Node(3);
        nbt.left.right = new Node(10);
        nbt.right.left = new Node(12);
        nbt.right.right = new Node(12);

        System.out.println("result =========== " + solution(bt)); //true
        System.out.println("result =========== " + solution(nbt)); //false
    }

    /**
     * TODO 주어진 트리가 이진 검색 트리인지 아닌지 검증하라.
     * 이진 트리는 부모 노드를 기준으로 왼쪽 노드는 부모 노드보다 작은 값이 보장되고
     * 오른쪽 노드는 해당 부모 노드보다 항상 큰 값이라는 보장이 된다.
     */
    public static boolean solution(Node root) {
        // 시간 복잡도: O(n)
        // 공간 복잡도: O(n)
        return recursion1(root.left, low, root.data) && recursion1(root.right, root.data, hight);

    }

    private static boolean recursion1(Node node, int low, int hight) {
        if (node == null) {
            return true;
        }

        if (node.data <= low && node.data >= hight) {
            return false;
        }

        return recursion1(node.left, low, node.data) && recursion1(node.right, node.data, hight);
    }

    public static void print(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println("=====================================");
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
